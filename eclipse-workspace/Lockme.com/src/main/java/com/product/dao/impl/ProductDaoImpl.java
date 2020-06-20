package com.product.dao.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.product.Exception.BussinessException;
import com.product.dao.ProductDAO;
import com.product.model.Product;

public class ProductDaoImpl implements ProductDAO {

	private Map<Integer,Product> productmap = new LinkedHashMap<>();
	@Override
	public Product addProduct(Product product) throws BussinessException {
		// TODO Auto-generated method stub
		if (productmap.size()==0)
		{
			productmap.put(10000,product);
			product.setId(10000);
		}else {
			List<Integer> idList = new ArrayList<>(productmap.keySet());
			Collections.sort(idList,Collections.reverseOrder());
			product.setId(idList.get(0)+1);
			productmap.put(product.getId(), product);
			
		}
		return null;
	}

	@Override
	public Product getProductById(int id) throws BussinessException {
		// TODO Auto-generated method stub
		if (productmap.containsKey(id))
		{
			return productmap.get(id);
		}else {
			throw new BussinessException("Enter "+id+ "doesnt exist");
		}
	
	}

	@Override
	public List<Product> getProductManufcturerName(String manufctureName) throws BussinessException {
         List<Product> productList = new ArrayList<>();
         for (Entry<Integer,Product> e:productmap.entrySet())
         {
        	 if (e.getValue().getManufctureName().equalsIgnoreCase(manufctureName))
        	 {
        		 productList.add(e.getValue());
        	 }
         }
         if (productList.size()== 0)
         {
        	 throw new BussinessException("No product foud by manufturer name"+manufctureName);
         }
		return productList;
	}

	@Override
	public Product updateProductprice(int id, double newCost) throws BussinessException {
		// TODO Auto-generated method stub
		if (productmap.containsKey(id))
		{
			Product product = productmap.get(id);
			product.setCost(newCost);
			productmap.put(id, product);
			return product ;
		}
		else
			
		{
			throw new BussinessException("no product with id "+id);
		}
	
	}

	@Override
	public void deleteProduct(int id) throws BussinessException {
		// TODO Auto-generated method stub
		if (productmap.containsKey(id))
		{
			productmap.remove(id);
		}
     else
			
		{
			throw new BussinessException("no product with id "+id);
		}
	}

	@Override
	public List<Product> getAllProducts() throws BussinessException {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>(productmap.values());
		return productList;
	}

}
