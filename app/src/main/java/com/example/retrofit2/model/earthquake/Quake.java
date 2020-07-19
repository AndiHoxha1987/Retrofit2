package com.example.retrofit2.model.earthquake;

import com.google.gson.annotations.SerializedName;

public class Quake {

    @SerializedName("mag")
    private final double magnitude;

    @SerializedName("place")
    private final String cityName;

    @SerializedName("time")
    private final long timeInMilliseconds;

    public Quake(double  magnitude,String cityName, long timeInMilliseconds){
        this.magnitude=magnitude;
        this.cityName=cityName;
        this.timeInMilliseconds=timeInMilliseconds;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getCityName(){
        return cityName;
    }

    public long getTimeInMilliseconds(){
        return timeInMilliseconds;
    }

}
