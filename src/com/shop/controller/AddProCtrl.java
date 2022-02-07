package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonProductDAO;
import com.shop.model.NikonProductVO;

@WebServlet("/AddProCtrl")
public class AddProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pinfo = request.getParameter("pinfo");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String pimg = request.getParameter("pimg");
		
		NikonProductVO vo = new NikonProductVO();
		vo.setPcode(pcode);
		vo.setPname(pname);
		vo.setPinfo(pinfo);
		vo.setPprice(pprice);
		vo.setPimg(pimg);
		
		NikonProductDAO dao = new NikonProductDAO();
		int cnt = dao.addPro(vo);
		
		if(cnt != 0) {
			response.sendRedirect("GetProductCtrl");
		} else {
			response.sendRedirect("addPro.jsp");
		} 
	}

}
