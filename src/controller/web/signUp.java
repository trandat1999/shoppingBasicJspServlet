package controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implement.AddressDAO;
import dao.implement.CustomerDAO;
import dao.implement.UserDAO;
import model.AddressModel;
import model.CustomerModel;
import model.UserModel;

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
	private AddressDAO addressDAO= new AddressDAO();
	private CustomerDAO customerDAo= new CustomerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/views/SignUp.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		/*
		 * if (!request.getParameter("name").equals("") ||
		 * !request.getParameter("pass").equals("") ||
		 * !request.getParameter("email").equals("") ||
		 * !request.getParameter("re_pass").equals("")) {
		 * response.sendRedirect("signUp"); }else
		 * if(request.getParameter("pass").equals(request.getParameter("re_pass"))){
		 * //send err pass==re-pass doGet(request,response);
		 * 
		 * }else {
		 */
		UserModel user = new UserModel();

		user.setUsername(request.getParameter("name"));
		user.setPassword(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		user.setPosition(request.getParameter("position"));
		if (userDAO.insert(user)) {
			AddressModel address = new AddressModel(request.getParameter("country"), request.getParameter("city"),
					request.getParameter("streets"));
			addressDAO.insert(address);
			CustomerModel customer = new CustomerModel(request.getParameter("fullname"), user.getId(), address.getId());
			customerDAo.insert(customer);
			response.sendRedirect("login");
			
		} else {
			doGet(request, response);
		}

	}

}
