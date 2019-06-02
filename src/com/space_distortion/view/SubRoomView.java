package com.space_distortion.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class SubRoomView extends SpaceActionEvent implements ViewIndex{

	public SubRoomView() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize(SpaceController sc, JFrame mainJframe)
	{
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 600, 600);
		jp.setLayout(null);
		
		
		
		JButton btn1 = new JButton("회원");
		btn1.setForeground(Color.BLACK);
		btn1.setBounds(100, 150, 163, 45);
		
		JButton btn2 = new JButton("비 회원");
		btn2.setForeground(Color.BLACK);
		btn2.setBounds(100, 200, 163, 45);
		
		JButton btn3 = new JButton("예약");
		btn3.setForeground(Color.BLACK);
		btn3.setBounds(100, 250, 163, 45);
		
		JButton btn4 = new JButton("뒤로가기");
		btn4.setForeground(Color.BLACK);
		btn4.setBounds(100, 300, 163, 45);
		
		btn1.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 1, sc, mainJframe ,jp));
		btn2.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 2, sc, mainJframe ,jp));
		btn3.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 3, sc, mainJframe ,jp));
		btn4.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 4, sc, mainJframe ,jp));
		
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		jp.setVisible(true);
		
		//mainJframe.setContentPane(jp);
		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();
		
		
		
		
//		jp.revalidate();
//		jp.repaint();
//		mainJframe.setVisible(true);
	
	}
}
