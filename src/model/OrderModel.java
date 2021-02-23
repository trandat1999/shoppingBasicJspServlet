package model;

import java.util.Date;

public class OrderModel {
	private long id;
	private float total;
	private Date orderDate;
	private long userID;
	private long shipID;
	private long cartID;
	private long payID;

	public long getPayID() {
		return payID;
	}

	public void setPayID(long payID) {
		this.payID = payID;
	}

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getShipID() {
		return shipID;
	}

	public void setShipID(long shipID) {
		this.shipID = shipID;
	}

	public OrderModel(long id, float total, Date orderDate, long userID, long shipID, long cartID, long pyID) {
		super();
		this.id = id;
		this.total = total;
		this.orderDate = orderDate;
		this.userID = userID;
		this.shipID = shipID;
		this.cartID = cartID;
		this.payID = pyID;
	}

	public OrderModel(float total, Date orderDate, long userID, long shipID, long cartID, long payID) {
		super();
		this.total = total;
		this.orderDate = orderDate;
		this.userID = userID;
		this.shipID = shipID;
		this.cartID = cartID;
		this.payID = payID;
	}

}
