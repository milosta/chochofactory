package com.example.milos.chocolatefactory;

import android.app.ActionBar;
import android.app.Activity;
import android.view.View;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Simple UI utility class
 */
public class UiUtils {
    private UiUtils() {}

    public static void hideStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null)
            actionBar.hide();
    }
}
