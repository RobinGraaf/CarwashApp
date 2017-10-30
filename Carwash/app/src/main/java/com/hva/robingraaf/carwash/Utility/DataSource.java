package com.hva.robingraaf.carwash.Utility;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;

import com.hva.robingraaf.carwash.Activity.AddReviewActivity;
import com.hva.robingraaf.carwash.Activity.ReviewActivity;
import com.hva.robingraaf.carwash.Object.Review;

import java.util.List;

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

    public void editReview(Review review, String name, String reviewText, float rating) {
        // Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(ReviewContract.ReviewEntry.TABLE_NAME, ReviewContract.ReviewEntry.COLUMN_NAME_ID
                + "= ?", new String[]{String.valueOf(review.getId())});

        ContentValues values = new ContentValues();
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_NAME, name);
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW, reviewText);
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_RATING, rating);
        db.insert(ReviewContract.ReviewEntry.TABLE_NAME, null, values);
        db.close(); // Closing ReviewEntry connection
    }

    public List<Review> getReviews() {
        return dbHelper.getReviews();
    }

    public void deleteReview(long user_Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(ReviewContract.ReviewEntry.TABLE_NAME, ReviewContract.ReviewEntry.COLUMN_NAME_ID
                + "= ?", new String[]{String.valueOf(user_Id)});
        db.close(); // Closing database connection
    }
}
