package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String type = request.getParameter("type");

            MarkDAO dao = new MarkDAO();

            List<StudentMark> list = null;

            // ABOVE MARKS REPORT
            if(type.equals("marks")) {

                int marks = Integer.parseInt(
                        request.getParameter("marks"));

                list = dao.getAboveMarks(marks);
            }

            // SUBJECT WISE REPORT
            else if(type.equals("subject")) {

                String subject =
                        request.getParameter("subject");

                list = dao.getBySubject(subject);
            }

            // TOP N STUDENTS
            else if(type.equals("top")) {

                int n = Integer.parseInt(
                        request.getParameter("n"));

                list = dao.getTopN(n);
            }

            // PASS / FAIL SUBJECT REPORT
            else if(type.equals("grade")) {

                String subject =
                        request.getParameter("subject");

                String result =
                        request.getParameter("result");

                list = dao.getStudentsByGradeAndSubject(
                        subject,
                        result
                );
            }

            // SEND DATA TO JSP
            request.setAttribute("list", list);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                            "report_result.jsp");

            rd.forward(request, response);

        }

        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error: " + e.getMessage()
            );
        }
    }
}