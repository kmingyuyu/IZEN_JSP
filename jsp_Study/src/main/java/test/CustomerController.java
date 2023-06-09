package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/customerControl")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	CustomerDAO DAO;
       
	
    public CustomerController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	DAO = new CustomerDAO();
    	
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext()
			.getRequestDispatcher("/customerControl?action=list")
			.forward(req, resp);
		}
		
		else {
			switch (action) {
			case "list": view = list(req , resp); break;
			case "insert": view = insert(req , resp); break;
			}
			getServletContext()
			.getRequestDispatcher("/test/" + view)
			.forward(req, resp);
		}
		
		
		
	}

    
    public String list(HttpServletRequest req, HttpServletResponse resp) {
    	req.setAttribute("qs", DAO.getAll());
    	return "customerList.jsp";
    }
    
    
    
    public String insert(HttpServletRequest req, HttpServletResponse resp) {
    	
    	Customer r = new Customer();
    	
    	try {
			BeanUtils.populate(r, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	
    	
    	DAO.insert(r);
    	
    	return "customerList.jsp";
    }
    
    

}
