package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HealthDAO;
import DO.Member;

@WebServlet("/")
@MultipartConfig(maxFileSize=1024*1024*2, location="c:/Temp/img")
public class HealthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HealthDAO DAO;
	private ServletContext ctx;
	
	
    public HealthController() {
        super();
    }
    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAO = new HealthDAO();
    	ctx = getServletContext();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath(); // 경로를 가져온다.
		String site = null;
		
		//현재경로 
				System.out.println("command : " + command);
				
		
		switch (command) {
		case "/list": site = getList(request) ; break; 
		}
		
	
		 //forward
			ctx.getRequestDispatcher("/" + site)
			.forward(request, response);
		
		
	}
	
	public String getList(HttpServletRequest request) {
		ArrayList<Member> list;
		
		try {
			list= DAO.getList();
			request.setAttribute("memberList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main.jsp";
		
		
	}

    

}
