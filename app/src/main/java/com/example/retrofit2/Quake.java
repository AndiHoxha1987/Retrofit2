package com.example.retrofit2;

import com.google.gson.annotations.SerializedName;

public class Quake {

    @SerializedName("mag")
    private double magnitude;

    @SerializedName("place")
    private String cityName;

    @SerializedName("time")
    private long timeInMilliseconds;

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
