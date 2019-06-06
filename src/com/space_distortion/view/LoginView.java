package com.space_distortion.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		jp.setBounds(0, 0, 1008, 729);
		jp.setLayout(null);
		 
		JLabel titleLb1 = new JLabel("SPACE");
		titleLb1.setFont(new Font("±¼¸²", Font.BOLD, 40));
		titleLb1.setBounds(419, 136, 169, 46);
				
		JLabel titleLb2 = new JLabel("DISTORITIONS");
		titleLb2.setFont(new Font("±¼¸²", Font.PLAIN, 35));
		titleLb2.setBounds(378, 209, 247, 46);
		
		JLabel titleLb3 = new JLabel("Login your account");
		titleLb3.setFont(new Font("±¼¸²", Font.BOLD, 31));
		titleLb3.setBounds(280, 298, 319, 46);
		
		JLabel idLb = new JLabel("E-Mail");
		idLb.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		idLb.setBounds(280, 354, 62, 36);
		
		
		JLabel pwLb = new JLabel("Password");
		pwLb.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		pwLb.setBounds(280, 439, 92, 36);
		
		final JTextField textField_ID = new JTextField();
		textField_ID.setBounds(280, 389, 436, 36);
		textField_ID.setColumns(10);
		
		 JPasswordField textField_PW = new JPasswordField();
	     textField_PW.setEchoChar('¡Ú');
	     textField_PW.setBounds(280, 475, 436, 36);
	     textField_PW.setColumns(10);
		

		JButton loginBtn1 = new JButton("Login");
		loginBtn1.setFont(new Font("±¼¸²", Font.PLAIN, 20));	
		loginBtn1.setBounds(526, 590, 190, 51);
		
		JButton btn_Register = new JButton("Register");		
		btn_Register.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btn_Register.setBounds(280, 590, 190, 51);
		
		
		JButton button_Skip = new JButton("Skip Registration");
		button_Skip.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		button_Skip.setBounds(349, 668, 290, 51);

		
		btn_Register.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 1, sc, mainJframe ,jp));
		button_Skip.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 2, sc, mainJframe ,jp));
		//loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 3, sc, mainJframe ,jp));
		
		
		jp.add(titleLb1);
		jp.add(titleLb2);
		jp.add(titleLb3);
		jp.add(idLb);
		jp.add(pwLb);
		jp.add(textField_PW);
		jp.add(textField_ID);
		
		
		
		jp.add(loginBtn1);
		jp.add(btn_Register);
		jp.add(button_Skip);
		
		
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);

		loginBtn1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String inputid = textField_ID.getText();
				String inputpw = textField_PW.getText();
				System.out.println(inputid+ " : " + inputpw);
				if(sc.logincheck(inputid, inputpw))
				{
					System.out.println(inputid + " : "  +inputpw);				
					loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 3, sc, mainJframe ,jp));
				}else
				{
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð ¶Ç´Â ÆÐ½º¿öµå°¡ Æ²·È½À´Ï´Ù."); 
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	
	
	
	
}
