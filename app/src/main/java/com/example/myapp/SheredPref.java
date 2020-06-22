package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SheredPref {

//    private Activity activity;
//
//    public sheredPref(Activity activity) {
//        this.activity = activity;
//    }
//
//    private static final String SETTINGS = "settings";
    private static final String ISSHOWN = "isShown";
//
//    public static  void isShown(Activity activity){
//        SharedPreferences preferences = activity.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
//        preferences.edit().putBoolean(ISSHOWN,true).apply();
//
//    }
//
//    public static   boolean isShownDva(Activity activity){
//        SharedPreferences preferences = activity.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
//        return preferences.getBoolean(SETTINGS,true);
//
//    }

    private SharedPreferences preferences;

    public SheredPref(Activity activity){
        preferences = activity.getPreferences(Context.MODE_PRIVATE);
    }
    public void isShown(boolean value){
        preferences.edit().putBoolean(ISSHOWN,value).apply();
    }
    public boolean isShown(){
        return preferences.getBoolean(ISSHOWN,false);
    }


}

