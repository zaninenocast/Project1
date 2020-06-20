package com.product.dao;
import java.util.List;

import com.product.Exception.BussinessException;
import com.product.model.Product;

public interface ProductDAO {
	   public Product addProduct(Product product)  throws   BussinessException;
	   public Product getProductById(int id) throws  BussinessException;
	   public List<Product> getProductManufcturerName(String manufctureName) throws BussinessException;
	   public Product updateProductprice(int id,double newCost) throws BussinessException;
	   public void deleteProduct(int id ) throws BussinessException;
	   public List<Product>getAllProducts() throws BussinessException;
}
