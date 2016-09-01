package com.excella.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by mamekuri on 9/1/16.
 */
@Component("helloResource")
@Path("/")
public class HelloResource {


        @GET
        @Path("/hello")
        @Produces(MediaType.TEXT_PLAIN)
        public String sayHello() {return "Hello cxf!";
        }


}
