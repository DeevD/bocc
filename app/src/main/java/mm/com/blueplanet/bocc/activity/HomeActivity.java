package mm.com.blueplanet.bocc.activity;
/*
*  Testing source tree comment
* */
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.ButterKnife;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRate;
import mm.com.blueplanet.bocc.fragment.AboutUsFragment;
import mm.com.blueplanet.bocc.fragment.BeautyTipFragment;
import mm.com.blueplanet.bocc.fragment.FavEmergencyFragment;
import mm.com.blueplanet.bocc.fragment.FavouriteFragment;
import mm.com.blueplanet.bocc.fragment.FootballFragment;
import mm.com.blueplanet.bocc.fragment.FortuneFragment;
import mm.com.blueplanet.bocc.fragment.GoldAndNewsFragment;
import mm.com.blueplanet.bocc.fragment.GoldExchangeFragment;
import mm.com.blueplanet.bocc.fragment.HotLineFragment;
import mm.com.blueplanet.bocc.fragment.HotlineFrag;
import mm.com.blueplanet.bocc.fragment.NewFragment;
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

        BottomBar bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId)
                {
                    case R.id.action_hot_line:{
                        navigateToHotLine();
                        break;
                    }
                    case R.id.action_news:{
                        navigateToNews();
                        break;
                    }
                    case R.id.action_football:{
                        navigateToFootball();
                        break;
                    }
                    case R.id.action_beauty_tip:{
                        navigateToBeautyTip();
                        break;
                    }
                    case R.id.action_fortune:{
                        navigateToFortune();
                        break;

                    }

                }
            }
        });

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

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected( MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.action_hot_line :
//                        navigateToHotLine();
//                        return true;
//                    case R.id.action_news :
//                        navigateToNews();
//                        return true;
//                    case R.id.action_football :
//                        navigateToFootball();
//                        return true;
//                    case R.id.action_fortune :
//                        navigateToFortune();
//                        return true;
//                    case R.id.action_beauty_tip :
//                        navigateToBeautyTip();
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    private void navigateToHotLine(){
        HotlineFrag hotlineFrag = new HotlineFrag();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, hotlineFrag)
                .commit();
    }
    private void navigateToNews(){
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fl_container, GoldExchangeFragment.newInstance())
//                .commit();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fl_container2, NewFragment.newInstance())
//                .commit();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentById(R.id.fl_container));
        fragmentTransaction.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, GoldAndNewsFragment.newInstace(), "Call Fragment").commit();
        //getFragmentManager().beginTransaction().hide(getFragmentManager().findFragmentById(R.id.fl_container)).commit();//


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

            case R.id.homeScreen:{
                navigateToHome();
                return true;
            }
        }

        return true;

    }

    private void navigateToHome() {
        HotlineFrag hotlineFrag = new HotlineFrag();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, hotlineFrag)
                .commit();
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item){ return false;}

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item){ return false;}

}
