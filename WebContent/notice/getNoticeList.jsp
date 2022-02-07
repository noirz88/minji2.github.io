<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.model.*" %>
<%
	ArrayList<NikonNoticeVO> noticeList = (ArrayList<NikonNoticeVO>) request.getAttribute("noticeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<title>공지사항 목록</title>
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
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
</style>
</head>
<body>
	<%@ include file="../admin_header.jsp" %>
	<div class="container">
		<h2 class="tit">공지사항 목록</h2>
		<form action="" method="post">
				<table class="table">
					<tr>
						<td>
								<select name="searchType" id="">
									<option value="ntit">제목</option>
									<option value="ncon">내용</option>
								</select>
								<input type="text" name="searchKeyword" />
								<input type="submit" value="검색"/>
						</td>
					</tr>
				</table>
		</form>
		<table class="table">
			<tr>
				<th class="item1">번호</th>
				<th class="item2">제목</th>
				<th class="item3">작성자</th>
				<th class="item4">작성일</th>
			</tr>
<%
	for(int i=0;i<noticeList.size();i++) {
		NikonNoticeVO notice = noticeList.get(i);
%>
	<tr>	
		<td class="item1"><%=notice.getSeq() %></td>
		<td class="item2"><a href="GetNoticeCtrl?seq=<%=notice.getSeq() %>"><%=notice.getNtit() %></a></td>
		<td class="item3"><%=notice.getNname() %></td>
		<td class="item4"><%=notice.getRegdate() %></td>
	</tr>
<%
	}
%>
		</table>
		<!-- 페이지내이션(PageNation) : 목록의 값이 한 페이지 분량을 초과할 경우 나누어 표시하고, 해당 페이지 링크를 누르면
		그 페이지에 해당하는 내용만 표시 -->
		<nav>
			<ul class="pagination">
				<li><a href="" arial-label="Previous"><span arial-hidden="true">&laquo;</span></a></li>
				<li><a href="GetNoticeListCtrl">1</a></li>
				<li><a href="" arial-label="Next"><span arial-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		<!--  버튼 그룹 -->
		<div class="btn-group">
			<a href="GetAddNoticeCtrl" class="btn btn-default">글 작성</a>
		</div>
	</div>
		<%@ include file="../admin_footer.jsp" %>
</body>
</html>