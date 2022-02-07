package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonInDAO;
import com.shop.model.NikonInVO;

@WebServlet("/GetUserInListCtrl")
public class GetUserInListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		
		NikonInVO vo = new NikonInVO();
		vo.setMid(mid);
		
		NikonInDAO dao = new NikonInDAO();
		ArrayList<NikonInVO> nikoninList = new ArrayList<NikonInVO>(); 
		nikoninList = dao.getUserInList(vo);
		
		if(nikoninList != null) {
			request.setAttribute("nikoninList", nikoninList);	//보낼 객체를 선언
			RequestDispatcher view = request.getRequestDispatcher("getUserInList.jsp");	//보내질 곳 선언
			view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}