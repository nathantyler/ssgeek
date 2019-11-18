<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="baseUrl" value="${ pageContext.request.contextPath }" />
<section id="main-content">
	<c:set var="imgSrc" value="${ baseUrl }/img/${ planet.name }.jpg" />
	<div id="container">
		<img src="${ imgSrc }">
		<h2>
			If you are ${ currentAge } years old on planet Earth, then you are
			<fmt:formatNumber type="number" maxFractionDigits="2"
				value="${ planetAge }" />
			years old.
		</h2>
	</div>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />