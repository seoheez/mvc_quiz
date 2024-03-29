<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function ucheck(chk){
		if(chk == 1){ alert("비밀번호가 틀렸습니다!!!"); }
		else if(chk == -1){ alert("존재하지 않는 id 입니다!!!")	}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:choose>
		<c:when test="${ reMap == null || reMap.usercheck.chk != 0}"> <!-- 로그인 검증x, 로그인 실패 사용자는 다시 로그인 페이지 보여줌 -->
			<script> ucheck(${reMap.usercheck.chk}) </script> <!-- usercheck 함수 호출 -->
			<form action="check" method="post">
				<input type="text" name="id" placeholder="id"><br> <input
					type="text" name="pwd" placeholder="password"><br> <input
					type="submit" value="login"> &nbsp;&nbsp; <!-- 로그인 버튼을 누르면 id와 pwd가 check로 넘어감 -->
					<a href="${contextPath }/member/register_view">회원가입</a>
			</form>
		</c:when>
		<c:otherwise>
			<h3>
				<img src="${contextPath }/resources/여름이.jpg" width="50px">
				${reMap.usercheck.name} 님 환영합니다!!!
			</h3>
		</c:otherwise>
	</c:choose>
	<a href="${contextPath }/member/member_list">모든회원보기</a>
</body>
</html>

</body>
</html>