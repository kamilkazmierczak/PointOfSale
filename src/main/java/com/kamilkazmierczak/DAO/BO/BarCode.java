package com.kamilkazmierczak.DAO.BO;

import com.kamilkazmierczak.Interfaces.IBarCode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kamil on 06.05.2017.
 */
public class BarCode implements IBarCode{
    private final static AtomicLong idCounter = new AtomicLong();
    private long code;

    public BarCode(){
        this.code = idCounter.incrementAndGet();
    }

    public BarCode(long code){
        this.code = code;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public int hashCode()
    {
        return ((int)(code ^ (code >>>32)));
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof BarCode))
            return false;
        BarCode barCode = (BarCode)o;
        return this.code == barCode.code;
    }
}
