/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(urlPatterns="/async/longjob",asyncSupported = true)
public class LongJobServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.進入 Servlet 
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        PrintWriter out = resp.getWriter();
        out.print("進入servlet時間"+ new Date()+"<p/>");
        out.flush();
        
        //此servlet做:接收->指派，並不做商業邏輯判斷
        // 2.在子執行緒中執行任務調用，並由其負責輸出響應，主執行緒退出
        AsyncContext ctx = req.startAsync();
        LongJob longjob = new LongJob(ctx);
        new Thread(longjob).start();
        
        out.print("離開servlet時間"+ new Date()+"<p/>");
        out.flush();
        // 3.離開 Servlet 給其他請求連線使用
    }
    
}
