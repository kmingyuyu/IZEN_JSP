package ch08;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegistService service;
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //서블릿 초기화 
		
		service = new RegistService();
//		객체도 프로그램 실행시 딱 한번만 생성이 됨(자원을 아낀다.)
		
	}




    
//  get , post 방식으로 오는 모든 request(:view에서의 데이터 요청) 를 처리할수 있다.
//  get/post 가기전 service 를 무조건 거쳐간다.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
//		action이라는 파라메터의 값을 얻어온다.
		String action = request.getParameter("action");
		String view = "";

//		주소에 따라 어떤 페이지를 보여줄지 지정
		if(action == null) {
//			forward 실행시 페이지는 이동하지만 주소는 바뀌지 않는다.
//			forward 실행시 
			getServletContext()
			.getRequestDispatcher("/rcontrol?action=list")
			.forward(request, responce);
		}
		else {
			switch (action) {
			case "list": view = list(request, responce); break;
			case "info": view = info(request, responce); break;
			}
			
			getServletContext()
			.getRequestDispatcher("/ch08/" + view)
			.forward(request, responce);
		}
		
		
//	1.주소에 따라 어떤 페이지를 보여줄지 지정
//	2.페이지에 맞는 데이터를 view페이지로 전달해주면된다(포워딩)
		
	}

//	2-1.model인 RegistService.java에게 데이터를 달라고 요청(메소드 실행)
	private String info(HttpServletRequest request, HttpServletResponse responce) {
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "registInfo.jsp";
		
	}
	
	
	private String list(HttpServletRequest request, HttpServletResponse responce) {
		request.setAttribute("regists", service.findAll());
		return "registList.jsp";
		
	}



}
