package com.kamilkazmierczak.Devices.Input;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.DataBase.DataBase;
import com.kamilkazmierczak.Devices.Output.LCDDisplay;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 09.05.2017.
 */
public class ScannerTest {

    private LCDDisplay lcdDisplay= null;
    private IBarCode barcode1 = null;
    private IBarCode barcode2 = null;
    private IProduct product1 = null;
    private IProduct product2 = null;

    @Before
    public void setUp() throws Exception {
        DAO dao = new DAO();
        product1 = dao.createProduct("Product1", 1.43);
        product2 = dao.createProduct("Product2", 2.9);

        barcode1 = product1.getBarCode();
        barcode2 = product2.getBarCode();

        dao.addProduct(product1);
        dao.addProduct(product2);
    }

    @Test
    public void ShouldScanAndGetProduct() throws Exception {
        Scanner scanner = new Scanner();
        IProduct product = scanner.scanAndGetProduct(barcode2);
        assertEquals(product2,product);
        assertEquals(product2.getName(),product.getName());
    }

    @Test
    public void ShouldScanAndNotGetProduct() throws Exception {
        Scanner scanner = new Scanner();
        IProduct product = scanner.scanAndGetProduct(new BarCode(27));
        assertEquals(product,null);
    }

}