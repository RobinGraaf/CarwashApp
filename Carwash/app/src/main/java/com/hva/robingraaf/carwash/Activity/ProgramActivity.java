package com.hva.robingraaf.carwash.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.hva.robingraaf.carwash.Adapter.ProgramAdapter;
import com.hva.robingraaf.carwash.Object.WashProgram;
import com.hva.robingraaf.carwash.R;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_program);

        List<WashProgram> mWashPrograms = new ArrayList<>();

        for (int i = 0; i < WashProgram.PRE_DEFINED_PROGRAM_IMAGE_IDS.length; i++) {
            mWashPrograms.add(new WashProgram(WashProgram.PRE_DEFINED_PROGRAM_IMAGE_IDS[i]));
        }

        RecyclerView mGeoRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2); //2 cells per row
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        ProgramAdapter mAdapter = new ProgramAdapter(this, mWashPrograms);
        mGeoRecyclerView.setAdapter(mAdapter);
    }
}
