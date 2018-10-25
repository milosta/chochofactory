package com.example.milos.chocolatefactory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.milos.chocolatefactory.model.Building;
import com.example.milos.chocolatefactory.model.DefaultValues;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Building} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.ViewHolder> {
    private final List<Building> buildingList;
    private final OnListFragmentInteractionListener mListener;

    public BuildingAdapter(List<Building> items, OnListFragmentInteractionListener listener) {
        buildingList = items;
        mListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.building_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Building building = buildingList.get(position);
        holder.mNameView.setText(building.getName());
        holder.mCountView.setText(Utils.toString(building.getCount()));
        holder.mCostView.setText(Utils.toString(building.getCost()));
        holder.mCPSView.setText(Utils.toString(building.getCps()));
        int imageId;
        try {
            imageId = DefaultValues.buildingIcons[position];
        } catch (IndexOutOfBoundsException ex) {
            imageId = R.drawable.ic_navigation_home;
        }
        holder.mImageView.setImageResource(imageId);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClick(holder.mView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // needs to be static , because otherwise it holds ref to outside class
        public View mView;
        public ImageView mImageView;
        public TextView mNameView;
        public TextView mCountView;
        public TextView mCostView;
        public TextView mCPSView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.icon);
            mNameView = (TextView) view.findViewById(R.id.name);
            mCountView = (TextView) view.findViewById(R.id.count);
            mCostView = (TextView) view.findViewById(R.id.cost);
            mCPSView = (TextView) view.findViewById(R.id.cps);
        }
    }

    public interface OnListFragmentInteractionListener {
        void onClick(View view);
    }
}
