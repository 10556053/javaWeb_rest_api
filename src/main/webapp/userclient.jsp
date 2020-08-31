<%-- 
    Document   : userclient
    Created on : 2020/8/31, 下午 07:05:56
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user crud Page</title>
        <script>
            function queryUser() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("result").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "/JavaEE0727/rest/user/all", true);
                xhttp.send();
            }
        </script>
    </head>

    <body style="padding: 20px">
        <h1>Hello World!</h1>
        <form id="user_form" class="pure-form">
            <fieldset>
                <legend>A compact inline form</legend>
                ID :<input type="text"readonly /></p>
                Name :<input type="text" id="name" name="name" /></p>
                Age :<input type="number" id="age" name="age" /></p>
                <button type="button" id="add_button" class="pure-button pure-button-primary">新增</button>
                <button type="button" id="update_button" class="pure-button pure-button-primary">修改</button>
                <button type="button" id="query_button" onclick="queryUser()" class="pure-button pure-button-primary">查詢</button>
                <button type="reset" id="delete_button" class="pure-button pure-button-primary">刪除</button>
            </fieldset>
        </form>
        
        <div id="result"></div>
    </body>
</html>
