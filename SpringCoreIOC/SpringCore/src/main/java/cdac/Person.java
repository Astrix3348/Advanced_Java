package cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//this is telling spring that this is a SpringBean and create an object of this class automatically
@Component
public class Person {
	int id;
	String name;
	Address address;
	
	
	//this is a constructor injection
	@Autowired
	public Person(@Value("101")  int id, 
			@Value("Aakash")  String name, 
			Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public void showDetails() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(address.getAddress());
	}
}
