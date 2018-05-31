package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 26.5.18.
 */

public class Building {
    private String name;
    private Long cost;
    private Long count;
    private Long cps;

    public Building(String name, Long cost, Long count, Long cps) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.cps = cps;
    }

    public void upgrade() {
        cost = (long) (cost * DefaultValues.buildingCostMultiplier);
        count ++;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public Long getCount() {
        return count;
    }

    public Long getCps() {
        return cps;
    }
}
