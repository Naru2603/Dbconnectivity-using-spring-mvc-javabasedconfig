<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<h2>How to iterate list on JSP in Spring MVC</h2>

	<p><b>Simple List:</b><p>
	
	${empList}
	
	<p><b>Iterated List:</b><p>

	<ol>
		<c:forEach var="emp" items="${empList}">
		
			<li>${emp}</li>
			
		</c:forEach>
	</ol>

</body>
</html>