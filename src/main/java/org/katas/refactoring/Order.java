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

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

	public String receipt() {
		StringBuilder output = new StringBuilder();
		output.append("======Printing Orders======\n");

        output.append(getCustomerName());
        output.append(getCustomerAddress());

		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : getLineItems()) {
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
