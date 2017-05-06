package com.kamilkazmierczak.DAO.BO;

import com.kamilkazmierczak.Interfaces.IBarCode;

/**
 * Created by Kamil on 06.05.2017.
 */
public class BarCode implements IBarCode{
    private long code;

    public BarCode(long code){
        this.code = code;
    }

    @Override
    public long getCode() {
        return code;
    }
}
