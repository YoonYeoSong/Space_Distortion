package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.KeyRep;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;

public class AccountView2 extends SpaceActionEvent implements ViewIndex {

	private JFrame mainJframe;
	
	//회원가입
		//회원정보 입력
		//입력화면
		// AccountView는 두개로 나뉘어져있음

		public AccountView2() {
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * Initialize the contents of the frame.
		 */
		public void initialize(SpaceController sc, JFrame mainJframe) {
		
			JPanel jp = new JPanel();
			jp.setBounds(10, 10, 700, 700);
			jp.setLayout(null);
		
			JLabel lbl_EmailAdress = new JLabel("Email Adress");
			lbl_EmailAdress.setForeground(Color.WHITE);
			lbl_EmailAdress.setFont(new Font("Ravie", Font.PLAIN, 25));
			lbl_EmailAdress.setBounds(43, 162, 221, 31);
			
			JTextField textField_Email = new JTextField();
			textField_Email.setColumns(10);
			textField_Email.setBounds(43, 205, 291, 45);

			
			JButton button_EmailCheck = new JButton("Email Check");
			button_EmailCheck.setForeground(Color.BLACK);
			button_EmailCheck.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
			button_EmailCheck.setBounds(305, 205, 150, 31);
	
			JLabel lbl_PW = new JLabel("Password");
			lbl_PW.setForeground(Color.WHITE);
			lbl_PW.setFont(new Font("Ravie", Font.PLAIN, 25));
			lbl_PW.setBounds(43, 274, 221, 31);
			
			JPasswordField textField_Pw = new JPasswordField();
			textField_Pw.setColumns(10);
			textField_Pw.setBounds(43, 317, 291, 45);

			JLabel lbl_PW2 = new JLabel("Confirm Password");
			lbl_PW2.setForeground(Color.WHITE);
			lbl_PW2.setFont(new Font("Ravie", Font.PLAIN, 25));
			lbl_PW2.setBounds(42, 386, 308, 31);
			
			JPasswordField textField_Pw2 = new JPasswordField();
			textField_Pw2.setColumns(10);
			textField_Pw2.setBounds(43, 429, 291, 45);
			
			JButton button_Home = new JButton("Home");
			button_Home.setForeground(Color.BLACK);
			button_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
			button_Home.setBounds(263, 540, 163, 45);
			
			JButton button_Next = new JButton("Next");
			button_Next.setForeground(Color.BLACK);
			button_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
			button_Next.setBounds(263, 609, 163, 64);
			
			JLabel label_Create = new JLabel("CREATE ACCOUNT");
			label_Create.setForeground(new Color(0, 0, 0));
			label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
			label_Create.setBounds(43, 29, 251, 31);
			
			//URL path = AccountView.class.getResource("");
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
			lblNewLabel.setBounds(0, -18, 711, 729);
			
			button_Home.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 1, sc, mainJframe ,jp));
			
			//button_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 2, sc, mainJframe ,jp));
			
			
			
			
		button_EmailCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textField_Email.getText();
				System.out.println("사용자가 사용할 아이디 : " + email);

				String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";

//					if(!(email.contains("@"))) {
//					JOptionPane.showMessageDialog(null, "올바른 이메일 형식이 아닙니다.");

				String check = email;
				boolean emailcheck = check.matches(regex);
				if (emailcheck == false) {
					JOptionPane.showMessageDialog(null, "올바른 이메일 형식이 아닙니다.");
				} else if (!(sc.emailCheck(email))) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
				}

			}
		});
		
		button_Next.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String pw = textField_Pw.getText();
				String pw2 = textField_Pw2.getText();
				String email=textField_Email.getText();
				String a="";

				
				System.out.println("입력한 패스워드 길이 : "+pw.length());
				
				if(email.equals(a)) {
					JOptionPane.showMessageDialog(null, "email을 입력해주세요.");
				} else if(6>=pw.length()){
					JOptionPane.showMessageDialog(null, "패스워드는 6글자이상으로 입력해주세요.");						
				} else if(pw.equals(a)) {
					JOptionPane.showMessageDialog(null, "pw을 입력해주세요.");
				} else if(pw2.equals(a)) {
					JOptionPane.showMessageDialog(null, "pw2을 입력해주세요.");
				} else if(!(pw.equals(pw2))) {
					JOptionPane.showMessageDialog(null, "pw와 pw2가 서로 다릅니다.");
				} else {
					
					sc.initMember2(email, pw);
					button_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 2, sc, mainJframe ,jp));
				}
			}
			
		});
			
			jp.add(lblNewLabel);
			jp.add(label_Create);
			jp.add(button_Next);
			jp.add(button_Home);
			jp.add(textField_Pw2);
			jp.add(lbl_PW2);
			jp.add(textField_Pw);
			jp.add(lbl_PW);
			jp.add(lbl_EmailAdress);
			jp.add(button_EmailCheck);
			jp.add(textField_Email);
			
			mainJframe.add(jp);
			jp.revalidate();
			jp.repaint();
			jp.setVisible(true);
//			mainJframe.setVisible(true);
			
			/*
			button_EmailCheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					String email = textField_Email.getText();
					sc.emailCheck(email);
				}
			});
			*/

		}
}