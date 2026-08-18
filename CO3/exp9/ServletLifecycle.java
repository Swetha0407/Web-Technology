package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifecycle")
public class ServletLifecycle extends HttpServlet {

    static int constructorCount = 0;
    static int initCount = 0;
    static int doGetCount = 0;
    static int destroyCount = 0;


    // Constructor
    public ServletLifecycle() {

        constructorCount++;

        System.out.println(
            "Constructor executed: " + constructorCount
        );
    }


    // init()
    @Override
    public void init() throws ServletException {

        initCount++;

        System.out.println(
            "init() executed: " + initCount
        );
    }


    // doGet()
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doGetCount++;

        System.out.println(
            "doGet() executed: " + doGetCount
        );

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("<title>Servlet Lifecycle</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;"
                + "background:#fff7ed;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "min-height:100vh;}");

        out.println(".card{background:white;"
                + "padding:35px;"
                + "width:500px;"
                + "border-radius:15px;"
                + "box-shadow:0 10px 30px #aaa;}");

        out.println("h1{text-align:center;"
                + "color:#ea580c;}");

        out.println("p{font-size:18px;"
                + "line-height:1.8;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Servlet Lifecycle</h1>");

        out.println("<p><b>Constructor:</b> "
                + constructorCount + "</p>");

        out.println("<p><b>init():</b> "
                + initCount + "</p>");

        out.println("<p><b>doGet():</b> "
                + doGetCount + "</p>");

        out.println("<p><b>destroy():</b> "
                + destroyCount + "</p>");

        out.println("<hr>");

        out.println("<p>Refresh the page to execute "
                + "doGet() again.</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }


    // destroy()
    @Override
    public void destroy() {

        destroyCount++;

        System.out.println(
            "destroy() executed: " + destroyCount
        );
    }
}