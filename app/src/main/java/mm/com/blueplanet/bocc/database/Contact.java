package mm.com.blueplanet.bocc.database;

import android.content.Context;
import android.provider.BaseColumns;

/**
 * Created by Lenovo on 5/26/2017.
 */

public  class Contact implements BaseColumns {

    public static final String CALL_CENTER_TABLE = "cctable";
    public static final String CC_ID = BaseColumns._ID;
    public static final String CC_NAME = "ccname";
    public static final String CC_PHONE = "ccphone";;
    public static final String CC_DES = "ccdes";
    public static final String CC_DET = "ccdet";
    public static final String CC_ICON_PATH = "ccicon";

    /**
     * end of Call_Center Table
     */

    public static final String EMER_TABLE = "emctable";
    public static final String E_ID = BaseColumns._ID;
    public static final String E_NAME = "ename";
    public static final String E_PHONE = "ephone";
    public static final String E_DES = "edes";
    public static final String E_DET = "edet";
    public static final String E_ICON_PATH = "eicon";

    /**
     * end of emergency table
     */

    public static final String GOV_TABLE = "govtable";
    public static final String G_ID = BaseColumns._ID;
    public static final String G_NAME = "gname";
    public static final String G_PHONE = "gphone";
    public static final String G_DES = "gdes";
    public static final String G_DET = "gdet";
    public static final String G_ICON_PATH = "gicon";


    public  Contact ()
    {

    }

}
