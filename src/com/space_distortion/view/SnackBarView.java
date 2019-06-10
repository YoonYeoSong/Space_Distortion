package com.space_distortion.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.border.LineBorder;
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
	private ImageIcon rightImage, leftImage;
	private JScrollPane jSrp;
	private JComboBox<Integer> rightMiCombo;
	private JLabel rightMiLb;
//	private int snackSum = 1;
	
	
	public void initialize(SpaceController smc, JFrame mainJFrame, List<SnackBar> list) {

		System.out.println("list size : " + list.size());
		rightImage = new ImageIcon(this.getClass().getResource("right_bg.png"));
		
		mainJFrame.setLayout(null);

		// ������ ���� ���� �г�
		JPanel mainJp = new JPanel();
		mainJp.setBounds(0, 0, mainJFrame.getWidth(), mainJFrame.getHeight()); //(0,0,1024,768)
		mainJp.setLayout(null);
		
		// Ÿ��Ʋ ���̺�
		JLabel titleLb = new JLabel("SNACK");
		titleLb.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		titleLb.setBounds(90, 45, 500, 50);
		mainJp.add(titleLb);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBorder(new LineBorder(Color.GRAY));
		lblNewLabel_5.setBounds(85, 95, 335, 2);
		mainJp.add(lblNewLabel_5);
		

		//////////// �¿� �г� ����   ////////////
		// ���� �г�
		leftImage = new ImageIcon(this.getClass().getResource("bgImg_2.png"));
		JPanel leftJp = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(leftImage.getImage(), 0, 0, null);
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
		leftTopIconPj.setBorder(BorderFactory.createLineBorder(Color.gray));

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
//		rightTopPj.setBackground(Color.cyan);
		rightTopPj.setBorder(BorderFactory.createLineBorder(Color.gray));
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
//		leftMiPj.setBackground(Color.white);
		leftMiPj.setBorder(BorderFactory.createLineBorder(Color.gray));
		leftMiPj.setLayout(null);

		// �� �ߴ� �г�2
		rightMiJp = new JPanel();
		rightMiJp.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7 + rightTopPj.getHeight() + 10
				, rightTopPj.getWidth(), rightTopPj.getHeight()/4);
		rightMiJp.setBorder(BorderFactory.createLineBorder(Color.gray));
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
		URL menuBackpath = this.getClass().getResource("next.png");
		leftDrinkBtn.setIcon(new ImageIcon(menuBackpath));
		leftDrinkBtn.setBounds(5, (leftMiPj.getHeight()/5)*4 - 20, 330, 50);

		// ���� ��ư(�̺�Ʈ)
		leftDrinkBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainJp));

		// ���� ��ư ���� �ϴ� (�ڷΰ���, ����)
		JButton rightBackBtn = new JButton("���� ����");
		rightBackBtn.setBounds(30, 0, 100, 30);
		rightBackBtn.setVisible(false);
		URL menuBackpath1 = this.getClass().getResource("pay_now.png");
		JButton rightNextBtn = new JButton("��  ��");
		rightNextBtn.setIcon(new ImageIcon(menuBackpath1));
		rightNextBtn.setBounds(5, (rightMiJp.getHeight()/5)*4 - 20, 330, 50);
		
		// ���� ��ư(�̺�Ʈ)
		rightNextBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainJp));

		////////////////////////////////////////////////////////////////////////////////////
		// �Ľ�
		
		String[] fstr = smc.snackTitle();
		
//		for (int i = 0; i < fstr.length; i++) {
//			System.out.println("����Ʈ ���� : " + fstr[i]);
//		}
		
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
		jsr.setBounds(10, 15, jSrp.getWidth()-20, leftMiPj.getHeight()/2);

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

//		mainJFrame.setDefaultCloseOperation(3);
//		mainJFrame.setVisible(true);

	}
	
	
	//	���� �̹��� ��ư ����  
	public void leftBtnInit(SpaceController smc, List<SnackBar> list, int index) {
	
	list = smc.snackSel(index);

	leftTopIconPj.removeAll(); // ������ �ִ� �г��� ������ Ŭ����
//	if(rightMiJp == null) {
//		rightMiJp = new JPanel();
//	}
	
	int iconNum = 0;
	String strTmp[] = new String[smc.snackTitle().length];
//	Arrays.sort(strTmp);
	strTmp = smc.snackTitle();
	
	// 9���� 900 ������ ������ �̹���
	int intTmp[] = {0, 100, 200, 300, 400, 500, 600, 700, 800, 900};
	
	// �޺��ڽ��� ������ ������ ���� ù��° ���� ��ġ�ϸ� intTmp�� ù��° �迭�� ��Ī�Ͽ�
	// ������ ���ڸ� �����Ѵ�. 
	
	for(int y = 0; y < strTmp.length; y++) {
		if( strTmp[index-1].equals( strTmp[y] )) {
			iconNum = intTmp[y];
			System.out.println(iconNum);
			break;
		}
	}
	
	
	// test
//	if( list.get(index).getSnackBarIndex() == 1) {
//		iconNum = 0;
//	}else
//		iconNum = 100;
	
	
	
	leftItemBtn = new JButton[list.size()];	// ������ ������ŭ ũ�⸦ �����;���
	jSrpColumnpanel = new JPanel[list.size()];
	leftItemLb = new JLabel[list.size()];
	
	leftTopIconPj.setLayout(new GridLayout(3, 10, 10, 10));
	leftTopIconPj.setBackground(Color.white);

	leftTopIconPj.revalidate();
	leftTopIconPj.repaint();
	
//	int width = 0; // ��ũ�� ũ�⿡ ���� ������
	// ��ũ�� ���� �г� �߰�
//	System.out.println("������ : " + list.size());
	String[] strImg = new String[list.size()];
	
	
	for (int i = 0; i < list.size(); i++) {
		
//		if(i != 0) width += 120;
		// �г� ����
		jSrpColumnpanel[i] = new JPanel();
		jSrpColumnpanel[i].setBackground(Color.lightGray);
//		jSrpColumnpanel[i].setBounds(0, 0, 90, 95);
		jSrpColumnpanel[i].setPreferredSize( new Dimension(90 , 95 ));
		jSrpColumnpanel[i].setLayout(null);
		
		// icon 0 ��°  + �迭 ������ ũ�� + 1 ���� ������ �̸��� �Ѱ���
		strImg[i] = (i + iconNum + 1) + ".png";
		
		// �̹��� �Ĵ� üũ�� ������ �⺻�� �̹����� ���
		String imgStr = "/com/space_distortion/view/" + strImg[i];
		if( SnackBarView.class.getResource(imgStr) == null){
			System.out.println("�̹��� ���� ���� !!!!!!!!!");
			imgStr = "/com/space_distortion/view/empty1.png";
		}
		ImageIcon imgCon = new ImageIcon(SnackBarView.class.getResource(imgStr));
		// ���� �г��� ��ư ����
//		System.out.println("i �� : " + i);
		leftItemBtn[i] = new JButton(list.get(i).getSnack() + " Image");
		leftItemBtn[i].setIcon(imgCon);
		leftItemBtn[i].setBounds(2, 2, 86, 75);
		
		leftItemBtn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		// ���� ���̺� ����
		leftItemLb[i] = new JLabel();
		leftItemLb[i].setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		leftItemLb[i].setText(list.get(i).getSnack() + "  " + list.get(i).getSnackPrice());
		leftItemLb[i].setBounds(2, 81, 86, 12);
//		leftItemLb[i].setForeground(Color.orange);

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
		rightMiLb.setBounds(200, 21, 100, 30);
		
		if(!rightMiLb.getText().equals(str))
			rightMiLb.setText(str);
		
//		rightMiLb.setBackground(Color.red);
		
		// �޺� �ڽ� ������ ���� +1�� 0���� ���� ������
		Integer[] num = new Integer[val+1];
		for(int i = 0; i <= val; i++) {
			num[i] = i;
		}

		// �޺� �ڽ� ������ �ʱ�
		rightMiCombo =  new JComboBox<Integer>(num);
		rightMiCombo.setBounds(265, 20, 60, 30);
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
					rightMiCombo.setVisible(false);
					rightMiLb.setVisible(false);
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


