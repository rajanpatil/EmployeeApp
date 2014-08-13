<%@ page import="java.io.*,java.util.*, com.employee.*"  %>
<html>
<head>
<title>EmployeeApp</title>
</head>
<body>
<div align="left"><a href="/EmployeeApp/">Home</a></div><br/>
    <h3 align="center">Employee List</h3>
    <table align="center" width="60%" border="1">
        <tr>
            <td  align="left"><b>Id</b></td>
	        <td  align="left"><b>Name</b></td>
	        <td  align="left"><b>Role</b></td>
        </tr>
        <%
        List<EmployeePOJO> empList = (List<EmployeePOJO>) request.getAttribute("empList");
        for(EmployeePOJO emp:empList){
        %>
        <tr>
            <td align="left"><%=emp.getId()%></td>
	        <td align="left"><%=emp.getName()%></td>
            <td align="left"><%=emp.getRole()%></td>
        </tr>
       <% } %>
    </table>
</body>
</html>