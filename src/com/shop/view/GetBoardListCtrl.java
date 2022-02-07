package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonBoardDAO;
import com.shop.model.NikonBoardVO;
//글목록 보기
@WebServlet("/GetBoardListCtrl")
public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
        // 현재 페이지 번호 만들기
        int spage = 1;
        String page = request.getParameter("page");
        
        if(page != null) spage = Integer.parseInt(page);
        
        // 검색조건과 검색내용을 가져온다.
        String opt = request.getParameter("opt");
        String condition = request.getParameter("condition");
        
        // 검색조건과 내용을 Map에 담는다.
        HashMap<String, Object> listOpt = new HashMap<String, Object>();
        listOpt.put("opt", opt);
        listOpt.put("condition", condition);
        listOpt.put("start", spage*10-9);
        
        NikonBoardDAO dao = new NikonBoardDAO();
        int listCount = dao.getBoardListCount(listOpt);
        ArrayList<NikonBoardVO> boardList =  dao.getBoardList(listOpt);
        
        // 한 화면에 10개의 게시글을 보여지게함
        // 페이지 번호는 총 5개, 이후로는 [다음]으로 표시
        
        // 전체 페이지 수
        int maxPage = (int)(listCount/10.0 + 0.9);
        //시작 페이지 번호
        int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
        //마지막 페이지 번호
        int endPage = startPage + 4;
        if(endPage > maxPage)    endPage = maxPage;
        
        // 4개 페이지번호 저장
        request.setAttribute("spage", spage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
		
		request.setAttribute("boardList", boardList);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}