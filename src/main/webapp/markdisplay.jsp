<%@ page import="java.util.*, com.mark.model.StudentMark" %>

<!DOCTYPE html>
<html>

<head>
    <title>Display Marks</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="nav">
    <a href="index.jsp">Home</a>
    <a href="markadd.jsp">Add</a>
    <a href="markupdate.jsp">Update</a>
    <a href="markdelete.jsp">Delete</a>
    <a href="report_form.jsp">Reports</a>
</div>

<h2>Student Marks</h2>
<div class="card">

<form action="DisplayMarksServlet"
      method="get">

   <input type="number"
       name="search"
       placeholder="Search By Student ID"
       min="1"
       required>

    <button class="btn btn-green">
        Search
    </button>

</form>

</div>

<%
    List<StudentMark> list = (List<StudentMark>) request.getAttribute("list");
%>

<% if (list != null && !list.isEmpty()) { %>

<table border="1" width="100%" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Exam Date</th>
</tr>

<% for (StudentMark m : list) { %>

<tr>
    <td><%= m.getStudentId() %></td>
    <td><%= m.getStudentName() %></td>
    <td><%= m.getSubject() %></td>
    <td><%= m.getMarks() %></td>
    <td><%= m.getExamDate() %></td>
</tr>

<% } %>

</table>

<% } else { %>

<h3 style="color:red;">No Records Found</h3>

<% } %>

</body>
</html>