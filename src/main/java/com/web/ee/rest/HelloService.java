/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author student
 */
@Path("hello")
public class HelloService {
    @Path("hi")
    @GET
    @Produces("text/plain")
    public String hi(){
        return "hi rest";
    }
    
    @Path("greet")
    @GET
    @Produces("text/plain")
    public String greet(@QueryParam("name") String name){
        return "hello1"+name;
    }
    
    //大括號代表是變數
    @Path("{name}")
    @GET
    @Produces("text/plain")
    public String hello(@PathParam("name") String name){
        return "hello2"+name;
    }
    
    //大括號代表是變數
    @Path("{x}/{y}")
    @GET
    @Produces("text/plain")
    public String plus(@PathParam("x") Integer x ,@PathParam("y") Integer y ){
        return "sum = "+(x+y);
    }
}
