package mm.com.blueplanet.bocc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;

public class HotLineDetailActivity extends AppCompatActivity {

    private static final String IE_HOTLINE_TITLE = "IE_HOTLINE_TITLE";

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    public static Intent newIntent(String hotlineTitle){
        Intent intent = new Intent(BOCCApp.getContext(), HotLineDetailActivity.class);
        intent.putExtra(IE_HOTLINE_TITLE, hotlineTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_line_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_accent_24dp);
        }


        String hotlineTitle = getIntent().getStringExtra(IE_HOTLINE_TITLE);
        collapsingToolbar.setTitle(hotlineTitle);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "It will daile soon !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
