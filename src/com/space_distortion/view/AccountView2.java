package com.space_distortion.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class AccountView2 {

	//회원가입
		//회원정보 입력
		//입력화면
		// AccountView는 두개로 나뉘어져있음
	
	private JFrame frame;
	private JTextField textField_Email;
	private JTextField textField_Pw;
	private JTextField textField_Pw2;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountView2 window = new AccountView2();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AccountView2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729	, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("회원 가입(Email,Pw)");
		frame.setResizable(false);
		
		JLabel lbl_EmailAdress = new JLabel("Email Adress");
		lbl_EmailAdress.setForeground(Color.WHITE);
		lbl_EmailAdress.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_EmailAdress.setBounds(43, 162, 221, 31);
		frame.getContentPane().add(lbl_EmailAdress);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(43, 205, 291, 45);
		frame.getContentPane().add(textField_Email);
		
		JLabel lbl_PW = new JLabel("Password");
		lbl_PW.setForeground(Color.WHITE);
		lbl_PW.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_PW.setBounds(43, 274, 221, 31);
		frame.getContentPane().add(lbl_PW);
		
		textField_Pw = new JTextField();
		JPasswordField textField_Pw = new JPasswordField();
		textField_Pw.setColumns(10);
		textField_Pw.setBounds(43, 317, 291, 45);
		frame.getContentPane().add(textField_Pw);
		
		JLabel lbl_PW2 = new JLabel("Confirm Password");
		lbl_PW2.setForeground(Color.WHITE);
		lbl_PW2.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_PW2.setBounds(42, 386, 308, 31);
		frame.getContentPane().add(lbl_PW2);
		
		textField_Pw2 = new JTextField();
		JPasswordField textField_Pw2 = new JPasswordField();
		textField_Pw2.setColumns(10);
		textField_Pw2.setBounds(43, 429, 291, 45);
		frame.getContentPane().add(textField_Pw2);
		
		JButton button_Home = new JButton("Home");
		button_Home.setForeground(Color.BLACK);
		button_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		button_Home.setBounds(263, 540, 163, 45);
		frame.getContentPane().add(button_Home);
		
		JButton button_Next = new JButton("Next");
		button_Next.setForeground(Color.BLACK);
		button_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
		button_Next.setBounds(263, 609, 163, 64);
		frame.getContentPane().add(button_Next);
		
		JLabel label_Create = new JLabel("CREATE ACCOUNT");
		label_Create.setForeground(new Color(0, 0, 0));
		label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		label_Create.setBounds(43, 29, 251, 31);
		frame.getContentPane().add(label_Create);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
		lblNewLabel.setBounds(0, -18, 711, 729);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel Regi2 = new JPanel();
		Regi2.setBounds(324, 29, 10, 10);
		frame.getContentPane().add(Regi2);
	}
}
