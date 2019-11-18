<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<div id="heading">
		<h2>New Geek Post</h2>
	</div>

	<div id="forum-post">
		<c:url var="submit" value="/submitPost" />
		<form:form modelAttribute="forumPost" method="POST"
			action="${ submit }">
			<div>
				<form:label path="username">Username</form:label>
				<form:input path="username" type="text" placeholder="Username" />
				<form:errors path="username" cssClass="submitError" />
			</div>
			<div>
				<form:label path="subject">Subject</form:label>
				<form:input path="subject" type="text"
					placeholder="Subject" />
				<form:errors path="subject" cssClass="submitError" />
			</div>

			<div>
				<form:label path="message">Message</form:label>
			</div>
			<div>
				<form:textarea path="message" type="text"
					placeholder="Post text" />
				<form:errors path="message" cssClass="submitError" />
			</div>
			<input type="submit" value="Sumbit!" />
		</form:form>
	</div>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />