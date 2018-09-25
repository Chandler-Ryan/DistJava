<%--
  Created by IntelliJ IDEA.
  User: Chandler
  Date: 9/24/2018
  Time: 8:58 PM
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
                Welcome to Distrubted Java Store
            </p>
        </div>

        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Featured Product 1</h3>
                </div>
                <div class="panel-body">
                    cool Product info here 1<br><br>
                    <a href="productList.jsp" class="btn btn-primary">buy cool</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Featured Product 2</h3>
                </div>
                <div class="panel-body">
                    cool Product info here 2<br><br>
                    <a href="productList.jsp" class="btn btn-warning">buy cool 2</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Featured Product 3</h3>
                </div>
                <div class="panel-body">
                    cool Product info here 3<br><br>
                    <a href="productList.jsp" class="btn btn-danger">buy cool 3</a>
                </div>
            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>
