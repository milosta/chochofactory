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

    public static final double count = 0;
    public static final double cps = 0L;
    public static final double clickVal = 1L;
    public static final float cpsFractionClick = 0;

    public static final double buildingCostMultiplier = 1.18;

    public static final int[] buildingIcons = {
            R.drawable.ic_building_cursor,
            R.drawable.building_grandma,
            R.drawable.building_confectioner,
            R.drawable.building_plantation,
            R.drawable.building_mine,
            R.drawable.factory,
            R.drawable.building_wizard,
            R.drawable.building_temple,
            R.drawable.ic_building_alchemy,
            R.drawable.building_collider,
            R.drawable.building_portal,
            R.drawable.ic_building_time_machine,
    };
    public static final int[] upgradeIcons = {
            R.drawable.upgrade_final,
            R.drawable.ic_upgrade_tap_cps,
            R.drawable.ic_upgrade_tap,
            R.drawable.ic_upgrade_cursor,
    };

    public static final float offlineFirstKoeficient = 0.5f;
    public static final float offlineRestKoeficient = 0.25f;

    public static final int offlineIgnoreSeconds = 10;
    public static final int offlineFirstPeriod = 3600 * 4;
}
