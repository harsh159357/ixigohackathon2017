package ixigo.invincible.takemethere.harsh.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import ixigo.invincible.takemethere.harsh.interfaces.Constants;

//Controller for storing and retrieving data from Shared Preferences
public class SharedPreferencesController implements Constants {

    public static final String TAG = SharedPreferencesController.class.getName();

    private SharedPreferences sharedPreferences;

    private static SharedPreferencesController sharedPreferencesController;

    public static final String SHARED_PREF_NAME = "team_work_preferences";

    public enum Keys {
        LOGGED_IN("LOGGED_IN");

        private String label;

        Keys(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private SharedPreferencesController() {
    }

    public static SharedPreferencesController getInstance(Context context) {
        if (sharedPreferencesController == null) {
            sharedPreferencesController = new SharedPreferencesController();

        }
        if (sharedPreferencesController.sharedPreferences == null) {
            sharedPreferencesController.sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferencesController;
    }

    /**
     * This Method Clear shared preference.
     */
    public void clear() {
        Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private boolean getBoolean(String key, boolean defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }

        return defaultValue;
    }

    private void putBoolean(String key, boolean value) {
        try {
            if (sharedPreferences != null) {
                Editor editor = sharedPreferences.edit();
                editor.putBoolean(key, value);
                editor.apply();
            }
        } catch (Exception e) {
            Log.e(TAG, "Unable Put Boolean in Shared preference", e);
        }
    }

    private String getString(String key, String defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, defaultValue);
        }

        return defaultValue;
    }

    private void putString(String key, String value) {
        try {
            if (sharedPreferences != null) {
                Editor editor = sharedPreferences.edit();
                editor.putString(key, value);
                editor.apply();
            }
        } catch (Exception e) {
            Log.e(TAG, "Unable Put String in Shared preference", e);
        }
    }

    private long getLong(String key, long defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(key, defaultValue);
        }

        return defaultValue;
    }

    private void putLong(String key, long value) {
        try {
            if (sharedPreferences != null) {
                Editor editor = sharedPreferences.edit();
                editor.putLong(key, value);
                editor.apply();
            }
        } catch (Exception e) {
            Log.e(TAG, "Unable Put Boolean in Shared preference", e);
        }
    }

    public boolean isUserLoggedIn() {
        return getBoolean(Keys.LOGGED_IN.getLabel(), false);
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        putBoolean(Keys.LOGGED_IN.getLabel(), userLoggedIn);
    }

}
