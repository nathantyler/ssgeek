<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h2 id="form-title">Alien Weight Calculator</h2>
	<c:url var="formAction" value="/alienWeight" />
	<form method="GET" action="${ formAction }">
		<div>
			<label for="name">Choose a Planet</label> <select name="name"
				id="name">
				<option value="Mercury">Mercury</option>
				<option value="Venus">Venus</option>
				<option value="Earth">Earth</option>
				<option value="Mars">Mars</option>
				<option value="Jupiter">Jupiter</option>
				<option value="Saturn">Saturn</option>
				<option value="Uranus">Uranus</option>
				<option value="Neptune">Neptune</option>
			</select>
		</div>

		<div>
			<label for="weight">Enter Your Earth Weight</label> <input
				type="number" name="weight" id="weight"
				value="${ empty weight ? 0 : weight }" />
		</div>
		<input type="submit" value="Calculate Weight" />
	</form>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />