package com.example.godwin.pokernotes;

/**
 * Created by Godwin on 18-Dec-17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Storage extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Player.db";
    public static final String TABLE_NAME = "Player_Details";
    public static final String COL_2 = "PLAYER";
    public static final String COL_3 = "DAY";
    public static final String COL_4 = "DATE";
    public static final String COL_5 = "TIME";
    public static final String COL_6 = "NOTES";

    public Storage(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ENTRYNUMBER INTEGER PRIMARY KEY AUTOINCREMENT, PLAYER TEXT ,DAY TEXT, " +
                " DATE TEXT, TIME TEXT, NOTES TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String player, String day, String date, String time, String notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, player);
        contentValues.put(COL_3, day);
        contentValues.put(COL_4, date);
        contentValues.put(COL_5, time);
        contentValues.put(COL_6, notes);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public void deleteAllRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,2);
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}