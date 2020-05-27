package com.example.android.quakereport;

public class Earthquake {

    // will store name of the location
    private String mlocation;

    // will store the value of the magnitude
    private double mMagnitude;

    // will store the date on which the earthquake occurred
    private long mTimeInMilliseconds;

    // will store the url of each earthquake object
    private  String mUrl;

    /**
     * Create a new Earthquake Object to store all the data related to earthquakes
     * @param Location is the location at which the earthquake occurred
     * @param Magnitude is the magnitude of the Earthquake
     * @param Magnitude is the date on which the earthquake occurred
     */
    public Earthquake(String Location , double Magnitude , long timeInMilliseconds , String url){
        mlocation = Location;
        mMagnitude = Magnitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    //Get the location
    public String getLocation() {
        return mlocation;
    }

    //Get the magnitude
    public double getMagnitude() {
        return mMagnitude;
    }

    //Get the date
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    //Get the url
    public String getUrl(){
        return mUrl;
    }
}
