package com.example.milos.chocolatefactory.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.milos.chocolatefactory.BuildConfig;
import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.activities.GameActivity;
import com.example.milos.chocolatefactory.model.DataStorage;


/**
 * A fragment with tapping button.
 * Use the {@link TappingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TappingFragment
        extends Fragment
        implements View.OnClickListener {

    private DataStorage mDS = DataStorage.getInstance();
    private GameActivity activity;

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
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tapping, container, false);

        // Set Views
        ImageButton mChocolateButton = view.findViewById(R.id.chocolateButton);
        mChocolateButton.setOnClickListener(this);
        this.activity = (GameActivity) getActivity();

        if (BuildConfig.DEBUG) {
            TextView mCPT = view.findViewById(R.id.CPT);
            mCPT.setText(mDS.getTapStats());
        }

        return view;
    }

    /**
     * On click listenner for the chocolate bar.
     */
    public void onClick(View view) {
        mDS.click();
        activity.updateUi();
    }
}
