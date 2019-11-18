<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h2 id="form-title">Alien Travel Calculator</h2>
	<c:url var="formAction" value="/driveTime" />
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
			<label for="method">Choose Travel Method</label> <select name="method"
				id="method">
				<option value="walking">Walking</option>
				<option value="car">Car</option>
				<option value="bullet train">Bullet Train</option>
				<option value="boeing 747">Boeing 747</option>
				<option value="concorde">Concorde</option>
			</select>
		</div>

		<div>
			<label for="age">Enter Your Earth Age</label> <input type="number"
				name="age" id="age" value="${ empty age ? 18 : age }" />
		</div>
		<input type="submit" value="Calculate Travel Time" />
	</form>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />