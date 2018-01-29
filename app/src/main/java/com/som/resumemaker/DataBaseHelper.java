package com.som.resumemaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Som on 11-07-2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="registration";
    private static final int DB_VERSION=1;
    public static final String TABLE_NAME="reg";
    private static final String COL1="id";
    private static final String COL2="name";
    private static final String COL3="email";
    private static final String COL4="password";
    private static final String COL5="phone";

    private static final String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + "("+ COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL2 + " TEXT,"+COL3+" TEXT," +COL4 +" TEXT,"+COL5+" TEXT)";
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.i("CREATE DATABASE","DATABASE IS CREATED");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
       Log.i("CREATE TABLE","Table Is Created");
    }

    public boolean insertData(String name, String email, String password, String phone, SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,password);
        contentValues.put(COL5,phone);
        db.insert(TABLE_NAME,null,contentValues);
        return true;
    }
    public Cursor search(String email, SQLiteDatabase db)
    {
        String emailid=email;
        Cursor cursor=db.rawQuery(" SELECT * FROM "+ TABLE_NAME +" WHERE "+ COL3 +" LIKE "+"'"+emailid+"'",null );
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
