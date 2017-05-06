package com.kamilkazmierczak.Devices;

import com.kamilkazmierczak.Devices.Input.Scanner;
import com.kamilkazmierczak.Devices.Output.LCDDisplay;
import com.kamilkazmierczak.Devices.Output.Printer;
import com.kamilkazmierczak.Devices.Output.TextOutputDevice;
import com.kamilkazmierczak.Interfaces.*;

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

    public PointOfSale(){
        scanner = new Scanner();
        printer = new Printer();
        display = new LCDDisplay();
        isTransactionInProgress = false;
    }

    @Override
    public void beginTransaction() {

    }

    @Override
    public void endTransaction() {

    }

    public void scan(IBarCode barCode){
        if (barCode==null){
            display.print("Invalid bar-code");
        }else {
            IProduct product = scanner.scanAndGetProduct(barCode);
            if (product!=null){
                display.print(product.getName()+";"+product.getPrice());
            }else{
                display.print("Product not found");
            }
        }
    }

}
