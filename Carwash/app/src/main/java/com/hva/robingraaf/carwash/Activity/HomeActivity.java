package com.hva.robingraaf.carwash.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hva.robingraaf.carwash.R;

public class HomeActivity extends AppCompatActivity {

    private Button btn_program;
    private Button btn_route;
    private Button btn_webcam;
    private Button btn_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        btn_program = (Button) findViewById(R.id.btn_program);
        btn_route = (Button) findViewById(R.id.btn_route);
        btn_webcam = (Button) findViewById(R.id.btn_webcam);
        btn_review = (Button) findViewById(R.id.btn_review);

        btn_program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProgramActivity.class);
                startActivity(intent);
            }
        });

        btn_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RouteActivity.class);
                startActivity(intent);
            }
        });

        btn_webcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WebcamActivity.class);
                startActivity(intent);
            }
        });

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });
    }

}
