package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonMemberDAO2;
import com.shop.model.NikonMemberVO;

@WebServlet("/DupCtrl")
public class DupCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		if(mid==null) {
			response.sendRedirect("idcheck.jsp?pass=1");	
		}
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		
		NikonMemberDAO2 dao = new NikonMemberDAO2();
		//받을객체 = DAO객체명.메서드명(vo)
		int cnt = dao.dupCheck(vo);
		response.sendRedirect("idcheck.jsp?pass="+cnt);
	}
}