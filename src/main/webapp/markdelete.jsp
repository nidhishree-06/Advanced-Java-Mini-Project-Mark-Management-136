<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Delete</title>
</head>

<body>

<div class="nav"><a href="index.jsp">Home</a></div>

<h2>Delete Record</h2>

<div class="card">

<form action="DeleteMarkServlet" method="post">

	<input type="number" name="studentId" placeholder="ID" min="1" required>

<button class="btn btn-red">Delete</button>
<%
String msg = request.getParameter("msg");
if("deleted".equals(msg)){
%>
    <h3 style="color:red;">✔ Record has been deleted successfully!</h3>
<%
}
%>

</form>

</div>

</body>
</html>