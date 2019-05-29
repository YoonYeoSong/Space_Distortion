package com.space_distortion.model.vo;

//ȸ�� Ŭ����
public class Member extends User {

	private String memberName; //ȸ�� �̸�
	private String memberPw; // ��й�ȣ
	private String emailId; // �̸��Ͼ��̵�
	private String address; // �ּ� 
	private String phoneNumber; /// �ڵ��� ��ȣ
	private String birthDay; // �������
	private int studentIsTrue;  // 0 false 1 true
	
	public Member() {
		super();
		mCodeNumber++;
		setmCodeNumber(mCodeNumber);
	}

	public Member(String memberName, String memberPw, String emailId, String address, String phoneNumber,
			String birthDay, int studentIsTrue) {
		super();
		this.memberName = memberName;
		this.memberPw = memberPw;
		this.emailId = emailId;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
		this.studentIsTrue = studentIsTrue;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getStudentIsTrue() {
		return studentIsTrue;
	}

	public void setStudentIsTrue(int studentIsTrue) {
		this.studentIsTrue = studentIsTrue;
	}
	
	
	
	
}