package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Payment;



public class PaymentView extends SpaceActionEvent implements ViewIndex, ItemListener {

Color color = new Color(93, 188, 210); 
 SpaceController sc;
	
/**
 * @wbp.parser.entryPoint
 */
public PaymentView() {
	
}

	// Payment 와 Controller 객체는 생성하지 않았다. 이유는 Controller 에 객체를 생성
	//했기 때문이고 또 public View 에 매개변수로 넣어주었기 때문에 필요없다. fuck. 하나 배웠다
	
//	왼쪽 패널에 있는 모든 변수들
	 private JLabel timeLabel, pplLabel, beamProjectorLabel, whiteBoardLabel, laptopLabel
	, displayHourlyCost, displaySelectedHour, displaySelectedPpl, displaySelectedLaptop, displayLaptopRentalCost,
	displayWhiteboardUsage, displayBeamProjectorUsage, displayTotalCost, displayPriceAfterDiscount;
	 Integer[] numTable = {1,2,3,4,5,6,7,8,9,10};
	 Integer[] laptopTable = {0,1,2,3,4,5,6,7,8,9,10};
	 private JComboBox<Integer> timeComboBox;
	 private JComboBox<Integer> pplComboBox;
	 private JComboBox<Integer> laptopComboBox;
	 private JCheckBox whiteBoardCheckBox;
	 private JCheckBox beamProjectorCheckBox;
	 private JPanel panelLeft, panelRight;
	 private JButton registerButton, proceedButton;
	
//	오른쪽 패널에 있는 모든 변수들
	private Image img;
	private JLabel timeLabelr, pplLabelr, beamProjectorLabelr, whiteBoardLabelr, laptopLabelr
	, totalLabelr, memberDiscountLabelr, finalPrice;

	
	public void initialize(SpaceController controller, JFrame mainJframe){
		sc=controller;
		
//		========= 왼쪽 패널 생성==================================================
		panelLeft = new JPanel();
		panelLeft.setBounds(0,0,512,768);
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setVisible(true);
		panelLeft.setLayout(null);
		
//		========왼쪽 패널에 있는 레이블=========
		
		// 시간 레이블
		timeLabel = new JLabel("시간 ");
		timeLabel.setBounds(117, 118, 30, 16);
		timeLabel.setVisible(true);
		panelLeft.add(timeLabel);
		
		
		//인원 레이블
		pplLabel = new JLabel("인원 ");
		pplLabel.setBounds(117, 243, 30, 16);
		panelLeft.add(pplLabel);
		
		//빔 프로젝터 레이브
		beamProjectorLabel = new JLabel("빔프로젝터 ");
		beamProjectorLabel.setBounds(136, 584, 63, 16);
		panelLeft.add(beamProjectorLabel);
		 
		
		//화이트보드 레이블
		whiteBoardLabel =new JLabel("화이트보드 ");
		whiteBoardLabel.setBounds(288, 584, 63, 16);
		panelLeft.add(whiteBoardLabel);
		 
		
		//노트북레이블
		laptopLabel = new JLabel("노트북 ");
		laptopLabel.setBounds(117, 379, 41, 16);
		panelLeft.add(laptopLabel);
		
//		========왼쪽 패널에 있는 체크하는 기능들=========
		
		// 시간 콤보박스
		timeComboBox = new JComboBox<Integer>(numTable);
		timeComboBox.setBounds(117,145,277,54);
		panelLeft.add(timeComboBox);
		timeComboBox.addItemListener((ItemListener) this);
		
		//인원 콤보박스
		pplComboBox = new JComboBox<Integer>(numTable);
		pplComboBox.setBounds(117,270,277,54);
		panelLeft.add(pplComboBox);
		pplComboBox.addItemListener(this);
		
		//노트북 콤보박스
		laptopComboBox = new JComboBox<Integer>(laptopTable);
		laptopComboBox.setBounds(117,405, 277, 54);
		panelLeft.add(laptopComboBox);
		laptopComboBox.addItemListener(this);
		
		//빔프로젝터 사용유무 체크박스
		beamProjectorCheckBox = new JCheckBox();
		beamProjectorCheckBox.setBounds(150, 600, 24, 24);
		panelLeft.add(beamProjectorCheckBox);
		beamProjectorCheckBox.addItemListener(this);
		
		
		//화이트보드 사용유무 체크박스
		whiteBoardCheckBox = new JCheckBox();
		whiteBoardCheckBox.setBounds(300, 600, 24, 24);
		panelLeft.add(whiteBoardCheckBox);
		whiteBoardCheckBox.addItemListener(this);
		
		mainJframe.getContentPane().add(panelLeft);
		
//		========= 오른쪽 패널 생성==================================================
		
		img = new ImageIcon("ocean_background_halfsize.png").getImage();
		panelRight = new JPanel() {
			private Image pImg=img;
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(pImg,0,0,this);
			}
			
		};
		panelRight.setBounds(512,0,512,768);
		panelRight.setVisible(true);
		panelRight.setLayout(null);
	
		
		
		// 시간 레이블
		timeLabelr = new JLabel("시간 ");
		timeLabelr.setForeground(Color.GRAY);
		timeLabelr.setBounds(74, 95, 50, 30);
		timeLabelr.setVisible(true);
		panelRight.add(timeLabelr);
		
		// 시간당 가격을 보여주는 레이블(현재값은 3000원)

//		System.out.println(controller.getPm()); // 이걸 출력하게되면 toString 출력
		
		displayHourlyCost = new JLabel(""+sc.pm.getHourlyCost());
		displayHourlyCost.setForeground(Color.DARK_GRAY);
		displayHourlyCost.setBounds(385, 97, 50, 30);
		displayHourlyCost.setVisible(true);
		panelRight.add(displayHourlyCost);
		
		// 몇시간을 이용하는지 보여주는 레이블
		displaySelectedHour = new JLabel("1");
		displaySelectedHour.setForeground(Color.DARK_GRAY);
		displaySelectedHour.setBounds(405, 125, 50, 30);
		displaySelectedHour.setVisible(true);
		panelRight.add(displaySelectedHour);
		
		
		//인원 레이블
		pplLabelr = new JLabel("인원 ");
		pplLabelr.setForeground(Color.GRAY);
		pplLabelr.setBounds(74, 161, 50, 30);
		panelRight.add(pplLabelr);
		
		// 인원이 몇명인지 보여주는 레이블
		displaySelectedPpl = new JLabel("1");
		displaySelectedPpl.setForeground(Color.DARK_GRAY);
		displaySelectedPpl.setBounds(405, 163, 50, 30);
		displaySelectedPpl.setVisible(true);
		panelRight.add(displaySelectedPpl);
		
		
		//빔 프로젝터 레이브
		beamProjectorLabelr = new JLabel("빔프로젝터 대여");
		beamProjectorLabelr.setForeground(Color.GRAY);
		beamProjectorLabelr.setBounds(74, 215, 100, 30);
		panelRight.add(beamProjectorLabelr);
		
		// Displaying the usage of the bream projector
		displayBeamProjectorUsage = new JLabel("사용 안함");
		displayBeamProjectorUsage.setForeground(Color.DARK_GRAY);
		displayBeamProjectorUsage.setBounds(368, 217, 100, 30);
		displayBeamProjectorUsage.setVisible(true);
		panelRight.add(displayBeamProjectorUsage);
		
		//화이트보드 레이블
		whiteBoardLabelr =new JLabel("화이트보드 대여");
		whiteBoardLabelr.setForeground(Color.GRAY);
		whiteBoardLabelr.setBounds(74, 276, 100, 30);
		panelRight.add(whiteBoardLabelr);
		
		//Displaying usage of whiteboard
		displayWhiteboardUsage = new JLabel("사용 안함");
		displayWhiteboardUsage.setForeground(Color.DARK_GRAY);
		displayWhiteboardUsage.setBounds(368, 275, 100, 30);
		displayWhiteboardUsage.setVisible(true);
		panelRight.add(displayWhiteboardUsage);
		
		//노트북레이블
		laptopLabelr = new JLabel("노트북 ");
		laptopLabelr.setForeground(Color.GRAY);
		laptopLabelr.setBounds(74, 336, 50, 30);
		panelRight.add(laptopLabelr);
		
		//노트북을 몇개 빌리는지 보여주는 레이블
		displaySelectedLaptop = new JLabel("(X)");
		displaySelectedLaptop.setForeground(Color.DARK_GRAY);
		displaySelectedLaptop.setBounds(400, 360, 50, 30);
		displaySelectedLaptop.setVisible(true);
		panelRight.add(displaySelectedLaptop);
		
		// 노트북 개당 얼마인지 보여주는 레이블
		displayLaptopRentalCost = new JLabel(""+sc.pm.getLaptopCost());
		displayLaptopRentalCost.setForeground(Color.DARK_GRAY);
		displayLaptopRentalCost.setBounds(385, 336, 50, 30);
		displayLaptopRentalCost.setVisible(true);
		panelRight.add(displayLaptopRentalCost);
		
		
		// Total 레이블
		totalLabelr = new JLabel("Total");
		totalLabelr.setForeground(Color.GRAY);
		totalLabelr.setBounds(74, 400, 100, 30);
		panelRight.add(totalLabelr);
		
		// 디스카운트 퍼센테지 레이블
		memberDiscountLabelr = new JLabel("Member Discount");
		memberDiscountLabelr.setForeground(Color.GRAY);
		memberDiscountLabelr.setBounds(74, 446, 150, 30);
		panelRight.add(memberDiscountLabelr);
		
		// 디스카운트 적 가격을 보여주는 레이블
		setDisplayTotalCost(new JLabel(""+sc.pm.getTotalCost()));
		getDisplayTotalCost().setForeground(Color.DARK_GRAY);
		getDisplayTotalCost().setBounds(405, 400, 50, 30);
		getDisplayTotalCost().setVisible(true);
		panelRight.add(getDisplayTotalCost());
		
		// 최종 가격을 보여주는 레이블
		setDisplayPriceAfterDiscount(new JLabel(""+sc.pm.getFinalCost()));
		getDisplayPriceAfterDiscount().setForeground(Color.DARK_GRAY);
		getDisplayPriceAfterDiscount().setBounds(405, 500, 50, 30);
		getDisplayPriceAfterDiscount().setVisible(true);
		panelRight.add(getDisplayPriceAfterDiscount());
		
		// 최종금액 레이블
		finalPrice = new JLabel("Price After Discount");
		finalPrice.setForeground(Color.GRAY);
		finalPrice.setBounds(74, 493, 150, 30);
		panelRight.add(finalPrice);
		
		
		//Register Button
		registerButton = new JButton("Register");
		registerButton.setBounds(180, 550, 150, 60);
		registerButton.setBackground(color);
		panelRight.add(registerButton);
		
		
		proceedButton = new JButton("Proceed");
		proceedButton.setBounds(180, 650, 150, 60);
		panelRight.add(proceedButton);
		
		mainJframe.getContentPane().add(panelRight);
		mainJframe.setVisible(true);
		
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		
//		System.out.println(p);
		
		if(e.getSource() == timeComboBox) {
			System.out.println(timeComboBox.getSelectedItem());
		sc.pm.setHour((int)timeComboBox.getSelectedItem());
		
		int choice = (int) timeComboBox.getSelectedItem();
		switch(choice) {
		case 1 : displaySelectedHour.setText("1"); break;
		case 2 : displaySelectedHour.setText("2"); break;
		case 3 : displaySelectedHour.setText("3"); break;
		case 4 : displaySelectedHour.setText("4"); break;
		case 5 : displaySelectedHour.setText("5"); break;
		case 6 : displaySelectedHour.setText("6"); break;
		case 7 : displaySelectedHour.setText("7"); break;
		case 8 : displaySelectedHour.setText("8"); break;
		case 9 : displaySelectedHour.setText("9"); break;
		case 10 : displaySelectedHour.setText("10"); break;
		
		default : displaySelectedHour.setText("wrong"); break;
		}
		
		} else if(e.getSource() == pplComboBox) {
		sc.pm.setPpl((int) pplComboBox.getSelectedItem());
		int choice = (int) pplComboBox.getSelectedItem();
		switch(choice) {
		case 1 : displaySelectedPpl.setText("1"); break;
		case 2 : displaySelectedPpl.setText("2"); break;
		case 3 : displaySelectedPpl.setText("3"); break;
		case 4 : displaySelectedPpl.setText("4"); break;
		case 5 : displaySelectedPpl.setText("5"); break;
		case 6 : displaySelectedPpl.setText("6"); break;
		case 7 : displaySelectedPpl.setText("7"); break;
		case 8 : displaySelectedPpl.setText("8"); break;
		case 9 : displaySelectedPpl.setText("9"); break;
		case 10 : displaySelectedPpl.setText("10"); break;
		
		default : displaySelectedPpl.setText("wrong"); break;
		}
		
		} else if (e.getSource() == laptopComboBox) {
		sc.pm.setLaptop((int) laptopComboBox.getSelectedItem());
		int choice = (int) laptopComboBox.getSelectedItem();
		switch(choice){
		case 0 : displaySelectedLaptop.setText("(X)"); break;
		case 1 : displaySelectedLaptop.setText("1"); break;
		case 2 : displaySelectedLaptop.setText("2"); break;
		case 3 : displaySelectedLaptop.setText("3"); break;
		case 4 : displaySelectedLaptop.setText("4"); break;
		case 5 : displaySelectedLaptop.setText("5"); break;
		case 6 : displaySelectedLaptop.setText("6"); break;
		case 7 : displaySelectedLaptop.setText("7"); break;
		case 8 : displaySelectedLaptop.setText("8"); break;
		case 9 : displaySelectedLaptop.setText("9"); break;
		case 10 : displaySelectedLaptop.setText("10"); break;
		
		default : displaySelectedLaptop.setText("wrong"); break;
		
		} 
		}else if(e.getSource()==beamProjectorCheckBox) {
			sc.pm.setWhiteBoardUsage(e.getStateChange());
			int choice  = e.getStateChange();
			switch (choice) {
			case 1 : displayBeamProjectorUsage.setText("사용"); break;
			case 2 : displayBeamProjectorUsage.setText("사용 안함"); break;
			default : displayBeamProjectorUsage.setText("wrong"); break;
			}
		}else if(e.getSource() == whiteBoardCheckBox) {
			sc.pm.setBeamProjectorUsage(e.getStateChange());
			int choice = e.getStateChange();
			switch(choice) {
			case 1 : 
				displayWhiteboardUsage.setText("사용");
				break;
			case 2 : displayWhiteboardUsage.setText("사용 안함"); break;
			
			default : displayWhiteboardUsage.setText("wrong"); break;
			}
		} 
		
		sc.totalCostCalculator();

	}

	public JLabel getDisplayPriceAfterDiscount() {
		return displayPriceAfterDiscount;
	}

	public void setDisplayPriceAfterDiscount(JLabel displayPriceAfterDiscount) {
		this.displayPriceAfterDiscount = displayPriceAfterDiscount;
	}

	public JLabel getDisplayTotalCost() {
		return displayTotalCost;
	}

	public void setDisplayTotalCost(JLabel displayTotalCost) {
		this.displayTotalCost = displayTotalCost;
	}
	
}
