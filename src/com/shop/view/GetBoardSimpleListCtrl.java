package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonBoardDAO2;
import com.shop.model.NikonBoardVO;
//글목록 보기
@WebServlet("/GetBoardSimpleListCtrl")
public class GetBoardSimpleListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
        
		NikonBoardDAO2 dao = new NikonBoardDAO2();
        ArrayList<NikonBoardVO> boardList =  dao.getBoardList();
        
		request.setAttribute("boardList", boardList);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("getBoardList2.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}