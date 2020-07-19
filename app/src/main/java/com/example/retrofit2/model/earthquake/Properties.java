package com.example.retrofit2.model.earthquake;

import com.google.gson.annotations.SerializedName;

public class Properties {
    @SerializedName("properties")
    private com.example.retrofit2.model.earthquake.Quake quake;

    public Quake getQuake() {
        return quake;
    }

    public void setQuakes(Quake quake) {
        this.quake = quake;
    }
}
