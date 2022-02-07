<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.*"  %>
<%@ page import="com.oreilly.servlet.MultipartRequest"  %>
<%@ page import="java.util.*" %>  
<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String originalFile, uploadFile;
		try {  
			int maxSize = 1024*1024*10;
			//String saveDirectory = config.getServletContext().getRealPath("/img"); 
			String saveDirectory = "C:\\dev\\jmj\\FileUpload";
			//System.out.println("config.getServletContext().getRealPath('/img'):::"+config.getServletContext().getRealPath("/img") );
			//String saveDirectory = "C:\\dev\\workspace_java\\Nikon2\\WebContent\\img";
			MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxSize, "utf-8");		//덮어쓰기
			//MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());	
			originalFile = multi.getOriginalFileName("p_pic");
			uploadFile = multi.getFilesystemName("p_pic");
			//여러 파일 인 경우 파일 목록을 저장하기
			//Enumeration formNames = multi.getFileNames(); 	
		if(uploadFile==null) {
			out.println("<p>해당 이미지가 업로드 되지 못했습니다.</p>");
		} else {
			out.println("<p>해당 이미지가 업로드 되었습니다.</p>");
			out.println("<a href='javascript:apply(\""+"./img/"+uploadFile+"\")'>"+uploadFile+" [적용]</a>");
			out.println("<p>적용을 눌러야만 업로드된 이미지로 이미지를 사용할 수 있습니다.</p>");
%>
		<script>
		function apply(id){
			//opener 부모창
			//opener.document.폼이름.컨트롤이름.value
			opener.document.frm.pimg.value=id;
			opener.document.getElementById("pimg").value=id;
			opener.document.getElementById("proData").src = id;
			//opener.document.joinform.m_id.readonly=true;
			opener.document.frm.imgck.value="yes";
			window.close();
		}
		</script>
<%			
		}
	} catch (Exception e) {
		System.out.println("파일 업로드가 실패되었습니다.");
		e.printStackTrace();
	}
%>