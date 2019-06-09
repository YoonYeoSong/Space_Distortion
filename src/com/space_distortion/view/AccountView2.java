package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
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
	
	//ȸ������
		//ȸ������ �Է�
		//�Է�ȭ��
		// AccountView�� �ΰ��� ������������

		public AccountView2() {
		}
		
		public void initialize(SpaceController sc, JFrame mainJframe) {
		
			JPanel jp = new JPanel();
			jp.setBounds(0, 0, 1008, 728);
			jp.setLayout(null);
		
			
			//���� ����ϴ� label�� ����̹����� ����
//			JLabel lbl_EmailAdress = new JLabel("Email Adress");
//			lbl_EmailAdress.setForeground(Color.WHITE);
//			lbl_EmailAdress.setFont(new Font("Ravie", Font.PLAIN, 25));
//			lbl_EmailAdress.setBounds(43, 162, 221, 31);
			
//			JLabel lbl_PW = new JLabel("Password");
//			lbl_PW.setForeground(Color.WHITE);
//			lbl_PW.setFont(new Font("Ravie", Font.PLAIN, 25));
//			lbl_PW.setBounds(43, 274, 221, 31);
			
//			JLabel lbl_PW2 = new JLabel("Confirm Password");
//			lbl_PW2.setForeground(Color.WHITE);
//			lbl_PW2.setFont(new Font("Ravie", Font.PLAIN, 25));
//			lbl_PW2.setBounds(42, 386, 308, 31);
			
//			JLabel label_Create = new JLabel("CREATE ACCOUNT");
//			label_Create.setForeground(new Color(0, 0, 0));
//			label_Create.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
//			label_Create.setBounds(43, 29, 251, 31);
			
			
			// ���� �Է¹��� textField����
			JTextField textField_Email = new JTextField();
			textField_Email.setColumns(10);
			textField_Email.setBounds(90, 425, 291, 36);
			jp.add(textField_Email);

			JPasswordField textField_Pw = new JPasswordField();
			textField_Pw.setColumns(10);
			textField_Pw.setBounds(90, 502, 291, 36);
			jp.add(textField_Pw);
			
			JPasswordField textField_Pw2 = new JPasswordField();
			textField_Pw2.setColumns(10);
			textField_Pw2.setBounds(90, 575, 291, 36);
			jp.add(textField_Pw2);
			
			// �̸��� �ߺ�üũ
//			JButton button_EmailCheck = new JButton("Email Check");
//			button_EmailCheck.setForeground(Color.BLACK);
//			button_EmailCheck.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
//			button_EmailCheck.setBounds(305, 205, 150, 31);
			JButton button_EmailCheck = new JButton("");
			button_EmailCheck.setIcon(new ImageIcon(AccountView2.class.getResource("/com/space_distortion/view/doublecheck.png")));
			button_EmailCheck.setBorderPainted(false);
			button_EmailCheck.setBounds(400, 425, 96, 36);
			jp.add(button_EmailCheck);
	
			//��ư �̹��� ����
//			JButton button_Home = new JButton("Home");
//			button_Home.setForeground(Color.BLACK);
//			button_Home.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
//			button_Home.setBounds(263, 540, 163, 45);
			JButton button_Home = new JButton("");
			button_Home.setIcon(new ImageIcon(AccountView2.class.getResource("/com/space_distortion/view/home1.png")));
			button_Home.setBorderPainted(false);
			button_Home.setBounds(80, 630, 140, 55);
			jp.add(button_Home);
			
//			JButton button_Next = new JButton("Next");
//			button_Next.setForeground(Color.BLACK);
//			button_Next.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
//			button_Next.setBounds(263, 609, 163, 64);
			JButton button_Next = new JButton("");
			button_Next.setIcon(new ImageIcon(AccountView2.class.getResource("/com/space_distortion/view/next1.png")));
			button_Next.setBorderPainted(false);
			button_Next.setBounds(250, 630, 140, 55);
			jp.add(button_Next);
			
			
			// ����̹���
			JLabel accBackground = new JLabel("");
			URL path = LoginView.class.getResource("acc2.png");
			accBackground.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/acc2.png")));
			accBackground.setBounds(0, 0, 1008, 728);
			jp.add(accBackground);
			
			
			button_Home.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 1, sc, mainJframe ,jp));
			//button_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 2, sc, mainJframe ,jp));
			
		
		// �̸��� �ߺ�Ȯ�ο� ���� ����	
		button_EmailCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textField_Email.getText();
				System.out.println("����ڰ� ����� ���̵� : " + email);

				String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";

//					if(!(email.contains("@"))) {
//					JOptionPane.showMessageDialog(null, "�ùٸ� �̸��� ������ �ƴմϴ�.");

				String check = email;
				boolean emailcheck = check.matches(regex);
				if (emailcheck == false) {
					JOptionPane.showMessageDialog(null, "�ùٸ� �̸��� ������ �ƴմϴ�.");
				} else if (!(sc.emailCheck(email))) {
					JOptionPane.showMessageDialog(null, "��� ������ ���̵� �Դϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.");
				}

			}
		});
		
		// Next��ư�� ��������
		button_Next.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String pw = textField_Pw.getText();
				String pw2 = textField_Pw2.getText();
				String email=textField_Email.getText();
				String a="";

				boolean check=false;
				System.out.println("�Է��� �н����� ���� : "+pw.length());
				if(!(sc.emailCheck(email))==check) {
					JOptionPane.showMessageDialog(null, "email�ߺ��˻縦 ���ּ���.");
				} else if(email.equals(a)) {
					JOptionPane.showMessageDialog(null, "email�� �Է����ּ���.");
				} else if(6>pw.length()){
					JOptionPane.showMessageDialog(null, "�н������ 6�����̻����� �Է����ּ���.");						
				} else if(pw.equals(a)) {
					JOptionPane.showMessageDialog(null, "pw�� �Է����ּ���.");
				} else if(pw2.equals(a)) {
					JOptionPane.showMessageDialog(null, "pw2�� �Է����ּ���.");
				} else if(!(pw.equals(pw2))) {
					JOptionPane.showMessageDialog(null, "pw�� pw2�� ���� �ٸ��ϴ�.");
				} else {
					
					sc.initMember2(email, pw);
					button_Next.addMouseListener(new SpaceActionEvent(ACCOUNT_SUB_LOGIN_VIEW, 2, sc, mainJframe ,jp));
				}
			}
			
		});
			
//			jp.add(lblNewLabel);
//			jp.add(label_Create);
//			jp.add(lbl_PW2);
//			jp.add(lbl_PW);
//			jp.add(lbl_EmailAdress);
			
			mainJframe.add(jp);
			jp.revalidate();
			jp.repaint();
			jp.setVisible(true);
		}
}