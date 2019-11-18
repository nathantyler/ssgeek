<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="newMessage" value="/forum" />
<section id="main-content">
	<div id="heading">
		<h2>Solar System Geek Forum</h2>
		<a href="${ newMessage }">Post a Message</a>
		<c:if test="${ not empty successfulPost}"><h2>${ successfulPost }</h2></c:if>
	</div>
	<div class="posts">
		<c:set var="counter" value="0" />
		<c:forEach items="${ posts }" var="post">
		<fmt:parseDate value="${ post.datePosted }"
							pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="MM/dd/yyyy 'at' HH:mm:ss" value="${ parsedDateTime }" var="dateTime" />
			<%-- <div id="${ counter % 2 == 0 ? 'even' : 'odd' }"> --%>
			<div class="post">
				<h4>${ post.subject }</h4>
				<p>by ${ post.username } on ${ dateTime }</p>
				<p class="message">${ post.message }</p>
			</div>
			<c:set var="counter" value="${ counter + 1 }" />
		</c:forEach>
	</div>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />