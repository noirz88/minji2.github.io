package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonMemberDAO2;
import com.shop.model.NikonMemberVO;


@WebServlet("/UpdateCtrl")
public class UpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		String mzipcode = request.getParameter("mzipcode");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMemail(memail);
		vo.setMzipcode(mzipcode);
		vo.setMaddr1(maddr1);
		vo.setMaddr2(maddr2);
		
		NikonMemberDAO2 dao = new NikonMemberDAO2();
		//받을객체 = DAO객체명.메서드명(vo)
		int cnt = dao.updateMember(vo);
		NikonMemberVO member = new NikonMemberVO();
		//받을객체 = DAO객체명.메서드명(vo)
		member = dao.getMember(vo);
		HttpSession session = request.getSession(); 
		if(cnt>0) {
			
			session.setAttribute("member", member);
			session.setAttribute("mid", member.getMid());
			session.setAttribute("mpw", member.getMpw());
			session.setAttribute("mname", member.getMname());
			session.setAttribute("memail", member.getMemail());
			response.sendRedirect("mypage.jsp");
		}  else {
			response.sendRedirect("mypage.jsp");
		}
	}
}
