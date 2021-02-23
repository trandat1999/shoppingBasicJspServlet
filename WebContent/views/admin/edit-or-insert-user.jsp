<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:if test="${user != null}"> Edit User </c:if>
								<c:if test="${user == null}"> Add New User </c:if></title>
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
						<c:if test="${user != null}">
							<form action="update-user" method="post" class="bg-light">
						</c:if>
						<c:if test="${user == null}">
							<form action="insert-user" method="post" class="bg-light">
						</c:if>
						 <caption>
							<h2 style="color:orange;">
								<c:if test="${user != null}"> Edit User </c:if>
								<c:if test="${user == null}"> Add New User </c:if>
							</h2>
						</caption> 
						<c:if test="${user != null}">
							<input type="hidden" name="id"
								value="<c:out value='${user.id}' />" />
						</c:if>
						<fieldset class="form-group">
							<label>User Name</label> 
							<input placeholder="Username" type="text"
								value="<c:out value="${user.getUsername()}"/>" class="form-control"
								name="username" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Password</label> 
							<input placeholder="Password" type="password"
								value="<c:out value='${user.getPassword()}' />" class="form-control"
								name="password">
						</fieldset>
						<fieldset class="form-group">
							<label>Email</label> 
							<input type="text" placeholder="Email"
								value="<c:out value='${user.getEmail()}' />" class="form-control"
								name="email">
						</fieldset>
						<fieldset class="form-group">
							<label>Position</label> 
							<input type="text" placeholder="Position"
								value="<c:out value='${user.getPosition()}' />" class="form-control"
								name="position">
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