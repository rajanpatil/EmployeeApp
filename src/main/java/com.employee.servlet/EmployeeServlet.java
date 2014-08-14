package com.employee.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;
import java.util.ArrayList;

import com.employee.EmployeePOJO;
import com.employee.EmployeeDAO;

public class EmployeeServlet extends HttpServlet {

    private static final List<EmployeePOJO> employeeList = new ArrayList<EmployeePOJO>();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        List<EmployeePOJO> empList = EmployeeDAO.getAllEmployee();
        RequestDispatcher rd = request.getRequestDispatcher("EmployeeList.jsp");
        request.setAttribute("empList", empList);
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        String empId = request.getParameter("id");
        String empName = request.getParameter("name");
        String empRole = request.getParameter("role");

        if (empId == null || empName == null || empRole == null) {
            message = "Couldn't add employee!";
            out.println("<div align=\"left\"><a href=\"/EmployeeApp/\">Home</a></div>");
            out.println("<h3 align=\"center\">" + message + "</h3>");
            return;
        }
        EmployeePOJO employee = new EmployeePOJO();
        employee.setId(empId);
        employee.setName(empName);
        employee.setRole(empRole);

        //employeeList.add(employee);
        EmployeeDAO.addEmployee(employee);

        message = "Employee added successfully!!!";
        out.println("<div align=\"left\"><a href=\"/EmployeeApp/\">Home</a></div>");
        out.println("<h3 align=\"center\">" + message + "</h3>");

    }
}