package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            StudentMark m = new StudentMark();

            String name = request.getParameter("studentName");
            String subject = request.getParameter("subject");
            String marksStr = request.getParameter("marks");
            String examDate = request.getParameter("examDate");

            // Validation
            if (name == null || subject == null || marksStr == null || examDate == null ||
                name.isEmpty() || subject.isEmpty() || marksStr.isEmpty() || examDate.isEmpty()) {

                response.getWriter().println("❌ All fields are required!");
                return;
            }

            int marks = Integer.parseInt(marksStr);

            if (marks < 0) {
                response.getWriter().println("❌ Marks cannot be negative!");
                return;
            }

            m.setStudentName(name);
            m.setSubject(subject);
            m.setMarks(marks);
            m.setExamDate(examDate);

            MarkDAO dao = new MarkDAO();

            // ✅ get generated ID
            int generatedId = dao.addMark(m);

            System.out.println("Generated ID = " + generatedId); // DEBUG

            if (generatedId > 0) {
                response.sendRedirect("markadd.jsp?msg=added&id=" + generatedId);
            } else {
                response.getWriter().println("Insert Failed OR ID not generated");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}