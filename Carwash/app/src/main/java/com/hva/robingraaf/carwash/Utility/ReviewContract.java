package com.hva.robingraaf.carwash.Utility;

import android.provider.BaseColumns;

/**
 * Created by Robin on 16-10-2017.
 */

public class ReviewContract {

    private ReviewContract() {
    }

    public static class ReviewEntry implements BaseColumns {
        public static final String TABLE_NAME = "Reviews";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_REVIEW = "review";
        public static final String COLUMN_NAME_RATING = "rating";
    }
}
