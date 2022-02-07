package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonNoticeDAO;
import com.shop.model.NikonNoticeVO;

@WebServlet("/DeleteNoticeCtrl")
public class DeleteNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int cnt = 0;
		NikonNoticeVO vo = new NikonNoticeVO();
		vo.setSeq(seq);
		
		NikonNoticeDAO dao = new NikonNoticeDAO();
		cnt = dao.deleteNotice(vo);
		if(cnt!=0) response.sendRedirect("GetNoticeListCtrl");
	}
}