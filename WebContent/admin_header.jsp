<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
.header {width: 100%;background: #EAEAEA;}
.header-gnb {width: 1566px; margin: 0 auto; padding: 0px; list-style: none; text-align: center; background: #CCC; margin-top:114px; margin-left:-229px;}
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
	String id = "guest";
	id = (String) session.getAttribute("mid");
	System.out.println("id::"+id);
%>    
<%
if(id.equals("admin") && id!=null) {
%>
<header class="hd container" style="margin-top:10px">
       <a href="index.jsp" class="logo"> <img src="./img/NIKON.PNG"
				alt="앰블럼이미지">
	<br>
	<header class="hd container">
        <nav class="tnb">
        	<ul>
				<!-- <li><a href="GetNoticeListCtrl">게시판 관리</a></li>
				<li><a href="GetMemberListCtrl">회원 관리</a></li>
				<li><a href="GetProListCtrl">상품 관리</a></li> -->
				<li><a href="LogoutCtrl">로그아웃</a></li>
        	</ul>
        </nav>
		<div class="header">
  <ul class="header-gnb">
    <li>
      <div class="menu-wrap"><a href="index.jsp">Home</a></div>
    </li>
    
    <li>
      <div><a href="GetNoticeListCtrl">게시판 관리</a></div>
    </li>
    <li>
      <div><a href="GetMemberListCtrl">회원 관리</a></div>
    </li>
    <li>
      <div><a href="GetProListCtrl">상품 관리</a></div>
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
	<%
	} else if(id=="guest" || id==null){
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("index.jsp");
	}
%>