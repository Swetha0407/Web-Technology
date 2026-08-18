package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get form values
        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        // Validate empty fields
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty()) {

            out.println("<h2 style='color:red;'>");
            out.println("Please fill all the fields.");
            out.println("</h2>");

            return;
        }

        // Display submitted details
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Successful</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;"
                + "background:#eef2ff;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "min-height:100vh;}");

        out.println(".card{background:white;"
                + "padding:35px;"
                + "width:450px;"
                + "border-radius:15px;"
                + "box-shadow:0 10px 30px #aaa;}");

        out.println("h1{color:#16a34a;"
                + "text-align:center;}");

        out.println("p{font-size:18px;"
                + "line-height:1.8;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Registration Successful!</h1>");

        out.println("<p><b>Student Name:</b> "
                + name + "</p>");

        out.println("<p><b>Register Number:</b> "
                + regno + "</p>");

        out.println("<p><b>Email:</b> "
                + email + "</p>");

        out.println("<p><b>Department:</b> "
                + department + "</p>");

        out.println("<p><b>Semester:</b> "
                + semester + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}