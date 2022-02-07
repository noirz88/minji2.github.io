package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonPaymentDAO;
import com.shop.model.NikonPaymentVO;

@WebServlet("/GetUserPaymentListCtrl")
public class GetUserPaymentListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");  //사용자 아이디
		
		NikonPaymentVO vo = new NikonPaymentVO();
		vo.setMid(mid);
		
		NikonPaymentDAO dao = new NikonPaymentDAO();
		ArrayList<NikonPaymentVO> payList = dao.getUserPaymentList(vo); 
		for(NikonPaymentVO vo2 : payList) {
			System.out.println("vo2::"+vo2.getMid());
		}
		
		request.setAttribute("payList", payList);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("getUserPaymentList.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}