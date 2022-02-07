package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonNoticeDAO;
import com.shop.model.NikonNoticeVO;

@WebServlet("/AddNoticeCtrl")
public class AddNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nname = request.getParameter("nname");
		String ntit = request.getParameter("ntit");
		String ncon = request.getParameter("ncon");
		
		NikonNoticeVO vo = new NikonNoticeVO();
		vo.setNname(nname);
		vo.setNtit(ntit);
		vo.setNcon(ncon);
		
		NikonNoticeDAO dao = new NikonNoticeDAO();
		int cnt = dao.addNotice(vo);
		
		if(cnt != 0) {
			response.sendRedirect("GetNoticeListCtrl");
		} else {
			response.sendRedirect("/notice/addNotice.jsp");
		} 
	}
}