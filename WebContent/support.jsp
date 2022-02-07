<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객지원</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="./js/jquery.js"></script>
<link rel="stylesheet" href="./css/ban.css">
<link rel="stylesheet" href="/css/layout.css" />
<link rel="stylesheet" href="/css/reset.css" />
<link rel="stylesheet" href="/css/support.css" />

<style>
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
.fr_list li:nth-child(2n) { background-color:white;}
.lb { display:block;  width:200px; height:42px; line-height:42px; float:left; 
padding-left:20px; color:#222; font-weight:bold;  }
.lb.rep:before { content:"* "; color:deeppink; font-size:18px; }
.lb_data { display:block;  height:42px; line-height:42px; float:left;  }
.in_data { display:block; float:left; border:1px solid #333; width:400px; height:40px; line-height:40px; padding-left:20px; }
.in_btn { display:block; height:40px; line-height:40px; width:130px; float:left; border-radius:22px; background:#333; color:#fff; margin-left:20px; 
cursor:pointer; }
.in_btn:hover { background-color:black; }
.fr_col { width:50%; float:left;  display:block; }
.fr_col .in_btn { clear:both;  }
.fr_col.first .in_btn { float:right; margin-right:25px; }
.fr_col.last .in_btn { float:left; margin-left:25px; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:black; }
#frm1 { width:960px; margin:0 auto; }
.indata { width:100%; line-height:40px; height:40px;   }
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
h2.page_tit {border-bottom:solid 2px; margin-top:36px; margin-bottom:30px; text-align:center; width:30%; margin-left:auto; margin-right:auto;}
p.outline {margin-bottom: 1.8em; padding-bottom: 1.5em; border-bottom: 1px solid #dbdbdb; line-height: 1.3; word-break: keep-all; word-wrap: break-word;
text-align:center;}
h2{text-align:center;}
.jumbotron{ margin-top:25px;background-color:white;}
.lead{text-align:center;}
p.lead{font-size:14px;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">

      <div class="jumbotron">
        <h2>NikonKorea</h2>
        <img src="./img/nikon_concept_img.png" alt="회사소개이미지">
        <p class="lead">니콘이미징코리아는광학기기 전문기업 니콘의 한국법인으로 2006년에 창립했습니다. <br>창립 이래, 최첨단 디지털 영상기술을 탑재한 제품과 뛰어난 품질의 A/S를 제공함과 동시에, 출사, 니콘스쿨, <br>디지털 라이브 쇼, 각종 세미나 등 사진, 영상 문화와 관련된 다양한 활동을 다방면으로 전개하여 <br>지난 약 15년 이상의 시간동안 국내 카메라 산업 발전에 이바지했습니다.
니콘이미징코리아는 한 세기 가까이 축적해온 <br>니콘만의 광학과 정밀 가공에 관한 기술력을 기반으로 고객에게 풍부한 사진, 영상 생활을 제안함으로써, 고객의 가슴을 뛰게 하는 감동창조 경영에 힘쓰고 있습니다. 또한, 압도적인 성능의 플래그십 DSLR D6를 비롯하여 풀프레임 미러리스 Z, 거리측정기 COOLSHOT 라인업을 통해 다양한 분야의 영상 사업을 선도하고 있습니다.
<br>앞으로도 광학기기 전문 기업으로서 소명과 책임을 다하고, 국내 긍정적인 사진문화 전파에 기여하고 카메라 대중화를 이끌고자 더욱 노력해 나갈 것입니다.</p>
      </div>

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>■ 대표이사</h4>
          <p>정해환</p>

          <h4>■ 사업영역</h4>
          <p>일안 리플렉스 카메라, 미러리스 카메라, 콤팩트 카메라, 교환렌즈 등 니콘의 영상 관련 제품의 수입,판매 및 서비스에 관한 업무</p>

          <h4>■ 소재지</h4>
          <p>서울특별시 강남구 테헤란로 87길 36 도심공항타워 22층 (우편번호 : 06164)</p>
        </div>

        <div class="col-lg-6">
          <h4>■ 회사명</h4>
          <p>주식회사 니콘이미징코리아</p>

          <h4>■ 연락처</h4>
          <p>Tel. 080-800-6600 / Fax. 02-2068-8488</p>

          <h4>■ 주소</h4>
          <p>서울특별시 강남구 테헤란로 87길 36 도심공항타워 22층 (우편번호 : 06164)</p>
        </div>
      </div>


    </div> <!-- /container -->
    <div class="wrap">
    	<h3 style="text-align:center;"><본사위치> </h3>
   
	<!-- * 카카오맵 - 지도퍼가기 -->
<!-- 1. 지도 노드 -->
<div id="daumRoughmapContainer1641717031278" class="root_daum_roughmap root_daum_roughmap_landing"></div>

<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

<!-- 3. 실행 스크립트 -->
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1641717031278",
		"key" : "28qki",
		"mapWidth" : "1500",
		"mapHeight" : "360"
	}).render();
</script>
 </div>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<%@ include file="footer.jsp" %>
<footer class="footer">
        <p>&copy; Company 2014</p>
      </footer>
</body>
</html>