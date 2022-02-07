package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonInDAO;
import com.shop.model.NikonInVO;

@WebServlet("/DeleteNikonInCtrl")
public class DeleteNikonInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int basketno = Integer.parseInt(request.getParameter("basketno")); //장바구니코드

		NikonInVO vo = new NikonInVO();
		vo.setBasketno(basketno);
		
		NikonInDAO dao = new NikonInDAO();
		int cnt = dao.deleteIn(vo);
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		if(cnt > 0) { //성공이면 1 실패는 0
			response.sendRedirect("GetUserInListCtrl?mid="+mid);
		} else {
			response.sendRedirect("GetUserInListCtrl?mid="+mid);
		} 
	}
}