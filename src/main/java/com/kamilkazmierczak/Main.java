package com.kamilkazmierczak;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.Devices.PointOfSale;
import com.kamilkazmierczak.Interfaces.IBarCode;
import com.kamilkazmierczak.Interfaces.IDAO;
import com.kamilkazmierczak.Interfaces.IPointOfSale;
import com.kamilkazmierczak.Interfaces.IProduct;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Point of Sale - Example");

        IDAO dao = new DAO();
        IProduct product1 = dao.createProduct("Product1", 1.41);
        IProduct product2 = dao.createProduct("Product2", 7.50);
        IProduct product3 = dao.createProduct("Product3", 12.99);
        IProduct product4 = dao.createProduct("Product4", 591.43);

        IBarCode barCode1 = product1.getBarCode();
        IBarCode barCode2 = product2.getBarCode();
        IBarCode barCode3 = product3.getBarCode();
        IBarCode barCode4 = product4.getBarCode();

        dao.addProduct(product1);
        dao.addProduct(product2);
        dao.addProduct(product3);
        dao.addProduct(product4);


        IPointOfSale pointOfSale = new PointOfSale();

        pointOfSale.scan(barCode1);
        pointOfSale.scan(barCode2);
        pointOfSale.scan(new BarCode(1));
        pointOfSale.scan(new BarCode(3));
        pointOfSale.scan(new BarCode(9));
        pointOfSale.scan(null);
        pointOfSale.inputText("exit");
    }
}
