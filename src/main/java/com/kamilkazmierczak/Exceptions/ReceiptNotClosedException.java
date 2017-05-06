package com.kamilkazmierczak.Exceptions;

/**
 * Created by Kamil on 07.05.2017.
 */
public class ReceiptNotClosedException extends Exception{

    public ReceiptNotClosedException(){}

    public ReceiptNotClosedException(String message){
        super(message);
    }
}
