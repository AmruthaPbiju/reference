package com.example.amritha.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amritha on 06-08-2018.
 */
public class dbstudent extends SQLiteOpenHelper {
    public  static String dbname="dbstudent";
    public static int version=1;
    public dbstudent(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sqlquery="create table student(rolno text,name text,branch text)";
        db.execSQL(sqlquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void studentinfo(String rolno,String name,String branch)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String insert="insert into student values(?,?,?)";
        db.execSQL(insert,new String[]{rolno,name,branch});
        db.close();
    }
    public Cursor select(String key)
    {
       String selectq="select * from student where rolno='"+key+"'";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectq,null);
        return cursor;
    }

}
