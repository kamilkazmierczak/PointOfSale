package com.kamilkazmierczak.Devices.Output;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 09.05.2017.
 */
public class PrinterTest {
    private Printer printer= null;

    @Before
    public void setUp() throws Exception {
        printer= new Printer();
    }
    @Test
    public void ShouldPrint() throws Exception {
        String textData = "printer"+System.lineSeparator()+"text"+System.lineSeparator()+"lolo";
        String output = printer.print(textData);
        String outputHeader = output.substring(0,"---PRINTER---".length());
        String outputWithoutHeader = output.substring("---PRINTER---".length()+System.lineSeparator().length(),output.length()-System.lineSeparator().length());

        assertEquals(outputWithoutHeader,textData);
        assertEquals("---PRINTER---",outputHeader);
    }
}