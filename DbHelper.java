package com.example.sois.health_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static final String dbname = "health_care";
    public static final String tname = "login";
    public static final String tname1 = "details";
    public static final String cname = "Name";
    public static final String cid = "Email";
    public static final String cpaswrd = "Password";
    public static final String cphne = "Phone_no";
    public static final String Cname = "name";
    public static final String cage = "Age";
    public static final String cgender = "Gender";
    public static final String cheight = "Height";
    public static final String cweight = "Weight";
    public static final String cbloodgroup = "Bloodgroup";

    SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, dbname, null, 1);
        db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(Name text,Email text primary key, Password text, Phone_no text)");
        db.execSQL("create table details(name text,Age integer,Gender text,Height integer,Weight integer, Bloodgroup text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table IF EXISTS MainActivity");
        db.execSQL("Drop table IF EXISTS Details");
        onCreate(db);
    }

    public boolean Insert(String Name, String Email, String Password, String Phone_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(cname, Name);
        value.put(cid, Email);
        value.put(cpaswrd, Password);
        value.put(cphne, Phone_no);
        db.insert(tname, null, value);
        db.close();
        return true;
    }

    public boolean InsertData(String name, String Age, String Gender, String Height, String Weight, String Bloodgroup) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Cname, name);
        value.put(cage, Age);
        value.put(cgender, Gender);
        value.put(cheight, Height);
        value.put(cweight, Weight);
        value.put(cbloodgroup, Bloodgroup);
        db.insert(tname1, null, value);
        db.close();
        return true;

    }

    public boolean validate(String Email, String Password) {
        Log.v("validate", Email);
        Log.v("validate", Password);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from login where Email=? and Password=?", new String[]{Email, Password});
        if (cs.getCount() > 0)
            return true;
        else
            return false;

    }

    public String fetchByID(String name) {
        String sql = "SELECT " + cage + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("Age"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }
    public String fetchByID1(String name) {
        String sql = "SELECT " + cgender + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("Gender"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }
    public String fetchByID2(String name) {
        String sql = "SELECT " + cheight + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("Height"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }
    public String fetchByID3(String name) {
        String sql = "SELECT " + cweight + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("Weight"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }
    public String fetchByID4(String name) {
        String sql = "SELECT " + cbloodgroup + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("Bloodgroup"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }

}