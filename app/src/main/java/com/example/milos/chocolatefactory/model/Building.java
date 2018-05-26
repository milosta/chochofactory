package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 26.5.18.
 */

public class Building {
    public final String name;
    public final Long cost;
    public final Long count;
    public final Long cps;

    public Building(String name, Long cost, Long count, Long cps) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.cps = cps;
    }

    @Override
    public String toString() {
        return name;
    }
}
