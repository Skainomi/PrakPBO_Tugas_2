package com.sugeB;

import java.util.HashMap;

public class Kerucut extends Lingkaran implements MenghitungRuang {


    public Kerucut(HashMap<String, Float> data) {
        super(data);

    }


    public HashMap<String, Float> getData() {
        return data;
    }

    public void setData(HashMap<String, Float> data) {
        this.data = data;
    }

    @Override
    public float calculateVolume() {
        return super.calculateLuas() * super.data.get("tinggi") / 3;
    }

    @Override
    public float calculateLuasPermukaan() {
        return Float.parseFloat(String.valueOf(Math.PI * super.data.get("jari") * (super.data.get("jari") + Math.sqrt((super.data.get("jari") * super.data.get("jari")) + (super.data.get("tinggi") * super.data.get("tinggi"))))));
    }

    public void outputData() {
        System.out.println("LUAS LINGKARAN : " + super.calculateLuas());
        System.out.println("KELILING LINGKARAN : " + super.calculateKeliling());
        outputData(0);
    }

    public void outputData(int a) {
        System.out.println("VOLUME KERUCUT : " + calculateVolume());
        System.out.println("LUAS PERMUKAAN KERUCUT : " + calculateLuasPermukaan());
    }

    @Override
    public float calculateKeliling() {
        return 0;
    }

    @Override
    public float calculateLuas() {
        return 0;
    }
}
