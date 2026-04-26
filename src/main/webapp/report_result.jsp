<%@ page import="java.util.*, com.mark.model.StudentMark" %>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/style.css">
<title>Report Result</title>
</head>

<body>

<div class="nav">
    <a href="index.jsp">Home</a>
    <a href="report_form.jsp">Back</a>
</div>

<h2>Report Results</h2>

<div class="card">

<table border="1" width="100%">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Date</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>) request.getAttribute("list");

if(list != null && !list.isEmpty()) {

    for(StudentMark m : list) {
%>

<tr>
    <td><%= m.getStudentId() %></td>
    <td><%= m.getStudentName() %></td>
    <td><%= m.getSubject() %></td>
    <td><%= m.getMarks() %></td>
    <td><%= m.getExamDate() %></td>
</tr>

<%
    }

} else {
%>

<tr>
    <td colspan="5">No Records Found</td>
</tr>

<%
}
%>

</table>

</div>

</body>
</html>