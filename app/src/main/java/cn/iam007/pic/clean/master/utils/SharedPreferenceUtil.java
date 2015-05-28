package cn.iam007.pic.clean.master.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

import cn.iam007.pic.clean.master.Iam007Application;

public class SharedPreferenceUtil {
    /**
     * 当前选中需要删除的图片中的文件大小
     */
    public final static String SELECTED_DELETE_IMAGE_TOTAL_SIZE = "SELECTED_DELETE_IMAGE_TOTAL_SIZE";
    public final static String SELECTED_RECYCLER_IMAGE_TOTAL_SIZE = "SELECTED_RECYCLER_IMAGE_TOTAL_SIZE";

    // 用于表示是否有清理相似图片
    public final static String HAS_DELETE_SOME_DUPLICATE_IMAGE = "HAS_DELETE_SOME_DUPLICATE_IMAGE";

    public static void setBoolean(String key, Boolean value){
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);

        if (value != sp.getBoolean(key, false)) {
            Editor editor = sp.edit();
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public static boolean getBoolean(String key, Boolean defaultValue){
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);
        return sp.getBoolean(key, defaultValue);
    }

    public static void setSharedPreference(String key, Long value) {
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);

        if (value != sp.getLong(key, 0)) {
            Editor editor = sp.edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    /**
     * 在当前保存的值上增加value值
     * 
     * @param key
     * @param value
     */
    public static void addSharedPreference(String key, Long value) {
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);
        Editor editor = sp.edit();
        editor.putLong(key, sp.getLong(key, 0) + value);
        editor.commit();
    }

    /**
     * 在当前保存的值上减少value值
     * 
     * @param key
     * @param value
     */
    public static void subSharedPreference(String key, Long value) {
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);
        Editor editor = sp.edit();
        editor.putLong(key, sp.getLong(key, 0) - value);
        editor.commit();
    }

    public static void setOnSharedPreferenceChangeListener(
            String key, OnSharedPreferenceChangeListener listener) {
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);

        sp.registerOnSharedPreferenceChangeListener(listener);
    }

    public static void clearOnSharedPreferenceChangeListener(
            String key, OnSharedPreferenceChangeListener listener) {
        SharedPreferences sp = Iam007Application.getApplication()
                .getSharedPreferences(key, 0);

        sp.unregisterOnSharedPreferenceChangeListener(listener);
    }
}