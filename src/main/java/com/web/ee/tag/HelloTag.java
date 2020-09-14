/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.tag;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author student
 */
public class HelloTag implements Tag{
    private PageContext pageContext;
    private Tag parentTag;
    
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        //印出Hello與現在時間
        JspWriter out =  pageContext.getOut();
        try {
            out.print("hello "+new Date());
        } catch (IOException ex) {
            Logger.getLogger(HelloTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.SKIP_BODY;
        
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
        
    }

    @Override
    public void release() {
        //關閉資源的程序
        
    }
    
}
