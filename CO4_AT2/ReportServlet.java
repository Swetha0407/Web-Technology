package com.elgoog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<ServiceRequest> requests =
            (List<ServiceRequest>)
            session.getAttribute("serviceRequests");

        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");

        response.setHeader(
            "Content-Disposition",
            "attachment; filename=IT_Service_Request_Report.csv"
        );

        PrintWriter out = response.getWriter();

        // Report title
        out.println("IT SERVICE REQUEST REPORT");
        out.println();

        // Column headings
        out.println(
            "Request Number,Employee ID,Employee Name,Department," +
            "Problem Category,Problem Description,Priority"
        );

        if (requests != null) {

            for (int i = 0; i < requests.size(); i++) {

                ServiceRequest sr = requests.get(i);

                String requestNumber =
                    "SR-" + (1001 + i);

                out.println(
                    csv(requestNumber) + "," +
                    csv(sr.getEmployeeId()) + "," +
                    csv(sr.getEmployeeName()) + "," +
                    csv(sr.getDepartment()) + "," +
                    csv(sr.getProblemCategory()) + "," +
                    csv(sr.getProblemDescription()) + "," +
                    csv(sr.getPriority())
                );
            }
        }

        out.flush();
    }

    private String csv(String value) {

        if (value == null) {
            return "";
        }

        value = value.replace("\"", "\"\"");

        return "\"" + value + "\"";
    }
}