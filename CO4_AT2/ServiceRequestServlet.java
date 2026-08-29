package com.elgoog;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ServiceRequestServlet")
public class ServiceRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        // Read values submitted from the JSP form
        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemCategory = request.getParameter("problemCategory");
        String problemDescription = request.getParameter("problemDescription");
        String priority = request.getParameter("priority");

        // Server-side validation
        if (isEmpty(employeeId) ||
            isEmpty(employeeName) ||
            isEmpty(department) ||
            isEmpty(problemCategory) ||
            isEmpty(problemDescription) ||
            isEmpty(priority)) {

            request.setAttribute(
                "errorMessage",
                "All fields are mandatory."
            );

            RequestDispatcher dispatcher =
                request.getRequestDispatcher("serviceRequest.jsp");

            dispatcher.forward(request, response);
            return;
        }

        // Create Model object
        ServiceRequest serviceRequest =
            new ServiceRequest(
                employeeId,
                employeeName,
                department,
                problemCategory,
                problemDescription,
                priority
            );

        // Generate service request number
        String requestNumber = "SR-1001";

        // Store Model and request number as request attributes
        request.setAttribute(
            "serviceRequest",
            serviceRequest
        );

        request.setAttribute(
            "requestNumber",
            requestNumber
        );

        // Forward to acknowledgement page
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("acknowledgement.jsp");

        dispatcher.forward(request, response);
    }

    // Method to check whether a field is empty
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}