<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>
<%
	ArrayList<NikonInVO> basketList = (ArrayList<NikonInVO>) request.getAttribute("basketList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
#mason li { box-sizing:border-box; max-width:370px; }
#mason li a h4, #mason li a p { padding:0px 20px; }
</style>
<script src="js/jquery-latest.js"></script>
<link rel="stylesheet" href="datatables.min.css" />
<script src="datatables.min.js"></script>
<script src="js/masonry.pkgd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div class="content">
		<h2 class="tit">장바구니 목록</h2>
		<div class="basketlist_area">
			<table id="pList" class="table">
				<thead>
					<tr>
						<th>순번</th>
						<th>상품코드</th>
						<th>사용자 아이디</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="cnt" value="${nikoninList.size() }"/>
				<c:forEach items="${nikoninList }" var="in" varStatus="status">
					<tr>
						<td>${in.getBasketno() }</td>
						<td>
							<span>${in.getPcode() }</span>
						</td>
						<td>
							<span>${in.getMid() }</span>
						</td>
						<td><a href="DeleteNikonInCtrl?basketno=${in.getBasketno() }" class="btn btn-primary">장바구니 삭제</a>
							&nbsp; &nbsp;
							<a href="GetPaymentCtrl?pcode=${in.getPcode() }" class="btn btn-primary">결제</a>
							
							
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<script>
 		$(function(){
			$("#pList").DataTable();		//#custom_tb는 반드시 table 태그일 것.
		}); 
		</script>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</div>	
</body>
</html>