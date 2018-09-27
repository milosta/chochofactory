package com.example.milos.chocolatefactory.activities;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.UiUtils;
import com.example.milos.chocolatefactory.Utils;
import com.example.milos.chocolatefactory.fragments.BuildingFragment;
import com.example.milos.chocolatefactory.fragments.TappingFragment;
import com.example.milos.chocolatefactory.fragments.UpgradeFragment;
import com.example.milos.chocolatefactory.model.DataStorage;
import com.example.milos.chocolatefactory.model.DefaultValues;

/**
 * The main game activity.
 */

public class GameActivity
        extends AppCompatActivity {

    private TextView mCountTV;
    private TextView mCpsTV;
    private DataStorage mDS = DataStorage.getInstance();

    Handler handler = new Handler();
    Runnable runnable;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_tapping:
                    selectedFragment = TappingFragment.newInstance();
                    break;
                case R.id.navigation_building:
                    selectedFragment = BuildingFragment.newInstance();
                    break;
                case R.id.navigation_upgrade:
                    selectedFragment = UpgradeFragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mDS.init(getApplicationContext());

        mCountTV = (TextView) findViewById(R.id.choco_count);
        mCpsTV = (TextView) findViewById(R.id.CPS);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, TappingFragment.newInstance());
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        UiUtils.hideStatusBar(this);

        Long secCount = mDS.getSecondsFromExit();

        if (secCount > DefaultValues.offlineIgnoreSeconds) {
            double money = 0;
            if (secCount > DefaultValues.offlineFirstPeriod) {
                money += (secCount - DefaultValues.offlineFirstPeriod) * mDS.getCps() * DefaultValues.offlineRestKoeficient;
                secCount = (long) DefaultValues.offlineFirstPeriod;
            }
            money += secCount * mDS.getCps() * DefaultValues.offlineFirstKoeficient;

            mDS.increaseCount(money);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Offline Earnings:")
                    .setMessage(Utils.toString(money))
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if (secCount > 0) {
            double money = secCount * mDS.getCps() * DefaultValues.offlineFirstKoeficient;
            mDS.increaseCount(money);
        }

        // start CPSing, its running in current thread, so no thread-safeness needed
        final long DELAY = 1000; //milliseconds
        runnable = new Runnable() {
            public void run() {
                mDS.oneSec();
                updateUi();

                handler.postDelayed(this, DELAY);
            }
        };
        handler.postDelayed(runnable, DELAY);

        updateUi();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDS.saveData();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    public void updateUi() {
        mCountTV.setText(Utils.toString(mDS.getCount()));
        mCpsTV.setText(Utils.toString(mDS.getCps()));
    }
}
