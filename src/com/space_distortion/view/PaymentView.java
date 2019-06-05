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

	// Payment �� Controller ��ü�� �������� �ʾҴ�. ������ Controller �� ��ü�� ����
	//�߱� �����̰� �� public View �� �Ű������� �־��־��� ������ �ʿ����. fuck. �ϳ� �����
	
//	���� �гο� �ִ� ��� ������
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
	
//	������ �гο� �ִ� ��� ������
	private Image img;
	private JLabel timeLabelr, pplLabelr, beamProjectorLabelr, whiteBoardLabelr, laptopLabelr
	, totalLabelr, memberDiscountLabelr, finalPrice;

	
	public void initialize(SpaceController controller, JFrame mainJframe){
		sc=controller;
		
//		========= ���� �г� ����==================================================
		panelLeft = new JPanel();
		panelLeft.setBounds(0,0,512,768);
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setVisible(true);
		panelLeft.setLayout(null);
		
//		========���� �гο� �ִ� ���̺�=========
		
		// �ð� ���̺�
		timeLabel = new JLabel("�ð� ");
		timeLabel.setBounds(117, 118, 30, 16);
		timeLabel.setVisible(true);
		panelLeft.add(timeLabel);
		
		
		//�ο� ���̺�
		pplLabel = new JLabel("�ο� ");
		pplLabel.setBounds(117, 243, 30, 16);
		panelLeft.add(pplLabel);
		
		//�� �������� ���̺�
		beamProjectorLabel = new JLabel("���������� ");
		beamProjectorLabel.setBounds(136, 584, 63, 16);
		panelLeft.add(beamProjectorLabel);
		 
		
		//ȭ��Ʈ���� ���̺�
		whiteBoardLabel =new JLabel("ȭ��Ʈ���� ");
		whiteBoardLabel.setBounds(288, 584, 63, 16);
		panelLeft.add(whiteBoardLabel);
		 
		
		//��Ʈ�Ϸ��̺�
		laptopLabel = new JLabel("��Ʈ�� ");
		laptopLabel.setBounds(117, 379, 41, 16);
		panelLeft.add(laptopLabel);
		
//		========���� �гο� �ִ� üũ�ϴ� ��ɵ�=========
		
		// �ð� �޺��ڽ�
		timeComboBox = new JComboBox<Integer>(numTable);
		timeComboBox.setBounds(117,145,277,54);
		panelLeft.add(timeComboBox);
		timeComboBox.addItemListener((ItemListener) this);
		
		//�ο� �޺��ڽ�
		pplComboBox = new JComboBox<Integer>(numTable);
		pplComboBox.setBounds(117,270,277,54);
		panelLeft.add(pplComboBox);
		pplComboBox.addItemListener(this);
		
		//��Ʈ�� �޺��ڽ�
		laptopComboBox = new JComboBox<Integer>(laptopTable);
		laptopComboBox.setBounds(117,405, 277, 54);
		panelLeft.add(laptopComboBox);
		laptopComboBox.addItemListener(this);
		
		//���������� ������� üũ�ڽ�
		beamProjectorCheckBox = new JCheckBox();
		beamProjectorCheckBox.setBounds(150, 600, 24, 24);
		panelLeft.add(beamProjectorCheckBox);
		beamProjectorCheckBox.addItemListener(this);
		
		
		//ȭ��Ʈ���� ������� üũ�ڽ�
		whiteBoardCheckBox = new JCheckBox();
		whiteBoardCheckBox.setBounds(300, 600, 24, 24);
		panelLeft.add(whiteBoardCheckBox);
		whiteBoardCheckBox.addItemListener(this);
		
		mainJframe.getContentPane().add(panelLeft);
		
//		========= ������ �г� ����==================================================
		
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
	
		
		
		// �ð� ���̺�
		timeLabelr = new JLabel("�ð� ");
		timeLabelr.setForeground(Color.GRAY);
		timeLabelr.setBounds(74, 95, 50, 30);
		timeLabelr.setVisible(true);
		panelRight.add(timeLabelr);
		
		// �ð��� ������ �����ִ� ���̺�(���簪�� 3000��)

//		System.out.println(controller.getPm()); // �̰� ����ϰԵǸ� toString ���
		
		displayHourlyCost = new JLabel(""+sc.pm.getHourlyCost());
		displayHourlyCost.setForeground(Color.DARK_GRAY);
		displayHourlyCost.setBounds(385, 97, 50, 30);
		displayHourlyCost.setVisible(true);
		panelRight.add(displayHourlyCost);
		
		// ��ð��� �̿��ϴ��� �����ִ� ���̺�
		displaySelectedHour = new JLabel("1");
		displaySelectedHour.setForeground(Color.DARK_GRAY);
		displaySelectedHour.setBounds(405, 125, 50, 30);
		displaySelectedHour.setVisible(true);
		panelRight.add(displaySelectedHour);
		
		
		//�ο� ���̺�
		pplLabelr = new JLabel("�ο� ");
		pplLabelr.setForeground(Color.GRAY);
		pplLabelr.setBounds(74, 161, 50, 30);
		panelRight.add(pplLabelr);
		
		// �ο��� ������� �����ִ� ���̺�
		displaySelectedPpl = new JLabel("1");
		displaySelectedPpl.setForeground(Color.DARK_GRAY);
		displaySelectedPpl.setBounds(405, 163, 50, 30);
		displaySelectedPpl.setVisible(true);
		panelRight.add(displaySelectedPpl);
		
		
		//�� �������� ���̺�
		beamProjectorLabelr = new JLabel("���������� �뿩");
		beamProjectorLabelr.setForeground(Color.GRAY);
		beamProjectorLabelr.setBounds(74, 215, 100, 30);
		panelRight.add(beamProjectorLabelr);
		
		// Displaying the usage of the bream projector
		displayBeamProjectorUsage = new JLabel("��� ����");
		displayBeamProjectorUsage.setForeground(Color.DARK_GRAY);
		displayBeamProjectorUsage.setBounds(368, 217, 100, 30);
		displayBeamProjectorUsage.setVisible(true);
		panelRight.add(displayBeamProjectorUsage);
		
		//ȭ��Ʈ���� ���̺�
		whiteBoardLabelr =new JLabel("ȭ��Ʈ���� �뿩");
		whiteBoardLabelr.setForeground(Color.GRAY);
		whiteBoardLabelr.setBounds(74, 276, 100, 30);
		panelRight.add(whiteBoardLabelr);
		
		//Displaying usage of whiteboard
		displayWhiteboardUsage = new JLabel("��� ����");
		displayWhiteboardUsage.setForeground(Color.DARK_GRAY);
		displayWhiteboardUsage.setBounds(368, 275, 100, 30);
		displayWhiteboardUsage.setVisible(true);
		panelRight.add(displayWhiteboardUsage);
		
		//��Ʈ�Ϸ��̺�
		laptopLabelr = new JLabel("��Ʈ�� ");
		laptopLabelr.setForeground(Color.GRAY);
		laptopLabelr.setBounds(74, 336, 50, 30);
		panelRight.add(laptopLabelr);
		
		//��Ʈ���� � �������� �����ִ� ���̺�
		displaySelectedLaptop = new JLabel("(X)");
		displaySelectedLaptop.setForeground(Color.DARK_GRAY);
		displaySelectedLaptop.setBounds(400, 360, 50, 30);
		displaySelectedLaptop.setVisible(true);
		panelRight.add(displaySelectedLaptop);
		
		// ��Ʈ�� ���� ������ �����ִ� ���̺�
		displayLaptopRentalCost = new JLabel(""+sc.pm.getLaptopCost());
		displayLaptopRentalCost.setForeground(Color.DARK_GRAY);
		displayLaptopRentalCost.setBounds(385, 336, 50, 30);
		displayLaptopRentalCost.setVisible(true);
		panelRight.add(displayLaptopRentalCost);
		
		
		// Total ���̺�
		totalLabelr = new JLabel("Total");
		totalLabelr.setForeground(Color.GRAY);
		totalLabelr.setBounds(74, 400, 100, 30);
		panelRight.add(totalLabelr);
		
		// ��ī��Ʈ �ۼ����� ���̺�
		memberDiscountLabelr = new JLabel("Member Discount");
		memberDiscountLabelr.setForeground(Color.GRAY);
		memberDiscountLabelr.setBounds(74, 446, 150, 30);
		panelRight.add(memberDiscountLabelr);
		
		// ��ī��Ʈ �� ������ �����ִ� ���̺�
		setDisplayTotalCost(new JLabel(""+sc.pm.getTotalCost()));
		getDisplayTotalCost().setForeground(Color.DARK_GRAY);
		getDisplayTotalCost().setBounds(405, 400, 50, 30);
		getDisplayTotalCost().setVisible(true);
		panelRight.add(getDisplayTotalCost());
		
		// ���� ������ �����ִ� ���̺�
		setDisplayPriceAfterDiscount(new JLabel(""+sc.pm.getFinalCost()));
		getDisplayPriceAfterDiscount().setForeground(Color.DARK_GRAY);
		getDisplayPriceAfterDiscount().setBounds(405, 500, 50, 30);
		getDisplayPriceAfterDiscount().setVisible(true);
		panelRight.add(getDisplayPriceAfterDiscount());
		
		// �����ݾ� ���̺�
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
			case 1 : displayBeamProjectorUsage.setText("���"); break;
			case 2 : displayBeamProjectorUsage.setText("��� ����"); break;
			default : displayBeamProjectorUsage.setText("wrong"); break;
			}
		}else if(e.getSource() == whiteBoardCheckBox) {
			sc.pm.setBeamProjectorUsage(e.getStateChange());
			int choice = e.getStateChange();
			switch(choice) {
			case 1 : 
				displayWhiteboardUsage.setText("���");
				break;
			case 2 : displayWhiteboardUsage.setText("��� ����"); break;
			
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
