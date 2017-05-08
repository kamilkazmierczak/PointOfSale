package com.kamilkazmierczak.Model;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;
import com.kamilkazmierczak.Interfaces.IProduct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Kamil on 08.05.2017.
 */
public class ReceiptTest {

    private Receipt receipt = null;
    private final double productPrice = 10.5;
    private final double product2Price = 21;

    @Before
    public void setUp() throws Exception {
        receipt = new Receipt();
    }

    @Test
    public void ShouldGetTotalSum() throws Exception {
        Product product = new Product("Product", productPrice, new BarCode(1));
        receipt.addProduct(product);
        receipt.addProduct(product);

        Product product2 = new Product("Product2", product2Price, new BarCode(2));
        receipt.addProduct(product2);
        receipt.closeReceipt();

        assertEquals(2 * productPrice + product2Price, receipt.getTotalSum(), 0);
    }

    @Test(expected=ReceiptNotClosedException.class)
    public void ShouldNotGetTotalSum() throws Exception {
        Product product = new Product("Product", productPrice, new BarCode(1));
        receipt.addProduct(product);

        assertEquals(productPrice, receipt.getTotalSum(), 0);
    }

    @Test
    public void ShouldAddProduct() throws Exception {
        Product product = new Product("Product", productPrice, new BarCode(1));
        receipt.addProduct(product);
        Optional<IProduct> addedProduct = receipt.getAllProducts().keySet().stream().findFirst();
        assertEquals(product, addedProduct.get());
    }

    @Test
    public void ShouldUpdateProductQuantity() throws Exception {
        Product product = new Product("Product", productPrice, new BarCode(1));
        receipt.addProduct(product);
        receipt.addProduct(product);
        assertEquals((Integer) 2, receipt.getAllProducts().get(product));
    }

    @Test
    public void ShouldGetAllProducts() throws Exception {
        Product product = new Product("Product", productPrice, new BarCode(1));
        Product product2 = new Product("Product2", product2Price, new BarCode(2));
        receipt.addProduct(product);
        receipt.addProduct(product2);
        assertEquals(2, receipt.getAllProducts().size());
    }

    @Test
    public void ShouldCloseReceipt() throws Exception {
        receipt.closeReceipt();
        assertFalse(receipt.isOpen());
    }

    @Test
    public void ShouldBeOpen() throws Exception {
        assertTrue(receipt.isOpen());
    }

}