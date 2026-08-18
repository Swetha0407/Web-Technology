package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Welcome</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#eef2ff;"
                + "text-align:center;padding:80px;}");

        out.println(".card{background:white;width:450px;"
                + "margin:auto;padding:35px;border-radius:15px;"
                + "box-shadow:0 10px 30px #aaa;}");

        out.println("h1{color:#2563eb;}");

        out.println("p{font-size:18px;line-height:1.8;}");
        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Welcome to Student Portal</h1>");

        out.println("<p><b>Student Name:</b> Swetha S</p>");

        out.println("<p><b>Course:</b> IT</p>");

        out.println("<p><b>Current Date & Time:</b><br>"
                + new Date() + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}