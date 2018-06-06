package com.example.milos.chocolatefactory.model;

import android.content.Context;

import com.example.milos.chocolatefactory.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by milos on 16.4.18.
 */

public class DataStorage {
    private static final DataStorage ourInstance = new DataStorage();
    private Gson gson = new Gson();

    private Long count;
    private Long cps;
    private Long clickVal;
    private float cpsFractionClick;
    private List<Building> buildingList;
    private List<Upgrade> upgradeList;

    private DataStorage() {}

    public static DataStorage getInstance() {
        return ourInstance;
    }

    public void init(Context context) {
        SharedPref.init(context);
        loadData(context);
    }

    private void loadData(Context context) {
        count = SharedPref.read("count", DefaultValues.count);
        cps = SharedPref.read("cps", DefaultValues.cps);
        clickVal = SharedPref.read("clickVal", DefaultValues.clickVal);
        cpsFractionClick = SharedPref.read("cpsFractionClick", DefaultValues.cpsFractionClick);

        String defVal = loadAsset(context, "buildings.json");
        String buildingString = SharedPref.read("buildingList", defVal);
        Type collectionType = new TypeToken<ArrayList<Building>>(){}.getType();
        buildingList = gson.fromJson(buildingString, collectionType);

        defVal = loadAsset(context, "upgrades.json");
        String upgradeString = SharedPref.read("upgradeList", defVal);
        collectionType = new TypeToken<ArrayList<Upgrade>>(){}.getType();
        upgradeList = gson.fromJson(upgradeString, collectionType);
        Collections.sort(upgradeList);
    }

    public void saveData() {
        SharedPref.write("count", count);
        SharedPref.write("cps", cps);
        SharedPref.write("clickVal", clickVal);
        SharedPref.write("cpsFractionClick", cpsFractionClick);

        SharedPref.write("buildingList", gson.toJson(buildingList));
        SharedPref.write("upgradeList", gson.toJson(upgradeList));
    }

    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public boolean decreaseCount(Long count) {
        if (this.count < count)
            return false;
        this.count -= count;
        return true;
    }

    public Long getCps() {
        return cps;
    }
    public void setCps(Long count) {
        this.cps = cps;
    }
    public void increaseCps(Long count) {
        cps += count;
    }

    public void increasecpsFractionClick(float count) {
        cpsFractionClick += count;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }
    public List<Upgrade> getUpgradeList() {
        return upgradeList;
    }

    public String getTapStats() {
        return Utils.toString(clickVal) + " + " + Utils.toString((long)cpsFractionClick *cps) +
                " = " + Utils.toString(clickVal + (long)(cpsFractionClick *cps));
    }

    public void oneSec() {
        count += cps;
    }
    public void click() {
        Long addition = (long) (clickVal + cps * cpsFractionClick);
        count += addition;
    }

    public void  multiplyClickVal(double multiplier) {
        clickVal = (long) (clickVal * multiplier);
    }

    private String loadAsset(Context context, String name) {
        String res;
        try {
            InputStream is = context.getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            res = new String(buffer, "UTF-8");
        } catch (java.io.IOException ex) {
            return null;
        }
        return res;
    }
}
