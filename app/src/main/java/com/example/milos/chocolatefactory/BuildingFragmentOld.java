package com.example.milos.chocolatefactory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildingFragmentOld#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildingFragmentOld extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BuildingFragmentOld.
     */
    public static BuildingFragmentOld newInstance() {
        BuildingFragmentOld fragment = new BuildingFragmentOld();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_building_old, container, false);
    }

}
