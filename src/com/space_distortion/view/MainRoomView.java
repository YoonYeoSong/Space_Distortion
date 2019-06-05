package com.space_distortion.view;

import java.awt.SystemColor;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class MainRoomView extends SpaceActionEvent implements ViewIndex{

	public MainRoomView() {
			
		}
	
	public void initialize(SpaceController sc, JFrame mainJframe, List roomInfoList)
	{	
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
				
		
		JButton btnRoom1 = new JButton("1\uBC88\uBC29");
		btnRoom1.setBounds(14, 122, 105, 49);
		
		
		JButton btnRoom2 = new JButton("2\uBC88\uBC29");
		btnRoom2.setBounds(131, 122, 105, 49);
		
		
		JButton btnRoom3 = new JButton("3\uBC88\uBC29");
		btnRoom3.setBounds(250, 122, 105, 49);
		
	
		JButton btnRoom4 = new JButton("4\uBC88\uBC29");
		btnRoom4.setBounds(369, 122, 105, 49);
		
		
		JButton btnRoom5 = new JButton("5\uBC88\uBC29");
		btnRoom5.setBounds(14, 288, 105, 49);
		
	
		JButton btnRoom6 = new JButton("6\uBC88\uBC29");
		btnRoom6.setBounds(131, 288, 105, 49);
		
		JButton btnRoom7 = new JButton("7\uBC88\uBC29");
		btnRoom7.setBounds(250, 288, 105, 49);
		
		
		JButton btnRoom8 = new JButton("8\uBC88\uBC29");
		btnRoom8.setBounds(369, 288, 105, 49);	
		
		
		//투명??
		btnRoom8.setBackground(SystemColor.textHighlightText);
		
		
		jp.add(btnRoom1);
		jp.add(btnRoom2);
		jp.add(btnRoom3);
		jp.add(btnRoom4);
		jp.add(btnRoom5);
		jp.add(btnRoom6);
		jp.add(btnRoom7);
		jp.add(btnRoom8);
		
		JButton btnAdmin = new JButton("\uAD00\uB9AC\uC790");
		
		btnAdmin.setBounds(398, 446, 105, 27);
		jp.add(btnAdmin); // 관리자버튼

		
		btnRoom1.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 1, sc, mainJframe, jp));
		btnRoom2.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 2, sc, mainJframe, jp));
		btnRoom3.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));
		btnRoom4.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 4, sc, mainJframe, jp));
		btnRoom5.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 5, sc, mainJframe, jp));
		btnRoom6.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 6, sc, mainJframe, jp));
		btnRoom7.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 7, sc, mainJframe, jp));
		btnRoom8.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 8, sc, mainJframe, jp));
		btnAdmin.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 9, sc, mainJframe, jp));
		
		
		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();
		
		
		
		//jp.setVisible(true);
		//mainJframe.setVisible(true);
	}
	
	

}
