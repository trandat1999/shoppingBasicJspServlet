package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implement.BookDAO;
import dao.implement.UserDAO;
import model.BookModel;
import model.UserModel;

@WebServlet(urlPatterns = { "/admin-home", "/list-user", "/list-book", "/delete-user", "/delete-book", "/new-form-user",
		"/edit-form-user", "/update-user", "/insert-user", "/edit-form-book", "/new-form-book", "/update-book",
		"/insert-book" })

public class HomeControllerAdmin extends HttpServlet {

	private static final long serialVersionUID = 8396220305765629106L;
	private UserDAO userDAO = new UserDAO();
	private BookDAO bookDAO = new BookDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			default:
				HomeAdmin(request, response);
				break;
			case "/delete-user":
				deleteUser(request, response);
				break;
			case "/delete-book":
				deleteBook(request, response);
				break;
			case "/list-user":
				listUser(request, response);
				break;
			case "/list-book":
				listBook(request, response);
				break;
			case "/edit-form-user":
				showEditForm(request, response);
				break;
			case "/new-form-user":
				showNewForm(request, response);
				break;
			case "/update-user":
				updateUser(request, response);
				break;
			case "/insert-user":
				insertUser(request, response);
				break;
			case "/edit-form-book":
				showEditFormBook(request, response);
				break;
			case "/new-form-book":
				showNewFormBook(request, response);
				break;
			case "/update-book":
				updateBook(request, response);
				break;
			case "/insert-book":
				insertBook(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserModel user = new UserModel(request.getParameter("username"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("position"));
		if (userDAO.insert(user)) {
			response.sendRedirect("./list-user");
		} else {
			response.sendRedirect("./new-form-user");
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		BookModel book = new BookModel(Long.parseLong(request.getParameter("id")), request.getParameter("name"),
				request.getParameter("category"), request.getParameter("author"),
				Float.parseFloat(request.getParameter("price")));
		if (bookDAO.update(book) == true) {
			response.sendRedirect("./list-book");
		} else {
			response.sendRedirect("./new-form-book");
		}

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		BookModel book = new BookModel(request.getParameter("name"), request.getParameter("category"),
				request.getParameter("author"), Float.parseFloat(request.getParameter("price")));
		if (bookDAO.insert(book) == true) {
			response.sendRedirect("./list-book");
		} else {
			response.sendRedirect("./new-form-book");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewFormBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/edit-or-insert-book.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		BookModel book = bookDAO.findBookById(id).get(0);
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/edit-or-insert-book.jsp");
		dispatcher.forward(request, response);
	}

	private void HomeAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<UserModel> listUser = userDAO.findAll();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/home.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		userDAO.delele(id);
		response.sendRedirect("./list-user");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		bookDAO.delete(id);
		response.sendRedirect("./list-book");
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<UserModel> listUser = userDAO.findAll();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/listUser.jsp");
		dispatcher.forward(request, response);
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BookModel> listBook = bookDAO.findAll();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/listBook.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		UserModel user = userDAO.findUserById(id).get(0);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/edit-or-insert-user.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/edit-or-insert-user.jsp");
		dispatcher.forward(request, response);
	}

}
