package com.sugeB;

import java.util.HashMap;

public class Lingkaran implements MenghitungBidang {

    HashMap<String, Float> data = new HashMap<String, Float>();


    public HashMap<String, Float> getData() {
        return data;
    }

    public void setData(HashMap<String, Float> data) {
        this.data = data;
    }

    Lingkaran(HashMap<String, Float> data){
        this.data = data;
    }

    @Override
    public float calculateKeliling() {
        return Float.parseFloat (String.valueOf(Math.PI * 2 * data.get("jari")));
    }

    @Override
    public float calculateLuas() {
        return Float.parseFloat(String.valueOf((Math.PI * data.get("jari") * data.get("jari"))));
    }

}
