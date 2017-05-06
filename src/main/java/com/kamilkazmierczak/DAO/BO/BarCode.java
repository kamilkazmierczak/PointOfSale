package com.kamilkazmierczak.DAO.BO;

import com.kamilkazmierczak.Interfaces.IBarCode;

/**
 * Created by Kamil on 06.05.2017.
 */
public class BarCode implements IBarCode{
    private long id;

    @Override
    public long getId() {
        return id;
    }
}
