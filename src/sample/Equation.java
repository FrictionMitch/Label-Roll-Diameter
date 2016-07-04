package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by uMac on 2016-01-14.
 */
public class Equation {

    public static final double PI = 3.14159;
    public static final double GAP = .25;
    public static final double MIN_CORE = 400;
    public static final int SPEED = 14;
    public static final int MINUTES = 2;

    private double mHeight = 0;
    private double mRollQty = 0;
    private double mLength = 0;
    private double mThickness = 0;
    private double mCore = 0;
    private double mDiameter = 0;
    //feet per minute
    private int mSpeed = (int) (SPEED * 3.28);

    private BufferedReader mReader;

    public int getSpeed() {
        return mSpeed;
    }

    public double getDiameter() {
        return mDiameter;
    }
    public double getLength() {
        return mLength = (mHeight + GAP) * mRollQty;
    }

    public double getHeight() {
        return mHeight;
    }

    public double getRollQty() {
        return mRollQty;
    }

    public double getThickness() {
        return mThickness;
    }

    public double getCore() {
        return mCore;
    }


    public void diameter() {
        mDiameter = Math.pow(getLength()*(mThickness/PI)+((mCore /2)*(mCore /2)),.5) * 2;
    }


    public void rollQty() {
        mRollQty = (PI*((Math.pow(mDiameter,2)/4) - (Math.pow(mCore,2)/4)) / mThickness) / (mHeight + GAP);

    }


    public Equation() {


        mReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Enter the label height: %n");
        try {
            mHeight = Double.parseDouble(mReader.readLine());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.printf("Enter the roll quantity: %n");
        try {
            mRollQty = Double.parseDouble(mReader.readLine());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.printf("Enter the thickness: %n");
        try {
            mThickness = Double.parseDouble(mReader.readLine())/1000;
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.printf("Enter the core diameter: %n");
        try {
            mCore = Double.parseDouble(mReader.readLine());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        diameter();
        System.out.printf("The diameter of the roll is %f %n", getDiameter() );

        System.out.printf("Enter the outer diameter: %n");
        try {
            mDiameter = Double.parseDouble(mReader.readLine());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        rollQty();
        System.out.printf("The number of labels per roll are: %f %n", mRollQty);
    }

    public Equation(double height, double qtyDiameter, double thickness, double core) {
        mHeight = height;
        mRollQty = qtyDiameter;
        mThickness = thickness/1000;
        mCore = core;
        mDiameter = qtyDiameter;
//        diameter();
//        rollQty();
//        Equation eq = new Equation();


    }

}
