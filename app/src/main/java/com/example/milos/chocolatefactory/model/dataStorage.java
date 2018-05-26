package com.example.milos.chocolatefactory.model;

import android.content.Context;

/**
 * Created by milos on 16.4.18.
 */

public class dataStorage {
    private static final dataStorage ourInstance = new dataStorage();
//    private SharedPref mSharedPref;

    private Long count = 0L;
    private Long cps = 1000L;
    private Long clickVal = 1L;

    private dataStorage() {}

    public static dataStorage getInstance() {
        return ourInstance;
    }

    public void init(Context context) {
        SharedPref.init(context);

        count = SharedPref.read("count", 0L);
        cps = SharedPref.read("cps", 0L);
        clickVal = SharedPref.read("clickVal", 1L);
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
