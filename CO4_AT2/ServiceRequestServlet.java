package com.elgoog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServiceRequestServlet")
public class ServiceRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        // Read submitted form values
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

        // Get current session
        HttpSession session = request.getSession();

        // Get existing requests from session
        List<ServiceRequest> serviceRequests =
            (List<ServiceRequest>) session.getAttribute("serviceRequests");

        if (serviceRequests == null) {
            serviceRequests = new ArrayList<>();
        }

        // Allow maximum 5 requests
        if (serviceRequests.size() >= 5) {

            request.setAttribute(
                "errorMessage",
                "Maximum of 5 service requests can be added."
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

        // Generate request number
        int requestNumberValue = 1001 + serviceRequests.size();

        String requestNumber =
            "SR-" + requestNumberValue;

        // Add request to the list
        serviceRequests.add(serviceRequest);

        // Store list in session
        session.setAttribute(
            "serviceRequests",
            serviceRequests
        );

        // Store latest request number
        request.setAttribute(
            "requestNumber",
            requestNumber
        );

        request.setAttribute(
            "serviceRequest",
            serviceRequest
        );

        // Forward to acknowledgement page
        RequestDispatcher dispatcher =
            request.getRequestDispatcher(
                "acknowledgement.jsp"
            );

        dispatcher.forward(request, response);
    }

    private boolean isEmpty(String value) {

        return value == null ||
               value.trim().isEmpty();
    }
}