package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonMemberDAO;
import com.shop.model.NikonMemberVO;

@WebServlet("/UpdateMemberCtrl")
public class UpdateMemberCtrl extends HttpServlet {
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
		vo.setMid(mid);;
		vo.setMpw(mpw);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMemail(memail);
		vo.setMzipcode(mzipcode);
		vo.setMaddr1(maddr1);
		vo.setMaddr1(maddr2);
		
		NikonMemberDAO dao = new NikonMemberDAO();
		NikonMemberVO member = new NikonMemberVO();
		//받을객체 = DAO객체명.메서드명(vo)
		int cnt = dao.updatemember(vo);
				
		if(cnt>0) {
			response.sendRedirect("GetMemberListCtrl");
		}  else {
			response.sendRedirect("admin.jsp");
		}
	}
}