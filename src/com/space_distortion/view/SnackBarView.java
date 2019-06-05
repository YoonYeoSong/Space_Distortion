package com.space_distortion.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.SnackBar;

// �г�1
class JPanelR01 extends JPanel implements ViewIndex{
	
	private SnackBarView sv;
	
	public JPanelR01(SnackBarView sv, SpaceController smc, int size) {
		
		// �ʱ� ����Ʈ ��ư ����
		JButton[] btn = new JButton[size];
		
		this.sv = sv;
		this.setLayout(new GridLayout(3,5));
		this.setBackground(Color.red);

		for (int i = 0; i < size; i++) {	// ��ü ����ŭ ��ư�� ����
			this.add(btn[i] = new JButton(i + "aaaaa"));
			btn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		}
		
	}
	
	
}
//�г�2
class JPanelR02 extends JPanel implements ViewIndex{
	
	private SnackBarView sv;
	
	public JPanelR02(SnackBarView sv, SpaceController smc, int size) {
		
		this.sv = sv;
		this.setLayout(new GridLayout(5,5));
		this.setBackground(Color.red);

	}
}

// ���� Ŭ��
public class SnackBarView implements ViewIndex{

	// ���� �Ǹ� ����Ʈ ��
	
	// ���۽� ������ list �� �ε�
	// 

	private JPanelR01 jp01 = null;
	private JPanelR02 jp02 = null;
	
	
	public void initialize(SpaceController smc, JFrame mainJFrame, List<SnackBar> list) {
		
	
		mainJFrame.setLayout(null);
		
		JPanel mainPl = new JPanel();
		mainPl.setBounds(0, 0, 800, 800);
		mainPl.setLayout(null);
		
		JPanel jpL = new JPanel();
		jpL.setBounds(0, 0, 180, 800);
		jpL.setLayout(null);
		
		JPanel jpD = new JPanel();
		jpD.setBounds(0, 500, 680, 200);
		jpD.setLayout(null);
		jpD.setBackground(Color.BLUE);
		
		JButton btnDrink = new JButton("drink");
		JButton btnSnack = new JButton("snack");
		JButton btnCancle = new JButton("cancle");
		JButton btnNext = new JButton("Next");
		
		btnDrink.setForeground(new Color(0,0,0));
		btnDrink.setFont(new Font("Ravie", Font.PLAIN, 20));
		btnDrink.setBounds(10, 30, 150, 50);
		
		btnSnack.setForeground(new Color(0,0,0));
		btnSnack.setFont(new Font("Ravie", Font.PLAIN, 20));
		btnSnack.setBounds(10, 80, 150, 50);
		
		btnCancle.setForeground(new Color(0,0,0));
		btnCancle.setFont(new Font("Ravie", Font.BOLD, 20));
		btnCancle.setBounds(30, 10, 150, 50);
		
		btnNext.setForeground(new Color(0,0,0));
		btnNext.setFont(new Font("Ravie", Font.BOLD, 20));
		btnNext.setBounds(180, 10, 150, 50);
		
		JTextArea jta = new JTextArea();
		
		
		
		jpL.add(btnDrink);
		jpL.add(btnSnack);
		
		// ����, ��� ��ư �̺�Ʈ
		btnCancle.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainPl));
		btnNext.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainPl));
		
		jpD.add(btnCancle);
		jpD.add(btnNext);
		
//		System.out.println("����Ʈ ������ :" + list.size());
		
		// ������ ���� �ٲ��� �г� 2�� ��ü ����
		jp01 = new JPanelR01(this, smc, list.size());
		jp01.setBounds(180, 10, 500, 500);
		jp02 = new JPanelR02(this, smc, list.size());
		jp02.setBounds(180, 10, 500, 500);
	
		
		
		mainPl.add(jpD);
		mainPl.add(jpL);
		mainPl.add(jp01);
		
		mainJFrame.add(mainPl);
		
		// ���� ��ư�� �г� ��ü
		btnDrink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smc.snackSel(2);	// ���� ��ü ��
				JButton[] btnDrinkArray = new JButton[list.size()];
				
				jp02.removeAll();	//	�ߺ� ���� �ʰ� �г��� ��ư�� Ŭ����
				mainJFrame.remove(jp01);	// �г� ��ü�� ���� �г��� ����
				jp02.setLayout(new GridLayout(3,2));
				
				for (int i = 0; i < list.size(); i++) {	// ��ü ����ŭ ��ư�� ����

//					jp02.add(btnDrinkArray[i] = new JButton(i + "aaaaa"));
					btnDrinkArray[i] = new JButton(i + "aaaaa");
					btnDrinkArray[i].setBounds(50, 50, 550, 550);
					btnDrinkArray[i].setLayout(null);
					jp02.add(btnDrinkArray[i]);
					btnDrinkArray[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));
				}
				
				mainJFrame.add(jp02);	// ������ �г��� �߰�

				jp02.revalidate();
				jp02.repaint();
//				mainJFrame.revalidate();
//				mainJFrame.repaint();
				
			}
		});

		// ���� ��ư �� �г� ��ü
		btnSnack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smc.snackSel(1);	// ���� ��ü ��
				JButton[] btnSnackArray = new JButton[list.size()];
				
//				System.out.println(list.size());
				jp01.removeAll();
				mainJFrame.remove(jp02);
//				System.out.println(jp01);
//				jp01.remove(jp01);
				jp01.setLayout(new GridLayout(3,2));
				for (int i = 0; i < list.size(); i++) {
//					System.out.println(btnSnackArray);
//					System.out.println(list.size());
//					System.out.println(i);
					btnSnackArray[i] = new JButton(i + "bbbbb");
					btnSnackArray[i].setBounds(50, 50, 550, 550);
					btnSnackArray[i].setLayout(null);
					jp01.add(btnSnackArray[i]);
					btnSnackArray[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));
				}
				jp01.setBackground(Color.green);
				mainJFrame.add(jp01);
				
				jp01.revalidate();
				jp01.repaint();
//				mainJFrame.revalidate();
//				mainJFrame.repaint();
				
			}
		});
		
		mainJFrame.revalidate();
		mainJFrame.repaint();
		
	}// init
	
	
	// ȭ�� ���� ��ħ
	public void jFrameClear() {
	
	}
		
		/*
		 *  ������ �ڵ�
		 */
		
		
//		list = smc.snackViewDidload();

//		smc.snackSel(1);
//		System.out.println(list);
//		smc.snackSel(2);
//		System.out.println(list);
		
		/*
		
		JPanel jpL = new JPanel();
		jpL.setBounds(0, 10, 150, 700);
		jpL.setLayout(null);
		
		JPanel jpR = new JPanel();
		jpR.setBounds(155, 10, 550, 700);
		jpR.setLayout(new GridLayout(5, 5));
		
		JButton btnDrink = new JButton("drink");
		JButton btnSnack = new JButton("snack");
		
		JButton btn;
		
		btnDrink.setForeground(new Color(0,0,0));
		btnDrink.setFont(new Font("Ravie", Font.PLAIN, 25));
		btnDrink.setBounds(10, 10, 150, 50);
		
		btnSnack.setForeground(new Color(0,0,0));
		btnSnack.setFont(new Font("Ravie", Font.PLAIN, 25));
		btnSnack.setBounds(10, 60, 150, 50);
		
		jpL.add(btnDrink);
		jpL.add(btnSnack);
		
		// ��ư ���ý� ��, ���� �̺�Ʈ
		btnDrink.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_DRINK_LEFT, smc, mainJFrame, jpR));
		btnSnack.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_SNACK_LEFT, smc, mainJFrame, jpR));
		
		
		*/
/////////////////////////////////////////////////////////////////////////////
//		list.add();
//		System.out.println(list);
		
		// 1 ����
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 1) {
//				System.out.println("���� =/= " + snack);
//			}
//		}
		
//		list = smc.snackSel();		// �⺻ ���ἱ������ ����
//		System.out.println(list.get(0));
		
//		System.out.println(list.get(0).getSnack());
//		System.out.println(((SnackBar)list).getSnackComment());
		
//		for (int i = 0; i < list.size(); i++) {
//			jpR.add( btn = new JButton(i + " " +list.get(i).getSnack()) );
//			btn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc, mainJFrame, jpR));
//		}

		
//		JButton btn1 = new JButton()

//		// 1 ����
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 1) {
//				System.out.println("���� / " + snack);
//			}
//		}
//		
//		// 2 ����
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 2) {
//				System.out.println("���� / " + snack);
//			}
//		}
//		
//		System.out.println("-- end --");
		
//		mainJFrame.add(jpR);
//		mainJFrame.add(jpL);
//		
//		jpR.revalidate();
//		jpR.repaint();
//		jpL.revalidate();
//		jpL.repaint();
//		
//		jpL.setVisible(true);
//		jpR.setVisible(true);
		
//	}//init
}
