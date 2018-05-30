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

    public static final double multiplier = 1.3;

    public static final int[] buildingIcons = {
            R.drawable.building_cursor,
    };

    public static final String buildingList = "[\n" +
            "  {\n" +
            "    \"name\": \"cursor\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor2\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor3\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor4\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor5\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor6\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor7\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor8\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor9\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor10\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor11\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"cursor12\",\n" +
            "    \"cost\": 27,\n" +
            "    \"count\": 0,\n" +
            "    \"cps\": 1\n" +
            "  }\n" +
            "]";

//    public static final String buildingList =  DefaultValues.readFile("buildings.json");

    private static String readFile(String path) {
        try {
            return new Scanner(new File(path)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            return "";
        }
    }

}
