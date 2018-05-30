package com.example.milos.chocolatefactory.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
    private List<Building> buildingList;

    private DataStorage() {}

    public static DataStorage getInstance() {
        return ourInstance;
    }

    public void init(Context context) {
        SharedPref.init(context);
        loadData();
    }

    public void loadData() {
        count = SharedPref.read("count", DefaultValues.count);
        cps = SharedPref.read("cps", DefaultValues.cps);
        clickVal = SharedPref.read("clickVal", DefaultValues.clickVal);

        String buildingString = SharedPref.read("buildingList", DefaultValues.buildingList);
        Type collectionType = new TypeToken<ArrayList<Building>>(){}.getType();
        buildingList = gson.fromJson(buildingString, collectionType);
        int a = 1;
    }

    public void saveData() {
        SharedPref.write("count", count);
        SharedPref.write("cps", cps);
        SharedPref.write("clickVal", clickVal);

        SharedPref.write("buildingList", gson.toJson(buildingList));
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

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void oneSec() {
        count += cps;
    }
    public void click() {
        count += clickVal;
    }
}
