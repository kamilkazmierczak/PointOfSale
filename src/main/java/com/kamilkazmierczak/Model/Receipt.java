package com.kamilkazmierczak.Model;

import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Interfaces.IReceipt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamil on 07.05.2017.
 */
public class Receipt implements IReceipt {

    private long currentSum;
    private boolean isOpen;
    private Map<IProduct, Integer> products;

    public Receipt() {
        currentSum = 0;
        isOpen = true;
        products = new HashMap<>();
    }

    @Override
    public long getTotalSum() throws ReceiptNotClosedException {
        if (!isOpen)
            return currentSum;
        else throw new ReceiptNotClosedException();
    }

    @Override
    public void addProduct(IProduct product) {
        if (products.get(product) == null) {
            products.put(product, 1);
        } else {
            Integer oldQuantity = products.get(product);
            products.put(product, ++oldQuantity);
        }
        System.out.println("wtf"+product.getPrice());
        currentSum += product.getPrice();

    }

    @Override
    public Map<IProduct, Integer> getAllProducts() {
        return products;
    }


    @Override
    public void closeReceipt() {
        isOpen = false;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }
}
