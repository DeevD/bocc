package mm.com.blueplanet.bocc.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.fragment.BeautyTipFragment;
import mm.com.blueplanet.bocc.fragment.FootballFragment;
import mm.com.blueplanet.bocc.fragment.FortuneFragment;
import mm.com.blueplanet.bocc.fragment.HotLineFragment;
import mm.com.blueplanet.bocc.fragment.NewsFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        if(savedInstanceState == null){
            navigateToHotLine();
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_hot_line :
                        navigateToHotLine();
                        return true;
                    case R.id.action_news :
                        navigateToNews();
                        return true;
                    case R.id.action_football :
                        navigateToFootball();
                        return true;
                    case R.id.action_fortune :
                        navigateToFortune();
                        return true;
                    case R.id.action_beauty_tip :
                        navigateToBeautyTip();
                        return true;
                }
                return false;
            }
        });
    }

    private void navigateToHotLine(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, HotLineFragment.newInstance())
                .commit();
    }
    private void navigateToNews(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, NewsFragment.newInstance())
                .commit();
    }
    private void navigateToFootball(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, FootballFragment.newInstance())
                .commit();
    }
    private void navigateToFortune(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, FortuneFragment.newInstance())
                .commit();
    }
    private void navigateToBeautyTip(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, BeautyTipFragment.newInstance())
                .commit();
    }



}
