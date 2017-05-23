package mm.com.blueplanet.bocc.component.textView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import mm.com.blueplanet.bocc.utility.MMFontUtil;

/**
 * Created by smmon on 5/22/17.
 */

public class MMTextView extends TextView {

    public MMTextView(Context context) {
        super(context);
        if(!isInEditMode()){
            MMFontUtil.setMMFont(this);
        }
    }

    public MMTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            MMFontUtil.setMMFont(this);
        }
    }

    public MMTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode()){
            MMFontUtil.setMMFont(this);
        }
    }
}
