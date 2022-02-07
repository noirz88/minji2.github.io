package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonProductDAO;
import com.shop.model.NikonProductVO;


@WebServlet("/GetProductCtrl")
public class GetProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pcode = request.getParameter("pcode");
		System.out.println("상품코드: "+pcode);
		NikonProductVO vo = new NikonProductVO();
		vo.setPcode(pcode);
		
		NikonProductDAO dao = new NikonProductDAO();
		NikonProductVO pro = dao.getPro(vo);
		
		//이용후기
		/*UseImpressDAO dao2 = new UseImpressDAO();
		UseImpressVO vo2 = new UseImpressVO();
		vo2.setProid(Integer.parseInt(proid));
		
		ArrayList<UseImpressVO> impressList = new ArrayList<UseImpressVO>();
		impressList = dao2.getUseImpressList(vo2);
		
		ServletContext application = getServletConfig().getServletContext(); 
		if(pro != null) {
			application.setAttribute("pro", pro);*/
		/* request.setAttribute("pro", pro); */
			/*request.setAttribute("impressList", impressList);*/
		/* ServletContext application = null; */
			if(pro!=null) {
				/* application.setAttribute("pro", pro); */
				request.setAttribute("pro", pro);
				RequestDispatcher view = request.getRequestDispatcher("getProduct.jsp");
				view.forward(request, response);
			
		} else {
			response.sendRedirect("GetProductListCtrl");
		}
	}
}