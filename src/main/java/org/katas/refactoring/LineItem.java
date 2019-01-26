package org.katas.refactoring;

public class LineItem {
	private static final double taxRate = .10;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    public double totalAmount() {
        return price * quantity;
    }
    
    public String toString() {
		return description + '\t' 
    			+ price + '\t'
    			+ quantity + '\t'
    			+ totalAmount() + '\n';
	}

	public double salesTax() {
		return totalAmount() * taxRate;
	}
}