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


    public static String toString(Long num) {
        if (num < 1000000)
            return formatterNormal.format(num);
        else {
            return formatterScientific.format(num);
        }
    }

    private static DecimalFormat getFormatter(String pattern) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
//        symbols.setGroupingSeparator(' ');
        return new DecimalFormat(pattern, symbols);
    }
}
