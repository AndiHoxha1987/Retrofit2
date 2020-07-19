package com.example.retrofit2.model.earthquake;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Features {

    @SerializedName("features")
    private List<Properties> Quakes;

    public List<Properties> getQuakes() {
        return Quakes;
    }

    public void setQuakes(List<Properties> quakes) {
        Quakes = quakes;
    }
}
