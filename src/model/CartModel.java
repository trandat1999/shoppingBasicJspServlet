package model;

import java.util.Date;

public class CartModel {
	private long id;
	private Date created;
	private long userID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public CartModel(long id, Date created, long userID) {
		super();
		this.id = id;
		this.created = created;
		this.userID = userID;
	}

	public CartModel(Date created, long userID) {
		super();
		this.created = created;
		this.userID = userID;
	}

	

}
