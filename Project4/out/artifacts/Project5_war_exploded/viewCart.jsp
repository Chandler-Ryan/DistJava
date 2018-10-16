<%@ page import="java.util.List" %>
<%@ page import="Product.Model.Product" %>
<%@ page import="java.util.ArrayList" %><%--
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
            Cookie[] cookies = request.getCookies();
            //List<Product> catalog = (List)request.getAttribute("Catalog");
            ArrayList<Product>catalog = new ArrayList<Product>();
            catalog.add(new Product(1, "Cool Product 1", 0.99 ));
            catalog.add(new Product(2, "Cool Product 2", 9.99));
            catalog.add(new Product(3, "Cool Product 3", 99.99));
            if (cookies.length > 0)
            {
                for(Product item: catalog)
                {
                    for(Cookie cookie: cookies)
                    {
                        if (cookie.getName().equals(Integer.toString(item.getID())))
                        {
                            int currentQ = item.getQuantity();
                            item.setQuantity(Integer.parseInt(cookie.getValue())+currentQ);
                        }
                    }
                }
            }
            for(Product item: catalog)
            {
                if(item.getQuantity() > 0)
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
                                <form method="post" action="buyCart">
                                    <button type="submit" name="remove" value="<%=item.getID()%>" class="btn btn-danger">Remove From Cart</button>
                                </form>
                            </div>
                        </div>
                     </div>
                <%}
            }%>
        </div><!-- End Row -->
        <a href="buyCart" class="btn btn-danger">Buy Items</a>
    </div><!-- End Container -->
    <jsp:include page="footer.jsp"></jsp:include>
