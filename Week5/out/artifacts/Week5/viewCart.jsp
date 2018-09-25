<%@ page import="product.model.product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/19/2018
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cart Results</title>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <h1 class="text-center">Your Cart contents.</h1>
        <div class="row">
            <%
                List<product> items = (List)request.getAttribute("products");
                for(product item : items)
                {%>
                  <div class="col-md-4">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <span id="name"><%=item.getName()%></span>
                          </div>
                          <div class="panel-body">
                              <p class="text-center">Product ID : <span id="id"><%=item.getID()%></span></p>
                              <p>Quantity Purchased: <span id="qty"><%=item.getQuantity()%></span></p>
                              <p>Price per item: <span id="price"><%=item.getPrice()%></span></p>
                          </div>
                      </div>
                  </div>
                <%}%>

        </div><!-- End Row -->
    </div><!-- End Container -->
    <jsp:include page="footer.jsp"></jsp:include>
