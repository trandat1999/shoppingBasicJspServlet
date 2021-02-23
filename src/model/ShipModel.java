package model;

import java.util.Date;

public class ShipModel {
	private long id;
	private String details;
	private Date date;
	private long addressID;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getAddressID() {
		return addressID;
	}
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	public ShipModel(long id, String details, Date date, long addressID) {
		super();
		this.id = id;
		this.details = details;
		this.date = date;
		this.addressID = addressID;
	}
	public ShipModel(String details, Date date, long addressID) {
		super();
		this.details = details;
		this.date = date;
		this.addressID = addressID;
	}
	
}
