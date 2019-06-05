package com.space_distortion.model.vo;

import java.awt.event.MouseListener;

//�뿡 ���� �������� 
public class Payment {
	
	// �ӽ� ���ȣ
	private int room = 0;
	// ������ ���� ���� ����
	private String user = "member";
	// �ð��� ������ 3000���� ����
	private int hourlyCost = 3000;
	// ������ �ð��� Ŭ���Ҷ� ���ϴ� ����
	private int hour = 1;
	// ������ �ο����� �Է��Ҵ� ���ϴ� ����
	private int ppl = 1;
	// ȸ���� ������ �Ҷ� 30% ��ī��Ʈ�� �ֱ� ���ؼ� total ���ݿ��� ���ϱ� 70% �ҷ��� ���� ����
	private double discountRate = 0.7;
	// ȭ��Ʈ���� �̿밡��(���߿� if ������ �ٲ���)
	private int whiteBoardCost = 0;
	// ��������Ʈ �̿밡��(���߿� if ������ �ٲ���)
	private int beamProjectorCost = 0;
	// ��Ʈ�� �Ѵ�� ������ ������ 3000������ ���ص�
	private int laptopCost = 3000;
	// ������ ��Ʈ���� �󸶳� ��Ʈ���� �˷��ִ� ����
	private int laptop = 0;
	// ���� �ð��� �ð� ������ ���� ��
	private int totalHourlyCost;
	// ���� ��Ʈ�� ����
	private int totalLaptopCost = laptop*laptopCost;
	// �� �ݾ�
	private int totalCost = 0;
	// ��ī��Ʈ ���� ���̳� �ݾ�
	private int finalCost = 0;
	// white board usage (2�� ������� �ʴ´�, 1�� ����Ѵ� ��� ��)
	private int whiteBoardUsage=2;
	// Beam projector Usage (2�� ������� �ʴ´�, 1�� ����Ѵ� ��� ��)
	private int beamProjectorUsage = 2;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int room, String user, int hourlyCost, int hour, int ppl, double discountRate, int whiteBoardCost,
			int beamProjectorCost, int laptopCost, int laptop, int totalHourlyCost, int totalLaptopCost, int totalCost,
			int finalCost, int whiteBoardUsage, int beamProjectorUsage) {
		this.room = room;
		this.user = user;
		this.hourlyCost = hourlyCost;
		this.hour = hour;
		this.ppl = ppl;
		this.discountRate = discountRate;
		this.whiteBoardCost = whiteBoardCost;
		this.beamProjectorCost = beamProjectorCost;
		this.laptopCost = laptopCost;
		this.laptop = laptop;
		this.totalHourlyCost = totalHourlyCost;
		this.totalLaptopCost = totalLaptopCost;
		this.totalCost = totalCost;
		this.finalCost = finalCost;
		this.whiteBoardUsage = whiteBoardUsage;
		this.beamProjectorUsage = beamProjectorUsage;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
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

	public int getWhiteBoardUsage() {
		return whiteBoardUsage;
	}

	public void setWhiteBoardUsage(int whiteBoardUsage) {
		this.whiteBoardUsage = whiteBoardUsage;
	}

	public int getBeamProjectorUsage() {
		return beamProjectorUsage;
	}

	public void setBeamProjectorUsage(int beamProjectorUsage) {
		this.beamProjectorUsage = beamProjectorUsage;
	}
	

	@Override
	public String toString() {
		setTotalCost((getHourlyCost()*getPpl())+
				getWhiteBoardCost()+getBeamProjectorCost()+
				getTotalLaptopCost());
		
		setFinalCost((int) (getTotalCost()*getDiscountRate()));
		
		return 
		"�ð�: "+getHourlyCost()+"�� X "+getHour()+"�ð� = "+getTotalHourlyCost()+"\n"
		+"�ο�: "+ getPpl()+"��"+ "\n"
		+"��Ʈ��: "+getLaptop()+" X "+getLaptopCost()+" = "+getTotalLaptopCost() + "\n"
		+"Total Cost: "+ getTotalCost()+ "\n"
		+"Final Cost: "+ getFinalCost();
		
	}


}