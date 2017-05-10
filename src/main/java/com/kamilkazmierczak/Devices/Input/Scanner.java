package com.kamilkazmierczak.Devices.Input;

import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Interfaces.IScanner;

/**
 * Created by Kamil on 06.05.2017.
 */
public class Scanner implements IScanner {

    private IDAO dao;

    public Scanner() {
        dao = new DAO();
    }

    @Override
    public IProduct scanAndGetProduct(IBarCode barCode) {
        return dao.getProduct(barCode);
    }
}
