package sample;

public class Time {
    Controller controller = new Controller();

    //speed in meters/minute
    public static final int SPEED = 14;
    public static final int MINUTES = 2;

    //inches per meter
    private int mSpeed = (int) (SPEED * 3.28 * 12);

    //total amount to be run
    private int mTotalQty = 0;

    private double mTotalMaterial = 0;
    private double mCoreTime = 0;

    public double getCoreTime() {
        return mCoreTime;
    }


    public int getSpeed() {
        return mSpeed;
    }

    public int getTotalQty() {
        return mTotalQty;
    }


    //adding 2 minutes for every core change
    public double coreTime (double total, double core) {
        return mCoreTime = (total/core) * MINUTES;
    }

    //total material used
    public double totalMaterial(double labelHeight, double gap, double totalQty) {
        return mTotalMaterial = (labelHeight+gap)*totalQty;
    }

    public double totalTime(){
        return (mTotalMaterial / getSpeed()) + getCoreTime();
    }
}
