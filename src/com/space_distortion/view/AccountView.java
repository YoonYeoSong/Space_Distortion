package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;

public class AccountView extends SpaceActionEvent implements ViewIndex{
	

	public AccountView ()  {

	}

	public void initialize(SpaceController sc, JFrame mainJframe) {
		
		// 패널생성
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 1008, 729);
		jp.setLayout(null);
		
		
		// 값을 입력받을 textField생성
		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(90, 440, 300, 36);
		textFieldName.setColumns(10);
		jp.add(textFieldName);
		
		JTextField textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(90, 540, 300, 36);
		jp.add(textField_Phone);
		
		
/* 사용하던 label 을 배경이미지와 통합
		JLabel lbl_Name = new JLabel("Name");
		lbl_Name.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_Name.setForeground(Color.WHITE);
		lbl_Name.setBounds(37, 222, 134, 31);

		JLabel label_Phone = new JLabel("Phone Number");
		label_Phone.setForeground(Color.WHITE);
		label_Phone.setFont(new Font("Ravie", Font.PLAIN, 25));
		label_Phone.setBounds(37, 337, 255, 31);
		
		JLabel label_Create = new JLabel("CREATE ACCOUNT");
		label_Create.setForeground(Color.BLACK);
		label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		label_Create.setBounds(37, 25, 251, 31);
*/
		
		//버튼 이미지 변경
//		JButton btn_Home = new JButton("Home");
//		btn_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
//		btn_Home.setForeground(Color.BLACK);
//		btn_Home.setBounds(264, 533, 163, 45);
		JButton btn_Home = new JButton("");
		btn_Home.setIcon(new ImageIcon(AccountView.class.getResource("/com/space_distortion/view/home1.png")));
		btn_Home.setBorderPainted(false);
		btn_Home.setBounds(80, 590, 140, 55);
		jp.add(btn_Home);
		
		
//		JButton btn_Next = new JButton("Next");
//		btn_Next.setForeground(new Color(0, 0, 0));
//		btn_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
//		btn_Next.setBounds(264, 590, 163, 64);
		JButton btn_Next = new JButton("");
		btn_Next.setIcon(new ImageIcon(AccountView.class.getResource("/com/space_distortion/view/next1.png")));
		btn_Next.setBorderPainted(false);
		btn_Next.setBounds(250, 590, 140, 55);
		jp.add(btn_Next);
		

		
		//배경이미지 - 기존의  JLabel들을 모두 배경이미지로 통합 하였음 
		JLabel accBackground = new JLabel("");
		URL path = LoginView.class.getResource("acc1.png");
		accBackground.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/acc1.png")));
		accBackground.setBounds(0, 0, 1008, 728);
		jp.add(accBackground);
		
		
		// 버튼이 클릭됬을때 이동하는 이벤트 매개변수로는 (이뷰가 몇번의 어떤뷰인지,버튼 몇번 2번,컨트롤러 sc,메인프레임,메인패널)
		btn_Home.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 1, sc, mainJframe, jp));
		btn_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 2, sc, mainJframe, jp));
		
		
		// 패널
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);
		
		
//		jp.add(lbl_Name);
//		jp.add(lblNewLabel);
//		jp.add(label_Create);
//		jp.add(btn_Next);
//		jp.add(btn_Home);
//		jp.add(label_Phone);

		//mainJframe.setContentPane(jp);
//		mainJframe.setVisible(true);
		
		////// [btn_Next]Next버튼에 대한 액션 리스너
		//입력 받은 값을 저장하고 AccountView2로 넘어감
		btn_Next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				String phone=textField_Phone.getText();
				String a="";
				
				
				//자릿수 제한 ,영문 대소문자 Phone은 숫자만
				if(name.equals(a)) {
					JOptionPane.showMessageDialog(null, "Name을 입력해주세요.");
				} else if(phone.equals(a)) {
					JOptionPane.showMessageDialog(null, "Phone Number를 입력해주세요.");
				} else {
					
					sc.initMember(name, phone);

								
				}
				
			}
		});
	}
}