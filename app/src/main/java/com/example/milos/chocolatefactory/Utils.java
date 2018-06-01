package com.example.milos.chocolatefactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Simple utility class
 */
public class Utils {
    private Utils() {}

    private static DecimalFormat formatter = getFormatter();

    public static String toString(Long num) {
        return formatter.format(num);
    }

    private static DecimalFormat getFormatter() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
//        symbols.setGroupingSeparator(' ');
        return formatter = new DecimalFormat("###,###", symbols);
    }
}
