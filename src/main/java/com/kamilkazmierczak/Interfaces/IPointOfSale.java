package com.kamilkazmierczak.Interfaces;

/**
 * Created by Kamil on 07.05.2017.
 */
public interface IPointOfSale {
    void beginTransaction();

    void endTransaction();

    void scan(IBarCode barCode);

    void inputText(String text);

    void printReceipt(IReceipt receipt);

    boolean isTransactionInProgress();

}
