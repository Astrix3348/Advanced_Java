package cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {
	int stock;
	Book book;
	
	
	@Autowired
	public Library(
			@Value("100") int stock, Book book) {
		this.stock = stock;
		this.book = book;
	}
	
	public void showDetails() {
		System.out.println(stock);
		System.out.println(book.getBook());
	}
}
