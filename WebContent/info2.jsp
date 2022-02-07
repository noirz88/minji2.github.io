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
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/company.css">
<link rel="stylesheet" href="./css/company2.css">
<link rel="stylesheet" href="./css/layout.css">
<link rel="stylesheet" href="./css/reset.css">		
</head>
<%@ include file="header.jsp" %>
<style>
h1{display:block; margin-block-start:0.67em; margin-block-end:0.67em; margin-inline-start:0px; margin-inline-end:0px;}
h1.page_tit {text-align:center; font-size: 32px; line-height: 120%; padding: 25px 0 15px; margin-bottom: 20px; font-weight:bold; color:#000; boder-bottom:2px solid;}
</style>
<body>
			<!-- 본문 영역 -->
			<div id="nikon_imaging">
				<!-- 니콘 소개 탭메뉴 -->
				
				<!-- //니콘 소개 탭메뉴 -->
				
				<!-- 니콘이미징코리아 -->
				<div class="tab_body">

					<!-- 소개 -->
					<div id="nikon_intro">
						<div class="company_txt">
							<p><span class="strong">니콘이미징코리아는</span> 광학기기 전문기업 니콘의 한국법인으로 2006년에 창립했습니다. 창립 이래, 최첨단 디지털 영상기술을 탑재한 제품과 뛰어난 품질의 A/S를 제공함과 동시에, 출사, 니콘스쿨, 디지털 라이브 쇼, 각종 세미나 등 사진, 영상 문화와 관련된 다양한 활동을 다방면으로 전개하여 지난 약 15년 이상의 시간동안 국내 카메라 산업 발전에 이바지했습니다.</p>
							<p>니콘이미징코리아는 한 세기 가까이 축적해온 니콘만의 광학과 정밀 가공에 관한 기술력을 기반으로 고객에게 풍부한 사진, 영상 생활을 제안함으로써, 고객의 가슴을 뛰게 하는 감동창조 경영에 힘쓰고 있습니다. 또한, 압도적인 성능의 플래그십 DSLR D6를 비롯하여 풀프레임 미러리스 Z, 거리측정기 COOLSHOT 라인업을 통해 다양한 분야의 영상 사업을 선도하고 있습니다.</p>
							<p>앞으로도 광학기기 전문 기업으로서 소명과 책임을 다하고, 국내 긍정적인 사진문화 전파에 기여하고 카메라 대중화를 이끌고자 더욱 노력해 나갈 것입니다.</p>
							<table class="tbl_vertical">
								<caption>니콘 회사 정보</caption>
								<colgroup>
									<col />
									<col />
								</colgroup>
								<tbody>
									<tr>
										<th class="first" scope="row">대표이사</th>
										<td class="first bdr0">정해환</td>
									</tr>
									<tr>
										<th scope="row">설립년도</th>
										<td class="bdr0">2006년</td>
									</tr>
									<tr>
										<th scope="row">사업영역</th>
										<td class="bdr0">일안 리플렉스 카메라, 미러리스 카메라, 콤팩트 카메라, 교환렌즈 등 니콘의 영상 관련 제품의 수입,판매 및 서비스에 관한 업무</td>
									</tr>
									<!-- <tr>
										<th scope="row">직원 수</th>
										<td class="bdr0">60여명</td>
									</tr> -->
									<tr>
										<th scope="row">소재지</th>
										<td class="bdr0">서울특별시 강남구 테헤란로 87길 36 도심공항타워 22층 (우편번호 : 06164)</td>
									</tr>
									<tr>
										<th scope="row">연락처</th>
										<td class="bdr0">고객센터 080-800-6600</td>
									</tr>
									<tr>
										<th scope="row">홈페이지</th>
										<td class="bdr0">http://www.nikon-image.co.kr</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<h3 class="tit_square">본사 위치 및 연락처 <a href="javascript:;" onclick="PrintMaps();" class="print">프린트</a></h3>
						<div class="map_wrap" id="map_canvas" name="map_canvas"></div>
						<table class="tbl_vertical">
							<caption>본사 연락처 정보</caption>
							<colgroup>
								<col />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th class="first" scope="row">회사명</th>
									<td class="first" class="bdr0">주식회사 <b>니콘이미징코리아</b></td>
								</tr>
								<tr>
									<th scope="row">연락처</th>
									<td class="bdr0">Tel. 080-800-6600 / Fax. 02-2068-8488</td>
								</tr>
								<tr>
									<th scope="row">주소</th>									
									<td class="bdr0">서울특별시 강남구 테헤란로 87길 36 도심공항타워 22층 (우편번호 : 06164)</td>
								</tr>
							</tbody>
						</table>
					</div>
					<%@ include file="footer.jsp" %>	
</body>
</html>


