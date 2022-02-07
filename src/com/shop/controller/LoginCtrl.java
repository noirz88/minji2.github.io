package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonMemberDAO2;
import com.shop.model.NikonMemberVO;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		
		NikonMemberVO member = new NikonMemberVO();
		NikonMemberDAO2 dao = new NikonMemberDAO2();
		//받을객체 = DAO객체명.메서드명(vo)
		member = dao.getMember(vo);
		HttpSession session = request.getSession();
		
		if(member!=null) {
			session.setAttribute("member", member);
			session.setAttribute("mid", member.getMid());
			session.setAttribute("mpw", member.getMpw());
			session.setAttribute("mname", member.getMname());
			session.setAttribute("memail", member.getMemail());
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		/*
		 * String cid = (String) custom.getCusid(); String admin = "admin";
		 * if(Objects.equals(cid, admin) || level==1) { session.setAttribute("cusid",
		 * custom.getCusid()); session.setAttribute("cusname", custom.getCusname());
		 * session.setAttribute("level", custom.getGrade());
		 * System.out.println("관리자페이지로"); response.sendRedirect("admin.jsp"); } else
		 * if(Objects.isNull(cid) && !(Objects.equals(cid, admin))) {
		 * session.setAttribute("cusid", custom.getCusid());
		 * session.setAttribute("cusname", custom.getCusname());
		 * session.setAttribute("level", custom.getGrade());
		 * System.out.println("일반회원페이지로"); response.sendRedirect("index.jsp"); } else {
		 * response.sendRedirect("join.jsp"); }
		 */
	}
}
