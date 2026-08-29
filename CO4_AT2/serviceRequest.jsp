<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Service Request Acknowledgement</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
        }

        .container {
            width: 650px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.15);
        }

        h1 {
            text-align: center;
            color: #16a34a;
        }

        .message {
            text-align: center;
            font-size: 18px;
            margin-bottom: 25px;
        }

        .details {
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
        }

        .row {
            display: flex;
            border-bottom: 1px solid #ddd;
        }

        .row:last-child {
            border-bottom: none;
        }

        .label {
            width: 35%;
            padding: 12px;
            background-color: #f3f4f6;
            font-weight: bold;
        }

        .value {
            width: 65%;
            padding: 12px;
        }
    </style>

</head>

<body>

<div class="container">

    <h1>✓ Request Submitted Successfully</h1>

    <div class="message">
        Your IT service request has been successfully submitted.
    </div>

    <div class="details">

        <div class="row">
            <div class="label">Service Request Number</div>
            <div class="value">${requestNumber}</div>
        </div>

        <div class="row">
            <div class="label">Employee ID</div>
            <div class="value">${serviceRequest.employeeId}</div>
        </div>

        <div class="row">
            <div class="label">Employee Name</div>
            <div class="value">${serviceRequest.employeeName}</div>
        </div>

        <div class="row">
            <div class="label">Department</div>
            <div class="value">${serviceRequest.department}</div>
        </div>

        <div class="row">
            <div class="label">Problem Category</div>
            <div class="value">${serviceRequest.problemCategory}</div>
        </div>

        <div class="row">
            <div class="label">Priority</div>
            <div class="value">${serviceRequest.priority}</div>
        </div>

        <div class="row">
            <div class="label">Problem Description</div>
            <div class="value">${serviceRequest.problemDescription}</div>
        </div>

    </div>

</div>

</body>
</html>