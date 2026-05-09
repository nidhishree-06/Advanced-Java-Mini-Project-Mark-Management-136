<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" href="css/style.css">

<title>Update Marks</title>

<script>

function confirmUpdate() {

    return confirm("Are you sure you want to update the marks?");

}

</script>

</head>

<body>

<div class="nav">
    <a href="index.jsp">Home</a>
</div>

<h2>Update Marks</h2>

<div class="card">

<form action="UpdateMarkServlet"
      method="post"
      onsubmit="return confirmUpdate()">

    <input type="number"
           name="studentId"
           placeholder="Enter Student ID"
           required><br><br>

    <input type="number"
           name="marks"
           placeholder="Enter New Marks"
           min="0"
           required><br><br>

    <button type="submit" class="btn btn-blue">
        Update
    </button>

</form>

<%
    String msg = request.getParameter("msg");

    if("updated".equals(msg)){
%>
    <h3 style="color:green;">
        ✔ Marks Updated Successfully!
    </h3>
<%
    }

    else if("notfound".equals(msg)){
%>
    <h3 style="color:red;">
        ❌ Record Not Found!
    </h3>
<%
    }
%>
<%@ page import="com.mark.model.StudentMark" %>

<%
    StudentMark s =
        (StudentMark)request.getAttribute(
                "updatedStudent");

    if(s != null){
%>
<div>
<form>
</form>
</div>
<div class="card">

<h3 style="color:green;">
    ✔ Record Updated Successfully
</h3>

<p><b>ID:</b> <%= s.getStudentId() %></p>

<p><b>Name:</b> <%= s.getStudentName() %></p>

<p><b>Subject:</b> <%= s.getSubject() %></p>

<p><b>Marks:</b> <%= s.getMarks() %></p>

<p><b>Exam Date:</b> <%= s.getExamDate() %></p>

</div>

<%
    }
%>

</div>

</body>

</html>