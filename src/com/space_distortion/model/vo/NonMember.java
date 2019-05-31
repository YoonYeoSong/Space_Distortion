package com.space_distortion.model.vo;


// 비회원 클래스
public class NonMember extends User {

	public NonMember() {
		super();
		
		
	}

	public NonMember(int userCode) {
		super(nCodeNumber++);		
	}
	
}
