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
	ArrayList<NikonPaymentVO> payList = (ArrayList<NikonPaymentVO>) request.getAttribute("payList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 목록</title>
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
.ft { background-color: rgb(163, 163, 163); color:rgb(61, 61, 61); width:100%; font-size: 12px; margin-top:-7px; height:153px;}
	.ft_wrap { width: 1000px; margin: 0 auto; padding-top:3px;}
	.row2 { clear:both;  width:100%; }
	.ft_link { clear:both; width: 1200px; margin:0 auto; height:48px; }
	.ft_link li { float:left; margin-right:20px; }
	.ft_link li a { display:block; line-height:48px; color:#333; font-weight:bold; }
	.ft_link li a:before { content:" | "; }
	.addr, .copyright { width: 1200px; margin:0 auto; font-size:11px; padding-bottom: 5px; }
	.copyright  { padding-bottom:12px; }
	.goto_top { float:left; }
	.goto_top a { display:block; line-height:36px; color:#333; width:160px; text-align: center; font-size:11px;  font-family: 'Noto Sans KR', sans-serif; font-weight:bold;
margin-top:6px;  }
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
		<h2 class="tit">결제 목록</h2>
		<div class="paylist_area">
			<table id="pList" class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>결제번호</th>
						<th>결제자이름</th>
						<th>결제유형</th>
						<!-- <th>상품수량</th> -->
						<th>결제금액</th>
						<th>기타</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="cnt" value="${payList.size() }"/>
				<c:forEach items="${payList }" var="pay" varStatus="status">
					<tr>
						<%-- <td>${cnt }</td> --%>
						<td>
							<span>${pay.getPayid() }</span>
						</td>
						<td>
							<span>${pay.getCreditnum() }</span>
						</td>
						<td>
							<span>${pay.getMid() }</span>
						</td>
						<td>
							<span>${pay.getPaytype() }</span>
						</td>
						<td>
							<span>${pay.getPprice() }</span>
						</td>
						
						
						<td><a href="GetProductListCtrl">목록으로 돌아가기</a></td>
					</tr>
					<%-- <c:set var="cnt" value="${cnt - 1 }" /> --%>
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