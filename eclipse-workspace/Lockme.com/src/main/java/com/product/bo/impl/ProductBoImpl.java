package com.product.bo.impl;

import java.util.List;

import com.product.Exception.BussinessException;
import com.product.bo.ProductBo;
import com.product.dao.ProductDAO;
import com.product.dao.impl.ProductDaoImpl;
import com.product.model.Product;

public class ProductBoImpl implements  ProductBo{
	
	private ProductDAO dao;
	public ProductDAO getDao()
	{
		
		if (dao == null)
			
		{
			dao = new ProductDaoImpl();
		}
		return dao;
	}

	@Override
	public Product addProduct(Product product) throws BussinessException {
		// TODO Auto-generated method stub
		 if (product == null )
		 {
			 throw new BussinessException("Product details can not be  empty");
			 
		 }
		 else if (!product.getName().matches("[a-zA-Z ]{3,15}") )
		 {
			 throw new BussinessException("Product Name  "+product.getName()+"   is invlid");
		 }
		 else
		 {
			 //code here for storage layer.
			 product = getDao().addProduct(product);
		 }
		return product;
	}
       private boolean isValidProductId(int id)
       {
    	   if ((id+"").matches("[0-9]{5}"))
    	   {
    		   return true;
    		   
    	   }else 
    	   {
    		   return false;
    	   }
       }
	@Override
	public Product getProductById(int id) throws BussinessException {
		// TODO Auto-generated method stub
		Product product = null;
		if (isValidProductId(id))
		{
			product = getDao().addProduct(product);
		}
		else 
		{
			throw new BussinessException("Enterd id "+id+"is invalid");
		}
		return product;
	}

	@Override
	public List<Product> getProductManufcturerName(String manufctureName) throws BussinessException {
		// TODO Auto-generated method stub
		return  getDao().getProductManufcturerName(manufctureName);
		
	}

	@Override
	public Product updateProductprice(int id, double newCost) throws BussinessException {
		// TODO Auto-generated method stub
		Product product = null;
		if (isValidProductId(id))
		{
			product = getDao().updateProductprice(id, newCost);
		}
		else 
		{
			throw new BussinessException("Enterd id "+id+"is invalid");
		}
		return product;
	}

	@Override
	public void deleteProduct(int id) throws BussinessException {
		// TODO Auto-generated method stub
		if (isValidProductId(id))
		{
			getDao().deleteProduct(id);
		}
		else 
		{
			throw new BussinessException("Enterd id "+id+"is invalid");
		}
	}

}
