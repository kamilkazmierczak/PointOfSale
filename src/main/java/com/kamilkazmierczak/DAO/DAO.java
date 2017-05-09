package com.kamilkazmierczak.DAO;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.DataBase.DataBase;

/**
 * Created by Kamil on 06.05.2017.
 */
public class DAO implements IDAO {

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
    public void addProduct(IProduct product) {
        //TODO if find barcode in database throw exception
        DataBase.getInstance().addProduct(product);


    }


}
