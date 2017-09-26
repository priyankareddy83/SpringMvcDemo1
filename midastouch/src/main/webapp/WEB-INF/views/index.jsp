<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html lang = "en">
<head>
<style type="text/css">
.img-rounded
{

}
</style>
<title>Web App</title> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset ="utf-8">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
<meta name="view port" content="width= device-width, initial-scale=1">
<meta charset ="utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
<h2><i>midas touch</i></h2>
<div id ="mycarousel" class="carousel slide" data-ride="carousel">
<ol class ="carousel-indicators">
<li data-target="#mycarousel" data-slide-to="0" class ="active"></li>
<li data-target="#mycarousel" data-slide-to="1" class="active"></li>
<li data-target="#mycarousel" data-slide-to="2" class="active"></li>
</ol>

<div class="carousel-inner">
<div class="item active">
<img class="img-rounded" class="img-responsive center-block" style = "width:100%"
src="resources/med1.jpg">
</div>

<div class ="item">
<img class="img-rounded" class="img-responsive center-block" style = "width:100%"
src="resources/med2.jpg">
</div>
<div class ="item">
<img class="img-rounded" class="img-responsive center-block" style = "width:100%"
src="resources/med3.png">
</div>
</div>
<a class="left carousel-control" href="#mycarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
<span class= "sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#mycarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
<span class="sr-only">Next</span>
</a>
</div>

</div>
<body>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</body>
</html>
