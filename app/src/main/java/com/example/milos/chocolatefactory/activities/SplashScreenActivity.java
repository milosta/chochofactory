package com.example.milos.chocolatefactory.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.UiUtils;

public class SplashScreenActivity extends AppCompatActivity {

    // Splash screen timer in milliseconds
    private static final int TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, GameActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UiUtils.hideStatusBar(this);
    }
}
