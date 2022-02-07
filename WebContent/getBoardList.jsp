<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.shop.model.*" %>    
<%@ page import="com.shop.controller.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.view.*" %>
<%
	ArrayList<NikonBoardVO> boardList = (ArrayList<NikonBoardVO>) request.getAttribute("boardList"); 
	int spage = (int) request.getAttribute("spage");
	int maxPage = (int) request.getAttribute("maxPage");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판 목록</title>
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
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
.table td { min-height:42px; padding:5px; }
</style>
</head>
<body>
<div class="container">
	<%@ include file="admin_header.jsp" %>
	<h2>게시판 목록</h2>
	<div class="content">
		<div class="writePosibleArea">		
			<%-- <c:if test="${session.getAttribute('id') != null}"> --%>
				<a href="addBoard.jsp" class="btn btn-default">글쓰기</a>
			<%-- </c:if> --%>
		</div>
		<div class="borad_area">
			<table id="bList" class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="cnt" value="${boardList.size() }"/>
				<c:forEach items="${boardList }" var="board" varStatus="status">
					<tr>
						<td>${cnt }</td>
						<td>
		                    <c:if test="${board.getReLevel() > 0}">
		                        <c:forEach begin="1" end="${board.getReLevel() }">
		                            &nbsp;&nbsp; <!-- 답변글일경우 글 제목 앞에 공백을 준다. -->
		                        </c:forEach>
		                        RE : 
		                    </c:if>
							<a href="GetBoardCtrl?num=${board.getNum() }&pageNum=${spage }">${board.getSubject() }</a>
						</td>
						<td>${board.getId() }</td>
						<td>${board.getResDate() }</td>
						<td>${board.getCount() }</td>
					</tr>
					<c:set var="cnt" value="${cnt - 1 }" />
				</c:forEach>
				</tbody>
			</table>
		<script>
/* 		$(function(){
			$("#custom_tb").DataTable();		//#custom_tb는 반드시 table 태그일 것.
		}); */
		</script>
		</div>
	    <div id="pageForm">
	        <c:if test="${startPage != 1 }">
	            <a href='GetBoardListCtrl?page=${startPage-1 }'>[ 이전 ]</a>
	        </c:if>
	        
	        <c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
	            <c:if test="${pageNum == spage }">
	                ${pageNum }&nbsp;
	            </c:if>
	            <c:if test="${pageNum != spage }">
	                <a href='GetBoardListCtrl?page=${pageNum }'>${pageNum }&nbsp;</a>
	            </c:if>
	        </c:forEach>
	        
	        <c:if test="${endPage != maxPage }">
	            <a href='GetBoardListCtrl?page=${endPage+1 }'>[다음]</a>
	        </c:if>
	    </div>
	    
	    <!--  검색 부분 -->
	    <br>
	    <div id="searchForm">
	        <form>
	            <select name="opt">
	                <option value="0">제목</option>
	                <option value="1">내용</option>
	                <option value="2">제목+내용</option>
	                <option value="3">글쓴이</option>
	            </select>
	            <input type="text" size="20" name="condition"/>&nbsp;
	            <input type="submit" value="검색" class="btn btn-primary"/>
	        </form>    
	    </div>
	</div>
	<%@ include file="footer.jsp" %>
</div>	
</body>
</html>