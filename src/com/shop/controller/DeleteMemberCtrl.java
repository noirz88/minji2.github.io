package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonMemberDAO;
import com.shop.model.NikonMemberVO;

@WebServlet("/DeleteMemberCtrl")
public class DeleteMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = (String) request.getParameter("mid");
		
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		
		NikonMemberDAO dao = new NikonMemberDAO();
		NikonMemberVO member = new NikonMemberVO();
		//받을객체 = DAO객체명.메서드명(vo)
		int cnt = dao.deletemember(vo);
	
		if(cnt>0) {
			response.sendRedirect("GetMemberListCtrl");
		}  else {
			response.sendRedirect("admin.jsp");
		}
	}
}