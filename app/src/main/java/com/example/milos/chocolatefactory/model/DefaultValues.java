package com.example.milos.chocolatefactory.model;

import com.example.milos.chocolatefactory.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by milos on 27.5.18.
 */

public class DefaultValues {
    private DefaultValues() {}

    public static final Long count = 0L;
    public static final Long cps = 1L;
    public static final Long clickVal = 10L;

    public static final double buildingCostMultiplier = 1.2;

    public static final int[] buildingIcons = {
            R.drawable.building_cursor,
            R.drawable.building_grandma,
            R.drawable.building_confectioner,
    };
    public static final int[] upgradeIcons = {
            R.drawable.ic_upgrade_navigation_bar,
    };

    public static final String buildingList = "[\n" +
            "  {\n" +
            "    \"name\": \"Cursor\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Grandma\",\n" +
            "    \"cost\": 174,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Confectioner\",\n" +
            "    \"cost\": 941,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 10\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Plantation\",\n" +
            "    \"cost\": 4701,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 37\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Mine\",\n" +
            "    \"cost\": 22423,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 119\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Factory\",\n" +
            "    \"cost\": 74925,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 499\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Wizard\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Temple\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Alchemy lab\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Hadron collider\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Portal\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Time machine\",\n" +
            "    \"cost\": 0,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 0\n" +
            "  }\n" +
            "]";

    public static final String upgradeList = "[\n" +
            "  {\n" +
            "    \"name\": \"Bigger finger\",\n" +
            "    \"cost\": 100,\n" +
            "    \"info\": \"Tapping gives double amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Cursor motivator\",\n" +
            "    \"cost\": 300,\n" +
            "    \"info\": \"Cursors make double amount of chocolate!\",\n" +
            "    \"buildingIx\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Huge finger\",\n" +
            "    \"cost\": 500,\n" +
            "    \"info\": \"Tapping gives double amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Bigger finger\",\n" +
            "    \"cost\": 100,\n" +
            "    \"info\": \"Tapping gives double amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Bigger finger\",\n" +
            "    \"cost\": 100,\n" +
            "    \"info\": \"Tapping gives double amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  }\n" +
            "]";

//    public static final String buildingList = DefaultValues.readFile("buildings.json");

    private static String readFile(String path) {
        try {
            return new Scanner(new File(path)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            return "";
        }
    }

}
