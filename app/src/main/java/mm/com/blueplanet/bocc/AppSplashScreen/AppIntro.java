package mm.com.blueplanet.bocc.AppSplashScreen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntroFragment;

import mm.com.blueplanet.bocc.Preference.Session;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.HomeActivity;

/**
 * Created by Lenovo on 5/24/2017.
 */

public class AppIntro extends com.github.paolorotolo.appintro.AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Session session = new Session(this);

        if (session.isFirst())
        {
           Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }

        addSlide(AppIntroFragment.newInstance("Hot Line"," Do you want to know something?", R.drawable.callcenter_icon,
                ContextCompat.getColor(getApplicationContext(),R.color.hotline_intro)));
        addSlide(AppIntroFragment.newInstance("News","Do you want to know Update Hot News? ", R.drawable.newspaper,
                ContextCompat.getColor(getApplicationContext(),R.color.news_intro)));
        addSlide(AppIntroFragment.newInstance("Football"," Live Football Scores ", R.drawable.football_wallpaper1,
                ContextCompat.getColor(getApplicationContext(),R.color.football_intro)));

        addSlide(AppIntroFragment.newInstance("Fortunes","Do you want to know your daily fortunes?", R.drawable.astrology,
                ContextCompat.getColor(getApplicationContext(),R.color.fortune_intro)));
        addSlide(AppIntroFragment.newInstance("Beauty"," How to make beauty for everyday?", R.drawable.mirror,
                ContextCompat.getColor(getApplicationContext(),R.color.beauty_intro)));
    }
        @Override
        public void onSkipPressed(Fragment currentFragment) {
            super.onSkipPressed(currentFragment);
            Session.setFirstTimeIntro(true);
            Intent main = new Intent(AppIntro.this, HomeActivity.class);
            startActivity(main);
            finish();
    }
    @Override
    public void onSlideChanged(Fragment oldFragment, Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Session.setFirstTimeIntro(true);
        Intent main = new Intent(AppIntro.this, HomeActivity.class);
        startActivity(main);
        finish();
    }


}
