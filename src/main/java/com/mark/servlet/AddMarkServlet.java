package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            StudentMark m = new StudentMark();

            m.setStudentName(
                    request.getParameter("studentName"));

            m.setSubject(
                    request.getParameter("subject"));

            int marks = Integer.parseInt(
                    request.getParameter("marks"));

            // VALIDATION
            if(marks < 0) {

                response.getWriter().println(
                    "❌ Marks cannot be negative");

                return;
            }

            m.setMarks(marks);

            m.setExamDate(
                    request.getParameter("examDate"));

            MarkDAO dao = new MarkDAO();

            int status = dao.addMark(m);

            if(status > 0) {

                // GET LAST INSERTED ID
                int id = dao.getLastStudentId();

                // GET COMPLETE RECORD
                StudentMark addedStudent =
                        dao.getStudentById(id);

                request.setAttribute(
                        "addedStudent",
                        addedStudent);

                RequestDispatcher rd =
                        request.getRequestDispatcher(
                                "markadd.jsp");

                rd.forward(request, response);

            } else {

                response.getWriter().println(
                        "Insert Failed");
            }

        }

        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error: " + e.getMessage());
        }
    }
}