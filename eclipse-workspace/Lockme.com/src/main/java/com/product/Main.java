package com.product;

import java.util.List;
import java.util.Scanner;

import com.product.Exception.BussinessException;
import com.product.bo.ProductBo;
import com.product.bo.impl.ProductBoImpl;
import com.product.dao.impl.ProductDaoImpl;
import com.product.model.Product;

public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("APPLICATION NAME ---->  LOCKME.com");
         System.out.println("DEVELOPER NAME ------> KOMAL JATYANI");
         
         System.out.println("**************************************************************************");
         Scanner scer = new Scanner(System.in);
         int ch = 0;
         ProductBo productBo = new ProductBoImpl();
         do {
         System.out.println("Main Menu");
         System.out.println("-------------------------------");
         System.out.println("1) Create a Product");
         System.out.println("2) Update a Product");
         System.out.println("3) Get Product by ID");
         System.out.println("4) Get Product by manufacturerName");
         System.out.println("5) Get All Products ");
         System.out.println("6) Delete product");
         System.out.println("7) Exit");
         try {
        	 ch= Integer.parseInt(scer.nextLine());
         }catch (NumberFormatException e) {
			// TODO: handle exception
		}
         switch (ch) {
         case 1:Product product = new Product();
         System.out.println("Enter Product Name:");
          product.setName(scer.nextLine());
          System.out.println("Enter MAnufacturer Name :");
          product.setManufctureName(scer.nextLine());
          try {
          System.out.println("Enter Product Cost:");
          product.setCost(Double.parseDouble(scer.nextLine()));
          System.out.println("Enter Product Rating:");
          product.setRating(Float.parseFloat(scer.nextLine()));
           product=productBo.addProduct(product);
          if (product.getId()!=0) {
        	  
              System.out.println("Product is added ..");
        	  System.out.println(product);
          }
          }catch (NumberFormatException e) {
			// TODO: handle exception
        	  System.out.println("Enter correct rating and cost");
	      	}
          catch(BussinessException e) {
          System.out.println(e.getMessage());}
          catch (Exception e) {
			// TODO: handle exception
        	  System.out.println(e);
		}
        	 break;
         case 2:
        	 System.out.println("Working o it");
        	 break;
         case 3:
        	 System.out.println("Working o it");
        	 break;
         case 4:
        	 System.out.println("Working o it");
        	 break;
         case 5:
        	 try {
        		 List<Product> productList = new ProductDaoImpl().getAllProducts();
        		 System.out.println("Printing all the product......");
        		 for (Product p:productList)
        		 {
        			 System.out.println(p);
        		 }
        	 }catch (BussinessException e) {
				// TODO: handle exception
        		 System.out.println(e.getMessage());
			}
        	 break;
         case 6:
        	 System.out.println("Working o it");
        	 break;
         case 7:
        	 System.out.println("Thank you for using Lockme.com Applicatio.");
        	 break;
        	 
        	 
        	 default:System.out.println("Entered choice is invalid.Choice should be numeric between 0 - 7");
        	 break;
         }
         } while (ch!=7);
         }

}
