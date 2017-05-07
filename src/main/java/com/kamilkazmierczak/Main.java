package com.kamilkazmierczak;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.Devices.Input.Scanner;
import com.kamilkazmierczak.Devices.Output.Printer;
import com.kamilkazmierczak.Devices.PointOfSale;
import com.kamilkazmierczak.Exceptions.ReceiptNotClosedException;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Interfaces.IReceipt;
import com.kamilkazmierczak.Model.Receipt;

import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hi");


        DAO dao = new DAO();
        IProduct p1 = dao.createProduct("A", 1.43);
        IProduct p2 = dao.createProduct("B", 2.9);
        IProduct p3 = dao.createProduct("C", 3);
        IProduct p4 = dao.createProduct("D", 4);

        dao.addProduct(p1);
        dao.addProduct(p2);
        dao.addProduct(p3);
        dao.addProduct(p4);

        PointOfSale pos = new PointOfSale();
        pos.beginTransaction();
        pos.scan(new BarCode(2));
        pos.scan(new BarCode(2));
        pos.scan(new BarCode(1));
        pos.scan(new BarCode(3));
        pos.scan(new BarCode(9));
        pos.scan(null);
        pos.inputText("exit");


        //long a =1.3;
        //long b = 1.9;

        //pos.beginTransaction();
        //pos.scan(new BarCode(2));



//        Scanner scanner = new Scanner();
//        IProduct pr = scanner.scanAndGetProduct(new BarCode(2));
//
//        //Printer lcd = new Printer("LG");
//        //lcd.print("trolo");
//
//        //System.out.println(pr.getName());
//        //System.out.println(dao.getProduct(new BarCode(2)).getName());
//
//        PointOfSale pos = new PointOfSale();
//        pos.scan(new BarCode(2));
//        pos.scan(new BarCode(9));
//        pos.scan(null);
//
//        IReceipt receipt = new Receipt();
//        receipt.addProduct(p1);
//        receipt.addProduct(p2);
//        receipt.addProduct(p2);
//        receipt.addProduct(p2);
//        receipt.addProduct(p3);
//        receipt.addProduct(p4);
//        receipt.addProduct(p4);
//
//        receipt.closeReceipt();
//        try {
//            receipt.getTotalSum();
//        } catch (ReceiptNotClosedException e) {
//            e.printStackTrace();
//        }


//        Iterator it = receipt.getAllProducts().entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            Product prOb= (Product) pair.getKey();
//            System.out.println(prOb.getName() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
//        }


//        for (Integer value : receipt.getAllProducts().values()) {
//            //Product ob = (Product) value;
//            System.out.println(value);
//        }


        //System.out.println(

//        Iterator it = DataBase.getInstance().getProductsDataSet().entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
//        }

        //DataBase.getInstance().getProductsDataSet().get()

//        for (Object value :  DataBase.getInstance().getProductsDataSet().values()) {
//            Product ob = (Product)value;
//            System.out.println(ob.getName());
//        }

    }
}
