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

        char[] suffixes = {'\0', 'K', 'M', 'B', 'T', 'Q',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char suffix;
        if (places < suffixes.length){
            suffix = suffixes[places];
        }
        else {
            suffix = '∞';
        }
        return rest.toString() + " " + suffix;
    }
}
