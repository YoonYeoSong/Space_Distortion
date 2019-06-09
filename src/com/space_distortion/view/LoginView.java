package com.space_distortion.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

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
		jp.setBounds(0, 0, 1024, 768);
		jp.setLayout(null);
		 
		// 배경이미지와 통합됨  label 
//		JLabel titleLb1 = new JLabel("SPACE");
//		titleLb1.setFont(new Font("굴림", Font.BOLD, 40));
//		titleLb1.setBounds(419, 136, 169, 46);

//		JLabel titleLb2 = new JLabel("DISTORITIONS");
//		titleLb2.setFont(new Font("굴림", Font.PLAIN, 35));
//		titleLb2.setBounds(378, 209, 247, 46);
	
//		JLabel titleLb3 = new JLabel("Login your account");
//		titleLb3.setFont(new Font("굴림", Font.BOLD, 31));
//		titleLb3.setBounds(280, 298, 319, 46);
		
//		JLabel idLb = new JLabel("E-Mail");
//		idLb.setFont(new Font("굴림", Font.PLAIN, 20));
//		idLb.setBounds(280, 354, 62, 36);
	
//		JLabel pwLb = new JLabel("Password");
//		pwLb.setFont(new Font("굴림", Font.PLAIN, 20));
//		pwLb.setBounds(280, 439, 92, 36);
		

		
		
		// 값을 입력받을 textField생성
		final JTextField textField_ID = new JTextField();
		textField_ID.setBounds(90, 440, 300, 36);
		textField_ID.setColumns(10);
		jp.add(textField_ID);
		
		JPasswordField textField_PW = new JPasswordField();
	    textField_PW.setEchoChar('★');
	    textField_PW.setBounds(90, 540, 300, 36);
	    textField_PW.setColumns(10);
		jp.add(textField_PW);
		
	    
	    // 병경된 버튼 이미지
	    // 로그인버튼
//		JButton loginBtn1 = new JButton("Login");
//		loginBtn1.setFont(new Font("굴림", Font.PLAIN, 20));	
//		loginBtn1.setBounds(526, 590, 190, 51);
		JButton loginBtn1 = new JButton("");
		loginBtn1.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/login1.png")));
		loginBtn1.setBorderPainted(false);
		loginBtn1.setBounds(250, 590, 140, 55);
		jp.add(loginBtn1);
		
		//회원가입 버튼
//		JButton btn_Register = new JButton("Register");		
//		btn_Register.setFont(new Font("굴림", Font.PLAIN, 20));
//		btn_Register.setBounds(320, 590, 190, 51);
		JButton btn_Register = new JButton("");
		btn_Register.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/register1.png")));
		btn_Register.setBorderPainted(false);
		btn_Register.setBounds(80, 590, 140, 55);
		jp.add(btn_Register);
		
		//스킵(비회원) 버튼
//		JButton button_Skip = new JButton("Skip Registration");
//		button_Skip.setFont(new Font("굴림", Font.PLAIN, 20));
//		button_Skip.setBounds(349, 668, 290, 51);
		JButton button_Skip = new JButton("");
		button_Skip.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/skip register1.png")));
		button_Skip.setBorderPainted(false);
		button_Skip.setBounds(130, 668, 210, 55);
		jp.add(button_Skip);
		
		
		//배경이미지
		JLabel lvBackground = new JLabel("");
		URL path = LoginView.class.getResource("loginview.png");
		lvBackground.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/loginview.png")));
		lvBackground.setBounds(0, 0, 1008, 728);
		jp.add(lvBackground);
		
		
		btn_Register.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 1, sc, mainJframe ,jp));
		button_Skip.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 2, sc, mainJframe ,jp));
		//loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 3, sc, mainJframe ,jp));
		

//		jp.add(titleLb1);
//		jp.add(titleLb2);
//		jp.add(titleLb3);
//		jp.add(idLb);
//		jp.add(pwLb);



		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);

		
		
		loginBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				URL memberPressed = this.getClass().getResource("Login2.png");
				loginBtn1.setIcon(new ImageIcon(memberPressed));
			
				String inputid = textField_ID.getText();
				String inputpw = textField_PW.getText();
				System.out.println(inputid+ " : " + inputpw);
				
				if(sc.logincheck(inputid, inputpw))
				{
					if(inputid.equals("admin") && inputpw.equals("1234"))
					{
						System.out.println(inputid + " : "  +inputpw);
						loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 4, sc, mainJframe ,jp));	
						
					}
					else
					{
						loginBtn1.addMouseListener(new SpaceActionEvent(LOGIN_VIEW, 3, sc, mainJframe ,jp));
					}

				}else
				{
					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 틀렸습니다."); 
				}
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL memberReleased = this.getClass().getResource("Login1.png");
				loginBtn1.setIcon(new ImageIcon(memberReleased));
			}
		});

		btn_Register.addMouseListener(new MouseAdapter() {
			//마우스버튼이 눌러졌을떄
			@Override
			public void mousePressed(MouseEvent e) {
				URL memberPressed = this.getClass().getResource("register2.png");
				btn_Register.setIcon(new ImageIcon(memberPressed));
			}
			
			// 마우스 버튼이 떼어질때
			@Override
			public void mouseReleased(MouseEvent e) {
				URL memberReleased = this.getClass().getResource("register1.png");
				btn_Register.setIcon(new ImageIcon(memberReleased));
			}
		});
		
		button_Skip.addMouseListener(new MouseAdapter() {
			//마우스버튼이 눌러졌을떄
			@Override
			public void mousePressed(MouseEvent e) {
				URL memberPressed = this.getClass().getResource("skip register2.png");
				button_Skip.setIcon(new ImageIcon(memberPressed));
			}
			
			// 마우스 버튼이 떼어질때
			@Override
			public void mouseReleased(MouseEvent e) {
				URL memberReleased = this.getClass().getResource("skip register1.png");
				button_Skip.setIcon(new ImageIcon(memberReleased));
			}
		});
		
	}
}