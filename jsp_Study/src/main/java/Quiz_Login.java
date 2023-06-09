

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz_Login
 */
@WebServlet("/Login")
public class Quiz_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quiz_Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		System.out.println(id);
		System.out.println(pw);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String s_id = "person";
		int s_pw = 1234;
		
		if(id.equals(s_id) && pw == s_pw) {
			out.append(id + " 님 반갑습니다."+"</body></html>");
		}else {
			out.append(" 로그인 실패 "+"</body></html>");
		}
		
		
		
		
		
//		해당 아이디와 비밀번호가 맞으면 ‘id 님 반갑습니다.’ 출력. 그렇지 않으면 ‘로그인 실패’ 출력
//		아이디: person, 비밀번호: 1234

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
