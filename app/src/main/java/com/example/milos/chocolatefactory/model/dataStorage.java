package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 16.4.18.
 */

public class dataStorage {
    private static final dataStorage ourInstance = new dataStorage();
    private Long count = 0L;
    private Long cps = 1000L;

    public Long getCount() {

        return count;
    }

    public Long getCps() {
        return cps;
    }

    public void increaseCount(Long count) {
        this.count += count;
    }

    public void increaseCps(Long count) {
        this.cps += cps;
    }

    public static dataStorage getInstance() {
        return ourInstance;
    }

    private dataStorage() {
    }

    public void oneSec() {
        count += cps;
    }
    public void click() {
        count += 1;
    }
}
