package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        // Get student details

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");


        // Get marks

        String m1 = request.getParameter("mark1");
        String m2 = request.getParameter("mark2");
        String m3 = request.getParameter("mark3");
        String m4 = request.getParameter("mark4");
        String m5 = request.getParameter("mark5");


        // Validate missing fields

        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            m1 == null || m1.trim().isEmpty() ||
            m2 == null || m2.trim().isEmpty() ||
            m3 == null || m3.trim().isEmpty() ||
            m4 == null || m4.trim().isEmpty() ||
            m5 == null || m5.trim().isEmpty()) {

            out.println("<h2 style='color:red;"
                    + "text-align:center;'>"
                    + "Please fill all the fields."
                    + "</h2>");

            return;
        }


        int mark1, mark2, mark3, mark4, mark5;


        // Convert marks to numbers

        try {

            mark1 = Integer.parseInt(m1);
            mark2 = Integer.parseInt(m2);
            mark3 = Integer.parseInt(m3);
            mark4 = Integer.parseInt(m4);
            mark5 = Integer.parseInt(m5);

        } catch (NumberFormatException e) {

            out.println("<h2 style='color:red;"
                    + "text-align:center;'>"
                    + "Marks must be numeric values."
                    + "</h2>");

            return;
        }


        // Validate mark range

        if (mark1 < 0 || mark1 > 100 ||
            mark2 < 0 || mark2 > 100 ||
            mark3 < 0 || mark3 > 100 ||
            mark4 < 0 || mark4 > 100 ||
            mark5 < 0 || mark5 > 100) {

            out.println("<h2 style='color:red;"
                    + "text-align:center;'>"
                    + "Marks must be between 0 and 100."
                    + "</h2>");

            return;
        }


        // Calculate total

        int total =
                mark1 + mark2 + mark3 + mark4 + mark5;


        // Calculate average

        double average = total / 5.0;


        // Find highest mark

        int highest = Math.max(
                Math.max(mark1, mark2),
                Math.max(
                    Math.max(mark3, mark4),
                    mark5
                )
        );


        // Find lowest mark

        int lowest = Math.min(
                Math.min(mark1, mark2),
                Math.min(
                    Math.min(mark3, mark4),
                    mark5
                )
        );


        // Calculate grade

        String grade;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";


        // Pass / Fail

        boolean pass =
                mark1 >= 40 &&
                mark2 >= 40 &&
                mark3 >= 40 &&
                mark4 >= 40 &&
                mark5 >= 40;


        String result;

        if (pass)
            result = "PASS";
        else
            result = "FAIL";


        // Dynamic HTML output

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Student Result</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;"
                + "background:#ecfeff;"
                + "padding:50px;}");

        out.println(".card{background:white;"
                + "max-width:650px;"
                + "margin:auto;"
                + "padding:30px;"
                + "border-radius:15px;"
                + "box-shadow:0 10px 30px #aaa;}");

        out.println("h1{text-align:center;"
                + "color:#0369a1;}");

        out.println("table{width:100%;"
                + "border-collapse:collapse;"
                + "margin-top:20px;}");

        out.println("th,td{padding:12px;"
                + "border:1px solid #cbd5e1;"
                + "text-align:center;}");

        out.println("th{background:#0284c7;"
                + "color:white;}");

        out.println(".pass{color:green;"
                + "font-weight:bold;}");

        out.println(".fail{color:red;"
                + "font-weight:bold;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Student Result</h1>");

        out.println("<p><b>Student Name:</b> "
                + name + "</p>");

        out.println("<p><b>Register Number:</b> "
                + regno + "</p>");


        // Result table

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Subject</th>");
        out.println("<th>Mark</th>");
        out.println("</tr>");

        out.println("<tr><td>Subject 1</td><td>"
                + mark1 + "</td></tr>");

        out.println("<tr><td>Subject 2</td><td>"
                + mark2 + "</td></tr>");

        out.println("<tr><td>Subject 3</td><td>"
                + mark3 + "</td></tr>");

        out.println("<tr><td>Subject 4</td><td>"
                + mark4 + "</td></tr>");

        out.println("<tr><td>Subject 5</td><td>"
                + mark5 + "</td></tr>");

        out.println("</table>");


        // Summary

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Total</th>");
        out.println("<th>Average</th>");
        out.println("<th>Highest</th>");
        out.println("<th>Lowest</th>");
        out.println("<th>Grade</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        out.println("<tr>");

        out.println("<td>" + total + "</td>");

        out.println("<td>"
                + String.format("%.2f", average)
                + "</td>");

        out.println("<td>" + highest + "</td>");

        out.println("<td>" + lowest + "</td>");

        out.println("<td>" + grade + "</td>");

        if (pass)
            out.println("<td class='pass'>PASS</td>");
        else
            out.println("<td class='fail'>FAIL</td>");

        out.println("</tr>");

        out.println("</table>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");

        out.close();
    }
}