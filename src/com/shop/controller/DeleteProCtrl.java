package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonProductDAO;
import com.shop.biz.ProlistDAO;
import com.shop.model.NikonProductVO;
import com.shop.model.ProlistVO;

@WebServlet("/DeleteProCtrl")
public class DeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String pcode = request.getParameter("pcode");
		int cnt = 0;
		NikonProductVO vo = new NikonProductVO();
		vo.setPcode(pcode);
		
		NikonProductDAO dao = new NikonProductDAO();
		cnt = dao.deletePro(vo);
		if(cnt!=0) response.sendRedirect("GetProListCtrl");
	}
}