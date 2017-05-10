package com.kamilkazmierczak.Devices.Output;

import com.kamilkazmierczak.Configuration.TextConstants;

/**
 * Created by Kamil on 06.05.2017.
 */
public abstract class TextOutputDevice {

    private String manufacturer = TextConstants.NONAME_MANUFACTURER;

    public TextOutputDevice(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TextOutputDevice() {

    }

    public String print(String data) {
        return data;
    }

    public String customizedPrint(String data, String type) {
        String output = TextConstants.TEXT_OUTPUT_INDICATOR +
                type +
                TextConstants.TEXT_OUTPUT_INDICATOR +
                System.lineSeparator() +
                data + System.lineSeparator();

        System.out.println(output);
        return output;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
