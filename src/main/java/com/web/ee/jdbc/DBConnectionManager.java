/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class DBConnectionManager {
    
    public Connection getConnection(String jdbcUrl,String username, String password){
        Connection conn= null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver") ;
            conn=DriverManager.getConnection(jdbcUrl,username,password);
            
        } catch (Exception e) {
        }
        return conn;
    }
    
   
}
