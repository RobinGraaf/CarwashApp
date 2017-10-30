package com.hva.robingraaf.carwash.Object;

import com.hva.robingraaf.carwash.R;

import java.io.Serializable;

/**
 * Created by Robin on 15-10-2017.
 */

public class WashProgram implements Serializable{
    private int mProgramImage;

    public static final int[] PRE_DEFINED_PROGRAM_IMAGE_IDS = {
            R.drawable.was1,
            R.drawable.was2,
            R.drawable.was3,
            R.drawable.was4,
            R.drawable.was5,
            R.drawable.was6,
            R.drawable.was7,
            R.drawable.was8
    };

    public WashProgram(int mProgramImage) {
        this.mProgramImage = mProgramImage;
    }

    public int getmProgramImage() {
        return mProgramImage;
    }

    public void setmProgramImage(int mProgramImage) {
        this.mProgramImage = mProgramImage;
    }
}
