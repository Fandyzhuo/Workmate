package com.workmate.application.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private SharedPreferences prefKey;
    private SharedPreferences.Editor sessionKey;
    private Context mContext;

    private static final String KEY = "key";

    public Session(Context context) {
        this.mContext = context;
        prefKey = mContext.getSharedPreferences(KEY, 0);
        sessionKey = prefKey.edit();
    }

    public boolean setKey(String key) {
        sessionKey.putString(KEY, key);
        sessionKey.commit();
        return true;
    }

    public String getKey() {
        return prefKey.getString(KEY, null);
    }

    public void clearSession() {
        sessionKey.clear();
        sessionKey.commit();
    }
}
