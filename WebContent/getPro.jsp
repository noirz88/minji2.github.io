<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.shop.biz.*"  %>
<%@ page import="com.shop.model.*"  %>
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
</head>
<body>
	<%@ include file="admin_header.jsp" %>
	<div class="container">
		<h2 class="tit">상품 추가 하기</h2>
		<form action="UpdateProCtrl" method="post" name="frm">
			<table class="table">
				<tr>	
					<th class="item1">상품타입</th>
					<td class="item2">
						<input type="hidden" name="pcode" id="pcode" value="${pro.getPcode() }" />
						<input type="text" name="ptype" id="ptype" value="${pro.getPtype() }" />
					</td>
				</tr>
				<tr>	
					<th class="item1">상품명</th>
					<td class="item2">
						<input type="text" name="pname" id="pname" value="${pro.getPname() }" />
					</td>
				</tr>
				<tr>
					<th class="item1">상품설명</th>
					<td class="item2">
						<textarea name="pinfo" id="pinfo"  cols="90" rows="10">${pro.getPinfo() }</textarea>
					</td>
				</tr>
				<tr>	
					<th class="item1">가격</th>
					<td class="item2">
						<input type="text" name="pprice" id="pprice" value="${pro.getPprice() }" />
					</td>
				</tr>
				<tr>	
					<th class="item1">수량</th>
					<td class="item2">
						<input type="number" name="pcnt" id="pcnt" max="100" min="1" value="${pro.getPcnt() }" />
					</td>
				</tr>
				<tr>	
					<th class="item1">상품 이미지</th>
					<td class="item2">
						<input type="text" name="pimg" id="pimg"  value="${pro.getPimg() }" />
						<input type="button" class="btn dtn-default" onclick="imgCheck()" value="이미지 업로드"/><br>
						<img src="${pro.getPimg() }" id="pimg" alt="제품사진" />
						<input type="hidden" name="pimg"/>
						<input type="hidden" name="imgck"/>
					</td>
				</tr>				
				<tr>
					<th class="item1">등록자</th>
					<td class="item2">
						<span>관리자</span>
						<input type="hidden" name="nname" value="관리자" />
					</td>
				</tr>
			</table>
			<!--  버튼 그룹 -->
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="상품 등록" />
				<input type="reset" class="btn btn-default" value="취소" />
			</div>
		</form>
	<script>
	function imgCheck() {
		window.open("imgUploadForm.jsp", "imguploadcheck", "width=300, height=300");
	}
	</script>
	</div>
		<%@ include file="admin_footer.jsp" %>
</body>
</html>