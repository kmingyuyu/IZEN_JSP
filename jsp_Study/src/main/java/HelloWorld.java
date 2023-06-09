

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super(); // httpServlet 의 생성자가 실행이 된다
    }
    
//  request 받을때 get 방식으로 주는 데이터를 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
//		resp : response 정보(서버가 클라이언트에게 응답해주기 위해서 필요하다)
		
		PrintWriter out = resp.getWriter();
		
//		req : request 정보(클라이언트로 부터 받아온 정보가 있다)
		System.out.println(req.getRequestURI());
		
		out.append("<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<title>hello</title>"
				+ "</head>"
				+ "<body>")
		.append("<h2>hello!</h2><hr>")
		.append("현재 날짜와 시간은 : " + java.time.LocalDate.now())
		.append("</body></html>");
	}
	
//	request 받을때 post 방식으로 주는 데이터를 받는다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getRequestURI());
		
		doGet(req , resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}
}