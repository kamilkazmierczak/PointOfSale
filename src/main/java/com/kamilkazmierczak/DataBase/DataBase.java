package com.kamilkazmierczak.DataBase;

import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;

import java.util.HashMap;
import java.util.Map;

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

    public Map<IBarCode,IProduct> getProductsDataSet(){
        return productsDataSet;
    }

}
