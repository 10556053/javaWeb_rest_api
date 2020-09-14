<%-- 
    Document   : tag2
    Created on : 2020/9/14, 下午 07:36:21
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/WEB-INF/tlds/my_tld" prefix="my"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Tag Demo</title>
    </head>
    <body>
        <h1><my:hello/></h1>
        <h1><my:hellouser name="bob"/></h1>
        <h1><my:calcbmi  h="170" w="60"/></h1>
        <h1><my:stock symbol="2330.TW" qty="2000" /></h1>
        <h1><my:stock symbol="USDTWD=x" /></h1>
        <h1><my:stock symbol="TWDUSD=x" qty="10000" /></h1>
        <h1>
            <my:lotto amount="6">
                樂透彩開獎:
            </my:lotto>
        </h1>
        
        <h1>
            <my:loop count="9">
                中秋節
            </my:loop>
        </h1>
    </body>
</html>
