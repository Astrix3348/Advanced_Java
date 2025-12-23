package cdac;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//tells spring that this is my applications setup file 
//look inside the cdac package and classes marked as beans @components


@Configuration //this means that it has the configuration info and replaces the XML configuration and instead using java 
@ComponentScan("cdac") //this scans the package and and find @component, @service, @repository, @controller
public class AppConfig {

}
