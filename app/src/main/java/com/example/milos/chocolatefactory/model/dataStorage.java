package com.example.milos.chocolatefactory.model;

import android.content.Context;

/**
 * Created by milos on 16.4.18.
 */

public class dataStorage {
    private static final dataStorage ourInstance = new dataStorage();
//    private SharedPref mSharedPref;

    private Long count;
    private Long cps;
    private Long clickVal;

    private dataStorage() {}

    public static dataStorage getInstance() {
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
    }

    public void writeAll() {
        SharedPref.write("count", count);
        SharedPref.write("cps", cps);
        SharedPref.write("clickVal", clickVal);
    }

    public Long getCount() {
        return count;
    }

    public Long getCps() {
        return cps;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setCps(Long count) {
        this.cps = cps;
    }

    public void oneSec() {
        count += cps;
    }
    public void click() {
        count += clickVal;
    }
}
