package com.mark.servlet;

import com.mark.dao.MarkDAO;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("studentId"));
            new MarkDAO().deleteMark(id);

            res.sendRedirect("markdelete.jsp?msg=deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}