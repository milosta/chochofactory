package com.example.milos.chocolatefactory.model;

import android.support.annotation.NonNull;

/**
 * Created by milos on 26.5.18.
 */

public class Upgrade implements Comparable {
    private String name;
    private double cost;
    private String info;
    private int buildingIx;

    public Upgrade(String name, double cost, String info, int buildingIx) {
        this.name = name;
        this.cost = cost;
        this.info = info;
        this.buildingIx = buildingIx;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getInfo() {
        return info;
    }

    public int getBuildingIx() {
        return buildingIx;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Upgrade other = (Upgrade) o;
        if (cost > other.cost)
            return 1;
        else if (cost < other.cost)
            return -1;
        return 0;
    }
}
