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
//		========= ���� �г� ����==================================================
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
		
//		========= ������ �г� ����==================================================
		// �ٴ� ���׶��忡 ���� �̹�
		halfBackground = new ImageIcon("ocean_background_halfsize.png").getImage();
		panelRight = new JPanel() {
			private Image pImg=halfBackground;
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(pImg,0,0,this);
			}
			
		};
		// ������ �г� ����
		panelRight.setBounds(512,0,512,768);
		panelRight.setVisible(true);
		panelRight.setLayout(null); 
		
//		Invalid �Ѱ� �����ִ� ���̺�
		invalidField = new JLabel();
		invalidField.setVisible(true);
		invalidField.setBounds(221, 340, 100, 50);
		panelRight.add(invalidField);
		
//		Pay in cash TextField (���ڰ� �ƴ� �ٸ� ���ڰ� ���� �߸���ٰ� ���)
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
		
		
//		���̳� ���� ����
		finalPrice = new JLabel("Total Price");
		finalPrice.setBounds(99, 95, 150, 60);
		panelRight.add(finalPrice);
		
//		���� �������� �����ֱ�
		//displayTotalPrice = new JLabel(""+list.get(list.size()-1).getFinalCost());
		//displayTotalPrice.setBounds(337, 95, 150, 60);
		//panelRight.add(displayTotalPrice);
		
		
//		���̳� ������ �����ִ� ���̺�
		payInCash = new JLabel("Pay in Cash");
		payInCash.setBounds(188, 163, 150, 60);
		panelRight.add(payInCash);
		
		
//		���̳� ������ �����ִ� ���̺�
		change = new JLabel("�Ž�����");
		change.setBounds(99, 446, 150, 60);
		panelRight.add(change);
		
//		�Ž����� ����ǥ �����ֱ�
		displayChangeCost = new JLabel("$�Ž�����");
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
	
	// ���� �����Ҷ� ������ �˾� ������
	public void popUp() {
		JFrame popUpMessage = new JFrame();
		popUpMessage.setBounds(500, 500, 400, 400);
		
		JPanel popUpPanel = new JPanel();
		popUpPanel.setBounds(500, 500, 300, 100);
		
		JLabel inefficientFund = new JLabel("���� ���ڸ��ϴ�. �� �� ��������");
		inefficientFund.setVisible(true);
		popUpPanel.add(inefficientFund);
		
		JButton exitButton = new JButton("�˰ھ��");
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
