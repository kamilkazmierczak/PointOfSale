package com.kamilkazmierczak.Devices.Output;

import com.kamilkazmierczak.Configuration.TextConstants;

/**
 * Created by Kamil on 06.05.2017.
 */
public class Printer extends TextOutputDevice {
    public Printer(String manufacturer) {
        super(manufacturer);
    }

    public Printer() {

    }

    @Override
    public String print(String data) {
        return super.customizedPrint(data, TextConstants.PRINTER);
    }

}
