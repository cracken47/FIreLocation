package com.karan.firelocation.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SavedSharedPreferences {
    private static final String PREF_USER_NAME = "username";
    private static final String USER_EMAIL = "noone@gmail.com";
    private static final String FIREBASEID ="firebaseid";


    public static void setUserName(Context ctx, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.apply();
    }


    private static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);

    }

    public static String getUserName(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }
    public static void setUserEmail(Context ctx, String email) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }

    public static String getUserEmail(Context ctx) {
        return getSharedPreferences(ctx).getString(USER_EMAIL, "");
    }
    public static String getFirebaseid(Context ctx) {
        return getSharedPreferences(ctx).getString(FIREBASEID, "");


    }
    public static  void setFirebaseid(Context ctx , String firebaseid){

        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(FIREBASEID,firebaseid);
        editor.apply();
    }
    public static void removeALlSharedPreferences(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.remove(PREF_USER_NAME);
        editor.remove(USER_EMAIL);
        editor.remove(FIREBASEID);
        editor.apply();
    }

}
