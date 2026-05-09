package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    request.getParameter("studentId"));

            MarkDAO dao = new MarkDAO();

            // GET RECORD BEFORE DELETE
            StudentMark deletedStudent =
                    dao.getStudentById(id);

            if(deletedStudent != null) {

                // DELETE RECORD
                dao.deleteMark(id);

                // SEND RECORD TO JSP
                request.setAttribute(
                        "deletedStudent",
                        deletedStudent);

                RequestDispatcher rd =
                        request.getRequestDispatcher(
                                "markdelete.jsp");

                rd.forward(request, response);

            } else {

                response.sendRedirect(
                        "markdelete.jsp?msg=notfound");
            }

        }

        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error: " + e.getMessage());
        }
    }
}