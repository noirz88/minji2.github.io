<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id="";
	id = (String) session.getAttribute("cusid");
	String name = (String) session.getAttribute("cusname");
%>    
	<header class="hd container">
        <a class="navbar-brand" href="index.jsp">일산 쇼핑몰</a>
        <nav class="tnb">
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
							<li><a href="MyPageCtrl?cusid=<%=id %>">마이 페이지</a></li>
							<li><a href="GetUserBasketListCtrl?cusid=<%=id %>">장바구니</a></li>
							<li><a href="GetUserPaymentListCtrl?cusid=<%=id %>">구입내역</a></li>
							<li><a href="LogoutCtrl">로그아웃</a></li>
							<li><a href="OutCtrl">회원탈퇴</a></li>
					<%
						}
					%>
        	</ul>
        </nav>
		<nav class="navbar navbar-inverse navbar-static-top" id="gnb">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">메뉴</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="company.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li class="dropdown">
                  <a href="GetProductListCtrl" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Product <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                  	<li class="dropdown-header">의류</li>
                    <li><a href="#">블라우스</a></li>
                    <li><a href="#">셔츠</a></li>
                    <li><a href="#">바지</a></li>
                    <li><a href="#">스커트</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">잡화</li>
                    <li><a href="#">란제리</a></li>
                    <li><a href="#">양말</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">액세서리</li>
                    <li><a href="#">벨트</a></li>
                    <li><a href="#">헤어밴드</a></li>
                  </ul>
                </li>
                <li>
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Community<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
					  <li><a href="GetInformListCtrl">공지사항</a></li>
					  <li><a href="GetBoardListCtrl">커뮤니티</a></li>
					</ul>
                </li>
                <li><a href="service.jsp">Service</a></li>
              </ul>
            </div>
          </div>
        </nav>
	</header>