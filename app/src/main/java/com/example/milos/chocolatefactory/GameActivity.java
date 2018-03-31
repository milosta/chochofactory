package com.example.milos.chocolatefactory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class GameActivity extends AppCompatActivity {

//    private TextView mChocoCount;
//    private TextView mCPS;
//
//    private Integer count = 0;
//    private Integer cps = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_tapping:
//                    mTextMessage.setText(R.string.title_tapping);
                    selectedFragment = BlankFragment.newInstance();
                case R.id.navigation_building:
//                    Intent intent = new Intent(getBaseContext(), BuildingActivity.class);
//                    intent.putExtra("EXTRA_MESSAGE", "Value");
//                    startActivity(intent);
//                    mTextMessage.setText("Buildings");
                    return true;
                case R.id.navigation_upgrade:
//                    mTextMessage.setText(R.string.title_upgrade);
                    return true;
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

//        mTextMessage = (TextView) findViewById(R.id.message);
//        mChocoCount = (TextView) findViewById(R.id.choco_count);
//        mCPS = (TextView) findViewById(R.id.CPS);
//
//        mChocolateButton = (ImageButton) findViewById(R.id.chocolateButton);
//        mChocolateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count ++;
//                mChocoCount.setText(String.valueOf(count));
//            }
//        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, BlankFragment.newInstance());
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
