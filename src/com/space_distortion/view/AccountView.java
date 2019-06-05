package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 700, 700);
		jp.setLayout(null);
		
		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(37, 265, 291, 45);
		textFieldName.setColumns(10);
		
		JLabel lbl_Name = new JLabel("Name");
		lbl_Name.setFont(new Font("Ravie", Font.PLAIN, 25));
		lbl_Name.setForeground(Color.WHITE);
		lbl_Name.setBounds(37, 222, 134, 31);
		
		JLabel label_Phone = new JLabel("Phone Number");
		label_Phone.setForeground(Color.WHITE);
		label_Phone.setFont(new Font("Ravie", Font.PLAIN, 25));
		label_Phone.setBounds(37, 337, 255, 31);
		
		JTextField textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(37, 380, 291, 45);
		
		JButton btn_Home = new JButton("Home");
		btn_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn_Home.setForeground(Color.BLACK);
		btn_Home.setBounds(264, 533, 163, 45);
		
		JButton btn_Next = new JButton("Next");
		btn_Next.setForeground(new Color(0, 0, 0));
		btn_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
		btn_Next.setBounds(264, 590, 163, 64);
		
		JLabel label_Create = new JLabel("CREATE ACCOUNT");
		label_Create.setForeground(Color.BLACK);
		label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		label_Create.setBounds(37, 25, 251, 31);
		
		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TaeYeop\\Desktop\\\uCC45 \uBC30\uAC38\u3155\u31472.jpg"));
		lblNewLabel.setBounds(0, 0, 711, 711);
		
		jp.setBounds(334, 25, 10, 10);
		jp.setBounds(100, 100, 729	, 758);
		
		
		btn_Home.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 1, sc, mainJframe, jp));
		// ��ư�� Ŭ�������� �̵��ϴ� �̺�Ʈ �Ű������δ� (�̺䰡 ����� �������,��ư ��� 2��,��Ʈ�ѷ� sc,����������,�����г�)
		btn_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_VIEW_NUM, 2, sc, mainJframe, jp));
		
		
		////// �гο� �߰�
		jp.add(textFieldName);
		jp.add(lbl_Name);
		jp.add(lblNewLabel);
		jp.add(label_Create);
		jp.add(btn_Next);
		jp.add(btn_Home);
		jp.add(label_Phone);
		jp.add(textField_Phone);

		//mainJframe.setContentPane(jp);
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		jp.setVisible(true);
//		mainJframe.setVisible(true);
		
		////// [btn_Next]Next��ư�� ���� �׼� ������
		//�Է� ���� ���� �����ϰ� AccountView2�� �Ѿ���Ѵ�.
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
