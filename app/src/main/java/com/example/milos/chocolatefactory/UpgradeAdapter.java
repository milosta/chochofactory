package com.example.milos.chocolatefactory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.milos.chocolatefactory.model.DefaultValues;
import com.example.milos.chocolatefactory.model.Upgrade;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Upgrade} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class UpgradeAdapter extends RecyclerView.Adapter<UpgradeAdapter.ViewHolder> {
    private final List<Upgrade> upgradeList;
    private final OnListFragmentInteractionListener mListener;

    public UpgradeAdapter(List<Upgrade> items, OnListFragmentInteractionListener listener) {
        upgradeList = items;
        mListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upgrade_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Upgrade upgrade = upgradeList.get(position);
        holder.mNameView.setText(upgrade.getName());
        holder.mCostView.setText(Utils.toString(upgrade.getCost()));
        holder.mInfoView.setText(upgrade.getInfo());
        holder.mImageView.setImageResource(getIconId(upgrade.getBuildingIx()));

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
        return upgradeList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // needs to be static , because otherwise it holds ref to outside class
        public View mView;
        public ImageView mImageView;
        public TextView mNameView;
        public TextView mCostView;
        public TextView mInfoView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.icon);
            mNameView = (TextView) view.findViewById(R.id.name);
            mCostView = (TextView) view.findViewById(R.id.cost);
            mInfoView = (TextView) view.findViewById(R.id.info);
        }
    }

    private int getIconId(int buildingIx) {
        int imageId;
        try {
            imageId = DefaultValues.upgradeIcons[buildingIx + 3];
        } catch (IndexOutOfBoundsException ex) {
            imageId = R.drawable.ic_navigation_upgrade;
        }
        return imageId;
    }

    public interface OnListFragmentInteractionListener {
        void onClick(View view);
    }
}
