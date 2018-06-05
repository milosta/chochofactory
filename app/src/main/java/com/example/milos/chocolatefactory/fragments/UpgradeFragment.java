package com.example.milos.chocolatefactory.fragments;


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

import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.UpgradeAdapter;
import com.example.milos.chocolatefactory.activities.GameActivity;
import com.example.milos.chocolatefactory.model.Building;
import com.example.milos.chocolatefactory.model.DataStorage;
import com.example.milos.chocolatefactory.model.Upgrade;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Upgrades.
 * Use the {@link UpgradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpgradeFragment
        extends Fragment
        implements UpgradeAdapter.OnListFragmentInteractionListener {

    private DataStorage mDS = DataStorage.getInstance();
    private List<Upgrade> mUpgrades = new ArrayList<>();
    private List<Building> mBuildings = new ArrayList<>();
    private UpgradeAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Toast mToast;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UpgradeFragment.
     */
    public static UpgradeFragment newInstance() {
        return new UpgradeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgrade, container, false);

        // Set layout manager and the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            mRecyclerView = (RecyclerView) view;
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));

            mUpgrades = mDS.getUpgradeList();
            mBuildings = mDS.getBuildingList();
            mAdapter = new UpgradeAdapter(mUpgrades,
                    (UpgradeAdapter.OnListFragmentInteractionListener) this);
            mRecyclerView.setAdapter(mAdapter);

            //set separator
            mRecyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        }
        return view;
    }

    public void onClick(View view) {
        int position = mRecyclerView.getChildAdapterPosition(view);
        Upgrade upgrade = mUpgrades.get(position);

        if (!mDS.decreaseCount(upgrade.getCost())) {
            String msg = "Not enough chocolate!";
            showToast(msg);
            return;
        }

        int buldingIx = upgrade.getBuildingIx();

        if (buldingIx == -1) {
            mDS.multiplyClickVal(2);
        }
        else if (buldingIx == -2) {
            mDS.increasecpsFractionClick(0.03f);
        }
        else if (buldingIx == -3) {
            String msg = "YOU WON!!!";
            showToast(msg);
        }
        else {
            Building building = mBuildings.get(buldingIx);
            Long cps_increase = building.multiplyCps(2);
            mDS.increaseCps(cps_increase * building.getCount());
        }

        mUpgrades.remove(position);
        mAdapter.notifyItemRemoved(position);

        GameActivity activity = (GameActivity) getActivity();
        activity.updateUi();
    }

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
        }
        if (!mToast.getView().isShown()) {
            mToast.setText(msg);
            mToast.show();
        }
    }
}
