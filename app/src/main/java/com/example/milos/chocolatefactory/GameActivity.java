package com.example.milos.chocolatefactory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView mCountTV;
    private TextView mCpsTV;

    private Integer count = 0;
    private Integer cps = 0;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
//        prepareUi();
    }

//    private void prepareUi() {
//        mChocoCount.setText(String.valueOf(count));
//        mCPS.setText(String.valueOf(cps));
//    }

}
