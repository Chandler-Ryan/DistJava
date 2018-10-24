<%@ page import="Product.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/19/2018
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%=request.getAttribute("hi") %>
        <!-- Table -->
        <table class="table table-hover">
            <thead>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>QTY</th>
            <th>Price</th>
            <th>Buy</th>
            </thead>
            <tbody>

            </tbody>
        </table>
        <%ArrayList<Product> catalog = (ArrayList<Product>)request.getAttribute("catalog");
            for(Product i : catalog){
        %>
        <tr>
            <form id="form<%=i.getProdnum()%>" name="form<%=i.getProdnum()%>" method="post" action="runCart">
                <td><%=i.getProdnum()%></td>
                <td><%=i.getDescription()%></td>
                <td>
                    <input type="number" min="0" step="1" value="0" id="qty<%=i.getProdnum()%>" name="qty<%=i.getProdnum()%>" required>
                    <input type="hidden" name="id" value="<%=i.getProdnum()%>">
                </td>
                <td><%=i.getPrice()%></td>
                <td><button type="submit" class="btn btn-default">Add 2 Cart</button></td>
            </form>
        </tr>

        <%}%>


    </div>
</div><!-- end container -->
<jsp:include page="footer.jsp"></jsp:include>