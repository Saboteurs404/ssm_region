<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="/message/ge">进行跳转</a>
<div>
    userName:<input type="text" id="userName" name="userName"/>
    <input type="button" value="查找用户" onclick="Search()"/>

</div>
<h2>form----------get</h2>
<div>
    <form id="reportGet" action="/message/report1" method="get">
        Begin:<input type="text" name="begin"><br>
        End:<input type="text" name="end"><br>
        <input type="submit" value="GET查找表">
    </form>
</div>
</body>
<script>
    function Search(){
        window.open("/message/detail/data"+document.getElementById("userName").value);
    }
</script>
</html>
