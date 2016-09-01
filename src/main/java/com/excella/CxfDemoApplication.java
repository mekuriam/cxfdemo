package com.excella;

import com.excella.resource.HelloResource;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CxfDemoApplication {

	@Autowired
	private Bus bus;

	public static void main(String[] args) {
		SpringApplication.run(CxfDemoApplication.class, args);
	}

	//@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		// Register 2 JAX-RS root resources supporting "/sayHello/{id}" and "/sayHello2/{id}" relative paths
		//endpoint.setResourceClasses(HelloResource.class);
		endpoint.setServiceBeans(Arrays.<Object>asList(new HelloResource()));

		//endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
		return endpoint.create();
	}
}
