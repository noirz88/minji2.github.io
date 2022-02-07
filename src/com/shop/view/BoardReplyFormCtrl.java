package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonBoardDAO;
import com.shop.model.NikonBoardVO;

@WebServlet("/BoardReplyFormCtrl")
public class BoardReplyFormCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        int num = Integer.parseInt(request.getParameter("num"));
        // 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
        String pageNum = request.getParameter("page");
        NikonBoardDAO dao = new NikonBoardDAO();
        NikonBoardVO vo = new NikonBoardVO();
		vo.setNum(num);
		
		NikonBoardVO board = dao.getDetail(vo);
		if(board != null) {
	        request.setAttribute("board", board);
	        request.setAttribute("page", pageNum);
			RequestDispatcher view = request.getRequestDispatcher("boardReplyForm.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetBoardListCtrl");
		}
	}
}