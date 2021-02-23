<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Card Payment Form Template | PrepBootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/payment/bootstrap/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/payment/font-awesome/css/font-awesome.min.css"/>" />

<script type="text/javascript"
	src="<c:url value="/templates/payment/js/jquery-1.10.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/templates/payment/js/bootstrap.min.js"/>"></script>
</head>
<body>

	<div class="container">

		<div class="page-header">
			<h1>Payment For Order</h1>
		</div>

		<!-- Credit Card Payment Form - START -->

		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<h3 class="text-center">Payment Details</h3>
								<img class="img-responsive cc-img"
									src="http://www.prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
							</div>
						</div>
						<div class="panel-body">
							<form role="form" action="./payment" method="post">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<label>CARD NUMBER</label>
											<div class="input-group">
												<input type="tel" class="form-control"
													placeholder="Valid Card Number" /> <span
													class="input-group-addon"><span
													class="fa fa-credit-card"></span></span>
											</div>
										</div>
									</div>
								</div>
								<!-- <div class="row">
									<div class="col-xs-7 col-md-7">
										<div class="form-group">
											<label><span class="hidden-xs">EXPIRATION</span><span
												class="visible-xs-inline">EXP</span> DATE</label> <input type="tel"
												class="form-control" placeholder="MM / YY" />
										</div>
									</div>
									<div class="col-xs-5 col-md-5 pull-right">
										<div class="form-group">
											<label>CV CODE</label> <input type="tel" class="form-control"
												placeholder="CVC" />
										</div>
									</div>
								</div> -->
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<label>Details</label> <input type="text" name="details"
												class="form-control" placeholder="Details" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<label>Payment Method</label> 
											<select name="paymethod">
											<option value="Payment by card">Payment by card</option>
											<option value="Ship Cod">Ship Cod</option>
											</select><!-- <input type="text" name="details"
												class="form-control" placeholder="Details" /> -->
										</div>
									</div>
								</div>
								
								<div class="panel-footer">
									<div class="row">
										<div class="col-xs-12">
											<button type="submit"
												class="btn btn-warning btn-lg btn-block">
												Payment for <c:out value="${total} VNĐ" ></c:out> </button>
										</div>
									</div>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>

		<style>
.cc-img {
	margin: 0 auto;
}
</style>
		<!-- Credit Card Payment Form - END -->

	</div>

</body>
</html>