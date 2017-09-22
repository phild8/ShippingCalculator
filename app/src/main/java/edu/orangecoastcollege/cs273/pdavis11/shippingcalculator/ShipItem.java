package edu.orangecoastcollege.cs273.pdavis11.shippingcalculator;

/**
 * Created by Phil on 9/19/2017.
 */


public class ShipItem {

//    public static final double BASE_CHARGE = 3.00;

    private int mOunces;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    String ounceStr = "";

    public ShipItem() {
        mOunces = 0;
        mBaseCost = 3.0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;

    }

    public int getmOunces() {
        return mOunces;
    }

    public void setmOunces(int mewOunces) {
        mOunces = mewOunces;
    }

    public double getmBaseCost() {
        return mBaseCost;
    }

    public void setmBaseCost(double newBaseCost) {
        mBaseCost = newBaseCost;
    }

    public double getmAddedCost() {
        return mAddedCost;
    }

    public double getmTotalCost(){
        mTotalCost = calculateBase(mOunces) + calculateAddedCost(mOunces);
        return mTotalCost;
    }

    public double calculateBase(int mOunces) {
        if (mOunces > 0)
            return mBaseCost = 3.0;
        else
            return mBaseCost;
    }


    public double calculateAddedCost(int mOunces) {
        recalculate();

        int price = 0;

        if (mOunces < 16)
            return mAddedCost;
        else {
            mOunces -= 16;

            if(mOunces % 4 == 0)
                price = mOunces / 4;
            else{
                if(mOunces % 4 > 1)
                {
                    mAddedCost += price;
                    mAddedCost += 0.50;
                }
            }
        }
        return mAddedCost;
    }

    public void recalculate()
    {
        ounceStr = ounceStr + mOunces;
        mOunces = Integer.parseInt(ounceStr);
    }

}
