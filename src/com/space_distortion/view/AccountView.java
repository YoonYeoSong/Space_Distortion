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
		
		// �гλ���
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 1008, 729);
		jp.setLayout(null);
		
		
		// ���� �Է¹��� textField����
		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(90, 440, 300, 36);
		textFieldName.setColumns(10);
		jp.add(textFieldName);
		
		JTextField textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(90, 540, 300, 36);
		jp.add(textField_Phone);
		
		
/* ����ϴ� label �� ����̹����� ����
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
		
		//��ư �̹��� ����
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
		

		
		//����̹��� - ������  JLabel���� ��� ����̹����� ���� �Ͽ��� 
		JLabel accBackground = new JLabel("");
		URL path = LoginView.class.getResource("acc1.png");
		accBackground.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/acc1.png")));
		accBackground.setBounds(0, 0, 1008, 728);
		jp.add(accBackground);
		
		
		// ��ư�� Ŭ�������� �̵��ϴ� �̺�Ʈ �Ű������δ� (�̺䰡 ����� �������,��ư ��� 2��,��Ʈ�ѷ� sc,����������,�����г�)
		btn_Home.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 1, sc, mainJframe, jp));
		btn_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 2, sc, mainJframe, jp));
		
		
		// �г�
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
		
		////// [btn_Next]Next��ư�� ���� �׼� ������
		//�Է� ���� ���� �����ϰ� AccountView2�� �Ѿ
		btn_Next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				String phone=textField_Phone.getText();
				String a="";
				
				
				//�ڸ��� ���� ,���� ��ҹ��� Phone�� ���ڸ�
				if(name.equals(a)) {
					JOptionPane.showMessageDialog(null, "Name�� �Է����ּ���.");
				} else if(phone.equals(a)) {
					JOptionPane.showMessageDialog(null, "Phone Number�� �Է����ּ���.");
				} else {
					
					sc.initMember(name, phone);

								
				}
				
			}
		});
	}
}