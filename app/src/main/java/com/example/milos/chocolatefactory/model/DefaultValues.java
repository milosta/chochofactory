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
            R.drawable.ic_building_cursor,
            R.drawable.building_grandma,
            R.drawable.building_confectioner,
            R.drawable.building_plantation,
            R.drawable.building_mine,
            R.drawable.factory,
            R.drawable.building_wizard,
            R.drawable.ic_building_temple,
            R.drawable.ic_building_alchemy,
            R.drawable.building_collider,
            R.drawable.building_portal,
            R.drawable.ic_building_time_machine,
    };
    public static final int[] upgradeIcons = {
            R.drawable.ic_upgrade_tap,
            R.drawable.ic_upgrade_cursor,
    };
}
