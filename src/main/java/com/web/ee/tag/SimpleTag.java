/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author student
 */
public class SimpleTag extends SimpleTagSupport{
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        out.print("我是一個很簡單的 Tag, msg: " + msg);
    }
    
}
