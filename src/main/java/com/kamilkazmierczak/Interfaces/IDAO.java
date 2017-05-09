package com.kamilkazmierczak.Interfaces;

/**
 * Created by Kamil on 06.05.2017.
 */
public interface IDAO {

    IBarCode createBarCode();
    IProduct createProduct(String name, double price);

    IProduct getProduct(IBarCode code);

    void addProduct(IProduct product);
}
