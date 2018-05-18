<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	Object obj = request.getAttribute("orgPath");
	request.setAttribute("orgPath", obj);

%>
<body>
	${error}
	<form action="LoginServlet" method="post">
	<input type='hidden' name="orgPath" value="${orgPath}">  
		ID:<input type="text" name="ID"><br>  
		Password:<input type="password" name="password"><br>  
		<input type="submit" value="login">  
	</form> 
	
</body>
</html>