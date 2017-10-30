package com.hva.robingraaf.carwash.Utility;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hva.robingraaf.carwash.Object.Review;

import java.util.ArrayList;
import java.util.List;

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
                    + ReviewContract.ReviewEntry.COLUMN_NAME_RATING + " TEXT )";

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

    public List<Review> getReviews() // Get all reviews
    {
        DBHelper dbHelper = new DBHelper(context);
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                ReviewContract.ReviewEntry.COLUMN_NAME_ID + ',' +
                ReviewContract.ReviewEntry.COLUMN_NAME_NAME + ',' +
                ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW + ',' +
                ReviewContract.ReviewEntry.COLUMN_NAME_RATING +
                " FROM " + ReviewContract.ReviewEntry.TABLE_NAME;
        //User user = new User();
        List<Review> reviewList = new ArrayList<>();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Review review = new Review();
                review.setId(cursor.getInt(cursor.getColumnIndex(ReviewContract.ReviewEntry.COLUMN_NAME_ID)));
                review.setName(cursor.getString(cursor.getColumnIndex(ReviewContract.ReviewEntry.COLUMN_NAME_NAME)));
                review.setReview(cursor.getString(cursor.getColumnIndex(ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW)));
                review.setRating((cursor.getFloat(cursor.getColumnIndex(ReviewContract.ReviewEntry.COLUMN_NAME_RATING))));
                reviewList.add(review);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return reviewList;
    }
}
