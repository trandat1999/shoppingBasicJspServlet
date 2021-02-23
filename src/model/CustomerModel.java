package model;

public class CustomerModel {
	private long id;
	private String name;
	private long userID;
	private long addressID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getAddressID() {
		return addressID;
	}

	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}

	public CustomerModel(long id, String name, long userID, long addressID) {
		super();
		this.id = id;
		this.name = name;
		this.userID = userID;
		this.addressID = addressID;
	}

	public CustomerModel(String name, long userID, long addressID) {
		super();
		this.name = name;
		this.userID = userID;
		this.addressID = addressID;
	}

	

	

}
