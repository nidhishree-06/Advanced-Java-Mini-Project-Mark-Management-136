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

    <input type="number" name="marks" placeholder="Enter Marks" min="0" required><br><br>

<button class="btn btn-orange">Generate</button>

</form>

</div>

<!-- 🟢 SUBJECT WISE -->
<div class="card">

<h3>Subject Wise Report</h3>

<form action="ReportServlet" method="post">

<input type="hidden" name="type" value="subject">

   <!-- SUBJECT DROPDOWN -->
    <select name="subject" required>

        <option value="">-- Select Subject --</option>

        <option value="Java">Java</option>

        <option value="Python">Python</option>

        <option value="DBMS">DBMS</option>

        <option value="Operating System">Operating System</option>

        <option value="Computer Networks">Computer Networks</option>

        <option value="Cyber Security">Cyber Security</option>

    </select>

    <br><br>

<button class="btn btn-green">Generate</button>

</form>

</div>

<!-- 🔵 TOP N STUDENTS -->
<div class="card">

<h3>Top N Students</h3>

<form action="ReportServlet" method="post">

<input type="hidden" name="type" value="top">

<input type="number" name="n" placeholder="Enter N Value" min="1" required>

<button class="btn btn-blue">Generate</button>
</form>

</div>

</form>
<!-- 🔴 SUBJECT WISE PASS / FAIL REPORT -->
<div class="card">

<h3>Subject Wise Pass / Fail Report</h3>

<form action="ReportServlet" method="post">

    <input type="hidden" name="type" value="grade">

    <!-- SUBJECT DROPDOWN -->
    <select name="subject" required>

        <option value="">-- Select Subject --</option>

        <option value="Java">Java</option>

        <option value="Python">Python</option>

        <option value="DBMS">DBMS</option>

        <option value="Operating System">Operating System</option>

        <option value="Computer Networks">Computer Networks</option>

        <option value="Cyber Security">Cyber Security</option>

    </select>

    <br><br>

    <!-- PASS / FAIL -->
    <select name="result" required>

        <option value="">-- Select Result --</option>

        <option value="pass">Pass Students</option>

        <option value="fail">Fail Students</option>

    </select>

    <br><br>

    <button class="btn btn-red">
        Generate
    </button>

</form>

</div>

</div>

</body>
</html>