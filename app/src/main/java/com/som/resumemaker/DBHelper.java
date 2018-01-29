package com.som.resumemaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Som on 14-07-2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="resume";
    private static final int DB_VERSION=1;
    private static final  String Table="info";
    private static final String COL_1="id";
    private static final String COL_2="fname";
    private static final String COL_3="adres";
    private static final String COL_4="phone";
    private static final String COL_5="email";
    private static final String COL_6="employ";
    private static final String COL_7="job";
    private static final String COL_8="start";
    private static final String COL_9="end";
    private static final String COL_10="collage";
    private static final String COL_11="city";
    private static final String COL_12="degree";
    private static final String COL_13="graduation";
    private static final String COL_14="skill";
    private static final String COL_15="summary";
    private static final String CREATE_TABLE="CREATE TABLE " + Table + "("+ COL_1 + " INTEGER PRIMARY KEY , "
            +COL_2 + " TEXT,"+COL_3+" TEXT," +COL_4 +" TEXT,"+COL_5+" TEXT,"+ COL_6 + " TEXT, "
            +COL_7+ " TEXT,"+COL_8+" TEXT," +COL_9 +" TEXT,"+COL_10+ " TEXT,"+COL_11+" TEXT," +COL_12 +" TEXT,"
            +COL_13+ " TEXT,"+COL_14+" TEXT," +COL_15 +" TEXT)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    public boolean resume(String  id,String name,String address,String phone,String email,String employe,String job,String start,String end,
                          String collage,String city,String degree,String graduation,String skill,String summary,SQLiteDatabase db)
    {
        ContentValues content=new ContentValues();
        content.put(COL_1,id);
        content.put(COL_2,name);
        content.put(COL_3,address);
        content.put(COL_4,phone);
        content.put(COL_5,email);
        content.put(COL_6,employe);
        content.put(COL_7,job);
        content.put(COL_8,start);
        content.put(COL_9,end);
        content.put(COL_10,collage);
        content.put(COL_11,city);
        content.put(COL_12,degree);
        content.put(COL_13,graduation);
        content.put(COL_14,skill);
        content.put(COL_15,summary);
        db.insert(Table,null,content);
        return true;
    }
    public Cursor view(String id,SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery(" SELECT * FROM "+ Table + " WHERE " + COL_1 + " LIKE " + "'"+id+"'" ,null );
        return cursor;
    }
    public boolean update(String id,String name,String address,String phone,String email,String employe,String job,String start,String end,
                          String collage,String city,String degree,String graduation,String skill,String summary,SQLiteDatabase db)
    {
        ContentValues content=new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,address);
        content.put(COL_4,phone);
        content.put(COL_5,email);
        content.put(COL_6,employe);
        content.put(COL_7,job);
        content.put(COL_8,start);
        content.put(COL_9,end);
        content.put(COL_10,collage);
        content.put(COL_11,city);
        content.put(COL_12,degree);
        content.put(COL_13,graduation);
        content.put(COL_14,skill);
        content.put(COL_15,summary);

        String where="id="+id;
        String[] whereArgs=new String[]{String.valueOf(email)};
        db.update(Table, content, where, null);
        return true;

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
