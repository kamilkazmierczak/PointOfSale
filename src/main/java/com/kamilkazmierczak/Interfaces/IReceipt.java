package com.kamilkazmierczak.Interfaces;

import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;

import java.util.Map;

/**
 * Created by Kamil on 07.05.2017.
 */
public interface IReceipt {
    double getTotalSum() throws ReceiptNotClosedException;

    void addProduct(IProduct product);

    Map<IProduct, Integer> getAllProducts();

    void closeReceipt();

    boolean isOpen();
}
