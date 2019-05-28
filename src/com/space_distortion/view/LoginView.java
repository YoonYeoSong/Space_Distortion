package com.space_distortion.view;

import java.awt.Color;
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
import javax.swing.JPanel;

public class LoginView extends JFrame {

	private JFrame frame;
	private JTextField textField_ID;
	private JTextField textFieldPW;
	private JButton btn_Register;
	private AccountView accountView = new AccountView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setTitle("로그인 창");
		frame.setResizable(false);

		JLabel lbl_Space = new JLabel("space");
		lbl_Space.setForeground(new Color(0, 0, 0));
		lbl_Space.setFont(new Font("Raavi", Font.PLAIN, 90));
		lbl_Space.setBounds(90, 12, 368, 151);
		frame.getContentPane().add(lbl_Space);

		JLabel lbl_Distortions = new JLabel("DISTORTIONS");
		lbl_Distortions.setForeground(new Color(0, 0, 0));
		lbl_Distortions.setFont(new Font("Ravie", Font.BOLD, 40));
		lbl_Distortions.setBounds(70, 145, 375, 88);
		frame.getContentPane().add(lbl_Distortions);

		JLabel lbl_LoginYourAccount = new JLabel("Login your account");
		lbl_LoginYourAccount.setForeground(Color.BLACK);
		lbl_LoginYourAccount.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lbl_LoginYourAccount.setBounds(14, 290, 301, 35);
		frame.getContentPane().add(lbl_LoginYourAccount);

		JLabel lbl_Email = new JLabel("E-Mail");
		lbl_Email.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setBounds(14, 350, 126, 18);
		frame.getContentPane().add(lbl_Email);

		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(Color.WHITE);
		lbl_Password.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbl_Password.setBounds(14, 427, 144, 18);
		frame.getContentPane().add(lbl_Password);

		textField_ID = new JTextField();
		textField_ID.setBounds(14, 380, 288, 35);
		frame.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);

		textFieldPW = new JTextField();
		JPasswordField textField_PW = new JPasswordField();
		textField_PW.setBounds(14, 457, 288, 35);
		frame.getContentPane().add(textField_PW);
		textField_PW.setColumns(10);

		btn_Register = new JButton("Register");
		btn_Register.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btn_Register.setForeground(new Color(0, 0, 0));
		btn_Register.setBounds(14, 526, 127, 40);
		frame.getContentPane().add(btn_Register);

		JButton button_Log = new JButton("Login");
		button_Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_Log.setForeground(Color.BLACK);
		button_Log.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		button_Log.setBounds(168, 526, 127, 40);
		frame.getContentPane().add(button_Log);

		JButton button_Skip = new JButton("Skip Registration");
		button_Skip.setForeground(Color.BLACK);
		button_Skip.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		button_Skip.setBounds(57, 609, 193, 40);
		frame.getContentPane().add(button_Skip);

		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
		image.setBounds(0, 0, 723, 723);
		frame.getContentPane().add(image);

		JPanel Login = new JPanel();
		Login.setBounds(329, 12, 10, 10);
		frame.getContentPane().add(Login);

		button_Log.addActionListener(new ActionListener() {

			//////////////////
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "abcd";
				String pass = "1234";

				if (id.equals(textField_ID.getText()) && pass.equals(textField_PW.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				} else {
					JOptionPane.showMessageDialog(null, "비번 틀림 수고링");
				}
			}
		});
		setRegisterButton();
	}
	
	// 
	public void setRegisterButton() {
		btn_Register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				accountView.showThisView();
			}
		});
	}
}
