package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonProductDAO;

import com.shop.model.NikonProductVO;


@WebServlet("/GetProCtrl")
public class GetProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		
		NikonProductVO vo = new NikonProductVO();
		vo.setPcode(pcode);
		
		NikonProductDAO dao = new NikonProductDAO();
		NikonProductVO pro = dao.getPro(vo);
		
		if(pro != null) {
			request.setAttribute("pro", pro);
			RequestDispatcher view = request.getRequestDispatcher("getPro.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetProListCtrl");
		}
	}
}