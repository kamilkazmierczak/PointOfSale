package com.kamilkazmierczak.DAO;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Exceptions.BarCodeAlreadyAssigned;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 09.05.2017.
 */
public class DAOTest {

    private DAO dao = null;

    @Before
    public void setUp() throws Exception {
        dao = new DAO();
    }

    @Test
    public void ShouldCreateBarCode() throws Exception {
        IBarCode barCode = dao.createBarCode();
        assertTrue(barCode instanceof BarCode);
    }

    @Test
    public void ShouldCreateProduct() throws Exception {
        IProduct product = dao.createProduct("Product", 56.71);
        assertTrue(product instanceof Product);
    }

    @Test
    public void ShouldAddAndGetProduct() throws Exception {
        dao.addProduct(new Product("Product", 23.1, new BarCode(77)));
        dao.getProduct(new BarCode(77));
    }

    @Test(expected=BarCodeAlreadyAssigned.class)
    public void ShouldNotAddProduct() throws Exception {
        BarCode barCode = new BarCode();
        Product product1 = new Product("Product1", 51.1, barCode);
        Product product2 = new Product("Product2", 4.11, barCode);
        dao.addProduct(product1);
        dao.addProduct(product2);
    }

}