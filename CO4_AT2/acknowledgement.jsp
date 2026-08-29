<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.elgoog.ServiceRequest" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Service Request Dashboard</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f1f5f9;
            color: #172033;
            padding: 35px;
        }

        .container {
            max-width: 1100px;
            margin: auto;
        }

        .success-card {
            background: white;
            border-radius: 18px;
            padding: 30px;
            margin-bottom: 25px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.08);
        }

        .success {
            text-align: center;
        }

        .success-icon {
            width: 60px;
            height: 60px;
            margin: auto;
            border-radius: 50%;
            background: #dcfce7;
            color: #16a34a;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 30px;
        }

        h1 {
            color: #16a34a;
            margin-bottom: 8px;
        }

        .success p {
            color: #64748b;
        }

        .request-number {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 18px;
            border-radius: 8px;
            background: #eff6ff;
            color: #2563eb;
            font-weight: bold;
        }

        .section {
            background: white;
            border-radius: 18px;
            padding: 30px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.06);
        }

        .section-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .section-header h2 {
            margin: 0;
        }

        .count {
            color: #64748b;
            font-size: 14px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            background: #172033;
            color: white;
            padding: 13px;
            font-size: 13px;
        }

        td {
            padding: 13px;
            border-bottom: 1px solid #e2e8f0;
            font-size: 13px;
        }

        tr:hover {
            background: #f8fafc;
        }

        .priority-high {
            color: #dc2626;
            font-weight: bold;
        }

        .priority-medium {
            color: #d97706;
            font-weight: bold;
        }

        .priority-low {
            color: #16a34a;
            font-weight: bold;
        }

        .buttons {
            margin-top: 25px;
            display: flex;
            justify-content: flex-end;
            gap: 12px;
        }

        .button {
            text-decoration: none;
            padding: 12px 20px;
            border-radius: 9px;
            font-weight: 600;
            font-size: 14px;
        }

        .add-button {
            background: #2563eb;
            color: white;
        }

        .report-button {
            background: #172033;
            color: white;
        }

    </style>

</head>

<body>

<div class="container">

    <!-- Success Message -->

    <div class="success-card">

        <div class="success">

            <div class="success-icon">
                ✓
            </div>

            <h1>Request Submitted Successfully</h1>

            <p>
                Your IT service request has been recorded successfully.
            </p>

            <div class="request-number">
                ${requestNumber}
            </div>

        </div>

    </div>


    <!-- All Requests -->

    <div class="section">

        <div class="section-header">

            <h2>Service Requests</h2>

            <span class="count">

                <%
                    List<ServiceRequest> requests =
                        (List<ServiceRequest>)
                        session.getAttribute("serviceRequests");

                    int requestCount =
                        requests == null ? 0 : requests.size();
                %>

                <%= requestCount %> / 5 Requests

            </span>

        </div>


        <table>

            <thead>

                <tr>
                    <th>Request No.</th>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Category</th>
                    <th>Priority</th>
                </tr>

            </thead>


            <tbody>

            <%
                if (requests != null) {

                    for (int i = 0; i < requests.size(); i++) {

                        ServiceRequest sr = requests.get(i);

                        String number =
                            "SR-" + (1001 + i);

                        String priorityClass =
                            "priority-" +
                            sr.getPriority().toLowerCase();
            %>

                <tr>

                    <td><strong><%= number %></strong></td>

                    <td><%= sr.getEmployeeId() %></td>

                    <td><%= sr.getEmployeeName() %></td>

                    <td><%= sr.getDepartment() %></td>

                    <td><%= sr.getProblemCategory() %></td>

                    <td class="<%= priorityClass %>">
                        <%= sr.getPriority() %>
                    </td>

                </tr>

            <%
                    }
                }
            %>

            </tbody>

        </table>


        <div class="buttons">

            <a href="serviceRequest.jsp"
               class="button add-button">
                + Add Another Request
            </a>

            <a href="ReportServlet"
               class="button report-button">
                ↓ Download Report
            </a>

        </div>

    </div>

</div>

</body>

</html>