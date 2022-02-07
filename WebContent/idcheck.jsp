<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pass = Integer.parseInt(request.getParameter("pass"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body onload="onSize()">
<%
	if(pass==0) {
%>
	<p>사용 가능한 아이디입니다.</p>
<%		
	} else {
%>
	<p>사용이 불가능한 아이디입니다.</p>
<%		
	}
%>
</body>
<script>
function onSize() {
	window.resizeTo(400,300);
}		
</script>
</html>