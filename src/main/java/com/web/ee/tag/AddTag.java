/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ee.tag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author student
 */
public class AddTag extends SimpleTagSupport implements  DynamicAttributes{
    private Map<String ,Integer> map = new LinkedHashMap<>();
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(map);
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        map.put(localName, Integer.parseInt(value.toString()));
        
    }
    
}
