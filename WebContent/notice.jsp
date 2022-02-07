<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="./js/jquery.js"></script>
<link rel="stylesheet" href="./css/ban.css">
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
h1.page_tit {border-bottom:solid 2px; text-align:center; }
table,th,td{border:1px solid gray; text-align:center; border-bottom:1px solid gray; margin-left:auto; margin-right:auto;}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>
<h3 class="page_tit" style="letter-spacing:0; width:30%; text-align:center; margin-top:35px; margin-left:auto; margin-right:auto; border-bottom:solid 2px; margin-bottom:10px;">공지사항 <span>Notice</span></h3>
<p class="intro" style="text-align:center; margin-top:10px;">니콘이미징코리아의 다양한 소식을 전합니다. <br>새로운 가치와 창조를 추구하는 니콘이미징코리아의 신제품 출시, 행사에 대한 소식을 전해드립니다.</p>
<div id="contents">
		<!-- 실제 콘텐츠 영역 -->
		<div class="box_960_sub ">
			<!-- 본문 영역 -->
			<div id="press_list">				
						
				
				<table class="press">
					<caption>니콘스쿨 공지사항 목록</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:65%;" />
						<col style="width:20%;" />
					</colgroup>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col" class="bg0 bdr0">등록일</th>
					</tr>
					<tr>
							<td>424</td>
							<td class="align_l">
								<a href="javascript:viewnotice('424');">-</a>
							</td>
							<td class="bdr0">-</td>
						  </tr>
						  
						  <tr>
							<td>423</td>
							<td class="align_l">
								<a href="javascript:viewnotice('423');">-</a>
							</td>
							<td class="bdr0">-</td>
						  </tr>
						  
						  <tr>
							<td>422</td>
							<td class="align_l">
								<a href="javascript:viewnotice('422');">-</a>
							</td>
							<td class="bdr0">-</td>
						  </tr>
						  
						  <tr>
							<td>421</td>
							<td class="align_l">
								<a href="javascript:viewnotice('421');">-</a>
							</td>
							<td class="bdr0">-</td>
						  </tr>
						  
						  <tr>
							<td>420</td>
							<td class="align_l">
								<a href="javascript:viewnotice('420');">-</a>
							</td>
							<td class="bdr0">-</td>
						  </tr>
						  
						  <tr>
							<td>419</td>
							<td class="align_l">
								<a href="javascript:viewnotice('419');"></a>
							</td>
							<td class="bdr0"></td>
						  </tr>
						  
						  <tr>
							<td>417</td>
							<td class="align_l">
								<a href="javascript:viewnotice('417');"></a>
							</td>
							<td class="bdr0"></td>
						  </tr>
						  
						  <tr>
							<td>416</td>
							<td class="align_l">
								<a href="javascript:viewnotice('416');"></a>
							</td>
							<td class="bdr0"></td>
						  </tr>
						  
						  <tr>
							<td>415</td>
							<td class="align_l">
								<a href="javascript:viewnotice('415');">니콘스쿨 저녁강의 시간 변경안내(오후 8시)</a>
							</td>
							<td class="bdr0">2021-09-14</td>
						  </tr>
						  
						  <tr>
							<td>414</td>
							<td class="align_l">
								<a href="javascript:viewnotice('414');">2021년 9월 온라인 니콘스쿨 강의안내</a>
							</td>
							<td class="bdr0">2021-08-25</td>
						  </tr>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>