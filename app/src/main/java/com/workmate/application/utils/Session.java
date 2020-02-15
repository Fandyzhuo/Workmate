package com.workmate.application.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private SharedPreferences prefKey;
    private SharedPreferences prefClockIn;
    private SharedPreferences prefClockOut;
    private SharedPreferences.Editor sessionKey;
    private SharedPreferences.Editor sessionClockIn;
    private SharedPreferences.Editor sessionClockOut;

    private Context mContext;

    private static final String KEY = "key";
    private static final String CLOCK_IN = "clockin";
    private static final String CLOCK_OUT = "clockout";

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

    public boolean setClockIn(String clockIn) {
        sessionKey.putString(CLOCK_IN, clockIn);
        sessionKey.commit();
        return true;
    }

    public String getClockIn() {
        return prefClockIn.getString(CLOCK_IN, null);
    }

    public boolean setClockOut(String clockOut) {
        sessionKey.putString(CLOCK_OUT, clockOut);
        sessionKey.commit();
        return true;
    }

    public String getClockOut() { return prefClockOut.getString(CLOCK_OUT, null); }

    public void clearSession() {
        sessionKey.clear();
        sessionKey.commit();
    }
}
