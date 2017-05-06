package com.kamilkazmierczak.Stubs;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kamil on 06.05.2017.
 */
public class DataBase {

    private static DataBase instance = new DataBase();
    public static DataBase getInstance() {
        return instance;
    }

    private Map<IBarCode,IProduct> productsDataSet;


    private DataBase(){
        productsDataSet = new HashMap<>();
    }


    public boolean addProduct(IProduct product){
        this.productsDataSet.put(product.getBarCode(),product);
        return true;
    }

    public boolean addBarCode(IBarCode barCode){
        this.productsDataSet.put(barCode,null);
        return true;
    }



}
