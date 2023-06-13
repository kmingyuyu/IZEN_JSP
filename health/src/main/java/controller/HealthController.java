package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

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
		case "/main": site = getList(request) ; break; //메인페이지
		case "/info": site = getInfo(request);	break; //회원 상세페이지
		case "/registration": site ="registration.jsp";  break; //회원 등록페이지
		case "/insert": site = registration(request);	break; //글 등록
		case "/edit": site = memberEdit(request);	break; //글 등록
		
		}
		
		if(site.startsWith("redirect:/")) { //redirect
//			redirect 경로만 짤라온다
			String rview = site.substring("redirect:/".length());
			System.out.println(rview);
			
			response.sendRedirect(rview); //페이지 이동
		}
		else { //forward
			ctx.getRequestDispatcher("/" + site)
			.forward(request, response);
		}
		
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
	
	
	public String getInfo(HttpServletRequest request) {
		int member_no = Integer.parseInt(request.getParameter("member_no"));
		
		try {
			Member m = DAO.getView(member_no);
			request.setAttribute("member", m);
		} catch (Exception e) {
		}
		
		
		return "info.jsp";
	}
	
	
	public String registration(HttpServletRequest request) {
		Member m = new Member();
		try {
			BeanUtils.populate(m, request.getParameterMap());
//			1.이미지 파일 자체를 서버 컴퓨터에 저장
			Part part = request.getPart("file");
			String fileName = getFilename(part);
			
			if(fileName != null && !fileName.isEmpty()) {
				part.write(fileName); //파일을 컴퓨터에 저장한다.
			}
					
			m.setMember_img("/img/" + fileName);
			
			DAO.registration(m);
			
		} catch (Exception e) {
		}
		
		return "redirect:/main";
		
	}
	
	public String memberEdit(HttpServletRequest request) {
		int member_no = Integer.parseInt(request.getParameter("member_no"));
		try {
			Member m = DAO.get
		} catch (Exception e) {
		}
		
		
		
		return "edit.jsp";
	}
	
	
	
	

	private String getFilename(Part part) {
		String fileName = null;
		String header = part.getHeader("content-disposition");
		
		System.out.println("header -> " + header);
		
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10 , header.length() -1 );
		
		System.out.println("파일명 -> " + fileName);
		
		return fileName;
	}

}
