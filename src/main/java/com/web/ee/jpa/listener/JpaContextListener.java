/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.jpa.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author student
 */
@WebListener
public class JpaContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa");
        sce.getServletContext().setAttribute("emf", emf);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(sce.getServletContext().getAttribute("emf") != null) {
            EntityManagerFactory emf = (EntityManagerFactory)sce.getServletContext().getAttribute("emf");
            emf.close();
        }
    }
        
}
