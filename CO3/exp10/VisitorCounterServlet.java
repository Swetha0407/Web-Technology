package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorCounterServlet extends HttpServlet {

    // Unsafe shared instance variable
    private int unsafeCount = 0;

    // Thread-safe shared variable
    private AtomicInteger safeCount = new AtomicInteger(0);


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Unsafe increment
        unsafeCount++;

        // Thread-safe increment
        int safeValue = safeCount.incrementAndGet();


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("<title>Visitor Counter</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;"
                + "background:#f1f5f9;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "min-height:100vh;}");

        out.println(".card{background:white;"
                + "width:550px;"
                + "padding:35px;"
                + "border-radius:18px;"
                + "box-shadow:0 10px 30px #aaa;}");

        out.println("h1{text-align:center;"
                + "color:#0f766e;}");

        out.println(".box{padding:15px;"
                + "margin:15px 0;"
                + "border-radius:10px;"
                + "background:#ecfeff;}");

        out.println(".unsafe{color:#dc2626;"
                + "font-weight:bold;}");

        out.println(".safe{color:#15803d;"
                + "font-weight:bold;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Visitor Counter</h1>");

        out.println("<div class='box'>");

        out.println("<p>Unsafe Counter:</p>");

        out.println("<h2 class='unsafe'>"
                + unsafeCount
                + "</h2>");

        out.println("<p>"
                + "May produce incorrect results "
                + "during concurrent requests."
                + "</p>");

        out.println("</div>");


        out.println("<div class='box'>");

        out.println("<p>Thread-Safe Counter:</p>");

        out.println("<h2 class='safe'>"
                + safeValue
                + "</h2>");

        out.println("<p>"
                + "AtomicInteger safely handles "
                + "concurrent updates."
                + "</p>");

        out.println("</div>");


        out.println("<hr>");

        out.println("<p><b>Refresh the page</b> "
                + "to simulate multiple visitors."
                + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}