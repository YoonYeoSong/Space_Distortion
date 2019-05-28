package com.space_distortion.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class AccountView extends JFrame{
	
	//회원가입
	//회원정보 입력
	//입력화면
	// AccountView는 두개로 나뉘어져있음

	private JFrame frame;
	private JTextField textFieldName;
	private JLabel lbl_Name;
	private JLabel label_Phone;
	private JTextField textField_Phone;
	private JLabel label_Create;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountView window = new AccountView();
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
	public AccountView ()  {
		initialize();
	}
	
	public void showThisView() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize () {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 729	, 758);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("회원 가입(Name,Phone)");
		frame.setResizable(false);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(37, 265, 291, 45);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		lbl_Name = new JLabel("Name");
		lbl_Name.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_Name.setForeground(Color.WHITE);
		lbl_Name.setBounds(37, 222, 134, 31);
		frame.getContentPane().add(lbl_Name);
		
		label_Phone = new JLabel("Phone Number");
		label_Phone.setForeground(Color.WHITE);
		label_Phone.setFont(new Font("Ravie", Font.PLAIN, 25));
		label_Phone.setBounds(37, 337, 255, 31);
		frame.getContentPane().add(label_Phone);
		
		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(37, 380, 291, 45);
		frame.getContentPane().add(textField_Phone);
		
		JButton btn_Home = new JButton("Home");
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn_Home.setForeground(Color.BLACK);
		btn_Home.setBounds(264, 533, 163, 45);
		frame.getContentPane().add(btn_Home);
		
		JButton btn_Next = new JButton("Next");
		btn_Next.setForeground(new Color(0, 0, 0));
		btn_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
		btn_Next.setBounds(264, 590, 163, 64);
		frame.getContentPane().add(btn_Next);
		
		label_Create = new JLabel("CREATE ACCOUNT");
		label_Create.setForeground(Color.BLACK);
		label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		label_Create.setBounds(37, 25, 251, 31);
		frame.getContentPane().add(label_Create);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
		lblNewLabel.setBounds(0, 0, 711, 711);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel Regi = new JPanel();
		Regi.setBounds(334, 25, 10, 10);
		frame.getContentPane().add(Regi);
		frame.setBounds(100, 100, 729	, 758);
	}
}
