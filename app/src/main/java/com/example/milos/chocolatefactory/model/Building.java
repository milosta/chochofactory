package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 26.5.18.
 */

public class Building {
    private String name;
    private double cost;
    private int count;
    private double cps;

    public Building(String name, double cost, int count, double cps) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.cps = cps;
    }

    public void upgrade() {
        cost = cost * DefaultValues.buildingCostMultiplier;
        count ++;
    }

    public double multiplyCps(double multiplier) {
        double old_cps = cps;
        cps = cps * multiplier;
        return cps - old_cps;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public double getCps() {
        return cps;
    }
}
