package cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
	String order;
	Invoice invoice;
	
	@Autowired
	public Order(
			@Value("Pizza")  String order, 
			Invoice invoice) {
		this.order = order;
		this.invoice = invoice;
	}
	
	public void getDetails() {
		System.out.println(order);
		System.out.println(invoice.details());
	}
}
