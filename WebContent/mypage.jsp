<%@page import="com.shop.model.NikonMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
h3 {
	margin: 0 auto;
	text-align: center;
	line-height: 60px;
}
.in_btn {
	margin: 4px;
}
.form-control{
	width:600px;
	margin:auto; 
}
.form-group{
	width:600px;
	margin:auto; 
}
.btn{
	margin:50px;
	width: 100px;
	border:1px;
	padding:7px;
}
<style>
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:black; }
</style>
<style>
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:black; }
#frm1 { width:600px; margin:0 auto; }
.indata { width:100%; line-height:48px; height:48px; padding:5px;  }
</style>
</style>
</head>
<body>
	<%
		System.out.println("member::"+request.getAttribute("member"));
		NikonMemberVO member = new NikonMemberVO();
			if(session.getAttribute("member") != null){
		member = (NikonMemberVO) session.getAttribute("member");
			}
			System.out.println("member::"+member.getMid());
	%>
	<%@ include file="header.jsp" %>
	
		<h3 style="margin-top: 70px;">마이페이지</h3>
		<form action="UpdateCtrl" method="post">
			<div class="form-group has-success">
				<label class="control-label" for="inputSuccess1">아이디</label> 
					<input type="text" name="mid" placeholder="문자 및 숫자로 입력" class="form-control" value="<%=member.getMid() %>" readonly/>
			</div>
			<div class="form-group has-warning">
				<label class="control-label" for="inputWarning1">비밀번호
					</label> <input type="text" name="mpw" class="form-control" value="<%=member.getMpw() %>" readonly/>
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">이름
					</label> <input type="text" name="mname" class="form-control" value="<%=member.getMname() %>">
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">우편번호
					</label> <input type="text" name="mzipcode" class="form-control" value="<%=member.getMzipcode() %>">
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">주소
					</label> <input type="text" name="maddr1" class="form-control" value="<%=member.getMaddr1() %>">
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">상세주소
					</label> <input type="text" name="maddr2" class="form-control" value="<%=member.getMaddr2() %>">
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">연락처
					</label> <input type="text" name="mtel" class="form-control" value="<%=member.getMtel() %>">
			</div>
			<div class="form-group has-error">
				<label class="control-label" for="inputError1">이메일
					</label> <input type="text" name="memail" class="form-control" value="<%=member.getMemail() %>">
			</div>
			<button type="submit" class="btn btn-primary" style="margin-left: 470px; margin-top: 15px;">수정</button>
			<button type="button" class="btn btn-danger" style="margin-left: 345px; margin-top: 15px;" id="deleteMemberBtn">탈퇴</button>
			
			<!-- 
			<button type="button" class="btn btn-default">Default</button>
			<button type="button" class="btn btn-success">Success</button>
			<button type="button" class="btn btn-info">Info</button>
			<button type="button" class="btn btn-warning">Warning</button>
			<button type="button" class="btn btn-danger">Danger</button>
			<button type="button" class="btn btn-link">Link</button>
			
			<div class="has-success">
				<div class="checkbox">
					<label> <input type="checkbox" id="checkboxSuccess"
						value="option1"> Checkbox with success
					</label>
				</div>
			</div>
			<div class="has-warning">
				<div class="checkbox">
					<label> <input type="checkbox" id="checkboxWarning"
						value="option1"> Checkbox with warning
					</label>
				</div>
			</div>
			<div class="has-error">
				<div class="checkbox">
					<label> <input type="checkbox" id="checkboxError"
						value="option1"> Checkbox with error
					</label>
				</div>
			</div> 
			-->
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
		</script>
		<script>
       
       $("#deleteMemberBtn").click(function(){
    	  location.href="DeleteMemberCtrl?id=<%=member.getMid() %>"
       });
    </script>
    <%@ include file="footer.jsp" %>
</body>
</html>