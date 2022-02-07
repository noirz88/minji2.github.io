<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.shop.biz.*"  %>
<%@ page import="com.shop.model.*" %>
<%
	NikonNoticeVO notice = (NikonNoticeVO) request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<title>공지사항 글 보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
.content { clear:both; width: 100%; height:auto; font-family: 'Nanum Gothic', sans-serif; backgrond-color:white;}    
.con_tit{margin-left: 46%; margin-top: -3%; margin-bottom:-25px;}
.art01 > ul > li > img {width:300px;}
.art01 { width: 960px; margin: 20px auto;  }
.art01 li { float:left; width: 300px; margin: 10px; }
.img_box{min-width:999px;}
.vs .img_box li .vs_img {display: block; width: 100%; height: 440px;}
img { display: block; margin: 0px auto;}
.pro_tit{font-size:medium;}
.div.box_960{display:block; height:100px;}
video{margin-left:254px; width:70%;}
.root_daum_roughmap root_daum_roughmap_landing{margin-left:auto; margin-right:auto; margin-top:20px;}
</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="container">
		<h2 class="tit">공지사항 보기</h2>
			<table class="table">
				<tr>
					<th class="item1">번호</th>
					<td class="item2"><%=notice.getSeq() %></td>
				</tr>
				<tr>	
					<th class="item1">제목</th>
					<td class="item2">
						<p><%=notice.getNtit() %></p>
					</td>
				</tr>	
				<tr>
					<th class="item1">내용</th>
					<td class="item2">
						<p><%=notice.getNcon() %></p>
					</td>
				</tr>
				<tr>
					<th class="item1">작성자</th>
					<td class="item2"><%=notice.getNname() %></td>
				</tr>
				<tr>	
					<th class="item1">작성일</th>
					<td class="item2"><%=notice.getRegdate() %></td>
				</tr>
				<tr>	
					<th class="item1">방문횟수</th>
					<td class="item2"><%=notice.getVisited() %></td>
				</tr>
			</table>
			<!--  버튼 그룹 -->
			<div class="btn-group">
				<a href="GetNoticeListCtrl2" class="btn btn-default">목록</a>
			</div>
		</form>
	</div>
		<%@ include file="../footer.jsp" %>
</body>
</html>