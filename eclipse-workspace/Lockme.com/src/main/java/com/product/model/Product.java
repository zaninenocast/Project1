//
package com.product.model;

public class Product {
	
	private int id;
	private String name;
    private double cost;
    private float rating;
    private String manufctureName;

    public Product()
    {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getManufctureName() {
		return manufctureName;
	}

	public void setManufctureName(String manufctureName) {
		this.manufctureName = manufctureName;
	}

	public Product(int id, String name, double cost, float rating, String manufctureName) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.rating = rating;
		this.manufctureName = manufctureName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", rating=" + rating + ", manufctureName="
				+ manufctureName + "]";
	}

	
}
