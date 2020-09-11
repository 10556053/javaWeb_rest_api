<%-- 
    Document   : tag1
    Created on : 2020/9/11, 下午 09:05:34
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="my"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:greet user="bob "/></h1>
        <h1>
            <my:if condition="true">
                if成立
            </my:if>    
        </h1>
        <h1>
            <my:loop count="5">
                java
            </my:loop>    
        </h1>
        
        <h2>
            <my:mark search="s">
                ssaaaasssaegghssssfff
            </my:mark>    
        </h2>
        
        
            <my:switch conditionValue="2">
                <my:case  caseValue="1">
                    dddd
                </my:case>
                <my:case  caseValue="2">
                    ffff
                </my:case>

            </my:switch>
        

    </body>
</html>
