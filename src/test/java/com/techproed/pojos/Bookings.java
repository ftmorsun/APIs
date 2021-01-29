package com.techproed.pojos;

public class Bookings {
	private String firstname;
	private String lastname;
	private Integer totalprice;
	private Boolean depositpaid;
	private Bookingdate bookingdate;
	public Bookings() {
	}

	public Bookings(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Bookingdate bookingdate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdate = bookingdate;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public Boolean getDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public Bookingdate getBookingdate() {
		return bookingdate;
	}
	public void setBookingdates(Bookingdate bookingdate) {
		this.bookingdate = bookingdate;
	}
	@Override
	public String toString() {
		return "Bookings [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdate + "]";
	}


}
