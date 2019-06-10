package com.space_distortion.model.vo;

import java.util.Date;

public class Reservation {

	private String memberNo;
	private boolean canReserv;
	private Date Date; 
	
	
	public Reservation () {}

	public Reservation(String memberNo, boolean canReserv, java.util.Date date) {
		super();
		this.memberNo = memberNo;
		this.canReserv = canReserv;
		Date = date;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public boolean isCanReserv() {
		return canReserv;
	}

	public void setCanReserv(boolean canReserv) {
		this.canReserv = canReserv;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}
	
	
	
}