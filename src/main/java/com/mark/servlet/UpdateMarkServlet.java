package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int studentId =
                Integer.parseInt(
                    request.getParameter("studentId"));

            int marks =
                Integer.parseInt(
                    request.getParameter("marks"));

            // VALIDATION
            if(marks < 0) {

                response.getWriter().println(
                    "❌ Marks cannot be negative");

                return;
            }

            MarkDAO dao = new MarkDAO();

            int status =
                dao.updateMark(studentId, marks);

            if(status > 0) {

                // GET UPDATED RECORD
                StudentMark updatedStudent =
                        dao.getStudentById(studentId);

                request.setAttribute(
                        "updatedStudent",
                        updatedStudent);

                RequestDispatcher rd =
                        request.getRequestDispatcher(
                                "markupdate.jsp");

                rd.forward(request, response);

            } else {

                response.sendRedirect(
                    "markupdate.jsp?msg=notfound");
            }

        }

        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "Error: " + e.getMessage());
        }
    }
}