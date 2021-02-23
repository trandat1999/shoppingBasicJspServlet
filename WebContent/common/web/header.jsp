<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-warning bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand" href="HomeCustomer">Book's Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<form action="./HomeCustomer" method="get"
			class="form-inline d-flex justify-content-center md-form form-sm active-cyan active-cyan-2">
			<i class="fas fa-search" aria-hidden="true"></i> <input name="name"
				class="form-control form-control-sm ml-3 w-75" type="text"
				placeholder="Search book's name" aria-label="Search">
		</form>

		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav ml-auto">

				<li class="nav-item active"><a class="nav-link"
					href="HomeCustomer">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="fb.com/dat.nuclear">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Services</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="https://fb.com/dat.nuclear">Contact</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./cart"><img
						src="<c:url value="/templates/shopping-cart-solid.svg"/>"
						width="20px" height="20px" /></a></li>
			</ul>

		</div>
	</div>
</nav>