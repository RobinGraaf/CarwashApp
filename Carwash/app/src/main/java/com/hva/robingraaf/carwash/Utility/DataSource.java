package com.hva.robingraaf.carwash.Utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hva.robingraaf.carwash.Object.Review;

/**
 * Created by Robin on 16-10-2017.
 */

public class DataSource {

    private final DBHelper dbHelper;

    public DataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void saveReview(Review review) {
        // Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_NAME, review.getName());
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW, review.getReview());
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_RATING, review.getRating());
        db.insert(ReviewContract.ReviewEntry.TABLE_NAME, null, values);
        db.close(); // Closing ReviewEntry connection
    }
}
