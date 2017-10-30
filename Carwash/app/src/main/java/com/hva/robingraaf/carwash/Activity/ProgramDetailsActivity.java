package com.hva.robingraaf.carwash.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hva.robingraaf.carwash.Object.WashProgram;
import com.hva.robingraaf.carwash.R;

public class ProgramDetailsActivity extends AppCompatActivity {

    private WashProgram program;
    private ImageView programImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_program_details);

        initialize();
    }

    private void initialize() {
        program = (WashProgram)getIntent().getSerializableExtra("selectedProgram");
        programImage = (ImageView) findViewById(R.id.programImageView);
    }
}
