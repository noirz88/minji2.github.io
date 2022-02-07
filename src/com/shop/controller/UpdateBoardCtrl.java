package com.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.shop.biz.NikonBoardDAO;
import com.shop.model.NikonBoardVO;
//글수정
@WebServlet("/UpdateBoardCtrl")
public class UpdateBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        //String saveDirectory = request.getServletContext().getRealPath("/upload");  //상대경로 설정시

        try {
            
            // 파일업로드 
            //MultipartRequest multi = new MultipartRequest(request, saveDirectory, fileSize, "utf-8", new DefaultFileRenamePolicy());
        	 //상대경로
            //String saveDirectory = request.getServletContext().getRealPath("/upload"); 
        	//절대경로
			String saveDirectory = "D:\\kim\\jsp\\web04\\WebContent\\upload";
			MultipartRequest multi = new MultipartRequest(request, saveDirectory, fileSize, "utf-8");		//덮어쓰기
            // 파일이름 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            if(names.hasMoreElements()) {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            NikonBoardDAO dao = new NikonBoardDAO();
            NikonBoardVO board = new NikonBoardVO();
            
            board.setNum(Integer.parseInt(multi.getParameter("board_num"))); // 히든값
            board.setId(multi.getParameter("board_id")); // 히든값
            board.setSubject(multi.getParameter("board_subject"));
            board.setContent(multi.getParameter("board_content"));
            if(multi.getParameter("board_file")==null) {
            	board.setFile(multi.getParameter("existing_file"));
            } else {
            	board.setFile(multi.getParameter("board_file"));	
            }
            
    		int cnt = dao.updateBoard(board);
    		
    		if(cnt != 0) {
    			response.sendRedirect("GetBoardListCtrl");
    		} else {
    			response.sendRedirect("BoardUpdateFormCtrl");
    		} 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("글 작성 오류 : " + e.getMessage());
        }
	}
}
