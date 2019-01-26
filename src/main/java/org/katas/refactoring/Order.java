package org.katas.refactoring;

import java.util.List;

public class Order {
    private static final double taxRate = .10;
	String customerName;
    String customerAddress;
    List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

	public String receipt() {
		StringBuilder output = new StringBuilder();
		output.append("======Printing Orders======\n");

        output.append(customerName);
        output.append(customerAddress);

		for (LineItem lineItem : lineItems) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');
		}
		output.append("Sales Tax").append('\t').append(getTotalSalesTax());

		output.append("Total Amount").append('\t').append(getTotalAmountAndTax());
		return output.toString();
	}

	private double getTotalAmountAndTax() {
		double salesTax;
		double totalAmountAndTax = 0;
		for (LineItem lineItem : lineItems) {
			salesTax = lineItem.totalAmount() * taxRate;
			totalAmountAndTax += lineItem.totalAmount() + salesTax;
		}
		return totalAmountAndTax;
	}

	private double getTotalSalesTax() {
		double totalSalesTax = 0;
		for (LineItem lineItem : lineItems) {
			double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax += salesTax;
		} 
		return totalSalesTax;
	}
}
