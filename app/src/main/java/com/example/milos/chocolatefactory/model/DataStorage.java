package com.example.milos.chocolatefactory.model;

import android.content.Context;

import com.example.milos.chocolatefactory.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Class DataStorage handles application data.
 */

public class DataStorage {
    private static final DataStorage ourInstance = new DataStorage();
    private Gson gson = new Gson();

    private double count;
    private double cps;
    private double clickVal;
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

        Long currentTime = System.currentTimeMillis() / 1000;
        SharedPref.write("exitTime", currentTime);
    }

    public Long getSecondsFromExit() {
        Long defVal = 0L;
        long exitTime = SharedPref.read("exitTime", defVal);
        if (exitTime == defVal) {
            return defVal;
        }
        Long currentTime = System.currentTimeMillis() / 1000;
        return currentTime - exitTime;
    }

    public double getCount() {
        return count;
    }
    public void setCount(double count) {
        this.count = count;
    }
    public boolean decreaseCount(double count) {
        if (this.count < count)
            return false;
        this.count -= count;
        return true;
    }
    public void increaseCount(double count) {
        this.count += count;
    }

    public double getCps() {
        return cps;
    }
    public void setCps(double cps) {
        this.cps = cps;
    }
    public void increaseCps(double count) {
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

    /** Debuging function for current tap statistics  */
    public String getTapStats() {
        return Utils.toString(clickVal) + " + " + Utils.toString(cpsFractionClick *cps) +
                " = " + Utils.toString(clickVal + cpsFractionClick *cps);
    }

    public void oneSec() {
        count += cps;
    }
    public void click() {
        count += clickVal + cps * cpsFractionClick;
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
