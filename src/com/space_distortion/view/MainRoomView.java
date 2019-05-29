package com.space_distortion.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class MainRoomView extends SpaceActionEvent implements ViewIndex{

	private JFrame frame;
	private JButton RNum1Btn;
	
	public MainRoomView() {
			
	}
	
	
	public void init()
	{
	
		frame = new JFrame("main view");
		frame.setBounds(100, 100, 800, 800);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);	
		
	}
	
	public void mainView(SpaceController sc)
	{
		JPanel jp = new JPanel();
		jp.setBounds(100, 100, 800, 800);
		
		JButton btn1 = new JButton("1번 방");
		JButton btn2 = new JButton("2번 방");
		JButton btn3 = new JButton("종료");
		frame.getContentPane().add(jp);
		
		btn1.addMouseListener(new SpaceActionEvent(1, sc, jp));
		btn2.addMouseListener(new SpaceActionEvent(2, sc, jp));
		
		jp.add(btn1);
		jp.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

}
