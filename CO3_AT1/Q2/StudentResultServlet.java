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

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        /* ==============================
           GET REQUEST DATA
           ============================== */

        String name =
                request.getParameter("name");

        String regno =
                request.getParameter("regno");

        String mark1Text =
                request.getParameter("mark1");

        String mark2Text =
                request.getParameter("mark2");

        String mark3Text =
                request.getParameter("mark3");


        /* ==============================
           VALIDATE MISSING VALUES
           ============================== */

        if (name == null || name.trim().isEmpty()
                || regno == null || regno.trim().isEmpty()
                || mark1Text == null || mark1Text.trim().isEmpty()
                || mark2Text == null || mark2Text.trim().isEmpty()
                || mark3Text == null || mark3Text.trim().isEmpty()) {

            showError(
                out,
                "Please fill in all the fields."
            );

            return;
        }


        /* ==============================
           CONVERT MARKS
           ============================== */

        int mark1;
        int mark2;
        int mark3;

        try {

            mark1 = Integer.parseInt(mark1Text);
            mark2 = Integer.parseInt(mark2Text);
            mark3 = Integer.parseInt(mark3Text);

        }
        catch (NumberFormatException e) {

            showError(
                out,
                "Marks must contain numeric values only."
            );

            return;
        }


        /* ==============================
           RANGE VALIDATION
           ============================== */

        if (mark1 < 0 || mark1 > 100
                || mark2 < 0 || mark2 > 100
                || mark3 < 0 || mark3 > 100) {

            showError(
                out,
                "Marks must be between 0 and 100."
            );

            return;
        }


        /* ==============================
           CALCULATIONS
           ============================== */

        int total =
                mark1 + mark2 + mark3;

        double average =
                total / 3.0;

        int highest =
                Math.max(
                    mark1,
                    Math.max(mark2, mark3)
                );

        boolean passed =
                mark1 >= 40
                && mark2 >= 40
                && mark3 >= 40;


        String status =
                passed ? "PASS" : "FAIL";


        /* ==============================
           GENERATE HTML RESPONSE
           ============================== */

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Student Result</title>");

        out.println("<style>");

        out.println(
            "body{" +
            "margin:0;" +
            "font-family:Arial,sans-serif;" +
            "background:#1e293b;" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "min-height:100vh;" +
            "padding:30px;" +
            "}"
        );

        out.println(
            ".result{" +
            "background:white;" +
            "width:650px;" +
            "padding:35px;" +
            "border-radius:20px;" +
            "box-shadow:0 20px 50px #0006;" +
            "}"
        );

        out.println(
            "h1{" +
            "text-align:center;" +
            "color:#c2410c;" +
            "}"
        );

        out.println(
            ".student{" +
            "background:#fff7ed;" +
            "padding:15px;" +
            "border-radius:10px;" +
            "margin:20px 0;" +
            "}"
        );

        out.println(
            "table{" +
            "width:100%;" +
            "border-collapse:collapse;" +
            "margin-top:20px;" +
            "}"
        );

        out.println(
            "th,td{" +
            "padding:13px;" +
            "border:1px solid #ddd;" +
            "text-align:center;" +
            "}"
        );

        out.println(
            "th{" +
            "background:#ea580c;" +
            "color:white;" +
            "}"
        );

        out.println(
            ".pass{" +
            "color:#15803d;" +
            "font-weight:bold;" +
            "}"
        );

        out.println(
            ".fail{" +
            "color:#dc2626;" +
            "font-weight:bold;" +
            "}"
        );

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='result'>");


        /* STUDENT DETAILS */

        out.println("<h1>Student Result</h1>");

        out.println("<div class='student'>");

        out.println(
            "<p><b>Student Name:</b> "
            + name
            + "</p>"
        );

        out.println(
            "<p><b>Register Number:</b> "
            + regno
            + "</p>"
        );

        out.println("</div>");


        /* MARK TABLE */

        out.println("<table>");

        out.println(
            "<tr>" +
            "<th>Subject</th>" +
            "<th>Mark</th>" +
            "</tr>"
        );

        out.println(
            "<tr>" +
            "<td>Subject 1</td>" +
            "<td>" + mark1 + "</td>" +
            "</tr>"
        );

        out.println(
            "<tr>" +
            "<td>Subject 2</td>" +
            "<td>" + mark2 + "</td>" +
            "</tr>"
        );

        out.println(
            "<tr>" +
            "<td>Subject 3</td>" +
            "<td>" + mark3 + "</td>" +
            "</tr>"
        );

        out.println("</table>");


        /* SUMMARY */

        out.println("<table>");

        out.println(
            "<tr>" +
            "<th>Total</th>" +
            "<th>Average</th>" +
            "<th>Highest</th>" +
            "<th>Status</th>" +
            "</tr>"
        );

        out.println("<tr>");

        out.println("<td>" + total + "</td>");

        out.println(
            "<td>"
            + String.format("%.2f", average)
            + "</td>"
        );

        out.println("<td>" + highest + "</td>");

        if (passed) {

            out.println(
                "<td class='pass'>PASS</td>"
            );

        } else {

            out.println(
                "<td class='fail'>FAIL</td>"
            );

        }

        out.println("</tr>");

        out.println("</table>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");

        out.close();
    }


    /* ==============================
       ERROR RESPONSE
       ============================== */

    private void showError(
            PrintWriter out,
            String message) {

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Validation Error</title>");

        out.println("</head>");

        out.println("<body style='font-family:Arial;"
                + "text-align:center;"
                + "padding:80px;"
                + "background:#fff7ed;'>");

        out.println(
            "<h1 style='color:#dc2626;'>"
            + "Validation Error"
            + "</h1>"
        );

        out.println(
            "<p style='font-size:18px;'>"
            + message
            + "</p>"
        );

        out.println("</body>");

        out.println("</html>");
    }
}