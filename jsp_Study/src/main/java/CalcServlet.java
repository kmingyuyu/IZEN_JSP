

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("op");
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(op);
		
		long result = 0;
		switch (op) {
		case "+":
			result = n1 + n2; break;
		case "-":
			result = n1 - n2; break;
		case "*":
			result = n1 * n2; break;
		case "/":
			result = n1 / n2; break;
		}
		
		response.setContentType("text/html;charset=utf-8");
//		resp : response 정보(서버가 클라이언트에게 응답해주기 위해서 필요하다)
		
		PrintWriter out = response.getWriter();
		
//		req : request 정보(클라이언트로 부터 받아온 정보가 있다)
		System.out.println(request.getRequestURI());
		
		out.append("<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<title>계산기</title>"
				+ "</head>"
				+ "<body>")
		.append("<h2>hello!</h2><hr>")
		.append("계산 결과 : " + result)
		.append("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
