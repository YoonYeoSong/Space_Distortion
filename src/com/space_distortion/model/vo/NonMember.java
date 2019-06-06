package com.space_distortion.model.vo;


// 비회원 클래스
public class NonMember extends User {

	private String nMemberName;
	private String phoneNumber;
	
	
	public NonMember() {
		super();
			
	}

	public NonMember(String nMemberName, String phoneNumber) {
		super(nCodeNumber++);		
		this.nMemberName = nMemberName;
		this.phoneNumber = phoneNumber;
	}

	public String getnMemberName() {
		return nMemberName;
	}

	public void setnMemberName(String nMemberName) {
		this.nMemberName = nMemberName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "NonMember [nMemberName=" + nMemberName + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
