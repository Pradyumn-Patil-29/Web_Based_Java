package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDaoImpl newDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
		
			newDao = new UserDaoImpl();
		} catch (Exception e) {
			
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			
			newDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy of " + getClass() + " " + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try (PrintWriter pw = response.getWriter()) {
			
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
	
			User user = newDao.authenticateUser(email, pwd);
			if (user == null) 
				pw.print("<h4> Invalid Email or Password , Please <a href='login.html'>Retry</a></h4>");
			else {
				Cookie c1=new Cookie("user-details",user.toString());  
				response.addCookie(c1);
				pw.print("<h4> Validated User details " + user + "</h4>");
		
				if (user.getRole().equals("admin")) {
	
					response.sendRedirect("admin_page");
				} else 
				if (user.isVotingStatus()) {
				
					response.sendRedirect("logout");
				} else {
					response.sendRedirect("candidate_list");
				
				}

			}

		} 
		catch (Exception e) {
	
			throw new ServletException("err in do-get " + getClass(), e);
		}
	}

}
