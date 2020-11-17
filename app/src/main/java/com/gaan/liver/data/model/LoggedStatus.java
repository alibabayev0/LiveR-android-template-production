package com.gaan.liver.data.model;

public enum LoggedStatus {
    LOGGED_IN_MODE_LOGGED_OUT(0),
    LOGGED_IN_MODE_GOOGLE(1),
    LOGGED_IN_MODE_FB(2),
    LOGGED_IN_MODE_SERVER(3);

    private final int mType;

    LoggedStatus(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}
