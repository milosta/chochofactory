package com.example.milos.chocolatefactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TappingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TappingFragment extends Fragment {

    private TextView mTextMessage;
    private ImageButton mChocolateButton;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TappingFragment.
     */
    public static TappingFragment newInstance() {
        TappingFragment fragment = new TappingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mChocolateButton = (ImageButton) findViewById(R.id.chocolateButton);
//        mChocolateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count ++;
//                mChocoCount.setText(String.valueOf(count));
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tapping, container, false);
    }

}
