package com.mark.servlet;

import com.mark.dao.MarkDAO;
import com.mark.model.StudentMark;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            MarkDAO dao = new MarkDAO();

            List<StudentMark> list;

            String search =
                    request.getParameter("search");

            // SEARCH BY STUDENT ID
            if(search != null &&
               !search.trim().equals("")) {

                int id = Integer.parseInt(search);

                // VALIDATION
                if(id <= 0) {

                    response.getWriter().println(
                        "❌ Student ID cannot be negative or zero"
                    );

                    return;
                }

                list = dao.searchById(id);

            }

            // DISPLAY ALL RECORDS
            else {

                list = dao.getAll();
            }

            request.setAttribute("list", list);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                            "markdisplay.jsp");

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