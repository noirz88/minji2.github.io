<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
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
ul { list-style: none; }
.tit { font-size:48px; text-align: center; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
div.row1{ background-color: rgb(163, 163, 163); color:rgb(61, 61, 61); width:100%; font-size: 12px; height:153px; margin-top:333px; margin-left:-173px;}
video{margin-left:180px; width:70%;}
.root_daum_roughmap root_daum_roughmap_landing{margin-left:auto; margin-right:auto; margin-top:20px;}
</style>
</head>
<body>
<div class="container">
	<%@ include file="admin_header.jsp" %>
	<div class="content">
	<h2 style="text-align:center;">관리자 페이지 입니다.</h2>
		<figure class="vs">
				<ul class="img_box">
					<li><img src="./img/banner_file110.jpg" alt="메인카메라1" class="vs_img"></li>
					<li><img src="./img/banner_file102.jpg" alt="메인카메라2" class="vs_img"></li>
					<li><img src="./img/banner_file108.jpg" alt="메인카메라3" class="vs_img"></li>
				</ul>
			</figure>
			<ul class="text_box">
			<h1 style="text-align:center; border-bottom:solid 2px yellow; border-top:solid 2px yellow; margin-top:10px; margin-bottom:-1px; background-color:black; color:white; font-size:25px; height:40px;">Nikon 100th Anniversary Video</h1>
			</ul>
				<video muted autoplay loop>
     			<source src="./mv/니콘 100주년 기념 영상.mp4" type="video/mp4">
      			<strong>Your browser does not support the video tag.</strong>
    </video>
	</div>
	<%@ include file="admin_footer.jsp" %>
</div>
</body>
</html>