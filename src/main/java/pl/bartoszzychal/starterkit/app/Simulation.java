package pl.bartoszzychal.starterkit.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Simulation {

	public static void main(String[] args) {
		 ApplicationContext ctx = new FileSystemXmlApplicationContext(
				 "src/main/resources/spring.xml");
	}
}
