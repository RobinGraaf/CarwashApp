package com.hva.robingraaf.carwash.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.hva.robingraaf.carwash.Adapter.ReviewAdapter;
import com.hva.robingraaf.carwash.HomeActivity;
import com.hva.robingraaf.carwash.Object.Review;
import com.hva.robingraaf.carwash.R;
import com.hva.robingraaf.carwash.Utility.DataSource;

import java.util.List;

public class ReviewActivity extends AppCompatActivity {

    private RecyclerView reviewListView;
    private ReviewAdapter mAdapter;
    private List<Review> mReviews;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_review);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this, AddReviewActivity.class);
                intent.putExtra("Editing", false);
                startActivity(intent);
            }
        });
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reviewListView = (RecyclerView) findViewById(R.id.reviewRecyclerView);
        reviewListView.setLayoutManager(mLayoutManager);

        updateUI();
    }

    private void updateUI() {
        DataSource dataSource = new DataSource(this);
        // Get the list of games from Database
        mReviews = dataSource.getReviews();
        if (mAdapter == null) {
            mAdapter = new ReviewAdapter(mReviews, this);
            reviewListView.setAdapter(mAdapter);
        } else {
            mAdapter.updateList(mReviews);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReviewActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}
