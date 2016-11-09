package com.stefanini.controller;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Hello;

@Path("/home")
@RequestScoped
public class HomeController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello get() {
        return new Hello("world");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hello post(Hello hello) {
        return  new Hello("world");
    }
}
