package com.kamilkazmierczak.Model;

import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Interfaces.IReceipt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kamil on 07.05.2017.
 */
public class Receipt implements IReceipt {
    private final static AtomicLong idCounter = new AtomicLong();
    private long id;
    private double currentSum;
    private boolean isOpen;
    private Map<IProduct, Integer> products;

    public Receipt() {
        id = idCounter.incrementAndGet();
        currentSum = 0;
        isOpen = true;
        products = new LinkedHashMap<>();
    }

    public long getId() {
        return id;
    }

    @Override
    public double getTotalSum() throws ReceiptNotClosedException {
        if (!isOpen)
            return  Math.round(currentSum*100.0)/100.0;
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
        currentSum +=  product.getPrice();
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
