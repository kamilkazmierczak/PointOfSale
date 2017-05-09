package com.kamilkazmierczak.Devices.Output;

/**
 * Created by Kamil on 06.05.2017.
 */
public class Printer extends TextOutputDevice{
    public Printer(String manufacturer) {
        super(manufacturer);
    }

    public Printer(){

    }

    @Override
    public String print(String data){
//        data = "---PRINTER---" + System.getProperty("line.separator")
//                + data + System.getProperty("line.separator");
//        System.out.println(data);
//        return data;
        return super.customizedPrint(data,"PRINTER");
    }

}
