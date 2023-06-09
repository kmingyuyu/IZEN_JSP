package ch08;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService service;
	
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // 서블릿 초기화
		
		
		//프로그램 실행시 최초로 request가 왔을때 객체를 딱한번 생성한다.
//		init() -> 초기화 역활을 하는 메소드 / 딱한번 실행된다 
		service = new ProductService();
		
	}


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
//		request : 화면단에서 전달 해준 데이터가 들어있다.
		String action = request.getParameter("action");
		String view = "";

//		action이 null 이면 
//		http://localhost:8081/jsp_Study/pcontrol?action=list 주소로 forward
		if(action == null) {
			getServletContext()
			.getRequestDispatcher("/pcontrol?action=list")
			.forward(request, responce);
			
		}else {
			switch (action) {
			case "list": view = list(request , responce); break;
			case "info": view = info(request , responce); break;
			}
			getServletContext()
			.getRequestDispatcher("/ch08/" + view)
			.forward(request, responce);
		}
		
	
	}
	
//	productService에게
	private String info(HttpServletRequest request, HttpServletResponse response) {
//		setAttribute = key / value
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "registInfo.jsp";
	}
	
//	특정 id로 찾은 product 객체를 request 객체에 넣어준다.
	private String list (HttpServletRequest request, HttpServletResponse responce) {
		request.setAttribute("products", service.findAll());
		return "registList.jsp";
	}


}
