<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="baseUrl" value="${ pageContext.request.contextPath }" />
<section id="main-content">
	<div id="heading">
		<h2>Solar System Geek Gift Shop</h2>
	</div>
	<c:if test="${ product != null }">
		<c:set var="imgSrc" value="${ baseUrl }/img/${ product.imageName }" />
		<div class="product-container">
			<div class="product-img-container">
				<img src="${ imgSrc }">
			</div>
			<div class="product-details">
				<h2 class="product-detail-name">
					<c:out value="${ product.name }" />
				</h2>
				<h3>
					<c:out value="${ product.price.toString() }" />
				</h3>
				<p>
					<c:out value="${ product.description }" />
				</p>
				<div class="cart-form">

					<c:url var="formAction" value="addtocart" />
					<form method="POST" action="${ formAction }">
						<label for="quantity">Quantity to buy</label>&nbsp <input
							type="number" name="quantity" id="quantity"
							value="${ empty quantity ? 0 : quantity }" /> &nbsp <input
							type="hidden" name="productId" value="${ product.id }" /> <input
							type="submit" value="Add to cart" />
					</form>
				</div>
			</div>

		</div>
	</c:if>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />