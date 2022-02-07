package com.shop.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonBoardDAO;

//글삭제
@WebServlet("/DeleteBoardCtrl")
public class DeleteBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String num = request.getParameter("num");
        int boardNum = Integer.parseInt(num);
        
        NikonBoardDAO dao = new NikonBoardDAO();
        // 삭제할 글에 있는 파일 정보를 가져온다.
        String fileName = dao.getFileName(boardNum);
        // 글 삭제 - 답글이 있을경우 답글도 모두 삭제한다.
        int cnt = dao.deleteBoard(boardNum);
        
        // 파일삭제 
        if(fileName != null) {
            // 파일이 있는 폴더의 절대경로를 가져온다.
            String folder = request.getServletContext().getRealPath("upload");
            // 파일의 절대경로를 만든다.
            String filePath = folder + "/" + fileName;
 
            File file = new File(filePath);
            if(file.exists()) file.delete(); // 파일은 1개만 업로드 되므로 한번만 삭제하면 된다.
        }
        
        response.sendRedirect("GetBoardListCtrl");
	}
}