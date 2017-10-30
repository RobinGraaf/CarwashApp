package com.hva.robingraaf.carwash.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hva.robingraaf.carwash.Activity.AddReviewActivity;
import com.hva.robingraaf.carwash.Activity.ReviewActivity;
import com.hva.robingraaf.carwash.R;
import com.hva.robingraaf.carwash.Object.Review;
import com.hva.robingraaf.carwash.Utility.DataSource;

import java.util.List;

/**
 * Created by Robin on 16-10-2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    final Context context;
    private final List<Review> reviewList;
    private ReviewAdapter mAdapter;

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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Populate the row
        holder.populateRow(getItem(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                    .setMessage("What do you want to do?")
                    .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteItem(reviewList.get(position));
                        }
                    })
                    .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton("Edit", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editItem(reviewList.get(position));
                        }
                    })
                    .create().show();
            }
        });
    }


    public void editItem(Review review) {
        Intent intent = new Intent(context, AddReviewActivity.class);
        intent.putExtra("Editing", true);
        intent.putExtra("Review", review);
        context.startActivity(intent);
    }

    public void deleteItem(Review review) {
        DataSource dataSource = new DataSource(this.context);

        dataSource.deleteReview(review.getId());

        // Notify that something has been changed, then update the list in the RecyclerView
        notifyDataSetChanged();
        updateList(dataSource.getReviews());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView reviewText;
        private final RatingBar ratingBar;

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
