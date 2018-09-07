package com.example.amritha.bloodconnectapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amritha on 29-08-2018.
 */
public class dbBlood extends SQLiteOpenHelper {
    public static  String dname="dbBlood";
    public static int version=1;
    public dbBlood(Context context) {

        super(context, dname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlquery="create table newregistration(edid String primary key,name text,address text,mobile text,username text,password text,type text,district text,bloodgroup text)";
        db.execSQL(sqlquery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void add(String edid,String name,String address,String mobile,String username,String password,String type,String district,String bloodgroup)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String insert="insert into newregistration values(?,?,?,?,?,?,?,?,?)";
        db.execSQL(insert,new String[]{edid,name,address,mobile,username,password,type,district,bloodgroup});
        db.close();
    }
    public Cursor searchdonor(String key)
    {
        String selectq="select name,address,mobile from newregistration where bloodgroup='"+key+"'";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectq,null);
        return cursor;
    }
    public int login(String uname,String pass)
    {
        int count;
        String select=" select * from newregistration where username=' "+uname +"' and password='"+ pass +"'";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(select,null);
        count=cursor.getCount();
        db.close();
        cursor.close();
        return  count;

    }
}
