package com.shop.model;

import java.util.Date;

public class NikonPayVO {
	private int payno;
	private String paycom;
	private Date paydate;
	private String payname;
	private int payprice;
	
	public int getPayno() {
		return payno;
	}
	public void setPayno(int payno) {
		this.payno = payno;
	}
	public String getPaycom() {
		return paycom;
	}
	public void setPaycom(String paycom) {
		this.paycom = paycom;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	public String getPayname() {
		return payname;
	}
	public void setPayname(String payname) {
		this.payname = payname;
	}
	public int getPayprice() {
		return payprice;
	}
	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}

}
