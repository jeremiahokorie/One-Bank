package com.crash.etranzact.collapsingtoolbar;

/**
 * Created by Etranzact on 2/7/2018.
 */

public class UssdAdapter  {
    private int mBanks;
    private String mUssd;

    public int getmBanks() {
        return this.mBanks;
    }

    public String getmUssd() {
        return this.mUssd;
    }

    public UssdAdapter(int mBanks, String mUssd) {
        this.mBanks = mBanks;
        this.mUssd = mUssd;
    }
}
