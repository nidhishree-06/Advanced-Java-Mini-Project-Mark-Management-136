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

    <!-- AUTO GENERATED ID DISPLAY -->
    <%
        String id = request.getParameter("id");
    %>

    <input type="text"
           value="<%= (id != null ? id : "Auto Generated") %>"
           readonly><br><br>

    <!-- STUDENT NAME -->
    <input type="text"
           name="studentName"
           placeholder="Enter Student Name"
           required><br><br>

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

    <!-- MARKS -->
    <input type="number"
           name="marks"
           placeholder="Enter Marks"
           min="0"
           required><br><br>



    <!-- EXAM DATE -->
    <input type="date"
           name="examDate"
        
           required><br><br>

    <!-- SUBMIT BUTTON -->
    <button type="submit" class="btn btn-blue">
        Submit
    </button>

</form>

<!-- SUCCESS MESSAGE -->
<%
    String msg = request.getParameter("msg");

    if("added".equals(msg)){
%>
    <h3 style="color:green;">
        ✔ Record Added Successfully!
    </h3>
    
<%
    }
%>

<!-- GENERATED ID MESSAGE -->
<%
    if(id != null){
%>
    <h3 style="color:blue;">
        Generated Student ID: <%= id %>
    </h3>
<%
    }
%>
<%@ page import="com.mark.model.StudentMark" %>

<%
    StudentMark s =
        (StudentMark)request.getAttribute(
                "addedStudent");

    if(s != null){
%>

<div class="card">

<h3 style="color:green;">
    ✔ Record Added Successfully
</h3>

<p><b>ID:</b> <%= s.getStudentId() %></p>

<p><b>Name:</b> <%= s.getStudentName() %></p>

<p><b>Subject:</b> <%= s.getSubject() %></p>

<p><b>Marks:</b> <%= s.getMarks() %></p>

<p><b>Date:</b> <%= s.getExamDate() %></p>

</div>

<%
    }
%>

</div>

</body>
</html>