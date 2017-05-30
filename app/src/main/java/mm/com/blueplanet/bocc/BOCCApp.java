package mm.com.blueplanet.bocc;

import android.app.Application;
import android.content.Context;

/**
 * Created by smmon on 3/11/17.
 * Called when the application is starting, before any other application objects have been created.
 */

public class BOCCApp extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
