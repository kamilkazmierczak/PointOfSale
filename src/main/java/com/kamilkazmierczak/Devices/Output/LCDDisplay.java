package com.kamilkazmierczak.Devices.Output;

import com.kamilkazmierczak.Configuration.TextConstants;

/**
 * Created by Kamil on 06.05.2017.
 */
public class LCDDisplay extends TextOutputDevice {
    public LCDDisplay(String manufacturer) {
        super(manufacturer);
    }

    public LCDDisplay() {

    }

    @Override
    public String print(String data) {
        return super.customizedPrint(data, TextConstants.LCD);
    }


}
