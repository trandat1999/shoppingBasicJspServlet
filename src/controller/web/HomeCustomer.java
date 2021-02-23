package controller.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implement.BookDAO;
import dao.implement.CartDAO;
import dao.implement.CustomerDAO;
import dao.implement.OrderDAO;
import dao.implement.PaymentDAO;
import dao.implement.ShipDAO;
import dao.implement.SoldbookDAO;
import model.BookModel;
import model.CartModel;
import model.CustomerModel;
import model.OrderModel;
import model.PaymentModel;
import model.ShipModel;
import model.SoldbookModel;
import model.UserModel;

@WebServlet(urlPatterns = { "/HomeCustomer", "/cart", "/Homecart", "/order", "/payment" })
public class HomeCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bookDAO = new BookDAO();
	OrderDAO orderDAO = new OrderDAO();
	CartDAO cartDAO = new CartDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	PaymentDAO paymentDAO= new PaymentDAO();
	SoldbookDAO soldBookDAO= new SoldbookDAO();
	ShipDAO shipDAO= new ShipDAO();
	List<BookModel> listbook;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/HomeCustomer":
				Homecustomer(request, response);
				break;
			case "/cart":
				cart(request, response);
				break;
			case "/Homecart":
				Homecart(request, response);
				break;
			case "/order":
				order(request, response);
				break;
			case "/payment":
				payment(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void payment(HttpServletRequest request, HttpServletResponse response)  throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Date date = new Date();
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		float total = (float) session.getAttribute("total");
		// insert soldbook.
		List<SoldbookModel> listSoldbook = new ArrayList<>();
		HashMap<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");

		HashMap<BookModel, Integer> order = (HashMap<BookModel, Integer>) session.getAttribute("order");
		List<CustomerModel> list = customerDAO.findByUserID(user.getId());
		CartModel cartmodel = new CartModel(date, user.getId());
		cartDAO.insert(cartmodel);
		String details=request.getParameter("details");
		String paymethod=request.getParameter("paymethod");
		PaymentModel payment= new PaymentModel(date, details, paymethod);
		paymentDAO.insert(payment);
		ShipModel ship= new ShipModel("Đang lên đơn hàng", date, list.get(0).getAddressID());
		shipDAO.insert(ship);
		
		OrderModel orderModel = new OrderModel(total, date, user.getId(), ship.getId(),cartmodel.getId(),payment.getId());
		orderDAO.insert(orderModel);
		for (long id : cart.keySet()) {
			SoldbookModel soldBook = new SoldbookModel(id, cart.get(id), bookDAO.findBookById(id).get(0).getPrice(),
					user.getId(), orderModel.getId(), cartmodel.getId());
			listSoldbook.add(soldBook);
		}
		
		for(SoldbookModel bookSold: listSoldbook) {
			soldBookDAO.insert(bookSold);
		}
		order.clear();
		session.setAttribute("listSoldBook", listSoldbook);
		session.removeValue("order");
		session.removeValue("cart");
		response.sendRedirect("./HomeCustomer");
		
	}

	private void order(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		Date date = new Date();
//		HttpSession session = request.getSession();
//		UserModel user = (UserModel) session.getAttribute("user");
//		float total = (float) session.getAttribute("total");
//		// insert soldbook.
//		List<SoldbookModel> listSoldbook = new ArrayList<>();
//		HashMap<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
//
//		HashMap<BookModel, Integer> order = (HashMap<BookModel, Integer>) session.getAttribute("order");
//		List<CustomerModel> list = customerDAO.findByUserID(user.getId());
//		OrderModel orderModel = new OrderModel(total, date, user.getId(), list.get(0).getAddressID());
//		CartModel cartmodel = new CartModel(date, user.getId());
//		orderDAO.insert(orderModel);
//		cartDAO.insert(cartmodel);
//
//		for (long id : cart.keySet()) {
//			SoldbookModel soldBook = new SoldbookModel(id, cart.get(id), bookDAO.findBookById(id).get(0).getPrice(),
//					user.getId(), orderModel.getId(), cartmodel.getId());
//			listSoldbook.add(soldBook);
//		}
//		order.clear();
//		session.setAttribute("listSoldBook", listSoldbook);
//		session.removeAttribute("order");
//		session.removeAttribute("cart");
		//response.sendRedirect("./HomeCustomer");
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/customer/payment.jsp");
		rd.forward(request, response);
	}

	private void Homecart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		long id = Long.parseLong(request.getParameter("id"));
		UserModel user = (UserModel) session.getAttribute("user");
		HashMap<Long, Integer> attribute = (HashMap<Long, Integer>) session.getAttribute("cart");
		HashMap<Long, Integer> cart = attribute;
		if (cart == null) {
			cart = new HashMap<>();
		}
		if (cart.get(id) == null) {
			cart.put(id, 1);
		} else {
			cart.put(id, cart.get(id) + 1);
		}

		session.setAttribute("cart", cart);
		session.setAttribute("user", user);
		response.sendRedirect("./HomeCustomer");
	}

	private void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		HashMap<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<>();
		}
		HashMap<BookModel, Integer> order = new HashMap<>();
		float total = 0;
		for (long id : cart.keySet()) {
			SoldbookModel soldBook = new SoldbookModel();
			order.put(bookDAO.findBookById(id).get(0), cart.get(id));
			total += bookDAO.findBookById(id).get(0).getPrice() * cart.get(id);
		}

		session.setAttribute("user", user);
		session.setAttribute("total", total);
		session.setAttribute("order", order);
//		List<BookModel> list= (List<BookModel>) session.getAttribute("list");
//		session.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/customer/cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void Homecustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user2");
		String bookname = request.getParameter("name");
		String category = request.getParameter("category");

		if (bookname == null && category == null) {
			listbook = bookDAO.findAll();
		}
		if (bookname != null && category == null) {
			listbook = bookDAO.findBookByName(bookname);
		}
		if (bookname == null && category != null) {
			listbook = bookDAO.findBookByCategory(category);
		}
		List<String> listCategory = bookDAO.findAllCategory();
		request.setAttribute("category", listCategory);
		request.setAttribute("listbook", listbook);
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/customer/HomeCustomer.jsp");
		rd.forward(request, response);
	}

}
