package pl.bartoszzychal.starterkit.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import net.logstash.logback.encoder.org.apache.commons.io.IOUtils;
import pl.bartoszzychal.starterkit.app.simulation.Simulation;

public class Luncher {
	
	public static void main(String []args){
		Luncher luncher = new Luncher();
		ApplicationContext ctx = luncher.getApplicationContext();
		luncher.loadContent(ctx);
		Simulation simulation = ctx.getBean(Simulation.class);
		 simulation.run();
		((AbstractApplicationContext)ctx).close();
	}

	private ApplicationContext getApplicationContext() {
		return new FileSystemXmlApplicationContext(
				 "src/main/resources/spring.xml");		
	}

	private  void loadContent(ApplicationContext ctx) {
		EntityManagerFactory entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		 try(InputStream input = new FileInputStream(new File("src/main/resources/content.sql"))){
				List<String> readLines = IOUtils.readLines(input);
				for (String sql : readLines) {
					System.out.println(sql);
					Query q = entityManager.createNativeQuery(sql);
					q.executeUpdate();					
				}
		 } catch (IOException e) {
			e.printStackTrace();
		}
		transaction.commit();
		entityManager.close();
	}
	
}
