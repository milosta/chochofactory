package com.example.milos.chocolatefactory;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.milos.chocolatefactory.model.dataStorage;

public class GameActivity extends AppCompatActivity
        implements TappingFragment.OnFragmentInteractionListener{
    /**
     * singleton
     * getry
     * setry synchronized
     * thread safe
     */
    private TextView mCountTV;
    private TextView mCpsTV;
    private dataStorage mDS = dataStorage.getInstance();

    Handler handler = new Handler();

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

        mCountTV = (TextView) findViewById(R.id.choco_count);
        mCpsTV = (TextView) findViewById(R.id.CPS);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, TappingFragment.newInstance());
        transaction.commit();

        // start CPSing, its running in current thread, so no thread-safeness needed
        final long DELAY = 1000; //milliseconds

        handler.postDelayed(new Runnable() {
            public void run() {
                mDS.oneSec();
                updateUi();

                handler.postDelayed(this, DELAY);
            }
        }, DELAY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        mCountTV.setText(String.valueOf(mDS.getCount()));
        mCpsTV.setText(String.valueOf(mDS.getCps()));
    }

    public void chocolateClicked() {
        mDS.click();
        updateUi();
    }

}
