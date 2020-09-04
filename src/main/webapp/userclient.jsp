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
            
            function getUser(id) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var jo = JSON.parse(this.responseText);
                        document.getElementById("id").value = jo.id;
                        document.getElementById("name").value = jo.name;
                        document.getElementById("age").value = jo.age;
                    }
                };
                var url = "/JavaEE0727/rest/user/" + id;
                xhttp.open("GET", url, true);
                xhttp.send();
                
            }
            
            function deleteUser(id){
                if(!confirm("確定要刪除此筆資料 ?")) {
                    return;
                }
               var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("result").innerHTML = this.responseText;
                        queryUser()
                    }
                };
                var url = "/JavaEE0727/rest/user/" + id;
                xhttp.open("DELETE", url, true);
                xhttp.send();
            }
            
            function updateUser() {
                // 抓取表單資料
                var id = document.getElementById("id").value;
                var name = document.getElementById("name").value;
                var age = document.getElementById("age").value;
                // 建立物件
                var jsonObj = new Object();
                jsonObj.id = id * 1;
                jsonObj.name = name;
                jsonObj.age = age * 1;
                // 將物件轉 json 字串
                var jsonText = JSON.stringify(jsonObj);
                console.log(jsonObj);
                console.log(jsonText);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("result").innerHTML = this.responseText;
                        queryUser()
                    }
                };
                var url = "/JavaEE0727/rest/user/" + id;
                xhttp.open("PUT", url, true);
                xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
                xhttp.send(jsonText);
            }
            
            function queryUser() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var jo = JSON.parse(this.responseText);
                        // 清空
                        var lens = document.getElementById("user_table").rows.length;
                        for(var i=0;i<lens;i++) {
                            document.getElementById("user_table").deleteRow(0);
                        }
                        
                        document.getElementById("result").innerHTML = this.responseText;
                        var table = document.getElementById("user_table");
                        for(var i=0;i<jo.length;i++) {
                            var row = table.insertRow(0);
                            var cell1 = row.insertCell(0);
                            var cell2 = row.insertCell(1);
                            var cell3 = row.insertCell(2);
                            var cell4 = row.insertCell(3);
                            cell1.innerHTML = '<a href="javascript:getUser(' + jo[i].id + ')">' + jo[i].id + '</a>';
                            cell2.innerHTML = jo[i].name;
                            cell3.innerHTML = jo[i].age;
                            cell4.innerHTML = '<input type="button" value="刪除" onclick="deleteUser(' + jo[i].id + ')">';
                        }
                    }
                };
                xhttp.open("GET", "/JavaEE0727/rest/user/all", true);
                xhttp.send();
            }
            
            function addUser() {
                // 抓取表單資料
                var id   = document.getElementById("id").value;
                var name = document.getElementById("name").value;
                var age  = document.getElementById("age").value;
                // 建立物件
                var jsonObj = new Object();
                jsonObj.id   = id*1;
                jsonObj.name = name;
                jsonObj.age  = age*1;
                // 將物件轉 json 字串
                var jsonText = JSON.stringify(jsonObj);
                console.log(jsonObj);
                console.log(jsonText);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("result").innerHTML = this.responseText;
                        queryUser()
                    }
                };
                xhttp.open("POST", "/JavaEE0727/rest/user/", true);
                xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
                xhttp.send(jsonText);
               
            }
        </script>
    </head>

    <body style="padding: 20px">
        <h1>Hello World!</h1>
        <form id="user_form" class="pure-form">
            <fieldset>
                <legend>A compact inline form</legend>
                ID :<input type="text" id="id" name ="id" /></p>
                Name :<input type="text" id="name" name="name" /></p>
                Age :<input type="number" id="age" name="age" /></p>
                <button type="button" id="add_button" onclick="addUser()" class="pure-button pure-button-primary">新增</button>
                <button type="button" id="update_button" onclick="updateUser()"  class="pure-button pure-button-primary">修改</button>
                <button type="button" id="query_button" onclick="queryUser()" class="pure-button pure-button-primary">查詢</button>
                <button type="reset" id="delete_button" class="pure-button pure-button-primary">刪除</button>
            </fieldset>
        </form>
        
        <div id="result"></div>
        <table id="user_table" class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>age</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody id="user_table">
               
            </tbody>
        </table>
    </body>
</html>
