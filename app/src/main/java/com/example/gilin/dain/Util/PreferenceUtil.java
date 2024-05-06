package com.example.gilin.dain.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {
    public static final String PREFERENCES_NAME = "rebuild_preference";
    private static final String DEFAULT_VALUE_STRING = "";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    // 유저 ID 저장
    public static void setUserId(Context context, String userId) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("userId", userId);
        editor.apply();
    }

    // 유저 ID 가져오기
    public static String getUserId(Context context) {
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString("userId", DEFAULT_VALUE_STRING);
    }

    // 로그인 상태 저장
    public static void setLoginStatus(Context context, String loginState) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("loginState", loginState);
        editor.apply();
    }

    // 로그인 상태 가져오기
    public static String getLoginStatus(Context context) {
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString("loginState", "x");
    }

}