<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/style.css">
<title>Reports</title>
</head>

<body>

<div class="nav">
    <a href="index.jsp">Home</a>
</div>

<h2>Generate Reports</h2>

<!-- 🔵 MARKS ABOVE -->
<div class="card">

<h3>Marks Above Value</h3>

<form action="ReportServlet" method="post">

<input type="hidden" name="type" value="marks">

<input type="number" name="marks" placeholder="Enter Marks" required>

<button class="btn btn-orange">Generate</button>

</form>

</div>

<!-- 🟢 SUBJECT WISE -->
<div class="card">

<h3>Subject Wise Report</h3>

<form action="ReportServlet" method="post">

<input type="hidden" name="type" value="subject">

<input type="text" name="subject" placeholder="Enter Subject" required>

<button class="btn btn-green">Generate</button>

</form>

</div>

<!-- 🔵 TOP N STUDENTS -->
<div class="card">

<h3>Top N Students</h3>

<form action="ReportServlet" method="post">

<input type="hidden" name="type" value="top">

<input type="number" name="n" placeholder="Enter N Value" required>

<button class="btn btn-blue">Generate</button>

</form>

</div>

</body>
</html>