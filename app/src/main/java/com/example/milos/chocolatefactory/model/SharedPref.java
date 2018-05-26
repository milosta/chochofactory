package com.example.milos.chocolatefactory.model;

/**
 * Created by milos on 27.5.18.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref
{
    private static SharedPreferences mSharedPref;

    private SharedPref() {}

    public static void init(Context context) {
        if(mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(),
                                                       Context.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static Long read(String key, Long defValue) {
        return mSharedPref.getLong(key, defValue);
    }

    public static void write(String key, Long value) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }
}