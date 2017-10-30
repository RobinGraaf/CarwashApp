package com.hva.robingraaf.carwash.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.hva.robingraaf.carwash.Object.Review;
import com.hva.robingraaf.carwash.R;
import com.hva.robingraaf.carwash.Utility.DataSource;

public class AddReviewActivity extends AppCompatActivity{

    private EditText nameEditText;
    private EditText reviewEditText;
    private RatingBar ratingBar;

    private Button btnAdd;
    private Button btnCancel;

    private Review editReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_review);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        reviewEditText = (EditText) findViewById(R.id.reviewEditText);
        ratingBar = (RatingBar) findViewById(R.id.addRatingBar);

        Intent intent = getIntent();
        Bundle values = intent.getExtras();

        final boolean editing = (boolean) values.get("Editing");
        if (editing) { setValues(values); }

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editing) {
                    saveEditedReview();
                } else
                saveNewReview();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddReviewActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveNewReview() {

        // Retrieve the input from the user
        String nameInput = nameEditText.getText().toString();
        String reviewInput = reviewEditText.getText().toString();
        float rating = ratingBar.getRating();

        DataSource dataSource = new DataSource(this);

        Review review = new Review(nameInput, reviewInput, rating);
        dataSource.saveReview(review);

        Intent intent = new Intent(AddReviewActivity.this, ReviewActivity.class);
        startActivity(intent);
    }

    public void saveEditedReview() {

        // Retrieve the input from the user
        String nameInput = nameEditText.getText().toString();
        String reviewInput = reviewEditText.getText().toString();
        float rating = ratingBar.getRating();

        // Edit the review based on the Id and the new values
        DataSource dataSource = new DataSource(this);
        dataSource.editReview(editReview, nameInput, reviewInput, rating);

        Intent intent = new Intent(AddReviewActivity.this, ReviewActivity.class);
        startActivity(intent);
    }

    private void setValues(Bundle values){
        Review review = (Review) values.get("Review");
        this.editReview = review;

        nameEditText.setText(review.getName());
        reviewEditText.setText(review.getReview());
        ratingBar.setRating(review.getRating());
    }
}
