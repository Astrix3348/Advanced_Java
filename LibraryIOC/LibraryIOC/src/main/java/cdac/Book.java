package cdac;

import org.springframework.stereotype.Component;

@Component
public class Book {
	String b_name = "harry potter goblet of fire";
	int b_price = 400;
	
	public String getBook() {
		return b_name + "--" + b_price;
	}

}
