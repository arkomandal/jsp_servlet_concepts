<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<!-- JSP Scriptlet -->
	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("auth.jsp");
		}
	%>

	<div align="center">
		<h1>Welcome ${sessionScope.username}</h1> <!-- Expression Language ${sessionScope.username} -->
		<form action="<%=request.getContextPath()%>/logout" method="get">
			<button>Logout</button>
		</form>

		<!-- "JSTL if statement" doesn't have an else part -->
		<c:choose>
			<c:when test="${param.success eq 1}">
				<script>
					setTimeout(function() {
						afterloggedin();
					}, 100)
				</script>
			</c:when>
			<c:otherwise>
				<script>
				<!-- yourAnotherFunctionName() -->
					
				</script>
			</c:otherwise>
		</c:choose>
	</div>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<script>
		function afterloggedin() {
			toastr.success('You\'re logged in', `Hi`);
		}
	</script>

</body>
</html>