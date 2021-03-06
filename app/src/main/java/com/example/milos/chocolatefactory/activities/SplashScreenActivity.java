package com.example.milos.chocolatefactory.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.UiUtils;

/**
 * Initro splash screen activity.
 * It is launcher Activity and starts {@link GameActivity}.
 */

public class SplashScreenActivity extends AppCompatActivity {

    // Splash screen timer in milliseconds
    private static final int TIME_OUT = 1000;

    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, GameActivity.class);
                startActivity(i);
                finish();
            }
        };
        new Handler().postDelayed(runnable, TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UiUtils.hideStatusBar(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

}
