package com.hva.robingraaf.carwash.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hva.robingraaf.carwash.R;
import com.hva.robingraaf.carwash.Object.Review;

import java.util.List;

/**
 * Created by Robin on 16-10-2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    final Context context;
    private final List<Review> reviewList;
    public ReviewAdapter(List<Review> list, Context context) {
        reviewList = list;
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return reviewList.size();
    }
    private Review getItem(int position) {
        return reviewList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return reviewList.get(position).getId();
    }
    public void updateList(List<Review> newlist) {
        reviewList.clear();
        reviewList.addAll(newlist);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_review, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Populate the row
        holder.populateRow(getItem(position));
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView reviewText;
        private final RatingBar ratingBar;

        //initialize the variables
        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTextView);
            reviewText = (TextView) view.findViewById(R.id.reviewTextView);
            ratingBar = (RatingBar) view.findViewById(R.id.reviewRating);
        }

        public void populateRow(Review review) {
            name.setText(review.getName());
            reviewText.setText(review.getReview());
            ratingBar.setRating(review.getRating());
        }
    }
}
