package com.techproed.pojos;

public class Bookingdate {
	private String checkin;
	private String checkout;
	public Bookingdate() {
				
			}	
			public Bookingdate(String checkin, String checkout) {
				this.checkin = checkin;
				this.checkout = checkout;
			}
					
			public String getCheckin() {
				return checkin;
			}
			public void setCheckin(String checkin) {
				this.checkin = checkin;
			}
			public String getCheckout() {
				return checkout;
			}
			public void setCheckout(String checkout) {
				this.checkout = checkout;
			}
			@Override
			public String toString() {
				return "Bookingdate [checkin=" + checkin + ", checkout=" + checkout + "]";
			}

}
