package com.kamilkazmierczak.Exceptions;

/**
 * Created by Kamil on 09.05.2017.
 */
public class BarCodeAlreadyAssigned extends Exception{

    public BarCodeAlreadyAssigned(){}

    public BarCodeAlreadyAssigned(String message){
        super(message);
    }

}
