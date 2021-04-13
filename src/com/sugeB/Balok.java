package com.sugeB;

import java.util.HashMap;

public class Balok extends PersegiPanjang implements MenghitungRuang {


    public Balok(HashMap<String, Float> data) {
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
        return super.data.get("panjang") * super.data.get("lebar") * super.data.get("tinggi");
    }

    @Override
    public float calculateLuasPermukaan() {
        return 2 * ((super.data.get("panjang") * super.data.get("lebar") + (super.data.get("panjang") * super.data.get("tinggi")) + (super.data.get("lebar") * super.data.get("tinggi"))));
    }


    public void outputData() {
        System.out.println("LUAS Persegi : " + super.calculateLuas());
        System.out.println("KELILING PERSEGI : " + super.calculateKeliling());
        outputData(0);

    }

    public void outputData(int a){
        System.out.println("VOLUME BALOK : " + calculateVolume());
        System.out.println("LUAS PERMUKAAN BALOK : " + calculateLuasPermukaan());
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
