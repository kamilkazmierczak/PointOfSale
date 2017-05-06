package com.kamilkazmierczak.Devices.Output;

/**
 * Created by Kamil on 06.05.2017.
 */
public abstract class TextOutputDevice {

    private String manufacturer = "NoName";

    public TextOutputDevice(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public TextOutputDevice(){

    }

    public String print(String data){
        System.out.println(data); //TODO to consider
        return data;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
