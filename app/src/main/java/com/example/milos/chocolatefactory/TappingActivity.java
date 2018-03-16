package com.example.milos.chocolatefactory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TappingActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageButton mChocolateButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tapping:
                    mTextMessage.setText(R.string.title_tapping);
                    return true;
                case R.id.navigation_building:
                    mTextMessage.setText(R.string.title_building);
                    return true;
                case R.id.navigation_upgrade:
                    mTextMessage.setText(R.string.title_upgrade);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapping);

        mTextMessage = (TextView) findViewById(R.id.message);
        mChocolateButton = (ImageButton) findViewById(R.id.chocolateButton);
//        mChocolateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String message = mMessageBodyEditText.getText().toString();
//
//                // in case user does not fill anything
//                if (message.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Fill the message ;)", Toast.LENGTH_SHORT)
//                            .show();
//                    return;
//                }
//
//                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
//                intent.putExtra("EXTRA_MESSAGE", message);
//                startActivity(intent);
//
//                Toast.makeText(getApplicationContext(), "Sending " + message, Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
