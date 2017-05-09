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
//        data = "---LCD---" + System.getProperty("line.separator")
//                + data + System.getProperty("line.separator");
//        System.out.println(data);
//        return data;
        return super.customizedPrint(data,"LCD");
    }


}
