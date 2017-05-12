package mm.com.blueplanet.bocc.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.fragment.AboutUsFragment;
import mm.com.blueplanet.bocc.fragment.BeautyTipFragment;
import mm.com.blueplanet.bocc.fragment.FavouriteFragment;
import mm.com.blueplanet.bocc.fragment.FootballFragment;
import mm.com.blueplanet.bocc.fragment.FortuneFragment;
import mm.com.blueplanet.bocc.fragment.HotLineFragment;
import mm.com.blueplanet.bocc.fragment.NewsFragment;
import mm.com.blueplanet.bocc.fragment.TakeATourFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MenuItemCompat.OnActionExpandListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_left_menu);
        navigationView.setNavigationItemSelectedListener(this);

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

    private void navigateToAboutUs(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, AboutUsFragment.newInstance())
                .commit();
    }

    private void navigateToTakeATour(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, TakeATourFragment.newInstance())
                .commit();
    }

    private void navigateToFavourite(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, FavouriteFragment.newInstance())
                .commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.action_about_us :
                navigateToAboutUs();
                return true;

            case R.id.action_take_a_tour :
                navigateToTakeATour();
                return true;

            case R.id.action_favourite :
                navigateToFavourite();
                return true;
        }

        return true;

    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item){ return false;}

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item){ return false;}

}
