package com.kamilkazmierczak.Devices.Output;

/**
 * Created by Kamil on 06.05.2017.
 */
public class LCDDisplay extends TextOutputDevice{
    public LCDDisplay(String manufacturer) {
        super(manufacturer);
    }

    public LCDDisplay(){

    }

    @Override
    public String print(String data){
        System.out.println("lcd:"+data);
        return "lcd:"+data;
    }


}
