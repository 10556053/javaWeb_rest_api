/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author student
 */
public class LoopTag implements IterationTag {
    private PageContext pageContext;
    private Tag parentTag;
    private Integer count;
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
          return Tag.EVAL_BODY_INCLUDE;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

     @Override
    public int doAfterBody() throws JspException {
        --count;
        if(count > 0)
            return IterationTag.EVAL_BODY_AGAIN;
        else
            return Tag.SKIP_BODY;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }
    

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
