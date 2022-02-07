package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonPaymentDAO;
import com.shop.model.NikonMemberVO;
import com.shop.model.NikonPaymentVO;

@WebServlet("/AddPaymentCtrl")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String mid = request.getParameter("mid");  //사용자 아이디
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		String contact = request.getParameter("contact");
		String mzipcode = request.getParameter("mzipcode");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String paytype = request.getParameter("paytype");
		String creditnum = request.getParameter("creditnum");
		String credipw = request.getParameter("credipw");
		
		if(credipw == null) {
			credipw = "해당없음";
		}
		maddr1 = maddr1+" "+maddr2;
		
		/*
		 * System.out.println("상품코드 : "+proid); System.out.println("주문수량 : "+num);
		 * System.out.println("주문자 : "+cusid); System.out.println("주문금액 : "+money);
		 */
		
		NikonPaymentVO vo = new NikonPaymentVO();
		
		vo.setMid(mid);
		vo.setMname(mname);
		vo.setMemail(memail);
		vo.setMtel(mtel);
		vo.setMaddr1(maddr1);
		vo.setMaddr2(maddr2);
		vo.setContact(contact);
		vo.setMzipcode(mzipcode);
		vo.setPprice(pprice);
		vo.setPaytype(paytype);
		vo.setCreditnum(creditnum);
		vo.setCredipw(credipw);
		
		NikonPaymentDAO dao = new NikonPaymentDAO();
		int cnt = dao.addPayment(vo);
		session.setAttribute("paymentResult", cnt);
		if(cnt != 0) {
			response.sendRedirect("GetPaymentCtrl");
		} else {
			response.sendRedirect("GetPaymentCtrl?mid="+mid);
		} 
	}
}