package cdac;

import org.springframework.stereotype.Component;

@Component
public class Invoice {
	int bill = 2100;
	double tax = 0.15;
	double totalBill = bill - (bill * tax);
	
	public String details() {
		return bill + " " + tax + " " + totalBill;
	}
}
