<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.shop.model.*"  %>
<%
	NikonMemberVO member = (NikonMemberVO) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>
ul { list-style: none;}
.tit { font-size:48px; text-align: center; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
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
#frm1 { width:960px; margin:0 auto; }
.indata { width:100%; line-height:40px; height:40px;   }
</style>
</head>
<body>
<div class="container">
	<%@ include file="admin_header.jsp" %>
	<div class="content">	
		<form action="UpdateCustomCtrl" class="frm" method="post" id="frm1" name="joinform" onsubmit="return joinCheck(this)">
		<h2 class="fr_tit">회원 가입</h2>
		<p class="fr_com">* 항목은 필수 입력 항목입니다.</p>
		<ul class="fr_list">
			<li>
				<label for="mid" class="lb rep">아이디</label>
				<span class="lb_data">
					<input type="text" name="mid" id="mid" value="<%=member.getMid() %>" class="in_data" readonly />
				</span>
			</li>
			<li>
				<label for="mpw" class="lb  rep">비밀번호</label>
				<span class="lb_data">
					<input type="password" name="mpw" id="mpw" value="<%=member.getMpw() %>" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mpw2" class="lb rep">비밀번호 확인</label>
				<span class="lb_data">
					<input type="password" name="mpw2" id="mpw2" placeholder="영문, 숫자를 반드시 포함할 것" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mname" class="lb rep">이름</label>
				<span class="lb_data">
					<input type="text" name="mname" id="mname" value="<%=member.getMname() %>" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="memail" class="lb rep">이메일</label>
				<span class="lb_data">
					<input type="text" name="memail" id="memail" value="<%=member.getMemail() %>" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mtel" class="lb rep">전화번호</label>
				<span class="lb_data">
					<input type="text" name="mtel" id="mtel" value="<%=member.getMtel() %>" class="in_data" required />
				</span>
			</li>
			<li><label for="mzipcode" class="lb">우편번호</label>
				  <span class="lb_data">
				  		<input type="text" name="mzipcode" id="mzipcode" value="<%=member.getMzipcode() %>" class="in_data" />
				  		<input type="button" value="주소찾기" onclick="findAddr()" class="in_btn"/>	
				  </span>
			</li>
			<li>
			    <label for="address1" class="lb">주소</label>
				<span class="lb_data">
					<input type="text" name="maddr1" id="maddr1" value="<%=member.getMaddr1() %>" class="in_data" />
				</span>
			</li>
			<li>
				<label for="address2" class="lb">상세주소</label>
				<span class="lb_data">
					<input type="text" name="maddr2" id="maddr2"  value="<%=member.getMaddr2() %>" class="in_data" />
				</span>
			</li>
			<li>
				<span class="fr_col first">
					<input type="submit" value="정보수정"  class="btn btn-default"/>
				</span>
				<span class="fr_col last">
					<input type="reset" value="취소" class="btn btn-default"/>
				</span>
			</li>
		</ul>
		</form>
</div>
	<%@ include file="admin_footer.jsp" %>
</div>
	<!-- 회원가입시 바뀐 형식의 주소 및 우편번호 취급 처리 스크립트 -->
    <script>
       //다음카카오의 주소 API이용
        function findAddr(){
            new daum.Postcode({
                oncomplete: function(data) {
                    console.log(data);                   
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('mzipcode').value = data.zonecode;
                    if(roadAddr !== ''){
                        document.getElementById("maddr1").value = roadAddr;
                    } 
                    else if(jibunAddr !== ''){
                        document.getElementById("maddr1").value = jibunAddr;
                    }
                }
            }).open();
        }
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
	<!-- 아이디 중복 체크 및 유효성 검증 체크 스크립트 -->
	<script>
	function joinCheck(f){
		if(f.cuspw.value!=f.cuspw2.value) {
			alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
			return false;
		}
	}
	</script>
</body>
</html>