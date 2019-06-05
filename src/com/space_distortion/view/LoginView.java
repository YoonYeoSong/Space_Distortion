package com.space_distortion.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.main.Main;

import javax.swing.JPanel;

public class LoginView extends SpaceActionEvent implements ViewIndex {

	/**
	 * @wbp.parser.entryPoint
	 */
	public LoginView() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe)
	{
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 700, 700);
		jp.setLayout(null);
		 
		JLabel lbl_Space = new JLabel("space");
		lbl_Space.setForeground(new Color(0, 0, 0));
		//lbl_Space.setFont(new Font("Raavi", Font.PLAIN, 90));
		lbl_Space.setBounds(383, 175, 240, 125);
		
		JLabel lbl_Distortions = new JLabel("DISTORTIONS");
		lbl_Distortions.setForeground(new Color(0, 0, 0));
		//lbl_Distortions.setFont(new Font("Ravie", Font.BOLD, 40));
		lbl_Distortions.setBounds(123, 111, 373, 54);
		
		JLabel lbl_LoginYourAccount = new JLabel("Login your account");
		lbl_LoginYourAccount.setForeground(Color.BLACK);
		//lbl_LoginYourAccount.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lbl_LoginYourAccount.setBounds(76, 175, 256, 35);
		
		JLabel lbl_Email = new JLabel("E-Mail");
		//lbl_Email.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setBounds(156, 416, 88, 28);
		
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(Color.WHITE);
		//lbl_Password.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Password.setBounds(138, 473, 131, 28);
		
		JTextField textField_ID = new JTextField();
		textField_ID.setBounds(14, 380, 288, 35);
		textField_ID.setColumns(10);
		
		JTextField textFieldPW = new JTextField();
		textFieldPW.setBounds(50, 50, 100, 100);
		JPasswordField textField_PW = new JPasswordField();
		textField_PW.setBounds(14, 457, 288, 35);
		textField_PW.setColumns(10);
		
		JButton btn_Register = new JButton("Register");
		//btn_Register.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btn_Register.setForeground(new Color(0, 0, 0));
		btn_Register.setBounds(279, 535, 144, 54);
		
		JButton loginBtn1 = new JButton("Login");
		loginBtn1.setForeground(Color.BLACK);
		//loginBtn1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		loginBtn1.setBounds(229, 28, 144, 54);
		
		JButton button_Skip = new JButton("Skip Registration");
		button_Skip.setForeground(Color.BLACK);
		//button_Skip.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		button_Skip.setBounds(20, 30, 193, 40);

		
		loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 3, sc, mainJframe ,jp));
		button_Skip.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 2, sc, mainJframe ,jp));
		btn_Register.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 1, sc, mainJframe ,jp));
		
		
		jp.add(lbl_Space);
		jp.add(btn_Register);
		jp.add(textFieldPW);
		jp.add(textField_ID);
		jp.add(button_Skip);
		jp.add(loginBtn1);
		jp.add(textField_PW);
		jp.add(lbl_Password);
		jp.add(lbl_Email);
		jp.add(lbl_LoginYourAccount);
		jp.add(lbl_Distortions);
		
		
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);

		
		
		loginBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputid=textField_ID.getText();
				char[] inputpw=textField_PW.getPassword();
				
				sc.logincheck(inputid, inputpw);
				
			}
		});
		
	}
}
