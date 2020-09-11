/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.async;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.ws.rs.core.Context;

/**
 *
 * @author student
 */
public class LongJob implements Runnable{
    
    private AsyncContext context;

    public LongJob(AsyncContext context) {
        this.context = context;
    }
    
    @Override
    public void run() {
        try {
            
            for(int i = 1;i<=10;i++){
                Thread.sleep(1000);
                PrintWriter out = context.getResponse().getWriter();
                out.print(i+".完成long job時間"+ new Date()+"<p/>");
                out.flush();
                
            }
            context.complete(); // 任務完成
        } catch (Exception e) {
        }
    }
    
}
