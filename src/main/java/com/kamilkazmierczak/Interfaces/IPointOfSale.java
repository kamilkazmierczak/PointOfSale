package com.kamilkazmierczak.Interfaces;

/**
 * Created by Kamil on 07.05.2017.
 */
public interface IPointOfSale {
    void beginTransaction(); //todo boolean?
    void endTransaction(); //todo boolean?
    void scan(IBarCode barCode);
    void inputText(String text);
    void printReceipt(IReceipt receipt);

}
