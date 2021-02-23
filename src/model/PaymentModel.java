package model;

import java.util.Date;

public class PaymentModel {
	private long id;
	private Date paid;
	private String details;
	private String paymethod;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPaid() {
		return paid;
	}

	public void setPaid(Date paid) {
		this.paid = paid;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public PaymentModel(long id, Date paid, String details, String paymethod) {
		super();
		this.id = id;
		this.paid = paid;
		this.details = details;
		this.paymethod = paymethod;
	}

	public PaymentModel(Date paid, String details, String paymethod) {
		super();
		this.paid = paid;
		this.details = details;
		this.paymethod = paymethod;
	}

	

}
