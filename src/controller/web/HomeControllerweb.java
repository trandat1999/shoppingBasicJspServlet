package controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implement.UserDAO;
import model.UserModel;

@WebServlet(urlPatterns = { "/login" })
public class HomeControllerweb extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	
	private UserDAO userDAO= new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/views/Login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel userModel= new UserModel();
		userModel.setUsername(request.getParameter("your_name"));
		userModel.setPassword(request.getParameter("your_pass"));
		boolean result= userDAO.checkLogin(userModel);
		if(result) {
			if(userModel.getPosition().equals("manager")) {
				HttpSession session= request.getSession(false);
				session.setAttribute("user1", userModel);
				response.sendRedirect("admin-home");
			}else {
				HttpSession session= request.getSession(false);
				
				session.setAttribute("user2", userModel);
				response.sendRedirect("HomeCustomer");
			}
		}else {
			String err = "Wrong pass";
			request.setAttribute("err", err);
			doGet(request,response);
			
		}
		
	}

}
