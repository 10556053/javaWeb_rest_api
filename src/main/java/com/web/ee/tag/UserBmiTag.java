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
public class UserBmiTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private int h;
    private int w;
    
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
        
        return Tag.SKIP_BODY;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    

    @Override
    public int doEndTag() throws JspException {
        //印出Hello與現在時間
        JspWriter out =  pageContext.getOut();
        float bmi = w/((h/100)*(h/100));
        try {
            if (bmi>23) {
                out.print("胖子 ");
            }else if(18<=bmi &&bmi<=23){
                out.print("ok ");
            }else{
                out.print("猴子 ");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HelloTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }
    
}
