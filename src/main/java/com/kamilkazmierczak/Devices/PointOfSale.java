package com.kamilkazmierczak.Devices;

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

    //TODO add text to ResourseBoundle

    public PointOfSale() {
        scanner = new Scanner();
        printer = new Printer();
        display = new LCDDisplay();
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
        if (isTransactionInProgress) {
            if (barCode == null) {
                display.print("Invalid bar-code");
            } else {
                IProduct product = scanner.scanAndGetProduct(barCode);
                if (product != null) {
                    display.print(product.getName() + ";" + product.getPrice());
                    receipt.addProduct(product);
                } else {
                    display.print("Product not found");
                }
            }
        } else {
            display.print("Begin transaction to scan bar-code"); //TODO remove?
        }

    }

    @Override
    public void inputText(String text) {
        if (text.equals("exit")) {

            if (receipt == null || !isTransactionInProgress ){ //|| receipt.receiptIsOpen()
                display.print("Nothing to exit"); //TODO remove?
            }else {
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
            Map.Entry pair = (Map.Entry)it.next();
            Product product = (Product) pair.getKey();
            textReceipt+=(product.getName()+" price:"+ product.getPrice()+ " Q= " + pair.getValue());
            textReceipt+='\n';
            //printer.print(product.getName()+" price:"+ product.getPrice()+ " Q= " + pair.getValue());
            it.remove();
        }

        double totalSum = 0;
        try {
            totalSum = receipt.getTotalSum();
        } catch (ReceiptNotClosedException e) {
            display.print("Receipt must be closed to get Total Sum");
        }

        textReceipt+="Total: "+ totalSum;
        textReceipt+='\n';
        display.print("Total: "+ totalSum);
        printer.print(textReceipt);

    }

}
