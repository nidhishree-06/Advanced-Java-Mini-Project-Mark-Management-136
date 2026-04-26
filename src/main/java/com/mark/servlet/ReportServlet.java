package com.mark.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String type = request.getParameter("type");

            MarkDAO dao = new MarkDAO();
            List<StudentMark> list = null;

            // 🔥 MARKS ABOVE REPORT
            if ("marks".equals(type)) {

                String m = request.getParameter("marks");

                if (m != null && !m.isEmpty()) {
                    int marks = Integer.parseInt(m);
                    list = dao.getAboveMarks(marks);
                }
            }

            // 🔥 SUBJECT REPORT
            else if ("subject".equals(type)) {

                String subject = request.getParameter("subject");

                if (subject != null && !subject.isEmpty()) {
                    list = dao.getBySubject(subject);
                }
            }

            // 🔥 TOP N REPORT
            else if ("top".equals(type)) {

                String nVal = request.getParameter("n");

                if (nVal != null && !nVal.isEmpty()) {
                    int n = Integer.parseInt(nVal);
                    list = dao.getTopN(n);
                }
            }

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error in ReportServlet: " + e.getMessage());
        }
    }
}