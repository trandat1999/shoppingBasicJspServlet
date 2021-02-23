package model;

public class SoldbookModel {
	private long id;
	private long bookID;
	private int quantity;
	private float price;
	private long userID;
	private long orderID;
	private long cartID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookID() {
		return bookID;
	}

	public void setBookID(long bookID) {
		this.bookID = bookID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public SoldbookModel(long id, long bookID, int quantity, float price, long userID, long orderID, long cartID) {
		super();
		this.id = id;
		this.bookID = bookID;
		this.quantity = quantity;
		this.price = price;
		this.userID = userID;
		this.orderID = orderID;
		this.cartID = cartID;
	}

	public SoldbookModel(long bookID, int quantity, float price, long userID, long orderID, long cartID) {
		super();
		this.bookID = bookID;
		this.quantity = quantity;
		this.price = price;
		this.userID = userID;
		this.orderID = orderID;
		this.cartID = cartID;
	}

	public SoldbookModel() {
		super();
	}

	

}
