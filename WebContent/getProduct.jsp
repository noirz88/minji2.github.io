<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.*"  %>
<%@ page import="com.shop.biz.*"  %>
<%@ page import="com.shop.model.*"  %>
<%
	NikonProductVO pro = (NikonProductVO) request.getAttribute("pro");
	int cnt=1; 
	session.setAttribute("pprice", pro.getPprice());
	String uid=(String) session.getAttribute("mid");
	/* String uid = (String) session.getAttribute("id"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<title>상품 상세 보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
ul { list-style: none; }
.tit { font-size:48px; text-align: center; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
</style>
<script src="js/jquery-latest.js"></script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h2 class="tit">상품 구매 하기</h2>
		<form action="" method="post" name="frm">
			<table class="table">
				<tr>	
					<th class="item1">상품타입</th>
					<td class="item2">
						<input type="hidden" name="pcode" id="pcode" value="${pro.getPcode() }" />
						<input type="hidden" name="mid" id="mid" value="${session.getAttribute('mid') }" />
						<h4>${pro.getPtype() }</h4>
					</td>
				</tr>
				<tr>	
					<th class="item1">상품명</th>
					<td class="item2">
						<h4>${pro.getPname() }</h4>
					</td>
				</tr>
				<tr>
					<th class="item1">상품설명</th>
					<td class="item2">
						<p class="procom">${pro.getPinfo() }</p>
					</td>
				</tr>
				<tr>	
					<th class="item1">가격</th>
					<td class="item2">
						<input type="hidden" name="price" id="price" value="${pro.getPprice() }" />
						<p class="price">${pro.getPprice() }</p>
					</td>
				</tr>
				<tr>	
					<th class="item1">수량</th>
					<td class="item2">
						<input type="number" name="cnt" id="cnt" max="<%=pro.getPcnt() %>" min="1" value="1"/>
					</td>
				</tr>
				<tr>	
					<th class="item1">상품 이미지</th>
					<td class="item2">
						<c:if test="${pro.getPimg() == null }">
							<img src="img/noimage.jpg" alt="관련 이미지 없음" class="thumbnail_img"/>
						</c:if>
						<c:if test="${pro.getPimg() != null }">
							<img src="${pro.getPimg() }" alt="${pro.getPinfo() }"  class="thumbnail_img"/>
						</c:if>
					</td>
				</tr>				
			</table>
			<!--  버튼 그룹 -->
			<div class="btn-group">
				<%
					if(id != null) {
				%>
				<a href="javascript:" onclick="payAction()" class="btn btn-primary">구매</a>
				<a href="AddInCtrl?pcode=<%=pro.getPcode() %>&iid=<%=uid %>" class="btn btn-primary">장바구니 담기</a>
				<%
					}
				%>
				<a href="GetProductListCtrl" class="btn btn-primary"> 목록</a>
			</div>
		</form>
		<script>
		function payAction(){
			var cnt = document.getElementById("cnt").value;
			location.href="payment.jsp?num="+cnt;
		}
/* 		$(function(){
			$("#cnt").on("key input", function(){
				
			});
		}); */
		</script>
<%--  이용후기 표시 및 쓰기 	--%>
<%-- <%
	if(id != null) {
%>
		<h3>이용후기</h3>
		<form action="AddImpressCtrl">
			<table class="table">
				<tbody>
				<c:forEach items="${impressList }" var="impress" varStatus="status">
					<tr>
						<td>${impress.getSubject() }</td>
						<td>${impress.getCusid() }</td>
						<%
						if(uid.equals("admin")) {
						%>
							<td><a href="DeleteImpressCtrl?impressid=${impress.getImpressid() }&proid=${impress.getProid() }">댓글삭제</a></td>
						<%	
						}	
						%>	
					</tr>
				</tbody>
				</c:forEach>
			</table>
			<input type="hidden" name="cusid" value="<%=session.getAttribute("cusid") %>" />
			<input type="hidden" name="proid" value="${pro.getProid() }" />
			<input type="text" name="subject" id="subject" size="150" placeholder="이용후기를 써주세요" required /><br><br>
			<div class="btn-group">
				<input type="submit" value="이용후기 등록" class="btn btn-primary"/>
			</div>
		</form>
<%
	}
%> --%>
	</div>
		<%@ include file="footer.jsp" %>
</body>
</html>