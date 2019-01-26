package org.katas.refactoring;

import java.util.List;

public class Order {
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
			output.append(lineItem.toString());
		}
		
		output.append("Sales Tax").append('\t').append(getTotalSalesTax());
		output.append("Total Amount").append('\t').append(getTotalAmountAndTax());
		return output.toString();
	}

	private double getTotalAmountAndTax() {
		double totalAmountAndTax = 0;
		for (LineItem lineItem : lineItems) {
			totalAmountAndTax += lineItem.totalAmount() + lineItem.salesTax();
		}
		return totalAmountAndTax;
	}

	private double getTotalSalesTax() {
		double totalSalesTax = 0;
		for (LineItem lineItem : lineItems) {
            totalSalesTax += lineItem.salesTax();
		} 
		return totalSalesTax;
	}
}
