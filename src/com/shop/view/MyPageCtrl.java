package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonMemberDAO2;
import com.shop.model.NikonMemberVO;

@WebServlet("/MyPageCtrl")
public class MyPageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mid = request.getParameter("mid");
		
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		
		NikonMemberDAO2 dao = new NikonMemberDAO2();
		//받을객체 = DAO객체명.메서드명(vo)
		NikonMemberVO member = new NikonMemberVO();
		member = dao.myPage(vo);
		System.out.println("처리된 아이디 : "+member.getMid());		
		if(member.getMid() == null) {
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("mypage.jsp");
			view.forward(request, response);
		}
	}
}