package com.space_distortion.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Payment;
import com.space_distortion.model.vo.SnackBar;



public class PaymentView extends SpaceActionEvent implements ViewIndex, ItemListener {

Color color = new Color(93, 188, 210); 
 private SpaceController sc;
 private List<Payment> list;
 
// 여기서  컬렉션의 '그릇'을 만들어준다
// List<Payment> list = new ArrayList<Payment> ();
 
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
	displayWhiteboardUsage, displayBeamProjectorUsage, displayTotalCost, displayPriceAfterDiscount, displayMemberDiscountLabelr, roomLabel;
	 Integer[] numTable = {1,2,3,4,5,6,7,8,9,10};
	 Integer[] laptopTable = {0,1,2,3,4,5,6,7,8,9,10};
	 private JComboBox<Integer> timeComboBox;
	 private JComboBox<Integer> pplComboBox;
	 private JComboBox<Integer> laptopComboBox;
	 private JCheckBox whiteBoardCheckBox;
	 private JCheckBox beamProjectorCheckBox;
	 private JPanel panelLeft, panelRight, jp;
	 private JButton registerButton, proceedButton;
	 private List <SnackBar> snackBarList = new ArrayList <SnackBar>();
	 private int roomNum = 1;
	 private String member = "";
	 private int snackPrice = 0;
	 
	
//	오른쪽 패널에 있는 모든 변수들
	private Image img;
	private JLabel timeLabelr, pplLabelr, beamProjectorLabelr, whiteBoardLabelr, laptopLabelr
	, totalLabelr, memberDiscountLabelr, finalPrice;
	private int room = 0;
	
	

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController controller, JFrame mainJframe, List<Payment> list, List tempPayment){
		sc=controller;
		this.list = list;		
//		System.out.println("1111" + this.list);
	
		
//		System.out.println("rrrrrrrrrr"+tempPayment.get(tempPayment.size()-1));
		for (Object o : tempPayment) {
//			System.out.println("fffffff" + o);
			Object i = tempPayment;
			if (o instanceof Integer) {
				System.out.println("Hello World");
				roomNum = (int)o;
				System.out.println("room Num????????????????" + roomNum);
			}
			if (o instanceof SnackBar) {
				//System.out.println("2222" + snackBarList.toString());
				System.out.println(o);
				int a = ((SnackBar)o).getSnackQty();
				int b = ((SnackBar)o).getSnackPrice();
				snackPrice = a * b; 
				
//				((Payment)tempPayment).set
				snackBarList.add((SnackBar)o);
			}
			if(o instanceof String)
			{
				member = o.toString();
				System.out.println("member???????????????:" + member);
//				System.out.println(o.toString());
			}
			
		}
		
		
		
//		리스트 인덱스 0번부터 여기서 추가해준다
		list.add(new Payment());
		
		jp = new JPanel();
		jp.setBounds(0, 0, 1024, 768);
		jp.setLayout(null);
		jp.setVisible(true);

		
		// 리스트 안에 페이먼틀 리스트가 들어갔어요  근데 주소는 아니에요 값이 들어갔아요 
		
		

//		========= 왼쪽 패널 생성==================================================
		panelLeft = new JPanel();
		panelLeft.setBounds(0,0,512,768);
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setVisible(true);
		panelLeft.setLayout(null);
		
		roomLabel = new JLabel("Room "+roomNum);
		roomLabel.setBounds(50, 50, 70, 16);
		roomLabel.setVisible(true);
		panelLeft.add(roomLabel);

		
//Method 1:		USe the contructor to set the hour(ex)
//		list.add(new Payment());
//		list.get(list.size()-1).setHour(100);
		
		
		
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
		
		
//		mainJframe.getContentPane().add(panelLeft);
		
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
		
		displayHourlyCost = new JLabel(""+list.get(list.size()-1).getHourlyCost()+"원");
		displayHourlyCost.setHorizontalAlignment(SwingConstants.RIGHT);
		displayHourlyCost.setForeground(Color.DARK_GRAY);
		displayHourlyCost.setBounds(385, 97, 50, 30);
		displayHourlyCost.setVisible(true);
		panelRight.add(displayHourlyCost);
		
		// 몇시간을 이용하는지 보여주는 레이블
		displaySelectedHour = new JLabel("1"+"시간");
		displaySelectedHour.setHorizontalAlignment(SwingConstants.RIGHT);
		displaySelectedHour.setForeground(Color.DARK_GRAY);
		displaySelectedHour.setBounds(385, 125, 50, 30);
		displaySelectedHour.setVisible(true);
		panelRight.add(displaySelectedHour);
		
		
		//인원 레이블
		pplLabelr = new JLabel("인원 ");
		pplLabelr.setForeground(Color.GRAY);
		pplLabelr.setBounds(74, 161, 50, 30);
		panelRight.add(pplLabelr);
		
		// 인원이 몇명인지 보여주는 레이블
		displaySelectedPpl = new JLabel("1명");
		displaySelectedPpl.setHorizontalAlignment(SwingConstants.RIGHT);
		displaySelectedPpl.setForeground(Color.DARK_GRAY);
		displaySelectedPpl.setBounds(385, 163, 50, 30);
		displaySelectedPpl.setVisible(true);
		panelRight.add(displaySelectedPpl);
		
		
		//빔 프로젝터 레이브
		beamProjectorLabelr = new JLabel("빔프로젝터 대여");
		beamProjectorLabelr.setForeground(Color.GRAY);
		beamProjectorLabelr.setBounds(74, 215, 100, 30);
		panelRight.add(beamProjectorLabelr);
		
		// Displaying the usage of the bream projector
		displayBeamProjectorUsage = new JLabel("사용 안함");
		displayBeamProjectorUsage.setHorizontalAlignment(SwingConstants.RIGHT);
		displayBeamProjectorUsage.setForeground(Color.DARK_GRAY);
		displayBeamProjectorUsage.setBounds(340, 217, 100, 30);
		displayBeamProjectorUsage.setVisible(true);
		panelRight.add(displayBeamProjectorUsage);
		
		//화이트보드 레이블
		whiteBoardLabelr =new JLabel("화이트보드 대여");
		whiteBoardLabelr.setForeground(Color.GRAY);
		whiteBoardLabelr.setBounds(74, 276, 100, 30);
		panelRight.add(whiteBoardLabelr);
		
		//Displaying usage of whiteboard
		displayWhiteboardUsage = new JLabel("사용 안함");
		displayWhiteboardUsage.setHorizontalAlignment(SwingConstants.RIGHT);
		displayWhiteboardUsage.setForeground(Color.DARK_GRAY);
		displayWhiteboardUsage.setBounds(340, 275, 100, 30);
		displayWhiteboardUsage.setVisible(true);
		panelRight.add(displayWhiteboardUsage);
		
		//노트북레이블
		laptopLabelr = new JLabel("노트북 ");
		laptopLabelr.setForeground(Color.GRAY);
		laptopLabelr.setBounds(74, 336, 50, 30);
		panelRight.add(laptopLabelr);
		
		//노트북을 몇개 빌리는지 보여주는 레이블
		displaySelectedLaptop = new JLabel("(X)");
		displaySelectedLaptop.setHorizontalAlignment(SwingConstants.RIGHT);
		displaySelectedLaptop.setForeground(Color.DARK_GRAY);
		displaySelectedLaptop.setBounds(385, 360, 50, 30);
		displaySelectedLaptop.setVisible(true);
		panelRight.add(displaySelectedLaptop);
		
		// 노트북 개당 얼마인지 보여주는 레이블
		displayLaptopRentalCost = new JLabel(""+list.get(list.size()-1).getLaptopCost()+"원");
		displayLaptopRentalCost.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		// 디스카운트 퍼센테지 레이블
		
		if (member == "Member") {
			displayMemberDiscountLabelr = new JLabel("Discount applied");
			list.get(list.size()-1).setUser("member");
		}
		else {
			displayMemberDiscountLabelr = new JLabel("No Discount");
			list.get(list.size()-1).setDiscountRate((int)1);
			list.get(list.size()-1).setUser("nonMember");
		}
		displayMemberDiscountLabelr.setForeground(Color.GRAY);
		displayMemberDiscountLabelr.setBounds(350, 446, 150, 30);
		panelRight.add(displayMemberDiscountLabelr);
		
		// total price 원 보여주기 won label
		JLabel wonTotal= new JLabel("원");
		
		wonTotal.setForeground(Color.GRAY);
		wonTotal.setBounds(400, 400, 50, 30);
		panelRight.add(wonTotal);
		wonTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		// price after discount won label
		JLabel finaltotal= new JLabel("원");
		finaltotal.setForeground(Color.GRAY);
		finaltotal.setHorizontalAlignment(SwingConstants.RIGHT);
		finaltotal.setBounds(400, 500, 50, 30);
		panelRight.add(finaltotal);
		
		// 디스카운트 적 가격을 보여주는 레이블
		setDisplayTotalCost(new JLabel(""+list.get(list.size()-1).getTotalCost()));
		getDisplayTotalCost().setForeground(Color.DARK_GRAY);
		getDisplayTotalCost().setHorizontalAlignment(SwingConstants.RIGHT);
		getDisplayTotalCost().setBounds(385, 400, 50, 30);
		getDisplayTotalCost().setVisible(true);
		panelRight.add(getDisplayTotalCost());
		
		// 최종 가격을 보여주는 레이블
		System.out.println("::::::"+list.get(list.size()-1).getFinalCost());
		setDisplayPriceAfterDiscount(new JLabel(""+list.get(list.size()-1).getFinalCost()));
		getDisplayPriceAfterDiscount().setHorizontalAlignment(SwingConstants.RIGHT);;
		getDisplayPriceAfterDiscount().setForeground(Color.DARK_GRAY);
		getDisplayPriceAfterDiscount().setBounds(385, 500, 50, 30);
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
		proceedButton.addMouseListener(new SpaceActionEvent(PAYMENT_VIEW_NUM,2,sc,mainJframe,jp));		
		registerButton.addMouseListener(new SpaceActionEvent(PAYMENT_VIEW_NUM,1,sc,mainJframe,jp ));
		proceedButton.setBounds(180, 650, 150, 60);
		panelRight.add(proceedButton);
		
		jp.add(panelLeft);
		jp.add(panelRight);
		
		mainJframe.getContentPane().add(jp);
		
		jp.revalidate();
		jp.repaint();
		
//		mainJframe.getContentPane().add(panelRight);
		//mainJframe.setVisible(true);
		
		 
	}
		
		
	
//	마우스를 클릭했을때 이벤트를 처리하는 메소드.5개의 클릭할수 있는 카테고리가 있으며 if문으로 처리함
	public void itemStateChanged(ItemEvent e) {
		
//		쎄터를 써더 이닛페이 컬렉션에 넣어주는 작업 - 문제는 이건 쎄터밖에 못씀
//		sc.initPay((int) timeComboBox.getSelectedItem(), (int) pplComboBox.getSelectedItem(), (int)laptopComboBox.getSelectedItem()
//				(int)setWhiteBoardUsage(e), (int)setBeamProjectorUsage(e.getStateChange())
//				);
		
//		System.out.println(p);
		if(e.getSource() == timeComboBox) {
			System.out.println("TimeComboBox selected: "+timeComboBox.getSelectedItem());
//		sc.pm.setHourlyCost((int)timeComboBox.getSelectedItem());
		
//		얼마나 시간을 사용할건지 보여주는 메소드
		list.get(list.size()-1).setHour((int) timeComboBox.getSelectedItem());
//		System.out.println("hourly selected: "+ list.get(list.size()-1).getHourlyCost());
		int choice = (int) timeComboBox.getSelectedItem();
		switch(choice) {
		case 1 : 
			displaySelectedHour.setText("1시간");
			break;
		case 2 :
			displaySelectedHour.setText("2시간");
			break;
		case 3 :
			displaySelectedHour.setText("3시간");
			break;
		case 4 :
			displaySelectedHour.setText("4시간"); 
			break;
		case 5 :
			displaySelectedHour.setText("5시간");
			break;
		case 6 : 
			displaySelectedHour.setText("6시간");
			break;
		case 7 :
			displaySelectedHour.setText("7시간");
			break;
		case 8 :
			displaySelectedHour.setText("8시간");
			break;
		case 9 :
			displaySelectedHour.setText("9시간");
			break;
		case 10 :
			displaySelectedHour.setText("10시간"); 
			break;
		
		default : 
			displaySelectedHour.setText("wrong");
			break;
		}
//		인원이 몇명이 이용할건지 처리하는 메소드
		} else if(e.getSource() == pplComboBox) {
			
		list.get(list.size()-1).setPpl((int) pplComboBox.getSelectedItem());
		
		int choice = (int) pplComboBox.getSelectedItem();
		switch(choice) {
		case 1 : 
			displaySelectedPpl.setText("1명");
			break;
		case 2 :
			displaySelectedPpl.setText("2명");
			break;
		case 3 : 
			displaySelectedPpl.setText("3명");
			break;
		case 4 :
			displaySelectedPpl.setText("4명"); 
			break;
		case 5 :
			displaySelectedPpl.setText("5명");
			break;
		case 6 : 
			displaySelectedPpl.setText("6명");
			break;
		case 7 : 
			displaySelectedPpl.setText("7명");
			break;
		case 8 :
			displaySelectedPpl.setText("8명");
			break;
		case 9 :
			displaySelectedPpl.setText("9명");
			break;
		case 10 :
			displaySelectedPpl.setText("10명");
			break;
		
		default :
			displaySelectedPpl.setText("wrong");
			break;
		}
//		노트북을 몇개 사용할지 처리하는 메소드
		} else if (e.getSource() == laptopComboBox) {
		list.get(list.size()-1).setLaptop((int) laptopComboBox.getSelectedItem());
		int choice = (int) laptopComboBox.getSelectedItem();
		switch(choice){
		case 0 :
			displaySelectedLaptop.setText("(X)");
			break;
		case 1 : 
			displaySelectedLaptop.setText("1개");
			break;
		case 2 : 
			displaySelectedLaptop.setText("2개");
			break;
		case 3 : 
			displaySelectedLaptop.setText("3개");
			break;
		case 4 :
			displaySelectedLaptop.setText("4개");
			break;
		case 5 :
			displaySelectedLaptop.setText("5개");
			break;
		case 6 :
			displaySelectedLaptop.setText("6개");
			break;
		case 7 : 
			displaySelectedLaptop.setText("7개");
			break;
		case 8 : 
			displaySelectedLaptop.setText("8개");
			break;
		case 9 : 
			displaySelectedLaptop.setText("9개");
			break;
		case 10 : 
			displaySelectedLaptop.setText("10개");
			break;
		
		default :
			displaySelectedLaptop.setText("wrong");
			break;
		
		} 
//		빔프로젝터에 대한 사용유무를 알려주는 이벤트
		}else if(e.getSource()==beamProjectorCheckBox) {
			list.get(list.size()-1).setWhiteBoardUsage(e.getStateChange());
			int choice  = e.getStateChange();
			switch (choice) {
			case 1 :
				displayBeamProjectorUsage.setText("사용");
				break;
			case 2 :
				displayBeamProjectorUsage.setText("사용 안함");
				break;
			default :
				displayBeamProjectorUsage.setText("wrong");
				break;
			}
			
//		화이트보드에 대한 사용유무를 알려주는 이벤트	
		}else if(e.getSource() == whiteBoardCheckBox) {
			list.get(list.size()-1).setBeamProjectorUsage(e.getStateChange());
			int choice = e.getStateChange();
			switch(choice) {
			case 1 : 
				displayWhiteboardUsage.setText("사용");
				break;
			case 2 :
				displayWhiteboardUsage.setText("사용 안함"); 
				break;
			
			default :
				displayWhiteboardUsage.setText("wrong");
				break;
			}
		} 
// 값을 다 계산해주는 메소드
		sc.totalCostCalculator(list);

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
