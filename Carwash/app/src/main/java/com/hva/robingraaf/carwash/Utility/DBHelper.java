package com.hva.robingraaf.carwash.Utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Robin on 16-10-2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    // Version number to upgrade database version
    // each time if you Add, Edit table, you need to change the
    // version number.
    private static final String DATABASE_NAME = "reviews.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    // Creating the table
    private static final String DATABASE_CREATE =
            "CREATE TABLE " + ReviewContract.ReviewEntry.TABLE_NAME +
                    "(" +
                    ReviewContract.ReviewEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + ReviewContract.ReviewEntry.COLUMN_NAME_NAME + " TEXT, "
                    + ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW + " TEXT, "
                    + ReviewContract.ReviewEntry.COLUMN_NAME_RATING + " TEXT, )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + ReviewContract.ReviewEntry.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
}
