package com.sugeB;

import java.util.HashMap;

public class PersegiPanjang implements MenghitungBidang {
    HashMap<String, Float> data = new HashMap<String, Float>();


    public HashMap<String, Float> getData() {
        return data;
    }

    public void setData(HashMap<String, Float> data) {
        this.data = data;
    }

    PersegiPanjang(HashMap<String, Float> data){
        this.data = data;
    }


    @Override
    public float calculateKeliling() {
        return Float.parseFloat(String.valueOf(2 * (data.get("panjang") + data.get("lebar"))));
    }

    @Override
    public float calculateLuas() {
        return Float.parseFloat(String.valueOf(data.get("panjang") * data.get("lebar")));
    }

}
