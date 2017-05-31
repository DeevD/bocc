package mm.com.blueplanet.bocc.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.CallCenter;
import mm.com.blueplanet.bocc.database.DBHandler;

public class CallCenterDetailActivity extends AppCompatActivity {
    public static final String CALL_CENTER = "call";
    public static final String EMERGENCY  = "emergency";
    public static final String GORVERMENT = "gorverment";
    private static final String IE_HOTLINE_TITLE = "IE_HOTLINE_TITLE";

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    public static Intent newIntent(String hotlineTitle){
        Intent intent = new Intent(BOCCApp.getContext(), CallCenterDetailActivity.class);
        intent.putExtra(IE_HOTLINE_TITLE, hotlineTitle);
        return intent;
    }
    ImageView icon;
    String name;
    String phone;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_line_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        DBHandler dbHandler = new DBHandler(this);
        ArrayList<CallCenter> getList = dbHandler.list();
//        dbHandler.list();
//        Log.d("fav list ",getList.get(6).getPhone());
        icon = (ImageView)findViewById(R.id.iv_stock_photo);

        Intent getData = getIntent();
//        if (getData.getSerializableExtra(CALL_CENTER) == CALL_CENTER )
//        {
//            Log.d("Detail Hotline Activity" + getData.getSerializableExtra(CALL_CENTER),"");
            CallCenter c = (CallCenter) getData.getSerializableExtra(CALL_CENTER);
            name = c.getName();
            phone = c.getPhone();
            image = c.getIcon();
            icon.setImageResource(image);
            setData(name,phone,image);


//        }
//        else if (getData.getSerializableExtra(EMERGENCY)==EMERGENCY)
//        {
//            Emergency emergency = (Emergency) getData.getSerializableExtra(EMERGENCY);
//            name = emergency.getName();
//            phone = emergency.getPhone();
//            image = emergency.getIcon();
//            icon.setImageResource(image);
//            setData(name,phone,image);
//        }
//        else if (getData.getSerializableExtra(GORVERMENT)==GORVERMENT){
//            Goverment goverment = (Goverment) getData.getSerializableExtra(GORVERMENT);
//            name = goverment.getName();
//            phone = goverment.getPhone();
//            image = goverment.getIcon();
//
//            setData(name,phone,image);
//        }



        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_accent_24dp);
        }


        String hotlineTitle = getIntent().getStringExtra(IE_HOTLINE_TITLE);
        collapsingToolbar.setTitle(name + phone);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "It will daile soon !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Uri call = Uri.parse(phone);
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                surf.setData(Uri.parse("tel:" +call));
                startActivity(surf);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setData(String name, String phone, int d) {
        collapsingToolbar.setTitle(name + phone);
        icon.setImageResource(d);

    }

}
