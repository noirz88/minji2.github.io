<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
.header {width: 100%;background: #EAEAEA;}
.header-gnb {width: 1541px; margin: 0 auto; padding: 0px; list-style: none; text-align: center; background: #CCC; margin-top:114px; margin-left:-205px;}
.header-gnb > li {display: inline-block;width:  120px;position: static;cursor: pointer; margin-inline:40px;}
.header-gnb > li > div {padding: 10px 0; width: 100%; text-align: center;}
.header-gnb > li:hover > ul { display: block;} 
.header-gnb > li > ul { display: none; margin: 0; padding: 10px; background: rgba(255,255,255,0.7); border: 1px solid #CCC;
 list-style: none; position: absolute; left: 0; right: 0; top: auto;} 
.header-gnb > li > ul > li > a { display: inline-block; width: 100%; padding: 5px;}
.global_link{margin-left:72px;}
.header-gnb > li.on{color:black;background-color:#FFE146; position:relative;}
</style>
    
<%
	String id="";
	id = (String) session.getAttribute("mid");
	String name = (String) session.getAttribute("mname");
%>    
	<header class="hd container" style="margin-top:10px">
       <a href="index.jsp" class="logo"> <img src="./img/NIKON.PNG"
				alt="앰블럼이미지">
		</a>
        <nav class="tnb" style="margin-top:10px">
        <nav class="tnb"  style="margin-left;">
                        <p class="site_tit">Nikon Imaging | Korea</p>
                        <a href="https://www.nikon.com/" class="global_link">Global Site</a>
                        <ul class="tnb_link">
                        </ul>
                    </nav>
        	<ul>
					<%
					if(id!=null && id.equals("admin")) {
						response.sendRedirect("admin.jsp");
					%>
					<%
					} else if(id==null ) {	//로그인이 되어 있을 때
					%>
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>

					<%		
						} else {
					%>
							<li><span style="display: block; height: 42px; line-height: 42px; font-weight:bold;"><%=name %>&nbsp;님</span></li>
							<li><a href="MyPageCtrl?mid=<%=id %>">마이 페이지</a></li>
							<li><a href="GetUserInListCtrl?mid=<%=id %>">장바구니</a></li>
							<li><a href="GetUserPaymentListCtrl?mid=<%=id %>">구입내역</a></li>
							<li><a href="LogoutCtrl">로그아웃</a></li>
							<li><a href="OutCtrl">회원탈퇴</a></li>
					<%
						}
					%>
        	</ul>
        </nav>
<div class="header">
  <ul class="header-gnb">
    <li>
      <div class="menu-wrap"><a href="index.jsp">Home</a></div>
    </li>
    
    <li>
      <div><a href="GetProductListCtrl">제품정보</a></div>
    </li>
    <li>
      <div><a href="support.jsp">회사소개</a></div>
    </li>
    <li>
      <div><a href="GetNoticeListCtrl2">공지사항</a></div>
    </li>
  </ul>
</div>
	</header>
	<script type="text/javascript">
	$(function(){
		$('li').click(function(){
			$('li').removeClass()
				$(this).addClass('on')
		})
	})
	</script>