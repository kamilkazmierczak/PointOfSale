package com.kamilkazmierczak.Interfaces;

/**
 * Created by Kamil on 06.05.2017.
 */
public interface IDAO {

    //to remove
    Iterable<IProduct> getAllProducts();
    Iterable<IBarCode> getAllBarCodes();

    IBarCode createBarCode();
    IProduct createProduct(String name, double price, IBarCode barCode);
    IProduct createProduct(String name, double price);

    IBarCode getFreeBarCode();

    boolean addProduct(IProduct product);
    boolean addBarCode(IBarCode barCode);
}
