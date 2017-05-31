package mm.com.blueplanet.bocc.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.component.textView.MMTextView;
import mm.com.blueplanet.bocc.data.model.Goverment;

/**
 * Created by Lenovo on 5/30/2017.
 */

public class DetailGov extends AppCompatActivity {
    TextView name;
    MMTextView detail;
    ImageView icon;
    Button call;
    Goverment g;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        g = (Goverment) intent.getSerializableExtra("gov");


        name = (TextView)findViewById(R.id.name_phone);
        detail = (MMTextView)findViewById(R.id.detail_call_center);
        icon = (ImageView)findViewById(R.id.detail_icon);
        call = (Button)findViewById(R.id.detail_call);
        name.setText(g.getPhone() + " " + " Hotline ");
        detail.setText(g.getName() + " " + g.getDetails());
        icon.setImageResource(g.getIcon());
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call();
            }
        });

    }

    private void Call() {
        Uri call = Uri.parse(g.getPhone());
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        surf.setData(Uri.parse("tel:" +call));
        startActivity(surf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
                break;
            }
            case R.id.share:{
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, g.getPhone() + "HotLine");
                shareIntent.setType("image/jpeg");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "send"));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
