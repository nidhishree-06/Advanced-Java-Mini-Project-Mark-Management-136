package com.mark.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");

        try {
            StudentMark m = new StudentMark();

            m.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            m.setStudentName(request.getParameter("studentName"));
            m.setSubject(request.getParameter("subject"));
            m.setMarks(Integer.parseInt(request.getParameter("marks")));
            m.setExamDate(request.getParameter("examDate"));

            MarkDAO dao = new MarkDAO();

            int status = dao.addMark(m);

            if (status > 0) {
                response.sendRedirect("markadd.jsp?msg=added");
            } else {
                response.getWriter().println("Insert Failed");
            }

        } catch(Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}