<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<div class="shopping-cart">
		<table id="cart-table" style="color: black">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Price</th>
				<th>Qty.</th>
				<th>Total</th>
			</tr>
			<c:forEach var="cartItem" items="${ sessionScope.cart.cart }">
				<c:set var="product" value="${ cartItem.key }"/>
				<c:set var="quantity" value="${ cartItem.value }"/>
				<c:url var="imgSrc" value="img/${ product.imageName }"/>
				<tr>
					<td><img src="${ imgSrc }"/></td>
					<td><c:out value="${ product.name }"/></td>
					<td><c:out value="${ product.price.toString() }"/></td>
					<td><c:out value="${ quantity }"/></td>
					<td><c:out value="${ product.getPriceOfMultiples(quantity) }"/></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Grand Total: <c:out value="${ sessionScope.cart.totalAsString }"/></th>
				<td></td>
			</tr>
		</table>
	</div>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />