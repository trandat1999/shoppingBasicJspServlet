package model;

public class AddressModel {
	private long id;
	private String country;
	private String city;
	private String streets;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreets() {
		return streets;
	}

	public void setStreets(String streets) {
		this.streets = streets;
	}

	public AddressModel(long id, String country, String city, String streets) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.streets = streets;
	}

	public AddressModel(String country, String city, String streets) {
		super();
		this.country = country;
		this.city = city;
		this.streets = streets;
	}

}
