package com.kamilkazmierczak.Devices;

import com.kamilkazmierczak.Configuration.TextConstants;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Devices.Input.Scanner;
import com.kamilkazmierczak.Devices.Output.LCDDisplay;
import com.kamilkazmierczak.Devices.Output.Printer;
import com.kamilkazmierczak.Devices.Output.TextOutputDevice;
import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;
import com.kamilkazmierczak.Interfaces.*;
import com.kamilkazmierczak.Model.Receipt;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kamil on 06.05.2017.
 */
public class PointOfSale implements IPointOfSale {
    private IScanner scanner;
    private TextOutputDevice printer;
    private TextOutputDevice display;
    private IReceipt receipt;
    private boolean isTransactionInProgress;

    public PointOfSale() {
        scanner = new Scanner();
        printer = new Printer();
        display = new LCDDisplay();
        isTransactionInProgress = false;
    }

    public PointOfSale(Scanner scanner, Printer printer, LCDDisplay display) {
        this.scanner = scanner;
        this.printer = printer;
        this.display = display;
        isTransactionInProgress = false;
    }

    @Override
    public void beginTransaction() {
        isTransactionInProgress = true;
        receipt = new Receipt();
    }

    @Override
    public void endTransaction() {
        isTransactionInProgress = false;
    }

    public void scan(IBarCode barCode) {
        if (!isTransactionInProgress)
            this.beginTransaction();

        if (barCode == null) {
            display.print(TextConstants.INVALID_BARCODE);
        } else {
            IProduct product = scanner.scanAndGetProduct(barCode);
            if (product != null) {
                display.print(product.getName() + TextConstants.PRICE_SEPARATOR + product.getPrice());
                receipt.addProduct(product);
            } else {
                display.print(TextConstants.PRODUCT_NOT_FOUND);
            }
        }
    }

    @Override
    public void inputText(String text) {
        if (text.equals(TextConstants.EXIT)) {
            if (!isTransactionInProgress) {
                display.print(TextConstants.NOTHING_TO_EXIT);
            } else {
                receipt.closeReceipt();
                this.printReceipt(receipt);
                this.endTransaction();
            }
        }
    }

    @Override
    public void printReceipt(IReceipt receipt) {
        Iterator it = receipt.getAllProducts().entrySet().iterator();

        String textReceipt = "";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Product product = (Product) pair.getKey();
            textReceipt += (product.getName() + TextConstants.PRICE_SEPARATOR + product.getPrice() + TextConstants.QUANTITY + pair.getValue());
            textReceipt += System.lineSeparator();
            it.remove();
        }

        double totalSum;
        try {
            totalSum = receipt.getTotalSum();
        } catch (ReceiptNotClosedException e) {
            display.print(TextConstants.RECEIPT_NOT_CLOSED_INFO);
            return;
        }

        textReceipt += TextConstants.TOTAL + totalSum;
        display.print(TextConstants.TOTAL + totalSum);
        printer.print(textReceipt);

    }

    public boolean isTransactionInProgress() {
        return isTransactionInProgress;
    }

}
