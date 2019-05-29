package com.space_distortion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.space_distortion.event.SpaceActionEvent;

import javax.swing.JButton;

public class MainRoomView extends SpaceActionEvent {

	private JPanel contentPane;
	private JFrame frame;
	private JButton RNum1Btn;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainRoomView frame = new MainRoomView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	/**
	 * Create the frame.
	 */
	
	public MainRoomView() {
		frame = new JFrame();
		initialize();
	}
	
	public void showMainView()
	{
		frame.setVisible(true);
	}
	
	public void initialize()
	{
		//frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 614, 530);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//프레임 생성
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton RNum1Btn = new JButton("1\uBC88\uBC29");
		RNum1Btn.setBounds(12, 120, 97, 23);
		contentPane.add(RNum1Btn);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

}
