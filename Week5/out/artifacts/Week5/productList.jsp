<%@ page import="java.util.ArrayList" %>
<%@ page import="product.model.product" %><%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/19/2018
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<product>ProductList = new ArrayList<product>();
    ProductList.add(new product(1, "Cool Product 1", 0.99 ));
    ProductList.add(new product(2, "Cool Product 2", 9.99));
    ProductList.add(new product(3, "Cool Product 3", 99.99));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home : SiteName</title>
    <jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="jumbotron">
        <p class="lead">
            Welcome to Distrubted Java
        </p>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Product Listing</div>
        <!-- Table -->
        <table class="table table-hover">
            <thead>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>QTY</th>
            <th>Price</th>
            </thead>
            <tbody>
            <form id="form1" name="form1" method="post" action="SelectBeer.do">
            <% for(product i : ProductList) {%>
            <tr>
                <td><%=i.getID()%></td>
                <td><%=i.getName()%></td>
                <td><input type="number" min="0" step="1" value="0" id="qty<%=i.getID()%>" name="qty<%=i.getID()%>" required>
                    <input type="hidden" id="name<%=i.getID()%>" name="name<%=i.getID()%>"  value="<%=i.getName()%>">
                    <input type="hidden" id="price<%=i.getID()%>" name="price<%=i.getID()%>" value="<%=i.getPrice()%>">
                    <input type="hidden" id="id<%=i.getID()%>" name="id<%=i.getID()%>" value="<%=i.getID()%>">
                </td>
                <td><%=i.getPrice()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <input type="submit" class="btn btn-default">
    </form>
    </div>
</div><!-- end container -->
<jsp:include page="footer.jsp"></jsp:include>