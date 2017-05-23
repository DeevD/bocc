package mm.com.blueplanet.bocc.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import mm.com.blueplanet.bocc.BOCCApp;

/**
 * Created by smmon on 5/22/17.
 */

public class MMFontUtil {
    private static Typeface mmTypeface;

    static {
        Context context = BOCCApp.getContext();
        mmTypeface =  Typeface.createFromAsset(context.getAssets(), "fonts/Zawgyi.ttf");
    }

    public static void setMMFont(TextView textView){
        textView.setTypeface(mmTypeface);
    }
}
