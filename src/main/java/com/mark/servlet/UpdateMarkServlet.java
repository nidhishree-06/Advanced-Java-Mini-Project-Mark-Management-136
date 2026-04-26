package com.mark.servlet;

import com.mark.dao.MarkDAO;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // GET VALUES SAFELY
            String idStr = request.getParameter("studentId");
            String marksStr = request.getParameter("marks");

            // VALIDATION (IMPORTANT)
            if (idStr == null || marksStr == null || idStr.isEmpty() || marksStr.isEmpty()) {
                response.getWriter().println("Error: Missing input values");
                return;
            }

            int studentId = Integer.parseInt(idStr);
            int marks = Integer.parseInt(marksStr);

            // DAO CALL
            MarkDAO dao = new MarkDAO();
            int status = dao.updateMark(studentId, marks);

            if (status > 0) {
                response.sendRedirect("markupdate.jsp?msg=updated");
            } else {
                response.getWriter().println("Update Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}