package edu.orangecoastcollege.cs273.pdavis11.shippingcalculator;

/**
 * Created by Phil on 9/19/2017.
 */


public class ShipItem {

    private static final double BASE_CHARGE = 3.00;
    private static final int CUT_OFF = 16;

    private int mOunces;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;


    public ShipItem() {
        mOunces = 0;
        mBaseCost = BASE_CHARGE;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    public double getmBaseCost() {return mBaseCost;}

    public double getmAddedCost() {
        return mAddedCost;
    }

    public double getmTotalCost(){ return mTotalCost; }

    public void setmOunces(int ounces) {
            mOunces = ounces;
            calculateAddedCost();
    }

    public void calculateAddedCost() {
            mAddedCost = 0.0;
            mTotalCost = 0.0;
            mBaseCost = BASE_CHARGE;

        if (mOunces < CUT_OFF)
            mBaseCost = 0.0;
        else {
            mOunces -= CUT_OFF;
            if (mOunces % 4 >= 1)
                mAddedCost += 0.5;
            mAddedCost += ((mOunces / 4) * 0.5);
            }

        mTotalCost += mAddedCost + mBaseCost;
    }
}
