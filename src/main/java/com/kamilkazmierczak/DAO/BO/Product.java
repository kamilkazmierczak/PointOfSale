package com.kamilkazmierczak.DAO.BO;

import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;

/**
 * Created by Kamil on 06.05.2017.
 */
public class Product implements IProduct{
    private String name;
    private double price;
    private IBarCode barCode;


    public Product(String name, double price, IBarCode barCode){
        this.name = name;
        this.price = price;
        this.barCode = barCode;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.barCode = null;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public IBarCode getBarCode() {
        return barCode;
    }

    public void setBarCode(IBarCode barCode) {
        this.barCode = barCode;
    }
}
