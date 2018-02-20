package com.crash.etranzact.collapsingtoolbar;

/**
 * Created by Etranzact on 2/2/2018.
 */

public class Customer {
    private String mphoneCustomer;
    private String mCustomrcareName;
    private int mImageBank;

    public String getMphoneCustomer() {
        return this.mphoneCustomer;
    }

    public String getmCustomrcareName() {
        return this.mCustomrcareName;
    }

    public int getmImageBank() {
        return this.mImageBank;
    }

    public Customer(String mphoneCustomer, String mCustomrcareName, int mImageBank) {
        this.mphoneCustomer = mphoneCustomer;
        this.mCustomrcareName = mCustomrcareName;
        this.mImageBank = mImageBank;


    }
}
