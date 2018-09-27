package com.example.milos.chocolatefactory.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.activities.GameActivity;
import com.example.milos.chocolatefactory.model.DataStorage;


/**
 * A fragment with tapping button.
 * Use the {@link TappingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TappingFragment extends Fragment{

    private DataStorage mDS = DataStorage.getInstance();
    private GameActivity activity;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tapping, container, false);

        // Set Views
        mChocolateButton = (ImageButton) view.findViewById(R.id.chocolateButton);
        mChocolateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chocolateClicked();
            }
        });
        this.activity = (GameActivity) getActivity();

        // DEBUG
        TextView mCPT = (TextView) view.findViewById(R.id.CPT);
        mCPT.setText(mDS.getTapStats());

        return view;
    }

    /**
     * On click listenner for the chocolate bar.
     */
    public void chocolateClicked() {
        mDS.click();
        activity.updateUi();
    }
}
