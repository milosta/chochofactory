package com.example.milos.chocolatefactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Simple utility class
 */
public class Utils {
    private Utils() {}

    private static DecimalFormat formatterNormal = getFormatter("###,###");
    private static DecimalFormat formatterScientific = getFormatter("0.###E0");

    private static DecimalFormat getFormatter(String pattern) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        return new DecimalFormat(pattern, symbols);
    }

// https://stackoverflow.com/questions/16319237/cant-put-double-sharedpreferences

    public static String toStringScientific(double num) {
        if (num < 1000000)
            return formatterNormal.format(num);
        else {
            return formatterScientific.format(num);
        }
    }

    public static String toString(double num) {
        int places = 0;
        while(num >= 1000) {
            num /= 1000;
            places++;
        }

        Double rest = Math.floor(num * 100) / 100;

        String[] suffixes = {"", "K", "M", "B", "T", "Q"};
        return rest.toString() + " " + suffixes[places];
    }
}
