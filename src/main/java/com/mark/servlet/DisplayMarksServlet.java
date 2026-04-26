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

public class DisplayMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            MarkDAO dao = new MarkDAO();

            List<StudentMark> list = dao.getAll();

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("markdisplay.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}