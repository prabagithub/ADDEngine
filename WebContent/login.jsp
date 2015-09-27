<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post your ADD - Login</title>

<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js" 
    data-require="angular.js@*" data-semver="2.0.0-alpha.31"></script>        
    <link href="style.css" rel="stylesheet" />
    <script src="script.js"></script>
</head>
<body ng-controller="LoginController">
<table>
                <tbody><tr>
                <td><h1 style="margin:5px 0;">{{message}}</h1></td>               
                </tr>
                </tbody></table>                
                <div class="redribbon"></div>                                
                <div class="overtop {{color}}">{{overtopmsg}}</div>  
<form action="LoginServlet" method="post" onsubmit="return checkLogin()">
<jsp:include page="beforeLogin.jsp"></jsp:include>
</form>
</body>
</html>