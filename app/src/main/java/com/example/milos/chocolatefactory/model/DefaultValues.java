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
    public static final Long cps = 0L;
    public static final Long clickVal = 1L;

    public static final double buildingCostMultiplier = 1.18;

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
            "    \"cost\": 19423,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 119\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Factory\",\n" +
            "    \"cost\": 66125,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 499\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Wizard\",\n" +
            "    \"cost\": 297562,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 961\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Temple\",\n" +
            "    \"cost\": 1339029,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 3086\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Alchemy lab\",\n" +
            "    \"cost\": 6628193,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 8949\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Hadron collider\",\n" +
            "    \"cost\": 31815326,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 39375\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Portal\",\n" +
            "    \"cost\": 196805903,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 147658\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Time machine\",\n" +
            "    \"cost\": 1012363686,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 885951\n" +
            "  }\n" +
            "]";

    public static final String upgradeList = "[\n" +
            "  {\n" +
            "    \"name\": \"Bigger finger\",\n" +
            "    \"cost\": 100,\n" +
            "    \"info\": \"Tapping gives triple amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Cursor motivator\",\n" +
            "    \"cost\": 300,\n" +
            "    \"info\": \"Motivated cursors work twice as hard!\",\n" +
            "    \"buildingIx\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Huge finger\",\n" +
            "    \"cost\": 500,\n" +
            "    \"info\": \"Huge fingers give triple amount of chocolate!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Send flowers to grandma\",\n" +
            "    \"cost\": 1000,\n" +
            "    \"info\": \"Happy grandmas make double amount of chocolate!\",\n" +
            "    \"buildingIx\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Swift fingers\",\n" +
            "    \"cost\": 1500,\n" +
            "    \"info\": \"So much skill! Much wow! Triple amount of chocolate per tap!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Certified confectioners\",\n" +
            "    \"cost\": 3000,\n" +
            "    \"info\": \"Confectioners work with twice efficiency!\",\n" +
            "    \"buildingIx\": 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Cursors modernization\",\n" +
            "    \"cost\": 5000,\n" +
            "    \"info\": \"Modernize cursors to double their production!\",\n" +
            "    \"buildingIx\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Make taps great again!\",\n" +
            "    \"cost\": 7500,\n" +
            "    \"info\": \"Your screen is screaming when tapping returns with tripple efiency!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"How about a tap?\",\n" +
            "    \"cost\": 12000,\n" +
            "    \"info\": \"Still no carpal tunnel \\nsyndrome? Taps x3!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Genetically modified cocoa beans\",\n" +
            "    \"cost\": 15000,\n" +
            "    \"info\": \"Plantation production doubles!\",\n" +
            "    \"buildingIx\": -1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Happy grandmas day\",\n" +
            "    \"cost\": 20000,\n" +
            "    \"info\": \"There is no such thing? Of course there is! Grandma production doubles!\",\n" +
            "    \"buildingIx\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Destructive mining\",\n" +
            "    \"cost\": 60000,\n" +
            "    \"info\": \"Kill all those ecoterrorists who want to stop your mining machines. Mine production x2!\",\n" +
            "    \"buildingIx\": 3\n" +
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
