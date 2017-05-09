package com.kamilkazmierczak.Devices;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.Devices.Input.Scanner;
import com.kamilkazmierczak.Devices.Output.LCDDisplay;
import com.kamilkazmierczak.Devices.Output.Printer;
import com.kamilkazmierczak.Devices.Output.TextOutputDevice;
import com.kamilkazmierczak.Interfaces.*;
import com.kamilkazmierczak.Model.Receipt;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Kamil on 09.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleTest {

    @Mock
    Scanner scanner;
    @Mock
    Printer printer;
    @Mock
    LCDDisplay display;

    private IPointOfSale pointOfSale;

    @Before
    public void setUp() throws Exception {
        IProduct product1 = new Product("Product1",10.0, new BarCode(1));
        IProduct product2 = new Product("Product2",20.0, new BarCode(2));
        when(scanner.scanAndGetProduct(new BarCode(1))).thenReturn(product1);
        when(scanner.scanAndGetProduct(new BarCode(2))).thenReturn(product2);

        pointOfSale = new PointOfSale(scanner,printer,display);
    }

    @Test
    public void ShouldFindProduct() throws Exception {
        pointOfSale.scan(new BarCode(1));
        verify(display,times(1)).print("Product1;10.0");
    }

    @Test
    public void ShouldDetectInvalidBarCode() throws Exception {
        pointOfSale.scan(null);
        verify(display,times(1)).print("Invalid bar-code");
    }

    @Test
    public void ShouldNotFindProduct() throws Exception {
        pointOfSale.scan(new BarCode());
        verify(display,times(1)).print("Product not found");
    }

    @Test
    public void ShouldPrintTotalOnLCD() throws Exception {
        pointOfSale.scan(new BarCode(1));
        pointOfSale.scan(new BarCode(2));
        pointOfSale.inputText("exit");

        //verify(display,times(3)).print(any(String.class));
        verify(display,times(1)).print("Total: 30.0");
    }

    @Test
    public void ShouldInputText() throws Exception {
    }

    @Test
    public void ShouldPrintReceipt() throws Exception {
    }

    @Test
    public void ShouldBeginTransaction() throws Exception {
        pointOfSale.beginTransaction();
        assertEquals(true, pointOfSale.isTransactionInProgress());
    }

    @Test
    public void SholudEndTransaction() throws Exception {
        pointOfSale.beginTransaction();
        pointOfSale.endTransaction();
        assertEquals(false, pointOfSale.isTransactionInProgress());
    }



}