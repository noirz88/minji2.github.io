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
	ArrayList<NikonProductVO> proList = (ArrayList<NikonProductVO>) request.getAttribute("proList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 페이지</title>
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
#mason li { box-sizing:border-box; max-width:332px; }
#mason li a h4, #mason li a p { padding:0px 20px; }
</style>
<script src="js/jquery-latest.js"></script>
<link rel="stylesheet" href="datatables.min.css" />
<script src="datatables.min.js"></script>s
<script src="js/masonry.pkgd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div class="content">
		<h2 class="tit">상품목록</h2>
		<div class="list_wrap container">
			<ul class="lst row" id="mason">
				<c:forEach items="${proList }" var="pro" varStatus="status"> 
				<li class="col-xs-6 col-md-4">
					<a href="GetProductCtrl?pcode=${pro.getPcode() }" class="thumbnail">
						<c:if test="${pro.getPimg() == null }">
							<img src="img/0.jpg" alt="관련 이미지 없음" class="thumbnail_img" style="height:196px"/>
						</c:if>
						<c:if test="${pro.getPimg() != null }">
							<img src="${pro.getPimg() }" alt="${pro.getPimg() }"  class="thumbnail_img" style="height:196px"/>
						</c:if>
						<h4 class="proname">${pro.getPname() }</h4>
						<p class="protype">${pro.getPtype() }</p>
						<p class="price">${pro.getPprice() } 원</p>
					</a>
					</c:forEach>
				</li>
			</ul>
			<script>
				//var container = document.querySelector('#mason');
				//var msnry = new Masonry(container);
				//$("#mason").masonry();
			</script>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</div>	
</body>
</html>