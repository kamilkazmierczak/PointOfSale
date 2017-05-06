package com.kamilkazmierczak.Devices.Output;

/**
 * Created by Kamil on 06.05.2017.
 */
public class Display extends TextOutputDevice{
    public Display(String manufacturer) {
        super(manufacturer);
    }

    @Override
    public String print(String data){
        System.out.println("lcd:"+data);
        return "lcd:";
    }


}
