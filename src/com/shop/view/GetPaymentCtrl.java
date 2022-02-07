package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.NikonPaymentDAO;
import com.shop.biz.NikonProductDAO;
import com.shop.model.NikonMemberVO;
import com.shop.model.NikonPaymentVO;
import com.shop.model.NikonProductVO;

@WebServlet("/GetPaymentCtrl")
public class GetPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String pcode = request.getParameter("pcode");
		NikonProductDAO dao = new NikonProductDAO();
		NikonProductVO vo = new NikonProductVO();
		NikonMemberVO member = (NikonMemberVO) session.getAttribute("member");
		vo.setPcode(pcode);
		vo = dao.getPro(vo);
		request.setAttribute("member", member);	//보낼 객체를 선언
		request.setAttribute("product", vo);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("payment.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}