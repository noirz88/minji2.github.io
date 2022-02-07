<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>    
<%@ page import="java.util.Date"%>
<%@ page import="com.shop.biz.*"%>
<%@ page import="com.shop.model.*"%>
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
.tit { font-size:48px; text-align: center; }
ul { list-style: none;}
input { outline:0; border:0;  border-radius:0;  }
.fr { clear:both; width:960px; margin:10px auto; margin-bottom:80px;    }
.fr:after { content:""; display:block; clear:both; }
.fr_com { text-align:center; line-height:2.4; color:deeppink; font-weight:bold; }
.fr_tit { text-align:center; line-height:3; padding-top:1em; text-align:center; }
.fr_list li { clear:both;  padding:15px;  }
.fr_list li:first-child { border-radius:30px 30px 0px 0px; }
.fr_list li:after { content:""; clear:both; display:block; }
.fr_list li:nth-child(2n+1) { background-color:#f6f6f6; }
.fr_list li:nth-child(2n) { background-color:#fff4d6; }
.lb { display:block;  width:200px; height:42px; line-height:42px; float:left; 
padding-left:20px; color:#222; font-weight:bold;  }
.lb.rep:before { content:"* "; color:deeppink; font-size:18px; }
.lb_data { display:block;  height:42px; line-height:42px; float:left;  }
.in_data { display:block; float:left; border:1px solid #333; width:400px; height:40px; line-height:40px; padding-left:20px; }
.in_btn { display:block; height:40px; line-height:40px; width:130px; float:left; border-radius:22px; background:#333; color:#fff; margin-left:20px; 
cursor:pointer; }
.in_btn:hover { background-color:deepskyblue; }
.fr_col { width:50%; float:left;  display:block; }
.fr_col .in_btn { clear:both;  }
.fr_col.first .in_btn { float:right; margin-right:25px; }
.fr_col.last .in_btn { float:left; margin-left:25px; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
.indata { width:100%; line-height:40px; height:40px;   }
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }

#frm1 { width:600px; margin:0 auto; }
.indata { width:100%; line-height:48px; height:48px; padding:5px;  }
</style>
</head>
<body>
	<%@ include file="../admin_header.jsp" %>
	<div class="container">
		<h2 class="tit">공지사항 보기</h2>
		<form action="UpdateNoticeCtrl" method="post" name="frm">
			<table class="table">
				<tr>
					<th class="item1">번호</th>
					<td class="item2"><%=notice.getSeq() %>
						<input type="hidden" name="seq" value="<%=notice.getSeq() %>"/>
					</td>
				</tr>
				<tr>	
					<th class="item1">제목</th>
					<td class="item2">
						<input type="text" name="ntit" value="<%=notice.getNtit() %>"/>
					</td>
				</tr>	
				<tr>
					<th class="item1">내용</th>
					<td class="item2">
						<textarea name="ncon" id="" ncon cols="90" rows="10"><%=notice.getNcon() %></textarea>
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
				<!-- <input type="submit" class="btn btn-default" value="글 수정" /> -->
				<a href="GetNoticeListCtrl" class="btn btn-default">목록</a>
				<%-- <a href="DeleteInformCtrl?seq=<%=inform.getSeq() %>" class="btn btn-default" >글 삭제</a> --%>
				<%-- <button class="btn btn-default"  onclick="func1(<%=notice.getSeq() %>)">글 삭제</button> --%>
			</div>
		</form>
		<script>
		function func1(data) {
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href="DeleteInformCtrl?seq="+data;
			} else {
				return false();
			}
		}
		</script>
	</div>
		<%@ include file="../admin_footer.jsp" %>
</body>
</html>