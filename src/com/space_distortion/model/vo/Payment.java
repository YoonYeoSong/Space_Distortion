package com.space_distortion.model.vo;

import java.awt.event.MouseListener;

//룸에 대한 가격정보 
public class Payment {
	
	//임시방번호
	private int usedRoomNumber;
	// 임으로 만든 유저 더미
	private String user = "member";
	// 시간당 가격은 3000원을 지정
	private int hourlyCost = 3000;
	// 유저가 시간을 클릭할때 변하는 변수
	private int hour = 0;
	// 유저가 인원수를 입력할대 변하는 변수
	private int ppl = 0;
	// 회원이 결제를 할때 30% 디스카운트를 주기 위해서 total 가격에서 곱하기 70% 할려고 만든 변수
	private double discountRate = 0.7;
	// 화이트 보드와 빔프로젝터를 쓰는지 안 쓰는지 유/무로 표현하기 위한 변수
	private boolean whiteBoard, beamProjector;
	// 화이트보드 이용가격(나중에 if 문에서 바꿔줌)
	private int whiteBoardCost = 0;
	// 빔프로젝트 이용가격(나중에 if 문에서 바꿔줌)
	private int beamProjectorCost = 0;
	// 노트북 한대당 빌리는 가격을 3000원으로 정해둠
	private int laptopCost = 3000;
	// 유저가 노트북을 얼마나 렌트할지 알려주는 변수
	private int laptop = 0;
	// 최종 시간과 시간 가격을 곱한 값
	private int totalHourlyCost = hour*hourlyCost;
	// 최종 노트북 가격
	private int totalLaptopCost = laptop*laptopCost;
	// 총 금액
	private int totalCost = 0;
	// 디스카운트 이후 파이널 금액
	private int finalCost = 0;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(String user, int hourlyCost, int hour, int ppl, double discountRate, boolean whiteBoard,
			boolean beamProjector, int whiteBoardCost, int beamProjectorCost, int laptopCost, int laptop,
			int totalHourlyCost, int totalLaptopCost, int totalCost, int finalCost) {
		this.user = user;
		this.hourlyCost = hourlyCost;
		this.hour = hour;
		this.ppl = ppl;
		this.discountRate = discountRate;
		this.whiteBoard = whiteBoard;
		this.beamProjector = beamProjector;
		this.whiteBoardCost = whiteBoardCost;
		this.beamProjectorCost = beamProjectorCost;
		this.laptopCost = laptopCost;
		this.laptop = laptop;
		this.totalHourlyCost = totalHourlyCost;
		this.totalLaptopCost = totalLaptopCost;
		this.totalCost = totalCost;
		this.finalCost = finalCost;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getHourlyCost() {
		return hourlyCost;
	}

	public void setHourlyCost(int hourlyCost) {
		this.hourlyCost = hourlyCost;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getPpl() {
		return ppl;
	}

	public void setPpl(int ppl) {
		this.ppl = ppl;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public boolean isWhiteBoard() {
		return whiteBoard;
	}

	public void setWhiteBoard(boolean whiteBoard) {
		this.whiteBoard = whiteBoard;
	}

	public boolean isBeamProjector() {
		return beamProjector;
	}

	public void setBeamProjector(boolean beamProjector) {
		this.beamProjector = beamProjector;
	}

	public int getWhiteBoardCost() {
		return whiteBoardCost;
	}

	public void setWhiteBoardCost(int whiteBoardCost) {
		this.whiteBoardCost = whiteBoardCost;
	}

	public int getBeamProjectorCost() {
		return beamProjectorCost;
	}

	public void setBeamProjectorCost(int beamProjectorCost) {
		this.beamProjectorCost = beamProjectorCost;
	}

	public int getLaptopCost() {
		return laptopCost;
	}

	public void setLaptopCost(int laptopCost) {
		this.laptopCost = laptopCost;
	}

	public int getLaptop() {
		return laptop;
	}

	public void setLaptop(int laptop) {
		this.laptop = laptop;
	}

	public int getTotalHourlyCost() {
		return totalHourlyCost;
	}

	public void setTotalHourlyCost(int totalHourlyCost) {
		this.totalHourlyCost = totalHourlyCost;
	}

	public int getTotalLaptopCost() {
		return totalLaptopCost;
	}

	public void setTotalLaptopCost(int totalLaptopCost) {
		this.totalLaptopCost = totalLaptopCost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(int finalCost) {
		this.finalCost = finalCost;
	}

	@Override
	public String toString() {
		setTotalCost((getHourlyCost()*getPpl())+
				getWhiteBoardCost()+getBeamProjectorCost()+
				getTotalLaptopCost());
		
		setFinalCost((int) (getTotalCost()*getDiscountRate()));
		
		return 
		"시간: "+getHourlyCost()+"원 X "+getHour()+"시간 = "+getTotalHourlyCost()+"\n"
		+"인원: "+ getPpl()+"명"+ "\n"
		+isWhiteBoard()+ "\n"
		+isBeamProjector()+ "\n"
		+"노트북: "+getLaptop()+" X "+getLaptopCost()+" = "+getTotalLaptopCost() + "\n"
		+"Total Cost: "+ getTotalCost()+ "\n"
		+"Final Cost: "+ getFinalCost();
	}

}
