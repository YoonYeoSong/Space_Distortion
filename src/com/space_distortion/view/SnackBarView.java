package com.space_distortion.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.SnackBar;


// ���� �г� ����
// �� �� �г� ����
// �� ��� ������ ��ư �г�
// �� �ϴ� : jlist, ��ư 2��

// ��
// �� ��� �� ->
// �� �ϴ� : ��Ż ���̺�(&&��), �ڷ�, ���� ��ư

public class SnackBarView implements ViewIndex{

	private JPanel leftTopIconPj;
	private JButton leftItemBtn[];
	private JPanel jSrpColumnpanel[];
	private JLabel leftItemLb[];
	private JPanel rightJp, rightMiJp;
	private JPanel rightTopPj;
	private int index = 1;	// jlist �ε���
	private List<SnackBar> snackOrderList;
	private Object rowData [][];
	private ImageIcon rightImage;
	private JScrollPane jSrp;
	private JComboBox<Integer> rightMiCombo;
	private JLabel rightMiLb;
//	private int snackSum = 1;
	
	
	public void initialize(SpaceController smc, JFrame mainJFrame, List<SnackBar> list) {

//		System.out.println("list size : " + list.size());
		rightImage = new ImageIcon("file:///Users/veso/eclipse-workspace/Space_Distortion/src/right_bg.png");
		
		mainJFrame.setLayout(null);

		// ������ ���� ���� �г�
		JPanel mainJp = new JPanel();
		mainJp.setBounds(0, 0, mainJFrame.getWidth(), mainJFrame.getHeight()); //(0,0,1024,768)
		mainJp.setLayout(null);

		//////////// �¿� �г� ����   ////////////
		// ���� �г�
		JPanel leftJp = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(rightImage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		leftJp.setBounds(0, 0, mainJp.getWidth()/2, mainJp.getHeight()); //(0,0,512,768)
		//leftJp.setBackground(Color.green);
		leftJp.setLayout(null);

		// ���� �г�
		rightJp = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(rightImage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		rightJp.setBounds(leftJp.getWidth(), 0, mainJp.getWidth()/2, mainJp.getHeight()); //(512,0,512,768)
		rightJp.setLayout(null);
//		rightJp.setBackground(Color.lightGray);
		
		
		//////////// ��� �г� ����   ////////////
		
		// ���� ��� �г�1
		leftTopIconPj = new JPanel();
//		leftTopIconPj.setBounds(0, 0, leftJp.getWidth()/2, leftJp.getHeight()/3);
		leftTopIconPj.setBorder(BorderFactory.createLineBorder(Color.red));

		// ��ũ�� �г� �߰�
		jSrp = new JScrollPane(leftTopIconPj);	// ��ũ�ѿ� �г��߰�
		jSrp.setBounds(leftJp.getWidth()/6, leftJp.getHeight()/7, leftJp.getWidth()/6 *4, (leftJp.getHeight()/7) * 3);
//		jSrp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		jSrp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 4 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		leftTopIconPj.setPreferredSize(new Dimension((120*list.size()), 100));		// ���� �г���  ����� ������ ���� (���� 600���� �þ�� , ���� 100����)
																					// ���� �г� ������ŭ ������ ��
		// ���� ��� ��ư �߰�(ȣ��)
		leftBtnInit(smc, list, index);

		// �� ��� �г� ����
		rightTopPj = new JPanel();
		rightTopPj.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7, rightJp.getWidth()/6 * 4, (rightJp.getHeight()/7) * 3);
		rightTopPj.setBackground(Color.cyan);
		rightTopPj.setLayout(new GridLayout());

		// �� ��� ���̺� ����

		String columnNames[] = {
				"��ǰ�̸�", "����", "��ǰ����"
		};

		DefaultTableModel dfTableModel = new DefaultTableModel(null, columnNames);
		JTable jTb = new JTable(dfTableModel);
		JScrollPane jScpane = new JScrollPane(jTb);

		rightTopPj.add(jScpane);

		// test �� ���� �߰�!
//		Object [] temporaryObject = { 4, "���ڼ���", 500};
//		dfTableModel.addRow(temporaryObject);

		//��� �� ���� ���ϱ�
//		System.out.println(dfTableModel.getRowCount());
//		System.out.println(dfTableModel.getColumnCount());

		//�÷�(��)�� index�� 0���� �����Ѵ�!!
//		System.out.println(dfTableModel.getColumnName(0));

		//0���� �����ϸ� �������� �����ϰ� ù°���� �����Ѵ�!!
//		dfTableModel.removeRow(0);

		//���� ���� ���� 0���� index�� ���۵ȴٴ� �Ϳ� �����Ѵ�!!
//		System.out.println(dfTableModel.getValueAt(2, 2));

		//Ư�� ��ǥ�� ���� �ٲٴ� ���� setValueAt()
//		dfTableModel.setValueAt("5000", 2, 2);

		//���̺� Row�� �̸� ������ ���·� �����!
//		jTb.setRowSelectionInterval(0, 0);

		//////////// �ϴ� �г� ����   ////////////
		
		// ���� �ϴ� �г�2
		JPanel leftMiPj = new JPanel();
		leftMiPj.setBounds(leftJp.getWidth()/6, leftJp.getHeight()/5 + jSrp.getHeight() - 15
		, jSrp.getWidth(), jSrp.getHeight() / 2);
//		leftMiPj.setBackground(Color.lightGray);
		leftMiPj.setLayout(null);

		// �� �ߴ� �г�2
		rightMiJp = new JPanel();
		rightMiJp.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7 + rightTopPj.getHeight()
				, rightTopPj.getWidth(), rightTopPj.getHeight()/4);
		rightMiJp.setLayout(null);
//		rightMiPj.setBackground(Color.orange);
		
		////// ���� ���̺� , ���� ��ư ����
		
		// �޺��ڽ� �׽�Ʈ
//		this.rightComboInit(smc);
		

		// �� �ϴ� �г�3
		JPanel rightBtPj = new JPanel();
		rightBtPj.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/4 + rightTopPj.getHeight() + 15
				, rightTopPj.getWidth(), rightTopPj.getHeight()/3 - 10);
		rightBtPj.setLayout(null);



		// ���� ��ư ���� �ϴ� (����, ����)
		JButton leftDrinkBtn = new JButton("Ȩ����");
		leftDrinkBtn.setBounds(0, (leftMiPj.getHeight()/5)*4, 100, 30);

		// ���� ��ư(�̺�Ʈ)
		leftDrinkBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainJp));

		// ���� ��ư ���� �ϴ� (�ڷΰ���, ����)
		JButton rightBackBtn = new JButton("���� ����");
		rightBackBtn.setBounds(30, 0, 100, 30);
		JButton rightNextBtn = new JButton("��  ��");
		rightNextBtn.setBounds(30, (rightMiJp.getHeight()/8)*5, 100, 30);
		
		// ���� ��ư(�̺�Ʈ)
		rightNextBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainJp));

		////////////////////////////////////////////////////////////////////////////////////
		// �Ľ�
		
		String[] fstr = smc.snackTitle();
//		System.out.println(fstr[1]);
		JList jlist = new JList(fstr);
//		char str = Character.toLowerCase('a');
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	// ���� ����
		jlist.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {

				// ����Ʈ�� �������� ������	
				String str = jlist.getSelectedValue().toString();
				// ���� ����Ʈ�� ������ �ε����� ����
				for(int i = 0; i < list.size(); i ++) {
					if(str.equals( list.get(i).getSnackKind() )) {
						index = list.get(i).getSnackBarIndex();
						leftBtnInit(smc, list, index);
						break;
					}

				}//for
			}
		});

		jlist.setVisibleRowCount(5);
		JScrollPane jsr = new JScrollPane(jlist);
		jsr.setBounds(10, 20, jSrp.getWidth()-20, leftMiPj.getHeight()/2);

		/*
		 *  �г� ��
		 */

		// ��ũ�� �߰�jSrp
		//leftJp.add(jSrp, BorderLayout.CENTER);
		leftJp.add(jSrp);
		leftMiPj.add(jsr);
		leftJp.add(leftMiPj);

		leftMiPj.add(leftDrinkBtn);
//		leftMiPj.add(leftSnackBtn);

		rightBtPj.add(rightBackBtn);
		rightBtPj.add(rightNextBtn);

		rightJp.add(rightTopPj);
		rightJp.add(rightMiJp);
		rightJp.add(rightBtPj);


		/////////////////////////////////////////////
		mainJp.add(leftJp);
		mainJp.add(rightJp);
		mainJFrame.add(mainJp);
		
		mainJp.revalidate();
		mainJp.repaint();

		mainJFrame.setDefaultCloseOperation(3);
		mainJFrame.setVisible(true);

	}
	
	
	//	���� �̹��� ��ư ����  
	public void leftBtnInit(SpaceController smc, List<SnackBar> list, int index) {
	
	list = smc.snackSel(index);

	leftTopIconPj.removeAll(); // ������ �ִ� �г��� ������ Ŭ����
//	if(rightMiJp == null) {
//		rightMiJp = new JPanel();
//	}
	
	leftItemBtn = new JButton[list.size()];	// ������ ������ŭ ũ�⸦ �����;���
	jSrpColumnpanel = new JPanel[list.size()];
	leftItemLb = new JLabel[list.size()];
	
	leftTopIconPj.setLayout(new GridLayout(3, 10, 10, 10));
//	leftTopIconPj.setPreferredSize(new Dimension(100,110));

//	jSrp.revalidate();
	leftTopIconPj.revalidate();
	leftTopIconPj.repaint();
	
//	int width = 0; // ��ũ�� ũ�⿡ ���� ������
	// ��ũ�� ���� �г� �߰�
//	System.out.println("������ : " + list.size());
	for (int i = 0; i < list.size(); i++) {
		
//		if(i != 0) width += 120;
		// �г� ����
		jSrpColumnpanel[i] = new JPanel();
		jSrpColumnpanel[i].setBackground(Color.blue);
//		jSrpColumnpanel[i].setBounds(0, 0, 90, 95);
		jSrpColumnpanel[i].setPreferredSize( new Dimension(90 , 95 ));
		jSrpColumnpanel[i].setLayout(null);
		

		// ���� �г��� ��ư ����
		leftItemBtn[i] = new JButton(list.get(i).getSnack() + " Image");
		leftItemBtn[i].setBounds(2, 2, 86, 75);
		
		leftItemBtn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		// ���� ���̺� ����
		leftItemLb[i] = new JLabel();
		leftItemLb[i].setText(list.get(i).getSnack() + "  " + list.get(i).getSnackPrice());
		leftItemLb[i].setBounds(2, 81, 86, 12);
		leftItemLb[i].setForeground(Color.orange);

		jSrpColumnpanel[i].add(leftItemBtn[i]);
		jSrpColumnpanel[i].add(leftItemLb[i]);
		leftTopIconPj.add(jSrpColumnpanel[i]);
		
//		System.out.println(width);
//		if (i == list.size()) {
//			System.out.println("������ ��ġ : " + jSrpColumnpanel[i].getX());				
//		}

		}// for
	}//leftBtnInit
	
	
	//	��ư���� ��ǰ ���ý� ���̺� �� ����
	public void rightTableInit(SpaceController smc) {

		rightTopPj.removeAll(); // ���̺� �ʱ�ȭ

		// �� ��� ���̺� ����
		String columnNames[] = {
				"��ǰ�̸�", "����", "��ǰ����"
		};

		snackOrderList = new ArrayList<SnackBar>();
		snackOrderList = smc.snackSelList();
//		snackOrderList.add(new SnackBar(1, "yyy", 44, 223332)); // �ӽ� �ڷ�

		rowData = new Object[snackOrderList.size()][columnNames.length];

		for (int i = 0; i < snackOrderList.size(); i++) {
			for (int j = 0; j < columnNames.length; j++) {
//				rowData [i][j] = i+1;
				rowData [i][j] = snackOrderList.get(i).getSnack();
				rowData [i][j+1] = snackOrderList.get(i).getSnackQty();
				rowData [i][j+2] = snackOrderList.get(i).getSnackPrice();
				break;
			}
		}
		
		DefaultTableModel dfTableModel = new DefaultTableModel(rowData, columnNames);
		JTable jTb = new JTable(dfTableModel);
		jTb.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {
				// ������
				JTable s = (JTable)e.getSource();
				int row = s.getSelectedRow();
				int col = s.getSelectedColumn();
//				System.out.println(s.getValueAt(row, col));
//				System.out.println(s.getValueAt(row, 1));
				int val = (Integer)(s.getValueAt(row, 1));
				String str = (String)s.getValueAt(row, 0);
//				System.out.println("val : " + val);
				rightComboInit(smc, val, row, str);
			}
		});
		JScrollPane jScpane = new JScrollPane(jTb);
		jScpane.revalidate();
		rightTopPj.add(jScpane);
		
		rightTopPj.revalidate();
		rightTopPj.repaint();
		
	}//rightTableInit
	
	
	public void rightComboInit(SpaceController smc, int val, int row, String str) {
		
		rightMiJp.removeAll();
		
		snackOrderList = new ArrayList<SnackBar>();
//		System.out.println(str);
		rightMiLb = new JLabel(str);
		rightMiLb.setBounds(10, 10, 100, 20);
		
		if(!rightMiLb.getText().equals(str))
			rightMiLb.setText(str);
		
		rightMiLb.setBackground(Color.red);
		
		// �޺� �ڽ� ������ ���� +1�� 0���� ���� ������
		Integer[] num = new Integer[val+1];
		for(int i = 0; i <= val; i++) {
			num[i] = i;
		}

		// �޺� �ڽ� ������ �ʱ�
		rightMiCombo =  new JComboBox<Integer>(num);
		rightMiCombo.setBounds(130, 10, 60, 30);
		rightMiCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("�޺� �̺�Ʈ �߻�");
				// �޺� �ڽ��������� 0 �ϰ�� ����
				snackOrderList = smc.snackSelList();
				smc.snackComboSelected(row, rightMiCombo.getSelectedItem().toString());
				int ix = (int)rightMiCombo.getSelectedItem();
				if( ix == 0) {
					snackOrderList.remove(row);
				}
				// ���õ� �������� �����ʹٽ� ���
				rightTopPj.removeAll();
				rightTableInit(smc);
				
			}
		});
		
		rightMiJp.add(rightMiLb);
		rightMiJp.add(rightMiCombo);
		
		rightMiJp.revalidate();
		rightMiJp.repaint();
		
	}// rightComboInit
	
	// ��ư ���ý� �޺��ڽ� ���� & ���� 
	public void rightComboDel(SpaceController smc) {
		
		if(rightMiJp != null) {
			rightMiJp.removeAll();
			rightMiJp.revalidate();
			rightMiJp.repaint();
		}
	}//rightComboDel

	
	
} //class




















/*
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
		
		
		 //  ������ �ڵ�
		 
		
		
//		list = smc.snackViewDidload();

//		smc.snackSel(1);
//		System.out.println(list);
//		smc.snackSel(2);
//		System.out.println(list);
		
		
		
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


*/
