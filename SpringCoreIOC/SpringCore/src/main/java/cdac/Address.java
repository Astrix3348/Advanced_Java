package cdac;

import org.springframework.stereotype.Component;

@Component
public class Address {
	String city = "New Delhi";
	String state = "Delhi";
	int pinCode = 11008;
	
	public String getAddress() {
		return city + " " + state + " " + pinCode;
	}
	
}
