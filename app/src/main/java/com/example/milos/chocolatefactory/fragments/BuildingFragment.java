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

import com.example.milos.chocolatefactory.BuildingAdapter;
import com.example.milos.chocolatefactory.R;
import com.example.milos.chocolatefactory.model.Building;
import com.example.milos.chocolatefactory.model.DummyContent;
import com.example.milos.chocolatefactory.model.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BuildingFragment extends Fragment {

//    private OnListFragmentInteractionListener mListener;
    private List<Building> buildingList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BuildingAdapter mAdapter;

    @SuppressWarnings("unused")
    public static BuildingFragment newInstance() {
        BuildingFragment fragment = new BuildingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building, container, false);

        // Set layout manager and the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            // set the adapter
//            recyclerView.setAdapter(new BuildingAdapter(DummyContent.ITEMS, mListener));
            mAdapter = new BuildingAdapter(buildingList);
            recyclerView.setAdapter(mAdapter);

            //set separator
            recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        }
        getDummyData();
        mAdapter.notifyDataSetChanged();
        return view;
    }

    public void getDummyData() {
        for (Long i = 0L; i < 10; i++) {
            Building building = new Building(String.valueOf(i), i, i, i);
            buildingList.add(building);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
