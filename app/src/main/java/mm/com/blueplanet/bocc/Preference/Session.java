package mm.com.blueplanet.bocc.Preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lenovo on 5/24/2017.
 */

public class Session {

    public static  SharedPreferences sharedPreferences ;
    public static  SharedPreferences.Editor editor ;
    public static  String FIRST_TIME = "intro";
    public static  Context context;

    public  Session(Context c)
    {
        context = c;
        sharedPreferences = context.getSharedPreferences(FIRST_TIME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setFirstTimeIntro(boolean isfirst)
    {
        editor.putBoolean(FIRST_TIME,isfirst);
        editor.commit();
    }

    public static boolean isFirst()
    {
        return sharedPreferences.getBoolean(FIRST_TIME,false);
    }

}
