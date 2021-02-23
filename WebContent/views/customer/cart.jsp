<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/cart/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/cart/css/custom.css"/>" />
</head>
<body>
	<nav class="navbar">
		<div class="container">
			<a class="navbar-brand" href="./HomeCustomer">Bookstore</a>
			<div class="navbar-right">
				<div class="container minicart"></div>
			</div>
		</div>
	</nav>

	<div class="container-fluid breadcrumbBox text-center">
		<ol class="breadcrumb">
			<li><a href="#">Review</a></li>
			<li class="active"><a href="#">Order</a></li>
			<li><a href="#">Payment</a></li>
		</ol>
	</div>

	<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>

		</div>

		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>Book's
						Name</span> <span>Price</span></li>

				<c:forEach var="order" items="${order}">
					<li class="row"><span class="quantity"><c:out
								value="${order.value}" /></span> <span class="itemName"><c:out
								value="${order.key.getName()}" /></span> <span class="popbtn"><a
							class="arrow"></a></span> <span class="price"><c:out
								value="${order.key.getPrice()}" /></span></li>
				</c:forEach>
				<%-- <c:forEach var="book" items="${list}">
				
					<li class="row">
						<span class="quantity"><c:out value="${book.getId()}"/></span> 
						<span class="itemName"><c:out value="${book.getName()}"/></span> 
						<span class="popbtn"><a class="arrow"></a></span> 
						<span class="price"><c:out value="${book.getPrice()}"/></span>
					</li>
				</c:forEach> --%>

				<li class="row totals"><span class="itemName">Total:</span> <span
					class="price"><c:out value="${total}" /></span> <span class="order">
						<a href="./order" class="text-center">ORDER</a>
				</span></li>
			</ul>
		</div>

	</div>

	<!-- The popover content -->

	<div id="popover" style="display: none">
		<a href="#"><span class="glyphicon glyphicon-pencil"></span></a> <a
			href="#"><span class="glyphicon glyphicon-remove"></span></a>
	</div>

	<!-- JavaScript includes -->

	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/templates/cart/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/template/cart/js/customjs.js"/>"></script>

</body>
</html>