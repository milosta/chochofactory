package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 16.4.18.
 */

public class dataStorage {
    private static final dataStorage ourInstance = new dataStorage();

    public static dataStorage getInstance() {
        return ourInstance;
    }

    private dataStorage() {
    }
}
