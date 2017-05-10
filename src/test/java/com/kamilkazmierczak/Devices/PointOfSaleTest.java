package com.kamilkazmierczak.Devices;

import com.kamilkazmierczak.Configuration.TextConstants;
import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Devices.Input.Scanner;
import com.kamilkazmierczak.Devices.Output.LCDDisplay;
import com.kamilkazmierczak.Devices.Output.Printer;
import com.kamilkazmierczak.Interfaces.*;
import com.kamilkazmierczak.Model.Receipt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DecimalFormat;

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

    private final String product1Name = "Product1";
    private final String product2Name = "Product2";
    private final double product1Price = 10.78;
    private final double product2Price = 211.16;
    private final int product1Quantity = 2;
    private final int product2Quantity = 4;
    private final long barCode1Code = 1;
    private final long barCode2Code = 2;


    @Before
    public void setUp() throws Exception {
        IProduct product1 = new Product(product1Name, product1Price, new BarCode(barCode1Code));
        IProduct product2 = new Product(product2Name, product2Price, new BarCode(barCode2Code));
        when(scanner.scanAndGetProduct(new BarCode(barCode1Code))).thenReturn(product1);
        when(scanner.scanAndGetProduct(new BarCode(barCode2Code))).thenReturn(product2);

        pointOfSale = new PointOfSale(scanner, printer, display);
    }

    @Test
    public void ShouldFindProduct() throws Exception {
        pointOfSale.scan(new BarCode(barCode1Code));
        verify(display, times(1)).
                print(product1Name + TextConstants.PRICE_SEPARATOR + product1Price);
    }

    @Test
    public void ShouldDetectInvalidBarCode() throws Exception {
        pointOfSale.scan(null);
        verify(display, times(1)).print(TextConstants.INVALID_BARCODE);
    }

    @Test
    public void ShouldNotFindProduct() throws Exception {
        pointOfSale.scan(new BarCode());
        verify(display, times(1)).print(TextConstants.PRODUCT_NOT_FOUND);
    }

    @Test
    public void ShouldPrintTotalOnLCD() throws Exception {
        pointOfSale.scan(new BarCode(barCode1Code));
        pointOfSale.scan(new BarCode(barCode2Code));
        pointOfSale.inputText(TextConstants.EXIT);

        double totalSum = product1Price + product2Price;
        totalSum = Math.round(totalSum*100.0)/100.0;

        String answer = TextConstants.TOTAL + totalSum;
        verify(display, times(1)).print(answer);
    }

    @Test
    public void ShouldPrintReceiptOnPrinter() throws Exception {
        for (int i = 0; i < product1Quantity; i++) {
            pointOfSale.scan(new BarCode(barCode1Code));
        }
        for (int i = 0; i < product2Quantity; i++) {
            pointOfSale.scan(new BarCode(barCode2Code));
        }
        pointOfSale.inputText(TextConstants.EXIT);

        double totalSum = (product1Quantity * product1Price) + (product2Quantity * product2Price);
        totalSum = Math.round(totalSum*100.0)/100.0;

        String output = product1Name +
                TextConstants.PRICE_SEPARATOR + product1Price +
                TextConstants.QUANTITY + product1Quantity +
                System.lineSeparator() +
                product2Name +
                TextConstants.PRICE_SEPARATOR + product2Price +
                TextConstants.QUANTITY + product2Quantity +
                System.lineSeparator() +
                TextConstants.TOTAL + totalSum;

        verify(printer, times(1)).print(output);
    }

    @Test
    public void ShouldNotPrintReceiptOnPrinter() throws Exception {
        pointOfSale.inputText(TextConstants.EXIT);
        String output = TextConstants.NOTHING_TO_EXIT;
        verify(display, times(1)).print(output);
    }

    @Test
    public void ShouldNotPrintReceiptOnPrinter2() throws Exception {
        Receipt receipt = new Receipt();
        pointOfSale.printReceipt(receipt);
        String output = TextConstants.RECEIPT_NOT_CLOSED_INFO;
        verify(display, times(1)).print(output);
    }

    @Test
    public void ShouldBeginTransaction() throws Exception {
        pointOfSale.beginTransaction();
        assertEquals(true, pointOfSale.isTransactionInProgress());
    }

    @Test
    public void ShouldEndTransaction() throws Exception {
        pointOfSale.beginTransaction();
        pointOfSale.endTransaction();
        assertEquals(false, pointOfSale.isTransactionInProgress());
    }
}