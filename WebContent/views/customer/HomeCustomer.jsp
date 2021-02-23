<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book's Store</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/templates/web//bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/templates/web/css/shop-homepage.css'/>"
	rel="stylesheet">

</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>

	<!-- body -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">

				<h1 class="my-4" style="color: red">BookStore</h1>
				<div class="list-group">
					<c:forEach var="category" items="${category }">
						<a href="./HomeCustomer?category=<c:out value="${category}"/>"
							class="list-group-item"><c:out value="${category}" /></a>
					</c:forEach>

				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="row">
					<c:if test="${listbook.size()==0}">
						<h4>không tìm thấy sách</h4>
					</c:if>
					<c:if test="${listbook.size()!=0}">
						<c:forEach var="book" items="${listbook}">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="card h-100">
									<a href="#"><img class="card-img-top"
										src="http://placehold.it/700x400" alt=""></a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="#"><c:out value="${book.getName()}"></c:out></a>
										</h4>
										<h5>
											<c:out value="${book.getPrice()}"></c:out>
											VNĐ
										</h5>
										<p class="card-text">
											Tác giả:
											<c:out value="${book.getAuthor() }"></c:out>
										</p>
									</div>
									<div class="card-footer d-flex justify-content-between">
										<small class="text-muted">&#9733; &#9733; &#9733;
											&#9733; &#9733; &#9733; &#9733;</small> <a
											href="./Homecart?id=<c:out value='${book.getId()}'/>"
											class="btn btn-primary ml-auto">Add to cart</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/templates/web/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/templates/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>