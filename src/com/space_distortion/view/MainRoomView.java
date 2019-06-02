package com.space_distortion.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class MainRoomView extends SpaceActionEvent implements ViewIndex{

	public MainRoomView() {
			
		}
	
	public void initialize(SpaceController sc, JFrame mainJframe)
	{
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(new FlowLayout());
		
		
		JButton btn1 = new JButton("1번 방");
		JButton btn2 = new JButton("2번 방(X)");
		JButton btn3 = new JButton("종료");
		JButton btn4 = new JButton("관리자");
		
		btn1.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 1, sc, mainJframe, jp));
		btn2.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 2, sc, mainJframe, jp));
		btn3.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));
		btn4.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 4, sc, mainJframe, jp));
		
		
		
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		
		//mainJframe.setContentPane(jp);
		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);
		mainJframe.setVisible(true);
	}
	
	

}
