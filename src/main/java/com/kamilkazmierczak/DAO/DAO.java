package com.kamilkazmierczak.DAO;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Stubs.DataBase;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kamil on 06.05.2017.
 */
public class DAO implements IDAO{

    private final static AtomicLong idCounter = new AtomicLong();

    @Override
    public Iterable<IProduct> getAllProducts() {
        return null;
    }

    @Override
    public Iterable<IBarCode> getAllBarCodes() {
        return null;
    }

    @Override
    public IBarCode createBarCode() {
        return new BarCode(idCounter.incrementAndGet());
    }

    @Override
    public IProduct createProduct(String name, double price, IBarCode barCode) {
        return new Product(name,price,barCode);
    }

    @Override
    public IProduct createProduct(String name, double price) {
        return new Product(name,price);
    }

    @Override
    public IBarCode getFreeBarCode() {
        return null;
    }

    @Override
    public boolean addProduct(IProduct product) {
        if (product.getBarCode()!=null){
            DataBase.getInstance().addProduct(product); //code duplicate
        }else if(getFreeBarCode()!=null){
            product.setBarCode(getFreeBarCode());
            DataBase.getInstance().addProduct(product); //code duplicate
        }else{
            product.setBarCode(this.createBarCode());
            DataBase.getInstance().addProduct(product); //code duplicate
        }

        //TODO
        return false;
    }

    @Override
    public boolean addBarCode(IBarCode barCode) {
        return false;
    }
}
