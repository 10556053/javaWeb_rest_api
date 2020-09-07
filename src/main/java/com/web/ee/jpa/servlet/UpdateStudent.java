/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.jpa.servlet;
import com.github.javafaker.Faker;
import com.web.ee.jpa.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/student/update")
public class UpdateStudent extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 取得 EntityManager
        // myjpa 是 unit name, 請參考 persistence.xml 中的設定
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        
        //先取得欲修改後的紀錄
        //1L:第一筆資料
        Student student = em.find(Student.class,1L);
        student.setName("huhuhuh");
        student.setAge(20);
        //進行修改
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(student);
        et.commit();
        em.close();
        
        out.print("update ok");
                
    }
    
}