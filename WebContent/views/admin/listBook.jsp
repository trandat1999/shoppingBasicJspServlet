<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value='/templates/admin/css/styles.css'/>"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->
	<div id="layoutSidenav">
		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- menu -->
		<div id="layoutSidenav_content">
			<table class="table table-bordered">
				<thead>
					<tr style="color: orange; background-color: green">
						<th>ID</th>
						<th>Name</th>
						<th>Category</th>
						<th>Author</th>
						<th>Price</th> 
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="book" items="${listBook}">
						<tr>
							<td><c:out value="${book.getId()}" /></td>
							<td><c:out value="${book.getName()}" /></td>
							<td><c:out value="${book.getCategory()}" /></td>
							<td><c:out value="${book.getAuthor()}" /></td>
							<td><c:out value="${book.getPrice()}" /></td> 
							<td><a href="./edit-form-book?id=<c:out value='${book.getId()}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="./delete-book?id=<c:out value='${book.getId()}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- footer -->
			<%@ include file="/common/admin/footer.jsp"%>
			<!-- footer -->
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/templates/admin/js/scripts.js'/>"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<%-- <script src="<c:url value='/templates/admin/assets/demo/chart-area-demo.js'/>"></script>
        <script src="<c:url value='/templates/admin/assets/demo/chart-bar-demo.js'/>"></script> --%>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<%--  <script src="<c:url value='/templates/admin/assets/demo/datatables-demo.js'/>"></script> --%>
</body>
</html>