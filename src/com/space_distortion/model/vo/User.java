package com.space_distortion.model.vo;

// Member와 NonMember의 부모 클래스(super)
public class User {
	protected static int mCodeNumber = 0;
	protected static int nCodeNumber = 0;
	private int userCode;
	
public User() {

}


public User(int userCode) {
	super();
	this.userCode = userCode;
}



public static int getmCodeNumber() {
	return mCodeNumber;
}


public static void setmCodeNumber(int mCodeNumber) {
	User.mCodeNumber = mCodeNumber;
}


public static int getnCodeNumber() {
	return nCodeNumber;
}


public static void setnCodeNumber(int nCodeNumber) {
	User.nCodeNumber = nCodeNumber;
}


public int getUserCode() {
	return userCode;
}

public void setUserCode(int userCode) {
	this.userCode = userCode;
}

}