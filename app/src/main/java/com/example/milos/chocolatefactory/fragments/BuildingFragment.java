package com.example.milos.chocolatefactory.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.milos.chocolatefactory.BuildingAdapter;
import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.activities.GameActivity;
import com.example.milos.chocolatefactory.model.Building;
import com.example.milos.chocolatefactory.model.DataStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Buildings.
 * Use the {@link BuildingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildingFragment
        extends Fragment
        implements BuildingAdapter.OnListFragmentInteractionListener {

    private DataStorage mDS = DataStorage.getInstance();
    private List<Building> mBuildings = new ArrayList<>();
    private BuildingAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Toast mToast;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BuildingFragment.
     */
    public static BuildingFragment newInstance() {
        return new BuildingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building, container, false);

        // Set layout manager and the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            mRecyclerView = (RecyclerView) view;
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            mBuildings = mDS.getBuildingList();

            mAdapter = new BuildingAdapter(mBuildings,
                                        (BuildingAdapter.OnListFragmentInteractionListener) this);
            mRecyclerView.setAdapter(mAdapter);

            //set separator
            mRecyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        }
        return view;
    }

    public void onClick(View view) {
        int position = mRecyclerView.getChildAdapterPosition(view);
        Building building = mBuildings.get(position);

        if (!mDS.decreaseCount(building.getCost())) {
            String msg = "Not enough chocolate!";
            if (mToast == null) {
                mToast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
            }
            if (!mToast.getView().isShown()) {
                mToast.setText(msg);
                mToast.show();
            }
            return;
        }

        building.upgrade();
        mAdapter.notifyItemChanged(position);
        mDS.increaseCps(building.getCps());

        GameActivity activity = (GameActivity) getActivity();
        activity.updateUi();
    }
}
