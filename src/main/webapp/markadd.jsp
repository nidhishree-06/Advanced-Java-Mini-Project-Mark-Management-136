<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Add Marks</title>
</head>

<body>

<div class="nav">
    <a href="index.jsp">Home</a>
</div>

<h2>Add Marks</h2>

<div class="card">

<form action="AddMarkServlet" method="post">

    <input type="number" name="studentId" placeholder="ID" required><br><br>

    <input type="text" name="studentName" placeholder="Name" required><br><br>

    <input type="text" name="subject" placeholder="Subject" required><br><br>

    <input type="number" name="marks" placeholder="Marks" required><br><br>

    <input type="date" name="examDate" required><br><br>

    <button class="btn btn-blue">Submit</button>

</form>

<%
    String msg = request.getParameter("msg");
    if("added".equals(msg)){
%>
    <h3 style="color:green;">✔ Record Added Successfully!</h3>
<%
    }
%>

</div>

</body>
</html>