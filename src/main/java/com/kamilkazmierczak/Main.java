package com.kamilkazmierczak;

import com.kamilkazmierczak.DAO.BO.BarCode;
import com.kamilkazmierczak.DAO.BO.Product;
import com.kamilkazmierczak.DAO.DAO;
import com.kamilkazmierczak.Interfaces.IProduct;
import com.kamilkazmierczak.Stubs.DataBase;

import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hi");


        DAO dao = new DAO();
        IProduct p1 = dao.createProduct("A",1);
        IProduct p2 = dao.createProduct("B",2);
        IProduct p3 = dao.createProduct("C",3);
        IProduct p4 = dao.createProduct("D",4);

        dao.addProduct(p1);
        dao.addProduct(p2);
        dao.addProduct(p3);
        dao.addProduct(p4);


        System.out.println(dao.getProduct(new BarCode(2)).getName());



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
