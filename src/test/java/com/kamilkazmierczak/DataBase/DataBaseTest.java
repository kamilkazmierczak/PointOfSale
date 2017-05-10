package com.kamilkazmierczak.DataBase;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 10.05.2017.
 */
public class DataBaseTest {

    private DataBase dataBase = null;

    @Before
    public void setUp() throws Exception {
        dataBase = DataBase.getInstance();
    }

    @Test
    public void ShouldAddAndGetProduct() throws Exception {
        BarCode barCode = new BarCode();
        Product product = new Product("Product1", 11.5, barCode);
        dataBase.addProduct(product);
        IProduct productFromDb = dataBase.getProductsDataSet().get(barCode);
        assertEquals(product, productFromDb);
    }

    @Test
    public void ShouldGetProductsDataSet() throws Exception {
        final Map<IBarCode, IProduct> productsDataSet = dataBase.getProductsDataSet();
        assertTrue(productsDataSet != null);
    }

}