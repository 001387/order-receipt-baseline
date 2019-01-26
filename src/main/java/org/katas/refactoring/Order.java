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

		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : lineItems) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');

            double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax += salesTax;

            total += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totalSalesTax);

		output.append("Total Amount").append('\t').append(total);
		return output.toString();
	}
}
