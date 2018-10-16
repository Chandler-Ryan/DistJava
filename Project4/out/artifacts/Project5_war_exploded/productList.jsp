<%@ page import="java.util.ArrayList" %>
<%@ page import="Product.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/19/2018
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Product>ProductList = new ArrayList<Product>();
    ProductList.add(new Product(1, "Cool Product 1", 0.99 ));
    ProductList.add(new Product(2, "Cool Product 2", 9.99));
    ProductList.add(new Product(3, "Cool Product 3", 99.99));
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
            <th>Buy</th>
            </thead>
            <tbody>
            <% for(Product i : ProductList) {%>
            <tr>
                <form id="form<%=i.getID()%>" name="form<%=i.getID()%>" method="post" action="runCart">
                    <td><%=i.getID()%></td>
                    <td><%=i.getName()%></td>
                    <td>
                        <input type="number" min="0" step="1" value="0" id="qty<%=i.getID()%>" name="qty<%=i.getID()%>" required>
                        <input type="hidden" name="id" value="<%=i.getID()%>">
                    </td>
                    <td><%=i.getPrice()%></td>
                    <td><button type="submit" class="btn btn-default">Add 2 Cart</button></td>
                </form>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div><!-- end container -->
<jsp:include page="footer.jsp"></jsp:include>