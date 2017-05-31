package mm.com.blueplanet.bocc.AppSplashScreen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.fingerlinks.mobile.android.navigator.AnimationEnum;
import org.fingerlinks.mobile.android.navigator.Navigator;

import mm.com.blueplanet.bocc.R;

/**
 * Created by Lenovo on 5/24/2017.
 */

public class SplashScreen extends AppCompatActivity {
    public static final int SPLASH_TIME  = 3000;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent appIntro  = new Intent(SplashScreen.this,AppIntro.class);
                startActivity(appIntro);
                finish();
            }
        },SPLASH_TIME);
    }





}
