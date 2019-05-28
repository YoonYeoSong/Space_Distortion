package com.space_distortion.model.vo;

//룸에 대한 가격정보 
public class Payment implements PaymentCalable{
	
	private int toTalPrice; // 총가격
	private int drinkPrice; // 음료가격
	private int roomPrice; // 인원대비 방가격
	private double meberDiscount = 0.1; // 회원에 대한 할인 퍼센트
	private int kindOfAccount; // 결재 방법 1 카드 0 현금
	private boolean drinkIsTrue = false; // 음료 사용 유무
	private final int TIME_PAY = 1000; // 시간당 가격 천원
	
	
	@Override
	public void cal() {
		// TODO Auto-generated method stub
		
	} 
	
	
}
