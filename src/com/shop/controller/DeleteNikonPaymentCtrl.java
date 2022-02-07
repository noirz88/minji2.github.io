package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonPaymentDAO;
import com.shop.model.NikonPaymentVO;

@WebServlet("/DeleteNikonPaymentCtrl")
public class DeleteNikonPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String payid = request.getParameter("payid"); //주문번호
		String proid = request.getParameter("proid"); //주문제품번호
				
		NikonPaymentVO vo = new NikonPaymentVO();
		vo.setPayid(Integer.parseInt(payid));
		vo.setProid(Integer.parseInt(proid));
		
		
		NikonPaymentDAO dao = new NikonPaymentDAO();
		int cnt = dao.deletePayment(vo);
		
		if(cnt > 0) {
			response.sendRedirect("GetUserPaymentListCtrl");
		} else {
			response.sendRedirect("GetUserPaymentListCtrl");
		} 
	}
}