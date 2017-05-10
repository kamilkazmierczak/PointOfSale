package com.kamilkazmierczak.DAO.BO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 10.05.2017.
 */
public class BarCodeTest {

    @Test
    public void ShouldSetProperCode() throws Exception {
        BarCode barCode1 = new BarCode();
        BarCode barCode2 = new BarCode();
        assertTrue(barCode1.getCode() != barCode2.getCode());
    }

    @Test
    public void getCode() throws Exception {
        BarCode barCode1 = new BarCode(71);
        assertEquals(barCode1.getCode(),71);
    }

}