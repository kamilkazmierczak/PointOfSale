package com.kamilkazmierczak.DAO;

import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IProduct;

/**
 * Created by Kamil on 06.05.2017.
 */
public class DAO implements IDAO{


    @Override
    public Iterable<IProduct> getAllProducts() {
        return null;
    }

    @Override
    public Iterable<IBarCode> getAllBarCodes() {
        return null;
    }
}
