package com.example.jim.test3;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class StepsDBHandler extends SQLiteOpenHelper {
    private static final String LOGTAG = "dbHandler";
    private static final int DATEBASE_VERSION = 1;
    private static final String DATEBASE_NAME = "Steps.db";
    private static final String TABLE_STEPS = "Steps";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_RECORDTIME = "recordTime";
    private static final String COLUMN_STEPS = "steps";

    public StepsDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATEBASE_NAME, factory, DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_STEPS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_RECORDTIME + " BLOB " +
                COLUMN_STEPS + " REAL  " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STEPS);
        onCreate(db);
    }

    public void addSteps(Steps steps) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_RECORDTIME, steps.get_recordTime());
        values.put(COLUMN_STEPS, steps.get_step());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STEPS, null, values);
        db.close();
    }

    public int getSteps () {
        String query = "SELECT * FROM " + TABLE_STEPS + " WHERE 1";
        SQLiteDatabase db = getWritableDatabase();
        int total = 0;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        //loop reults from query
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("recordTime")) != null) {
            }
        }
        db.close();

        return c.getColumnCount();
    }
}
