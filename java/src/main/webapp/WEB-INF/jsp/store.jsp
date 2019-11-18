<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="baseUrl" value="${ pageContext.request.contextPath }" />
<section id="main-content">
	<c:url var="cartUrl" value="shoppingcart"/>
	<div id="heading">
		<h2>Solar System Geek Gift Shop</h2>
		<a href="${ cartUrl }" >View Shopping Cart</a>
	</div>
	<table id="productTable">
		<c:forEach items="${ products }" var="product">
			<c:set var="detailLink" value="${ baseUrl }/productDetails?id=" />

			<tr>
				<c:set var="productImg" value="${ baseUrl }/img/${ product.imageName }" />
				<td><a href="${ detailLink }${ product.id }"><img
						id="imageProduct" src="${ productImg }"></a></td>
				<td><h4>
						<a class="no-link-highlight" href="${ detailLink }${ product.id }">${ product.name }</a>
					</h4>
					<h3>
						<a class="no-link-highlight" href="${ detailLink }${ product.id }">${ product.price.toString() }</a>
					</h3>
					</td>

			</tr>

		</c:forEach>
	</table>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />