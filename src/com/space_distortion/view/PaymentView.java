package com.space_distortion.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class PaymentView extends SpaceActionEvent implements ViewIndex {

	// �� ���� ������ �����ִ�
		// ȸ������ȭ������ ���ư��� �̺�Ʈ
		// ���� �̺�Ʈ
		
		//�����̺�Ʈ�� ���������� �������� ī������ �Ǻ��� ����
		public PaymentView() {
			// TODO Auto-generated constructor stub
		}
		
		public void initialize(SpaceController sc, JFrame mainJframe) {
			
			JPanel jp = new JPanel();
			
			jp.setBounds(10, 10, 500, 500);
			jp.setLayout(null);
			
			JButton btn1 = new JButton("����");
			btn1.setForeground(new Color(0,0,0));
			btn1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
			btn1.setBounds(10, 10, 250, 30);
			
			JButton btn2 = new JButton("ȸ�� ����");
			btn2.setForeground(new Color(0,0,0));
			btn2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
			btn2.setBounds(btn1.getWidth() + 20, 10, 250, 30);
			
			JButton btn3 = new JButton("Ȩ����");
			btn3.setForeground(new Color(0,0,0));
			btn3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
			btn3.setBounds(btn2.getWidth() + 20, 10, 250, 30);
			
			btn1.addMouseListener(new SpaceActionEvent(PAYMENT_VIEW_NUM, 1, sc, mainJframe ,jp));
			btn2.addMouseListener(new SpaceActionEvent(PAYMENT_VIEW_NUM, 2, sc, mainJframe ,jp));
			btn3.addMouseListener(new SpaceActionEvent(PAYMENT_VIEW_NUM, 3, sc, mainJframe ,jp));
			
			jp.add(btn1);
			jp.add(btn2);
			jp.add(btn3);
			jp.setVisible(true);
			
			//mainJframe.setContentPane(jp);
			mainJframe.add(jp);
			mainJframe.revalidate();
			mainJframe.repaint();
			
//			mainJframe.setVisible(true);
			
		}
}
