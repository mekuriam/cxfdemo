package com.excella;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class CxfDemoApplication {

	@Autowired
	private Bus bus;

	@Autowired
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(CxfDemoApplication.class, args);
	}

	@Bean
	public Server rsServer() {

		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();

		List<Object> serviceBeans = new ArrayList<Object>(ctx.getBeansWithAnnotation(Path.class).values());
		List<Object> providers = new ArrayList<Object>(ctx.getBeansWithAnnotation(Provider.class).values());

		endpoint.setBus(bus);
		endpoint.setAddress("/");
		endpoint.setServiceBeans(serviceBeans);
		endpoint.setProviders(providers);
		return endpoint.create();
	}

}
