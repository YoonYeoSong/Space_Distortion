package com.space_distortion.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Payment;



public class FinalPaymentView extends SpaceActionEvent implements ViewIndex {
	
	SpaceController sc;
	private JPanel panelLeft, panelRight,jp;
	private Image halfBackground, logo;
	private JButton confirmButton;
	private JLabel finalPrice, payInCash, change, displayChangeCost, displayTotalPrice, invalidField;
	private JTextField inputCash;
	private List<Payment> list;
	public FinalPaymentView() {
		
	}
	
	
	
	public void initialize(SpaceController controller, JFrame mainJframe, List<Payment> paymentList){
		
		jp = new JPanel();
		jp.setBounds(0, 0, 1024, 768);
		jp.setLayout(null);
		jp.setVisible(true);
		
		sc=controller;
		list = paymentList;
//		========= 왼쪽 패널 생성==================================================
		logo = new ImageIcon("logo.png").getImage();
				
		panelLeft = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				panelLeft.setBackground(Color.WHITE);
				g.drawImage(logo,28,137,this);
			}
		};
		panelLeft.setBounds(0,0,512,768);
//		panelLeft.revalidate();
//		panelLeft.repaint();
		panelLeft.setVisible(true);
		panelLeft.setLayout(null);
		

		
		//mainJframe.getContentPane().add(panelLeft);
		
//		========= 오른쪽 패널 생성==================================================
		// 바다 벡그라운드에 넣은 이미
		halfBackground = new ImageIcon("ocean_background_halfsize.png").getImage();
		panelRight = new JPanel() {
			private Image pImg=halfBackground;
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(pImg,0,0,this);
			}
			
		};
		// 오른쪽 패널 설정
		panelRight.setBounds(512,0,512,768);
		panelRight.setVisible(true);
		panelRight.setLayout(null); 
		
//		Invalid 한거 보여주는 레이블
		invalidField = new JLabel();
		invalidField.setVisible(true);
		invalidField.setBounds(221, 340, 100, 50);
		panelRight.add(invalidField);
		
//		Pay in cash TextField (숫자가 아닌 다른 문자가 들어가면 잘못됬다고 띄워)
		inputCash = new JTextField();
		inputCash.setBounds(221, 259, 100, 50);
		inputCash.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					int i = Integer.parseInt(inputCash.getText());
					invalidField.setText("");
				}catch (NumberFormatException e1) {
					invalidField.setText("invalid number");
				}
			}
		});
		panelRight.add(inputCash);
		
		
//		파이널 가격 제목
		finalPrice = new JLabel("Total Price");
		finalPrice.setBounds(99, 95, 150, 60);
		panelRight.add(finalPrice);
		
//		최종 받을가격 보여주기
		//displayTotalPrice = new JLabel(""+list.get(list.size()-1).getFinalCost());
		//displayTotalPrice.setBounds(337, 95, 150, 60);
		//panelRight.add(displayTotalPrice);
		
		
//		파이널 가격을 보여주는 레이블
		payInCash = new JLabel("Pay in Cash");
		payInCash.setBounds(188, 163, 150, 60);
		panelRight.add(payInCash);
		
		
//		파이널 가격을 보여주는 레이블
		change = new JLabel("거스름돈");
		change.setBounds(99, 446, 150, 60);
		panelRight.add(change);
		
//		거스름돈 가격표 보여주기
		displayChangeCost = new JLabel("$거스름돈");
		displayChangeCost.setBounds(337, 446, 150, 60);
		panelRight.add(displayChangeCost);
	
//		Confirm Button
		confirmButton = new JButton("Proceed");
		confirmButton.setBounds(180, 650, 150, 60);
//		confirmButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String text = inputCash.getText();
//				list.get(list.size()-1).setInputtedCash(Integer.parseInt(text));
//				System.out.println(list.get(list.size()-1).getInputtedCash());
//				int changePrice = list.get(list.size()-1).getInputtedCash()-list.get(list.size()-1).getFinalCost();
//				if(changePrice>=0) {
//					sc.mainView();
//				}else if (changePrice<0) {
//					popUp();
//				}
//				
//			}
//		});
		confirmButton.addMouseListener(new SpaceActionEvent(PAYMENTFINAL_VIEW_NUM,1,sc,mainJframe,jp));
		panelRight.add(confirmButton);
		
		jp.add(panelLeft);
		jp.add(panelRight);
		mainJframe.getContentPane().add(jp);
		
		jp.revalidate();
		jp.repaint();
		mainJframe.setVisible(true);
		
		
	}
	
	// 돈이 부족할때 나오는 팝업 프레임
	public void popUp() {
		JFrame popUpMessage = new JFrame();
		popUpMessage.setBounds(500, 500, 400, 400);
		
		JPanel popUpPanel = new JPanel();
		popUpPanel.setBounds(500, 500, 300, 100);
		
		JLabel inefficientFund = new JLabel("돈이 모자릅니다. 돈 더 넣으세요");
		inefficientFund.setVisible(true);
		popUpPanel.add(inefficientFund);
		
		JButton exitButton = new JButton("알겠어요");
		exitButton.setBounds(50, 50, 70, 50);
		exitButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
			
				popUpMessage.dispose();
			}
		});
		inefficientFund.setVisible(true);
		popUpPanel.add(exitButton);
		
		popUpPanel.setVisible(true);
		popUpMessage.add(popUpPanel);
		
		popUpMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popUpMessage.setVisible(true);
	}



	public JTextField getInputCash() {
		return inputCash;
	}


	public void setInputCash(JTextField inputCash) {
		this.inputCash = inputCash;
	}

}
