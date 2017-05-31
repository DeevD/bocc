package mm.com.blueplanet.bocc.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.DetailAdapter;
import mm.com.blueplanet.bocc.component.textView.MMTextView;
import mm.com.blueplanet.bocc.data.model.CallCenter;

/**
 * Created by Lenovo on 5/30/2017.
 */

public class DetailHotline extends AppCompatActivity {
    ImageView imageView;
    RecyclerViewPager mRecyclerView;
    DetailAdapter detailAdapter;
    ArrayList<CallCenter>callCentersList;
    TextView name;
    MMTextView detail_callcenter;
    CallCenter c ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        callCentersList = new ArrayList<>();
        Intent getData = getIntent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        c = (CallCenter) getData.getSerializableExtra("callcenter");
        callCentersList.add(c);
//        Log.d("sfdsf",callCentersList.get(0).getName());
        ImageView detail = (ImageView)findViewById(R.id.detail_icon);
        Button call = (Button)findViewById(R.id.detail_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call();
            }

            private void Call() {
                Uri call = Uri.parse(c.getPhone());
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                surf.setData(Uri.parse("tel:" +call));
                startActivity(surf);
            }
        });
        detail.setImageResource(c.getIcon());

        name = (TextView)findViewById(R.id.name_phone);

        name.setText(c.getPhone() + "" + "HotLine");
        detail_callcenter = (MMTextView)findViewById(R.id.detail_call_center);
        detail_callcenter.setText(c.getName() + "\n" + c.getDetails());




//        callCentersList = new ArrayList<>();
//        mRecyclerView = (RecyclerViewPager) findViewById(R.id.list);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        mRecyclerView.setLayoutManager(manager);
//        detailAdapter = new DetailAdapter(this,c);
//        mRecyclerView.setAdapter(detailAdapter);

//        imageView = (ImageView) findViewById(R.id.iv_back);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
//    }


//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            {
                onBackPressed();
                break;
            }
            case R.id.share:{
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, c.getPhone() + "HotLine");
                shareIntent.setType("image/jpeg");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "send"));
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
