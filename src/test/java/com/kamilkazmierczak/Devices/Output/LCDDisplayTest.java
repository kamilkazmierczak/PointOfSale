package com.kamilkazmierczak.Devices.Output;

import com.kamilkazmierczak.Configuration.TextConstants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 09.05.2017.
 */
public class LCDDisplayTest {

    private LCDDisplay lcdDisplay = null;

    @Before
    public void setUp() throws Exception {
        lcdDisplay = new LCDDisplay();
    }

    @Test
    public void ShouldPrint() throws Exception {
        String textData = "lcd" + System.lineSeparator() + "text" + System.lineSeparator() + "test";
        String output = lcdDisplay.print(textData);
        String header = TextConstants.TEXT_OUTPUT_INDICATOR + TextConstants.LCD + TextConstants.TEXT_OUTPUT_INDICATOR;
        String outputHeader = output.substring(0, header.length());
        String outputWithoutHeader = output.substring(
                header.length() + System.lineSeparator().length(),
                output.length() - System.lineSeparator().length()
        );

        assertEquals(outputWithoutHeader, textData);
        assertEquals(header, outputHeader);
    }
}