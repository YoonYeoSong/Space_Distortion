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

	private JLabel lbl_Space;
	
	private JTextField textField_ID;
	private JTextField textFieldPW;	
	private JButton btn_Register; // 회원가입	
	
	SpaceController sc = Main.getSpaceController();

	
	public static void main(String[] args) {

	}

	
	public LoginView() {

	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void loginView(SpaceController sc)
	{
		JPanel jp = new JPanel();
		Container con = sc.getJframe().getContentPane();
		con.add(jp);
		jp.setBounds(100, 100, 800, 800);
		jp.setLayout(null);
		
		lbl_Space = new JLabel("space");
		lbl_Space.setForeground(new Color(0, 0, 0));
		lbl_Space.setFont(new Font("Raavi", Font.PLAIN, 90));
		lbl_Space.setBounds(383, 175, 240, 125);
		
		jp.add(lbl_Space);
		//sc.getJframe().getContentPane().add(lbl_Space);
		
		JLabel lbl_Distortions = new JLabel("DISTORTIONS");
		lbl_Distortions.setForeground(new Color(0, 0, 0));
		lbl_Distortions.setFont(new Font("Ravie", Font.BOLD, 40));
		lbl_Distortions.setBounds(123, 111, 373, 54);
		//sc.getJframe().getContentPane().add(lbl_Distortions);
		jp.add(lbl_Distortions);
		
		JLabel lbl_LoginYourAccount = new JLabel("Login your account");
		lbl_LoginYourAccount.setForeground(Color.BLACK);
		lbl_LoginYourAccount.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lbl_LoginYourAccount.setBounds(76, 175, 256, 35);
		//sc.getJframe().getContentPane().add(lbl_LoginYourAccount);
		jp.add(lbl_LoginYourAccount);
		
		JLabel lbl_Email = new JLabel("E-Mail");
		lbl_Email.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setBounds(156, 416, 88, 28);
		//sc.getJframe().getContentPane().add(lbl_Email);
		jp.add(lbl_Email);
		
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(Color.WHITE);
		lbl_Password.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Password.setBounds(138, 473, 131, 28);
		//sc.getJframe().getContentPane().add(lbl_Password);
		jp.add(lbl_Password);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(14, 380, 288, 35);
		textField_ID.setColumns(10);
		jp.add(lbl_LoginYourAccount);
		//sc.getJframe().getContentPane().add(textField_ID);
		
		textFieldPW = new JTextField();
		textFieldPW.setBounds(50, 50, 100, 100);
		JPasswordField textField_PW = new JPasswordField();
		textField_PW.setBounds(14, 457, 288, 35);
		textField_PW.setColumns(10);
		//sc.getJframe().getContentPane().add(textField_PW);
		jp.add(textFieldPW);
		
		btn_Register = new JButton("Register");
		btn_Register.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btn_Register.setForeground(new Color(0, 0, 0));
		btn_Register.setBounds(279, 535, 144, 54);
		//sc.getJframe().getContentPane().add(btn_Register);
		jp.add(btn_Register);
		
		JButton loginBtn1 = new JButton("Login");
		loginBtn1.addMouseListener(new SpaceActionEvent(1, sc, jp));
		loginBtn1.setForeground(Color.BLACK);
		loginBtn1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		loginBtn1.setBounds(229, 28, 144, 54);
		//sc.getJframe().getContentPane().add(loginBtn1);
		jp.add(loginBtn1);
		
		
//		JButton button_Log = new JButton("Login");
//		button_Log.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		//button_Log.setForeground(Color.BLACK);
		//button_Log.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		//button_Log.setBounds(168, 526, 127, 40);
		//sc.getJframe().getContentPane().add(button_Log);
		
		JButton button_Skip = new JButton("Skip Registration");
		button_Skip.setForeground(Color.BLACK);
		button_Skip.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		button_Skip.setBounds(20, 30, 193, 40);
		//sc.getJframe().getContentPane().add(button_Skip);
		jp.add(button_Skip);
		
//		JLabel image = new JLabel("New label");
//		image.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
//		image.setBounds(0, 0, 723, 723);
		//sc.getJframe().getContentPane().add(image);
		
		//sc.getJframe().getContentPane().add(jp);
		sc.getJframe().getContentPane().add(con);
		//jp.setVisible(true);
		
		con.setVisible(true);

	}
}
