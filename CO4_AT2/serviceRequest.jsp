<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>IT Service Desk</title>

    <style>

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: "Segoe UI", Arial, sans-serif;
            min-height: 100vh;
            background:
                radial-gradient(circle at top left, #dbeafe, transparent 35%),
                radial-gradient(circle at bottom right, #e0e7ff, transparent 35%),
                #f8fafc;
            color: #172033;
            padding: 40px 20px;
        }

        .page {
            max-width: 1000px;
            margin: auto;
        }

        /* Header */

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .logo {
            width: 64px;
            height: 64px;
            margin: auto;
            border-radius: 18px;
            background: #2563eb;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 30px;
            box-shadow: 0 10px 25px rgba(37, 99, 235, 0.25);
        }

        .header h1 {
            margin-top: 15px;
            font-size: 32px;
            color: #111827;
        }

        .header p {
            margin-top: 8px;
            color: #64748b;
            font-size: 15px;
        }

        /* Main Card */

        .card {
            background: rgba(255, 255, 255, 0.95);
            border: 1px solid #e2e8f0;
            border-radius: 20px;
            padding: 35px;
            box-shadow: 0 20px 50px rgba(15, 23, 42, 0.08);
        }

        .card-title {
            margin-bottom: 25px;
        }

        .card-title h2 {
            font-size: 21px;
            color: #1e293b;
        }

        .card-title p {
            margin-top: 5px;
            color: #64748b;
            font-size: 14px;
        }

        /* Form Grid */

        .form-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .full {
            grid-column: 1 / -1;
        }

        label {
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 8px;
            color: #334155;
        }

        .required {
            color: #ef4444;
        }

        input,
        select,
        textarea {
            width: 100%;
            border: 1px solid #cbd5e1;
            border-radius: 10px;
            padding: 12px 14px;
            font-size: 14px;
            font-family: inherit;
            background: white;
            color: #1e293b;
            outline: none;
            transition: 0.2s;
        }

        input:focus,
        select:focus,
        textarea:focus {
            border-color: #2563eb;
            box-shadow: 0 0 0 3px rgba(37, 99, 235, 0.12);
        }

        textarea {
            min-height: 120px;
            resize: vertical;
        }

        /* Priority */

        .priority-options {
            display: flex;
            gap: 12px;
        }

        .priority-option {
            flex: 1;
            position: relative;
        }

        .priority-option input {
            position: absolute;
            opacity: 0;
        }

        .priority-option label {
            display: block;
            text-align: center;
            padding: 12px;
            border: 1px solid #cbd5e1;
            border-radius: 10px;
            cursor: pointer;
            background: white;
            transition: 0.2s;
        }

        .priority-option input:checked + label {
            border-color: #2563eb;
            background: #eff6ff;
            color: #2563eb;
        }

        /* Submit */

        .submit-area {
            margin-top: 28px;
            display: flex;
            justify-content: flex-end;
        }

        button {
            border: none;
            border-radius: 10px;
            padding: 13px 25px;
            background: #2563eb;
            color: white;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: 0.2s;
            box-shadow: 0 8px 20px rgba(37, 99, 235, 0.2);
        }

        button:hover {
            background: #1d4ed8;
            transform: translateY(-1px);
        }

        /* Footer */

        .footer {
            text-align: center;
            margin-top: 20px;
            color: #94a3b8;
            font-size: 13px;
        }

        /* Responsive */

        @media (max-width: 700px) {

            .form-grid {
                grid-template-columns: 1fr;
            }

            .full {
                grid-column: auto;
            }

            .priority-options {
                flex-direction: column;
            }

            .card {
                padding: 25px;
            }

        }

    </style>

</head>

<body>

<div class="page">

    <!-- Header -->

    <div class="header">

        <div class="logo">
            🛠
        </div>

        <h1>IT Service Desk</h1>

        <p>
            Submit a technical support request to the IT team
        </p>

    </div>


    <!-- Form Card -->

    <div class="card">

        <div class="card-title">

            <h2>Submit Service Request</h2>

            <p>
                Please provide the details of the technical issue.
            </p>

        </div>


        <form action="ServiceRequestServlet" method="post">

            <div class="form-grid">


                <!-- Employee ID -->

                <div class="form-group">

                    <label for="employeeId">
                        Employee ID <span class="required">*</span>
                    </label>

                    <input
                        type="text"
                        id="employeeId"
                        name="employeeId"
                        placeholder="e.g. EMP101"
                        required>

                </div>


                <!-- Employee Name -->

                <div class="form-group">

                    <label for="employeeName">
                        Employee Name <span class="required">*</span>
                    </label>

                    <input
                        type="text"
                        id="employeeName"
                        name="employeeName"
                        placeholder="Enter employee name"
                        required>

                </div>


                <!-- Department -->

                <div class="form-group">

                    <label for="department">
                        Department <span class="required">*</span>
                    </label>

                    <input
                        type="text"
                        id="department"
                        name="department"
                        placeholder="e.g. CSE"
                        required>

                </div>


                <!-- Category -->

                <div class="form-group">

                    <label for="problemCategory">
                        Problem Category <span class="required">*</span>
                    </label>

                    <select
                        id="problemCategory"
                        name="problemCategory"
                        required>

                        <option value="">
                            Select a category
                        </option>

                        <option value="Network">
                            Network
                        </option>

                        <option value="Software">
                            Software
                        </option>

                        <option value="Hardware">
                            Hardware
                        </option>

                        <option value="Account">
                            Account
                        </option>

                        <option value="Other">
                            Other
                        </option>

                    </select>

                </div>


                <!-- Description -->

                <div class="form-group full">

                    <label for="problemDescription">
                        Problem Description
                        <span class="required">*</span>
                    </label>

                    <textarea
                        id="problemDescription"
                        name="problemDescription"
                        placeholder="Describe the technical problem in detail..."
                        required></textarea>

                </div>


                <!-- Priority -->

                <div class="form-group full">

                    <label>
                        Priority <span class="required">*</span>
                    </label>

                    <div class="priority-options">

                        <div class="priority-option">

                            <input
                                type="radio"
                                id="low"
                                name="priority"
                                value="Low"
                                required>

                            <label for="low">
                                Low
                            </label>

                        </div>


                        <div class="priority-option">

                            <input
                                type="radio"
                                id="medium"
                                name="priority"
                                value="Medium">

                            <label for="medium">
                                Medium
                            </label>

                        </div>


                        <div class="priority-option">

                            <input
                                type="radio"
                                id="high"
                                name="priority"
                                value="High">

                            <label for="high">
                                High
                            </label>

                        </div>

                    </div>

                </div>


            </div>


            <!-- Submit Button -->

            <div class="submit-area">

                <button type="submit">
                    Submit Service Request →
                </button>

            </div>

        </form>

    </div>


    <div class="footer">
        Internal IT Support • Service Request Management System
    </div>

</div>

</body>
</html>