package com.space_distortion.model.vo;


// ��ȸ�� Ŭ����
public class NonMember extends User {

	public NonMember() {
		super();
		nCodeNumber++;
		setnCodeNumber(nCodeNumber);
		
	}

	public NonMember(int userCode) {
		super(userCode);
		
	}
	
}
