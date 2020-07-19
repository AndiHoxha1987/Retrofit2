package com.example.retrofit2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Properties {
    @SerializedName("properties")
    private Quake Quake;

    public Quake getQuake() {
        return Quake;
    }

    public void setQuakes(Quake quake) {
        Quake = quake;
    }
}
