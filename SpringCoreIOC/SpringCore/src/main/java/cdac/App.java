package cdac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		
		
		//spring container
		//spring lives here
		/*This container:
		* Creates objects
		* Manages dependencies
		* Controls lifecycle
		* Stores beans
		* Injects dependencies
		*/

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = context.getBean(Person.class);
		person.showDetails();
	}
}
/*
 * 
 * App (main method)
        |
        v
ApplicationContext
        |
        v
Reads AppConfig
        |
        v
Scans cdac package
        |
        v
Creates beans
        |
        v
Injects dependencies
        |
        v
getBean() → ready object
*
*/
 