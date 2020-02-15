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
        prefClockIn = mContext.getSharedPreferences(CLOCK_IN, 0);
        prefClockOut = mContext.getSharedPreferences(CLOCK_OUT, 0);

        sessionKey = prefKey.edit();
        sessionClockIn = prefClockIn.edit();
        sessionClockOut = prefClockOut.edit();

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
        sessionClockIn.putString(CLOCK_IN, clockIn);
        sessionClockIn.commit();
        return true;
    }

    public boolean isClockIn() {
        return prefClockIn.contains(CLOCK_IN);
    }

    public String getClockIn() {
        return prefClockIn.getString(CLOCK_IN, null);
    }

    public boolean setClockOut(String clockOut) {
        sessionClockOut.putString(CLOCK_OUT, clockOut);
        sessionClockOut.commit();
        return true;
    }

    public String getClockOut() { return prefClockOut.getString(CLOCK_OUT, null); }

    public void clearSession() {
        sessionKey.clear();
        sessionKey.commit();
        sessionClockOut.clear();
        sessionClockOut.commit();
        sessionClockIn.clear();
        sessionClockIn.commit();
    }
}
