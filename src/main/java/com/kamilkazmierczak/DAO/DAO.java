package com.kamilkazmierczak.DAO;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Stubs.DataBase;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kamil on 06.05.2017.
 */
public class DAO implements IDAO {


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
        return new BarCode();
    }

    @Override
    public IProduct createProduct(String name, double price) {
        return new Product(name, price, createBarCode());
    }

    @Override
    public IProduct getProduct(IBarCode code) {
        return DataBase.getInstance().getProductsDataSet().get(code);
    }


    @Override
    public boolean addProduct(IProduct product) {
        DataBase.getInstance().addProduct(product);

        //TODO
        return true;
    }


}
