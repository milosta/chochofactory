package com.example.milos.chocolatefactory;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    // Splash screen timer in milliseconds
    private static int TIME_OUT = 0; //1500; FIXME

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
}


//public class Welcome extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_welcome);
//
//
//        ImageView IMGVW_SPSOA = (ImageView)findViewById(R.id.imageView);
//        Animation ANIM_SPSOALOGO = AnimationUtils.loadAnimation(this, R.anim.welcome_sc);
//
//        ImageView IMGVW_MSK = (ImageView)findViewById(R.id.imageView3);
//        Animation ANIM_MSK = AnimationUtils.loadAnimation(this, R.anim.welcome_sc_right);
//
//        IMGVW_MSK.startAnimation(ANIM_MSK);
//        IMGVW_SPSOA.startAnimation(ANIM_SPSOALOGO);
//
//        Thread Thrd_wlcmscrndelay = new Thread() {
//            public void run() {
//                try {
//                    sleep(4500);
//                    startActivity(new Intent(getApplicationContext(), calcActivity.class));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    finish();
//                }
//            }
//        };
//        Thrd_wlcmscrndelay.start();
//    }
//}