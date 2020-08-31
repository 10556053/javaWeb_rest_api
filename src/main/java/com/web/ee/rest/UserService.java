/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author student
 */
@Path("user")
public class UserService {
    private static List<User>   users;
    static {
//        users = Arrays.asList(new User( "john", 18,1),new User("mary", 19,2),new User("hellen", 20,3));
        users = new ArrayList<>() ;
        users.add((new User( "john", 18,1)));
        users.add((new User( "mary", 19,2)));
        users.add((new User( "hellen", 20,3)));
    }
    // http://localhost:8080/JavaEE0727/rest/user/all
    @Path("all")
    @GET
    @Produces("application/json")
    public List<User> getAll(){
        return users;
    }
    // http://localhost:8080/JavaEE0727/rest/user/id
    @Path("{id}")
    @GET
    @Produces("application/json")
    public User getUser(@PathParam("id") int id){
        Optional<User> optUser = users.stream().filter(user-> user.getId() ==id ).findFirst();
        
        return optUser.isPresent()?optUser.get():null;
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/
    @Path("/")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Message addUser(User user) {
        users.add(user);
        return new Message("add ok", 200);
    }
 
    
    // http://localhost:8080/JavaEE0727/rest/user/1
    @Path("{id}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Message updateUser(@PathParam("id") int id, User user) {
        Optional<User> optUser = users.stream().filter(u -> u.getId() == id).findFirst();
        if(optUser.isPresent()) {
            User u = optUser.get();
            u.setName(user.getName());
            u.setAge(user.getAge());
            return new Message("update ok", 201);
        } else {
            return new Message("update error", -1);
        }
    }
    
    // http://localhost:8080/JavaEE0727/rest/1
    @Path("{id}")
    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    public Message deleteUser(@PathParam("id") int id) {
        boolean check = users.removeIf(u -> u.getId() == id);
        return check ? new Message("delete ok", 202) : new Message("delete error", -2);
    }
}
