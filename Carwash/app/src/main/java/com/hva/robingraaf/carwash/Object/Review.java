package com.hva.robingraaf.carwash.Object;

import android.media.Rating;

import java.io.Serializable;

/**
 * Created by Robin on 16-10-2017.
 */

public class Review implements Serializable {

    // Property help us to keep data
    private int id;
    private String name;
    private String review;
    private float rating;

    public Review(String name, String review, float rating) {
        this.name = name;
        this.review = review;
        this.rating = rating;
    }

    public Review() {
    }

    public long getId() {
        return (long) id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
