package com.example.crud_operation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        DB.execSQL("create Table Userdetails(name TEXT primary key , contact TEXT , dob TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion)
    {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = DB.insert("userdetails", null, contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean deletedata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where name=?", new String[]{name});
        if (cursor.getCount() > 0)
        {
            long result = DB.delete("userdetails", "name=?", new String[]{name});
            if (result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails ",null);
        return cursor;
    }

}