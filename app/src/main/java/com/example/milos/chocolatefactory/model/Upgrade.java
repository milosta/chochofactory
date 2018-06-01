package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 26.5.18.
 */

public class Upgrade {
    private String name;
    private Long cost;
    private String info;
    private int buildingIx;

    public Upgrade(String name, Long cost, String info, int buildingIx) {
        this.name = name;
        this.cost = cost;
        this.info = info;
        this.buildingIx = buildingIx;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public String getInfo() {
        return info;
    }

    public int getBuildingIx() {
        return buildingIx;
    }
}
