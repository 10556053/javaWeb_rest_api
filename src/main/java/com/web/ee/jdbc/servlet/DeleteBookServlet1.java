/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 路徑 ex: http://localhost:8080/JavaEE0727/servlet/jdbc/delete/book?id=4
@WebServlet("/servlet/jdbc/delete/book")
public class DeleteBookServlet1 extends HttpServlet{

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        
        Connection conn = (Connection)getServletContext().getAttribute("conn");
        String sql = "SELECT id, title, price, amount, ts FROM Book WHERE id=" + id;
        try(Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);) {
            if(!rs.last()) {
                resp.getWriter().print("No data, Delete error !");
                return;
            }
            rs.deleteRow();
            resp.getWriter().print("Delete OK !");
            
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
    
}

