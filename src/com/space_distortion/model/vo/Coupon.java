package com.space_distortion.model.vo;

import java.util.Objects;

public class Coupon {

	private String userCode;
	private String coupontNumber;
	
	
	public Coupon() {
		
	}

	public Coupon(String coupontNumber) {
		super();		
		this.coupontNumber = coupontNumber;
	}
	
	public Coupon(String userCode, String coupontNumber) {
		super();
		this.userCode = userCode;
		this.coupontNumber = coupontNumber;
	}



	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCoupontNumber() {
		return coupontNumber;
	}

	public void setCoupontNumber(String coupontNumber) {
		this.coupontNumber = coupontNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coupon c;
		if(obj instanceof Coupon)
		{
			c = (Coupon)obj;
			if(coupontNumber.equals(c.getCoupontNumber()))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Coupon [userCode=" + userCode + ", coupontNumber=" + coupontNumber + "]";
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(coupontNumber);
	}	
}
