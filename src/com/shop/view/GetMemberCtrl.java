package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonMemberDAO;
import com.shop.model.NikonMemberVO;

@WebServlet("/GetMemberCtrl")
public class GetMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		
		NikonMemberVO vo = new NikonMemberVO();
		vo.setMid(mid);
		
		NikonMemberDAO dao = new NikonMemberDAO();
		NikonMemberVO member = dao.getMember(vo);
		
		if(member != null) {
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("getMember.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetMemberListCtrl");
		}
	}
}