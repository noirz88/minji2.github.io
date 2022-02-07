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
<title>상품관리</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="jquery-latest.js"></script>
<link rel="stylesheet" href="datatables.min.css" />
<script src="datatables.min.js"></script>
<style>
ul { list-style: none; }
.tit { font-size:48px; text-align: center; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
</style>
</head>
<body>
<div class="container">
	<%@ include file="admin_header.jsp" %>
	<h2>상품 목록</h2>
	<div class="content">
		<table class="table" id="product_tb">
			<thead>
				<tr>
					<th class="item1">연번</th>
					<th class="item2">상품타입</th>
					<th class="item3">상품명</th>
					<th class="item4">상품설명</th>
					<th class="item5">가격</th>
					<th class="item6">수량</th>
					<th class="item7">편집</th>
				</tr>
			</thead>
			<tbody>
		<%
		int cnt = proList.size();
		for(int i=0;i<proList.size();i++) {
			NikonProductVO pro = null;
			pro = proList.get(i);
		%>
				<tr>
					<td class="item1"><%=pro.getPcode() %></td>
					<td class="item2"><%=pro.getPtype() %></td>
					<td class="item3"><%=pro.getPname() %></td>
					<td class="item3"><%=pro.getPinfo() %></td>
					<td class="item5"><%=pro.getPprice() %></td>
					<td class="item6"><%=pro.getPcnt() %></td>
					<td class="item7">
						<%-- <a href="GetProCtrl?pcode=<%=pro.getPcode() %>" class="btn btn-default">편집</a> --%>
						<a href="DeleteProCtrl?pcode=<%=pro.getPcode() %>" class="btn btn-default">삭제</a>
					</td>
				</tr>
		<%
		}
		%>
			</tbody>
		</table>
		<script>
		$(function(){
			$("#product_tb").DataTable();		//#custom_tb는 반드시 table 태그일 것.
		});
		</script>
		<div class="btn-group">	
			<a href="addPro.jsp" class="btn btn-default">상품 추가</a>
		</div>
	</div>
	<%@ include file="admin_footer.jsp" %>
</div>	
</body>
</html>