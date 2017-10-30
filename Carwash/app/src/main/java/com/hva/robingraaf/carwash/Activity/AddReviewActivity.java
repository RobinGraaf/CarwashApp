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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_review);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        reviewEditText = (EditText) findViewById(R.id.reviewEditText);
        ratingBar = (RatingBar) findViewById(R.id.addRatingBar);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveReview();
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

    public void saveReview() {
        // Retrieve the input from the user
        String nameInput = nameEditText.getText().toString();
        String reviewInput = reviewEditText.getText().toString();
        float rating = ratingBar.getRating();

        DataSource dataSource = new DataSource(this);
        Review review = new Review(-1, nameInput, reviewInput, rating);
        dataSource.saveReview(review);

        Intent intent = new Intent(AddReviewActivity.this, ReviewActivity.class);
        startActivity(intent);
    }
}
