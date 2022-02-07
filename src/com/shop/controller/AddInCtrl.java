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

@WebServlet("/AddInCtrl")
public class AddInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String pcode = request.getParameter("pcode");
		String mid = (String) session.getAttribute("mid");
		//System.out.println(proid);
		//System.out.println(uid);
		
		NikonInVO vo = new NikonInVO();
		vo.setPcode(pcode);
		vo.setMid(mid);
		
		NikonInDAO dao = new NikonInDAO();
		int cnt = dao.addIn(vo);
		
		if(cnt > 0) {
			response.sendRedirect("GetProductCtrl?pcode="+pcode);
		} else {
			response.sendRedirect("GetProductCtrl?pcode="+pcode);
		} 
	}
}