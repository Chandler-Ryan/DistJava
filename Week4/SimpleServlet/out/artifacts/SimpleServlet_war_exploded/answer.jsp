<%@ page import="edu.wctc.simple.Individual" %>
<%@ page import="edu.wctc.simple.FindColumns" %>
<%@ page import="edu.wctc.simple.Students" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/12/2018
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Search results</title>
</head>
<body>
    <div class="container">
        <h1>Search results:</h1>
        <table class="table table-hover table-striped">
            <tr>
                <th>Account Number</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>IP Address</th>
            </tr>

    <%
        Students theStudents2 = new Students();
        ArrayList<Individual> result2;
        result2 = theStudents2.findStudents(FindColumns.valueOf(request.getParameter("searchType")), request.getParameter("message"));
        for (Individual i: result2) { %>
            <tr>
                <td> <%=i.getAccountNumber()%></td>
                <td> <%=i.getFname()%></td>
                <td> <%=i.getLname()%></td>
                <td> <%=i.getEmail()%></td>
                <td> <%=i.getIpAddress()%></td>
            </tr>
    <%}%>
    </table></div>
</body>
</html>
