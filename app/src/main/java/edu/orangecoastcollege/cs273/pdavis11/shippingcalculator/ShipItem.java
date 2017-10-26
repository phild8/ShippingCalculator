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

/**
* Default constructor setting all member variables to 0 
* and base cost set to constant. 
*/
    public ShipItem() {
        mOunces = 0;
        mBaseCost = BASE_CHARGE;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

/**   
* Getter method returning the base cost of shipping set to a constant 
* @return the base cost as a double 
*/
    public double getmBaseCost() {return mBaseCost;}
/**   
* Getter method returning the added cost of shipping
* @return the added cost as a double 
*/
    public double getmAddedCost() {
        return mAddedCost;
    }
/**   
* Getter method returning the total cost of shipping
* @return the total cost as a double 
*/
    public double getmTotalCost(){ return mTotalCost; }
/**   
* Method that sets the weight of the package in ounces 
* and calls the method to calculate added cost and stores 
* results in member variables 
*/
    public void setmOunces(int ounces) {
            mOunces = ounces;
            calculateAddedCost();
    }
/**   
* Method that calculates all the added cost based on
* package weight. If package over cut off weight adds 
* .5 to the cost 
* returns the calculated amount as a double 
*/
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
