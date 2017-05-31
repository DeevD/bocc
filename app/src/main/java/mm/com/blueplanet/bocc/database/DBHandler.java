package mm.com.blueplanet.bocc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import mm.com.blueplanet.bocc.data.model.CallCenter;

/**
 * Created by Lenovo on 5/26/2017.
 */

public class DBHandler extends SQLiteOpenHelper
{
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "BOCC.db";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CALL_CENTER_TABLE = " CREATE TABLE " + Contact.CALL_CENTER_TABLE + " ( "

                + Contact.CC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Contact.CC_NAME + " TEXT NOT NULL, "
                + Contact.CC_PHONE + " TEXT NOT NULL, "
                + Contact.CC_DES + " TEXT NOT NULL, "
                + Contact.CC_DET + " TEXT NOT NULL, "
                + Contact.CC_ICON_PATH + " INTEGER " + " ) ";

        db.execSQL(CALL_CENTER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contact.CALL_CENTER_TABLE);
        onCreate(db);
    }


    public void insertFav(CallCenter callCenter) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contact.CC_NAME,callCenter.getName());
        values.put(Contact.CC_PHONE,callCenter.getPhone());
        values.put(Contact.CC_DES,callCenter.getDetails());
        values.put(Contact.CC_DET,callCenter.getDesc());
        values.put(Contact.CC_ICON_PATH,callCenter.getIcon());
        database.insert(Contact.CALL_CENTER_TABLE,null,values);
        database.close();


    }
    public ArrayList<CallCenter> list()
{
    ArrayList<CallCenter>getFavCall  = new ArrayList<>();
    CallCenter callCenter;
    SQLiteDatabase database = this.getReadableDatabase();
     String SQL_QUERY = " SELECT * FROM " + Contact.CALL_CENTER_TABLE +  " ORDER BY " +Contact.CC_ID + " DESC; ";
    Cursor cursor = database.rawQuery(SQL_QUERY,null);
    if (cursor.getCount()==0)
    {
        return null;
    }
    if (cursor!=null)
    {
        cursor.moveToFirst();
        do {
            callCenter = new CallCenter(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
            getFavCall.add(callCenter);
        }while (cursor.moveToNext());

        Log.d("fav return list ", getFavCall.get(0).getName() + "cursor count " + cursor.getCount());
    }

    return getFavCall ;
}

    public int delete_row(String phone) {
        SQLiteDatabase database = this.getWritableDatabase();
        //database.delete(Contact.CALL_CENTER_TABLE,Contact.CC_PHONE+ "=" + phone,null);
      int row =   database.delete(Contact.CALL_CENTER_TABLE, Contact.CC_PHONE+ "=?" , new String[]{String.valueOf(phone)} );
        if (row>0)
        {
            return row;
        }
        return 0;

    }
}
