package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonBoardDAO;
import com.shop.model.NikonBoardVO;

@WebServlet("/BoardReplyAddCtrl")
public class BoardReplyAddCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        NikonBoardDAO dao = new NikonBoardDAO();
        NikonBoardVO boardData = new NikonBoardVO();

        // 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
        String pageNum = request.getParameter("page");
        
        // 파리미터 값을 가져온다.
        String id = request.getParameter("board_id");
        String subject = request.getParameter("board_subject");
        String content = request.getParameter("board_content");
        int ref = Integer.parseInt(request.getParameter("board_re_ref"));
        int lev = Integer.parseInt(request.getParameter("board_re_lev"));
        int seq = Integer.parseInt(request.getParameter("board_re_seq"));
        
        // 답글중 가장 최근 답글이 위로 올라가게 처리한다. 
        // 그러기 위해 답글의 순서인 seq를 1증가시킨다.
        boardData.setReRef(ref);
        boardData.setReSeq(seq);
        dao.updateReSeq(boardData);
        
        // 답글 저장
        boardData.setNum(dao.getSeq()); // 답글의 글번호는 시퀀스값 가져와 세팅
        boardData.setId(id);
        boardData.setSubject(subject);
        boardData.setContent(content);
        boardData.setReRef(ref);
        boardData.setReLevel(lev+1);
        boardData.setReSeq(seq+1);
        int cnt= dao.boardReplyInsert(boardData);
		if(cnt > 0) {
			response.sendRedirect("GetBoardListCtrl");
		} else {
			response.sendRedirect("BoardReplyFormCtrl");
		}
	}
}