<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*" %>
<%
	NikonBoardVO board = (NikonBoardVO) request.getAttribute("board");
 	int pageNum = (int) (request.getAttribute("pageNum"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 보기</title>
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
.table td { min-height:42px; padding:5px; }
</style>
</head>
<body>
<div class="container">
	<%@ include file="admin_header.jsp" %>
	<h2>게시판 글보기</h2>
	<div class="content">
	    <div id="board">
	        <table id="detailBoard" class="table">
	            <tr>
	                <td id="title">작성일</td>
	                <td>${board.getResDate() }</td>
	            </tr>
	            <tr>
	                <td id="title">작성자</td>
	                <td>${board.getId() }</td>
	            </tr>
	            <tr>
	                <td id="title">
	                    제 목
	                </td>
	                <td>
	                    ${board.getSubject() }
	                </td>        
	            </tr>
	            <tr>
	                <td id="title">
	                    내 용
	                </td>
	                <td>
	                    ${board.getContent() }
	                </td>        
	            </tr>
	            <tr>
	                <td id="title">
	                    첨부파일
	                </td>
	                <td>
	                    <a href='${board.getFile() }'>${board.getFile() }</a>
	                </td>    
	            </tr>
	    
	            <tr align="center" valign="middle">
	                <td colspan="5">
	                    <a href="BoardUpdateFormCtrl?num=${board.getNum() }&page=${pageNum }" class="btn btn-primary">수정</a>
	                    <a href="DeleteBoardCtrl?num=${board.getNum() }" class="btn btn-primary">삭제</a>
	                    <a href="BoardReplyFormCtrl?num=${board.getNum() }&page=${pageNum }" class="btn btn-primary">답글</a>    
	                    <input type="button" value="목록" 
	                        onclick="javascript:location.href='GetBoardListCtrl?page=${pageNum }'" class="btn btn-primary">            
	                </td>
	            </tr>
	        </table>
	    </div>
	</div>
	<%@ include file="admin_footer.jsp" %>
</div>	
</body>
</html>