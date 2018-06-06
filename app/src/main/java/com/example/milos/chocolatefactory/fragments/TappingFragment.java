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
import com.example.milos.chocolatefactory.model.DataStorage;


/**
 * A fragment with tapping button.
 * Use the {@link TappingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TappingFragment extends Fragment{

    private Activity activity;
    private ImageButton mChocolateButton;

    private TextView mCPT;

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
        mChocolateButton.setOnClickListener(new View.OnClickListener() { // (this;) implements View.OnClickListener
            @Override
            public void onClick(View v) {
                ((OnFragmentInteractionListener) activity).chocolateClicked();
            }
        });
        this.activity = getActivity();

        // DEBUG
        mCPT = (TextView) view.findViewById(R.id.CPT);
        DataStorage ds = DataStorage.getInstance();
        mCPT.setText(ds.getTapStats());
        return view;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void chocolateClicked();
    }

}
