package com.space_distortion.view;

import java.awt.Color;
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



public class FinalPaymentView extends SpaceActionEvent implements ViewIndex, ItemListener {
	
	SpaceController sc;
	private JPanel panelLeft, panelRight;
	private Image img;
	private JButton confirmButton;
	
	public FinalPaymentView() {
		
	}
	
	
	
	public void initialize(SpaceController controller, JFrame mainJframe){
		sc=controller;
		
//		========= 왼쪽 패널 생성==================================================
		panelLeft = new JPanel();
		panelLeft.setBounds(0,0,512,768);
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setVisible(true);
		panelLeft.setLayout(null);
		

		
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
	
//		Confirm Button
		
		confirmButton = new JButton("Proceed");
		confirmButton.setBounds(180, 650, 150, 60);
		panelRight.add(confirmButton);
		
		mainJframe.getContentPane().add(panelRight);
		mainJframe.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
