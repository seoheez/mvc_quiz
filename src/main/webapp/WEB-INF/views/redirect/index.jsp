<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp
	<br>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<img src="resources/여름이.jpg" width="100px" height="130px">
	<img src="${contextPath }/resources/여름이.jpg" width="100px"
		height="130px">
	<img src="<c:url value='/resources/여름이.jpg'/>" width="100px"
		height="130px">
	<hr>
	<img src="resources/test/춘식이1.jpg" width="100px" height="100px">
	<img src="css/춘식이2.jpg" width="100px" height="100px">


	<form action="result">
		<input type="text" name="id"><br> <input type="submit"
			value="전송">
	</form>
</body>
</html>