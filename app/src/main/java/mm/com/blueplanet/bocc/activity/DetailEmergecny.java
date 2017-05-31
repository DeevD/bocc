package mm.com.blueplanet.bocc.activity;

import android.content.Intent;
import android.media.Image;
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
import mm.com.blueplanet.bocc.data.model.Emergency;

/**
 * Created by Lenovo on 5/30/2017.
 */

public class DetailEmergecny extends AppCompatActivity {

    TextView hotline;
    MMTextView detail;
    ImageView icon;
    Emergency e;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ActionBar actrion = getSupportActionBar();
        actrion.setDisplayHomeAsUpEnabled(true);
        actrion.setHomeButtonEnabled(true);

        Intent intent = getIntent();
        e = (Emergency) intent.getSerializableExtra("emergency");

        hotline = (TextView)findViewById(R.id.name_phone);
        detail = (MMTextView)findViewById(R.id.detail_call_center);
        icon = (ImageView)findViewById(R.id.detail_icon);
        button = (Button)findViewById(R.id.detail_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call();
            }
        });

        hotline.setText(e.getPhone() + " " + "HotLine");
        detail.setText(e.getName() + "\n" + e.getDetails());
        icon.setImageResource(e.getIcon());



    }

    private void Call() {
        Uri call = Uri.parse(e.getPhone());
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
                shareIntent.putExtra(Intent.EXTRA_TEXT, e.getPhone() + "HotLine");
                shareIntent.setType("image/jpeg");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "send"));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
