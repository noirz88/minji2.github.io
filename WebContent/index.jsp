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
	<%@ include file="header.jsp" %>
	<div class="wrap">
		<div class="content">
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
	<!-- <h2 style="text-align:center; border-bottom:solid 2px yellow; border-top:solid 2px yellow; margin-top:10px; margin-bottom:10px; background-color:black; color:white; font-size:25px; height:40px;">Nikon Location</h2>	 -->
	<h2 class="con_tit"></h2>
		<div class="box_960">
            <article class="art01">
                <ul>
                    <li>
				     </li>
                </ul>
            </article>
            </div>
	<div class="content">
	<script src="./js/ban.js"></script>
	</div>
	<%@ include file="footer.jsp" %>
</div>


</body>
</html>