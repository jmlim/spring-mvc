<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<jsp:include page="../fragments/headTag.jsp" />
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<div class="main">
		${currentUser.uid}(${currentUser.name}) 님 환영합니다.
	</div>
</body>
</html>