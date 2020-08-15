package com.juaracoding.huda.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {

    private static final String SHARED_APP_PREFERENCED_NAME = "JuaracodingPreference";
    Context context;
    private SharedPreferences pref;
    private SharedPreferences.Editor mEditor;

       public SharedPrefUtil(Context context){
           this.pref = context.getSharedPreferences(SHARED_APP_PREFERENCED_NAME,Context.MODE_PRIVATE);
       }

       public static SharedPrefUtil getInstance(Context context){

           return new SharedPrefUtil(context);
       }

       public void put(String key, String value){
           this.pref.edit().putString(key,value).apply();
       }

       public String getString(String key){
           return pref.getString(key,"");
       }
}
