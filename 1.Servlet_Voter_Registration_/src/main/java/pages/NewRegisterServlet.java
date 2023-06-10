package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class NewRegisterServlet
 */
@WebServlet(value="/AddNewUser",loadOnStartup=1)
public class NewRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDaoImpl userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		try {
			userDao=new UserDaoImpl();
			
		} catch (SQLException e) {
			
			throw new ServletException("error in init"+getClass(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	     
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			
			System.out.println("err in destroy of " + getClass() + " " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			//int id=request.getParameter("id");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String Email=request.getParameter("Email");
			String Password=request.getParameter("pass");
			String dob=request.getParameter("dob");
			//Boolean voterstatus=request.getParameter("voterstatus");
			//String role=request.getParameter("role");
			
			userDao.RegisterNewVoter(firstName, lastName, Email, Password, dob);
			System.out.println("in registeServelet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
