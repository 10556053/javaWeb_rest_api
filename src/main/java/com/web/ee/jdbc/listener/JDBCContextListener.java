/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.jdbc.listener;

import com.web.ee.jdbc.DBConnectionManager;
import java.sql.Connection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author student
 */
@WebListener
public class JDBCContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBConnectionManager manager = new DBConnectionManager();
        String jdbcUrl="jdbc:derby://localhost:1527/web";
        String username = "app";
        String password = "app";
        Connection conn =manager.getConnection(jdbcUrl, username, password);
        //將connection置入ServletContext中
        sce.getServletContext().setAttribute("conn",conn);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection conn = (Connection)sce.getServletContext().getAttribute("conn");
        
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
}
