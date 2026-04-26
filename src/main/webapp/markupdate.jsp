<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/style.css">
<title>Update Marks</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<h2 style="text-align:center;">Update Marks Only</h2>

<div class="card" style="text-align:center;">

<form action="UpdateMarkServlet" method="post">

    <input type="number" name="studentId" placeholder="Student ID" required><br><br>

    <input type="number" name="marks" placeholder="Enter New Marks" required><br><br>

    <button class="btn btn-blue">Update</button>

</form>

<%
    String msg = request.getParameter("msg");
    if ("updated".equals(msg)) {
%>
    <h3 style="color:green;">✔ Marks Updated Successfully</h3>
<%
    }
%>

</div>

</body>
</html>