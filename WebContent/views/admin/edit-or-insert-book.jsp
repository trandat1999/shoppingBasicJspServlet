<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:if test="${book != null}"> Edit Book </c:if>
								<c:if test="${book == null}"> Add New Book </c:if></title>
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
			<!-- body -->
			
			<div class="container col-md-5 mt-5">
				<div class="card">
					<div class="card-body">
						<c:if test="${book != null}">
							<form action="update-book" method="post" class="bg-light">
						</c:if>
						<c:if test="${book == null}">
							<form action="insert-book" method="post" class="bg-light">
						</c:if>
						 <caption>
							<h2 style="color:orange;">
								<c:if test="${book != null}"> Edit Book </c:if>
								<c:if test="${book == null}"> Add New Book </c:if>
							</h2>
						</caption> 
						<c:if test="${book != null}">
							<input type="hidden" name="id"
								value="<c:out value='${book.getId()}' />" />
						</c:if>
						<fieldset class="form-group">
							<label>Book's Name</label> 
							<input placeholder="Book's Name" type="text"
								value="<c:out value="${book.getName()}"/>" class="form-control"
								name="name" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Category</label> 
							<input placeholder="Category" type="text"
								value="<c:out value='${book.getCategory() }' />" class="form-control"
								name="category">
						</fieldset>
						<fieldset class="form-group">
							<label>Author</label> 
							<input type="text" placeholder="Author"
								value="<c:out value='${book.getAuthor()}' />" class="form-control"
								name="author">
						</fieldset>
						<fieldset class="form-group">
							<label>Price</label> 
							<input type="text" placeholder="Price"
								value="<c:out value='${book.getPrice()}' />" class="form-control"
								name="price">
						</fieldset>
						<button type="submit" class="btn btn-success">Save</button>
						</form>
					</div>
				</div>
			</div>
			<!-- body -->
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