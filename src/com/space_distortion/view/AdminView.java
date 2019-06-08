package com.space_distortion.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.main.Main;
import com.space_distortion.model.vo.Admin;

public class AdminView extends SpaceActionEvent implements ViewIndex, TableCellRenderer, TableModelListener ,ActionListener {
	
	
	SpaceController spaceController; 
	
	private DefaultTableModel defaultModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	private JPanel jp; // ��ü �г�
	private JPanel menuJp; // ���,��,����,����,���� ��ư����ִ� �г�
	private JPanel TableJp; // ���̺��� ����ִ� �г�
	private JPanel subMenuJp;
	
	private JButton btn1Member; // ��� ��ư
	private JButton btn2RoomInfo; // �� ���� ��ư
	private JButton btn3Snack; // ���� ��ư
	private JButton btn4Reservation; // ���� ��ư
	private JButton btn5TotalPay; // ��ü ���� ��ư
	private JButton btn6Delete; // 
	private JButton btn7Search;
	private JButton btn8Back;
	
	private JTextField nameField;
	private JTextField numberField;
	
	JLabel mainBackLabel; //���� ���
	JLabel menuBackLabel; //�޴� ���
	JLabel tableBackLabel; // ���̺� ���
	JLabel subBackLabel; // ���� ���
	
	JLabel nameLabel;
	JLabel indexLabel;
	JLabel menuLabel;
	JLabel subMenuLabel;
	JLabel logoLabel;
	
	Admin admin = new Admin();
	
	public AdminView()
	{
		
	}
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe)
	{	
		
		spaceController = sc;
		
		jp = new JPanel();
		jp.setBounds(0, 0, 1008, 730);
		jp.setLayout(null);
		
		mainBackLabel = new JLabel();
		URL mainBackpath = this.getClass().getResource("main.png");
		mainBackLabel.setIcon(new ImageIcon(mainBackpath));
		mainBackLabel.setBounds(0, 0, 1008, 730);
				
		menuJp = new JPanel();
		menuJp.setBounds(12, 20, 985, 164);
		menuJp.setLayout(null);
		
		menuBackLabel = new JLabel();
		menuBackLabel.setBounds(0, 0, 1000, 164);
		menuBackLabel.setLayout(null);
		URL menuBackpath = this.getClass().getResource("sub.png");
		menuBackLabel.setIcon(new ImageIcon(menuBackpath));
		
		// ���̺� JP
		TableJp = new JPanel();
		TableJp.setBounds(12, 194, 985, 365);
		TableJp.setLayout(null);
		
		
		tableBackLabel = new JLabel();
		tableBackLabel.setIcon(new ImageIcon(AdminView.class.getResource("/com/space_distortion/view/sub.png")));
		tableBackLabel.setBounds(0, 0, 985, 365);
		
		
		btn1Member = new JButton();
		URL memberpath = this.getClass().getResource("Member1.png");	
		btn1Member.setIcon(new ImageIcon(memberpath));
		btn1Member.setBounds(20, 100, 140, 55);
		btn1Member.setBorderPainted(false);
		btn1Member.setContentAreaFilled(false);
		btn1Member.setFocusPainted(false);
		btn1Member.setOpaque(false);
		menuBackLabel.add(btn1Member);
		
		btn2RoomInfo = new JButton();
		URL roomInfopath = this.getClass().getResource("RoomInfo1.png");
		btn2RoomInfo.setIcon(new ImageIcon(roomInfopath));
		btn2RoomInfo.setBounds(btn1Member.getX()+200, btn1Member.getY(), 140, 55);
		btn2RoomInfo.setBorderPainted(false);
		btn2RoomInfo.setContentAreaFilled(false);
		btn2RoomInfo.setFocusPainted(false);
		btn2RoomInfo.setOpaque(false);
		
		menuBackLabel.add(btn2RoomInfo);		
			
		
		btn3Snack = new JButton();
		btn3Snack.setBounds(btn2RoomInfo.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		
		URL snackpath = this.getClass().getResource("snack1.png");	
		btn3Snack.setIcon(new ImageIcon(snackpath));
		btn3Snack.setBorderPainted(false);
		btn3Snack.setContentAreaFilled(false);
		btn3Snack.setFocusPainted(false);
		btn3Snack.setOpaque(false);
		
		menuBackLabel.add(btn3Snack);
		
		btn4Reservation = new JButton();
		btn4Reservation.setBounds(btn3Snack.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		
		URL reservationpath = this.getClass().getResource("ReserVation1.png");	
		btn4Reservation.setIcon(new ImageIcon(reservationpath));
		btn4Reservation.setBorderPainted(false);
		btn4Reservation.setContentAreaFilled(false);
		btn4Reservation.setFocusPainted(false);
		btn4Reservation.setOpaque(false);
		
		menuBackLabel.add(btn4Reservation);
		
		btn5TotalPay = new JButton();
		btn5TotalPay.setBounds(btn4Reservation.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		
		URL totalpaypath = this.getClass().getResource("TotalPay1.png");	
		btn5TotalPay.setIcon(new ImageIcon(totalpaypath));
		btn5TotalPay.setBorderPainted(false);
		btn5TotalPay.setContentAreaFilled(false);
		btn5TotalPay.setFocusPainted(false);
		btn5TotalPay.setOpaque(false);
		
		menuBackLabel.add(btn5TotalPay);
		
		
		//�޴� �۾�
		menuLabel = new JLabel("Admin Management");
		menuLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		menuLabel.setFont(new Font("Verdana", Font.PLAIN, 60));
		menuLabel.setBounds(219, 0, 751, 74);
		menuBackLabel.add(menuLabel);
		
		//�� ��ư
		btn8Back = new JButton();
		URL backpath = this.getClass().getResource("back1.png");		
		btn8Back.setIcon(new ImageIcon(backpath));
		btn8Back.setBounds(30, 10, 100, 40);
		
		btn8Back.setBorderPainted(false);
		btn8Back.setContentAreaFilled(false);
		btn8Back.setFocusPainted(false);
		btn8Back.setOpaque(false);
		
		
		
		
		
		
		btn1Member.addMouseListener(new MouseAdapter() {
			
			//���콺��ư�� ����������
			@Override
			public void mousePressed(MouseEvent e) {
				URL memberPressed = this.getClass().getResource("Member2.png");
				btn1Member.setIcon(new ImageIcon(memberPressed));
			}
			
			// ���콺 ��ư�� ��������
			@Override
			public void mouseReleased(MouseEvent e) {
				URL memberReleased = this.getClass().getResource("Member1.png");
				btn1Member.setIcon(new ImageIcon(memberReleased));
			}
			
		});
		
		
		btn2RoomInfo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL roomInfoPressed = this.getClass().getResource("RoomInfo2.png");
				btn2RoomInfo.setIcon(new ImageIcon(roomInfoPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL roomInfoReleased = this.getClass().getResource("RoomInfo1.png");
				btn2RoomInfo.setIcon(new ImageIcon(roomInfoReleased));
			}
			
		});
		
		
		
		btn3Snack.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL snackPressed = this.getClass().getResource("snack2.png");
				btn3Snack.setIcon(new ImageIcon(snackPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL snackReleased = this.getClass().getResource("snack1.png");
				btn3Snack.setIcon(new ImageIcon(snackReleased));
			}
			
		});
		
		btn4Reservation.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL reservationPressed = this.getClass().getResource("ReserVation2.png");
				btn4Reservation.setIcon(new ImageIcon(reservationPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL reservationReleased = this.getClass().getResource("ReserVation1.png");
				btn4Reservation.setIcon(new ImageIcon(reservationReleased));
			}
			
		});
		
		btn5TotalPay.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL totalPayPressed = this.getClass().getResource("TotalPay2.png");
				btn5TotalPay.setIcon(new ImageIcon(totalPayPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL totalPayReleased = this.getClass().getResource("TotalPay1.png");
				btn5TotalPay.setIcon(new ImageIcon(totalPayReleased));
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		btn8Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton)e.getSource();
				System.out.println("Ŭ��");
				URL backPressed = this.getClass().getResource("back2.png");
				btn8Back.setIcon(new ImageIcon(backPressed));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL backReleased = this.getClass().getResource("back1.png");
				btn8Back.setIcon(new ImageIcon(backReleased));
			}
			
			
			
		});
			
		
		
		btn8Back.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, 8, sc, mainJframe, jp));
		
		
		menuBackLabel.add(btn8Back);
		
		
		
		
		//�޴� ����
		menuJp.add(menuBackLabel);
		
		defaultModel = new DefaultTableModel(0, 0);
		table = new JTable(defaultModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setLocation(12, 10);
		scrollPane.setSize(960, 340);  // 960 340
		
		tableBackLabel.add(scrollPane,null);
	
		TableJp.add(tableBackLabel);
		
		defaultModel = new DefaultTableModel(0,0);
		table = new JTable(defaultModel);
			
		subMenuJp = new JPanel();
		subMenuJp.setBounds(12, 570, 985, 140);
		subMenuJp.setLayout(null);
		
		
		subBackLabel = new JLabel();
		subBackLabel.setBounds(0, 0, 985, 140);
		subBackLabel.setLayout(null);
		URL subBackpath = this.getClass().getResource("sub.png");
		subBackLabel.setIcon(new ImageIcon(subBackpath));
		
		
		
		// ��� �̸� ã�� �Ǵ� �����̸�
		nameField = new JTextField(); 
		nameField.setBounds(571, 75, 149, 48);
		subBackLabel.add(nameField);
		
		numberField = new JTextField(1);
		numberField.setBounds(414, 75, 149, 48);
		subBackLabel.add(numberField);
				
		nameField.setEnabled(false);
		numberField.setEnabled(false);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		nameLabel.setBounds(571, 57, 58, 15);
		subBackLabel.add(nameLabel);
		
		indexLabel = new JLabel("Index");
		indexLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		indexLabel.setBounds(414, 57, 65, 15);
		subBackLabel.add(indexLabel);
				
		
		btn6Delete = new JButton();
		btn6Delete.setBounds(847, 74, 117, 48);
		btn6Delete.setName("����");
		URL deletepath = this.getClass().getResource("delete1.png");	
		btn6Delete.setIcon(new ImageIcon(deletepath));
		btn6Delete.setBorderPainted(false);
		btn6Delete.setContentAreaFilled(false);
		btn6Delete.setFocusPainted(false);
		btn6Delete.setOpaque(false);
		
		
		subBackLabel.add(btn6Delete);
		
		btn7Search = new JButton();
		btn7Search.setBounds(726, 74, 117, 48);
		btn7Search.setName("�˻�");
		URL searchpath = this.getClass().getResource("search1.png");	
		btn7Search.setIcon(new ImageIcon(searchpath));
		btn7Search.setBorderPainted(false);
		btn7Search.setContentAreaFilled(false);
		btn7Search.setFocusPainted(false);
		btn7Search.setOpaque(false);
		
		
		btn6Delete.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL deletePressed = this.getClass().getResource("delete2.png");
				btn6Delete.setIcon(new ImageIcon(deletePressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL deleteReleased = this.getClass().getResource("delete1.png");
				btn6Delete.setIcon(new ImageIcon(deleteReleased));
			}
			
		});
		
		btn7Search.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL searchPressed = this.getClass().getResource("search2.png");
				btn7Search.setIcon(new ImageIcon(searchPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL searchReleased = this.getClass().getResource("search1.png");
				btn7Search.setIcon(new ImageIcon(searchReleased));
			}
			
		});
		
		subBackLabel.add(btn7Search);
		
		
		//subMenuJp.add(logoLabel);
		
		
		// ��Ī�� ���� ( Ư������ ���� �� ���� �ٷιٷ� ���� )
		nameField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar() > 32 && e.getKeyChar() < 65)
					nameField.setText(null);
				else if(e.getKeyChar() > 90 && e.getKeyChar() < 97)
					nameField.setText(null);
				else if(e.getKeyChar() > 122 && e.getKeyChar() < 127)
					nameField.setText(null);
			
			}
		});
		
		// �������� �ε��� 1,2������ �ٸ��� ���� �ٷ� ����
		numberField.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if( e.getKeyChar() != '1' && e.getKeyChar() != '2')							
					numberField.setText(null);
				
				else if(e.getKeyChar() == '1' || e.getKeyChar() == '2')				
					if(numberField.getText().length() > 1)
						numberField.setText(null);				
				
			}
			
		});
		
		
		// ȸ�� ��ư
		btn1Member.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				
				//URL memberPressed = this.getClass().getResource("Member2.png");
				//btn1Member.setIcon(new ImageIcon(memberPressed));
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				 // TableJP  ->ScollPane -> Table -> DefaultTable
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName),modelName) {
					 @Override
				    public boolean isCellEditable(int row, int column) {
					 
				        return column != 0;
				    }
				};
				
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�
							
				table.getModel().addTableModelListener(new Hendler(btn1Member,table));
				
				
				nameField.setName("ȸ��");
				numberField.setName(null);
				
				
				nameField.setVisible(true);
				nameField.setEnabled(true);
				
				numberField.setVisible(false);
				
				nameLabel.setVisible(true);
				indexLabel.setVisible(false);
				
				btn6Delete.setVisible(true);
				btn7Search.setVisible(true);
				
				tableBackLabel.add(scrollPane,null);
				//TableJp.add(scrollPane,null);
				
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				//TableJp.revalidate();
				//TableJp.repaint();
			
			}
		});
		
		
		btn2RoomInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				 // TableJP  ->ScollPane -> Table -> DefaultTable
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"�� ��ȣ","�� �̸�","�ִ� �ο�(��)","��Ʈ��(����)"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllRoomInfo(modelName),modelName) {
					 @Override
				    public boolean isCellEditable(int row, int column) {
					 
				        return false;
				    }
				};
				
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�
							
				//table.getModel().addTableModelListener(new Hendler(btn1Member));
				
				
				nameField.setName("ȸ��");
				numberField.setName(null);
				
				
				nameField.setVisible(false);
				nameField.setEnabled(false);
				
				numberField.setVisible(false);
				numberField.setVisible(false);
				
				nameLabel.setVisible(false);
				indexLabel.setVisible(false);
				
				
				//TableJp.add(scrollPane,null);
				tableBackLabel.add(scrollPane);
				
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				//TableJp.revalidate();
				//TableJp.repaint();
				
			}
		});
		
			
		// ���� ��ư
		btn3Snack.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				
				
				
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"�����ε���","�����̸�","����","����","�ڸ�Ʈ"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllSnack(modelName),modelName){
					 @Override
					    public boolean isCellEditable(int row, int column) {
						 
					        return false;
					    }
					};
					
					
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�			
				
				
				table.getModel().addTableModelListener(new Hendler(btn6Delete,table));
				
				
				System.out.println(table.getModel().getColumnCount());
				
				
				
				
				nameField.setName("����");
				numberField.setName("������ȣ");
				
				nameField.setVisible(true);
				nameField.setEnabled(true);
				
				numberField.setVisible(true);
				numberField.setEnabled(true);
				
				nameLabel.setVisible(true);
				indexLabel.setVisible(true);
				
				btn6Delete.setVisible(true);
				btn7Search.setVisible(true);
							
				tableBackLabel.add(scrollPane);
				
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				//TableJp.add(scrollPane,null);
				
				//TableJp.revalidate();
				//TableJp.repaint();
				
				
			}
		});
		
		//���� 
		btn4Reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"����"};
				String[][] reservation = new String[1][1];
				reservation[0][0] = "���� ���� �� (�� �� ��)";
				defaultModel = new DefaultTableModel(reservation,modelName){
					 @Override
					    public boolean isCellEditable(int row, int column) {
						 
					        return false;
					    }
					};
							
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�			
				
				
				//table.getModel().addTableModelListener(new Hendler(btn6Delete,table));
				
		
				nameField.setVisible(false);
				nameField.setEnabled(false);
				
				numberField.setVisible(false);
				numberField.setEnabled(false);
				
				nameLabel.setVisible(false);
				indexLabel.setVisible(false);
				
				btn6Delete.setVisible(false);
				btn7Search.setVisible(false);
				
				
				//TableJp.add(scrollPane,null);	
				//TableJp.revalidate();
				//TableJp.repaint();
				
				tableBackLabel.add(scrollPane);
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				
				
			}
		});
		
		
		// ���� �Ѿ�	
		btn5TotalPay.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
								
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"userCode","����","��¥"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchTotalPay(modelName),modelName){
					 @Override
					    public boolean isCellEditable(int row, int column) {
						 
					        return false;
					    }
					};
							
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�			
				
				
				table.getModel().addTableModelListener(new Hendler(btn6Delete,table));
				
		
				nameField.setVisible(false);
				nameField.setEnabled(false);
				
				numberField.setVisible(false);
				numberField.setEnabled(false);
				
				nameLabel.setVisible(false);
				indexLabel.setVisible(false);
				
				btn7Search.setVisible(false);
				
				//TableJp.add(scrollPane,null);	
				//TableJp.revalidate();
				//TableJp.repaint();
				
				tableBackLabel.add(scrollPane);
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				
			}
		});
		
		
		// �� ���� ���
		btn6Delete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				
				
				if(table.getSelectedRow() == -1)
				{
					return;
				}
				else
				{
					int ans = JOptionPane.showConfirmDialog(null, "������ ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if(ans == 0)
					{					
						if(table.getColumnCount() == 5) //  �÷��� �����϶� 4
						{
							int row = table.getSelectedRow(); // ���õ� ��
							String selectName = table.getValueAt(row, 1).toString(); // ���õ� �� �� 1��° Į�� 
							spaceController.adminDelSnack(selectName);
							defaultModel.removeRow(table.getSelectedRow());
						}
						else if(table.getColumnCount() == 8) // Į���� ȸ�� 8
						{
							int row = table.getSelectedRow(); // ���õ� ��
							String selectName = table.getValueAt(row, 0).toString(); // �����ٿ� 0��° Į��
							spaceController.adminDelMember(Integer.parseInt(selectName));
							defaultModel.removeRow(table.getSelectedRow());
						}
						else if(table.getColumnCount() == 4)
						{
							JOptionPane.showMessageDialog(null, "�� ������ ���� �� ����!", "���", JOptionPane.WARNING_MESSAGE);
							return;
						}
						else if(table.getColumnCount() == 3)
						{
							JOptionPane.showMessageDialog(null, "���� ������ ���� �� ����!", "���", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
					}else
					{
						return;
					}
					
				}				
			}
		});
			
		//�̸� �˻�	
		btn7Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							 
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
					
				if(nameField.getName() == "ȸ��")
				{				
					String[] modelName = {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"};
					defaultModel = new DefaultTableModel(spaceController.adminSearchMember(modelName,nameField.getText()),modelName) {
						@Override
						public boolean isCellEditable(int row, int column) {
							
							return column != 0;
						}
					};
					
					table = new JTable(defaultModel);
					scrollPane = new JScrollPane(table);
					scrollPane.setLocation(12, 10);
					scrollPane.setSize(960, 340);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
					table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�									
	
				}
				else if(nameField.getName() == "����" && numberField.getName() == "������ȣ")
				{
					
					
					tableBackLabel.remove(scrollPane);
					//TableJp.remove(scrollPane);
					System.out.println("���� �̸� �ؽ�Ʈ " + nameField.getText());
					System.out.println("����� �ѹ� �ؽ�Ʈ : " + numberField.getText());
					
					numberField.addKeyListener(new KeyAdapter() {
						
						@Override
						public void keyPressed(KeyEvent e) {
							char c = e.getKeyChar();
							if(!Character.isDigit(c))
							{
								e.consume();
								return;
							}	
						}
						
					});
						
					
				
						
					String[] modelName = {"�����ε���","�����̸�","����","�ڸ�Ʈ"};		
					
					int index = 0;
					String name = null;
					
					if(nameField.getText().equals(""))
						name = null;
					else
						name = nameField.getText();
					
					if(numberField.getText().equals("") )
						index = 0;
					else
						index = Integer.parseInt( numberField.getText());
					
					
					defaultModel = new DefaultTableModel(spaceController.adminSearchSnack( index, name ,modelName),modelName){
						@Override
						public boolean isCellEditable(int row, int column) {
							
							return false;
						}
					};
					
								
					table = new JTable(defaultModel);
					scrollPane = new JScrollPane(table);
					scrollPane.setLocation(12, 0);
					scrollPane.setSize(961, 365);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
					table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�	
					
					
				}
					
				nameField.setText(null);
				numberField.setText(null);
				
				//TableJp.add(scrollPane,null);
				
				//TableJp.revalidate();
				//TableJp.repaint();
				
				tableBackLabel.add(scrollPane);
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				 
				
			}
		});
		
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2)
				{
					System.out.println("�ι�");					
				}
			}
			
		});
		
		
		
		
		
	
		subMenuJp.add(subBackLabel);
		mainBackLabel.add(menuJp);
		mainBackLabel.add(TableJp);
		mainBackLabel.add(subMenuJp);
		
		
		
		
		jp.add(mainBackLabel);
//		jp.add(menuJp);
//		jp.add(TableJp);
//		jp.add(subMenuJp);
		jp.setVisible(true);
		
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		
			
	}
	
class Hendler implements TableModelListener,KeyListener,MouseListener
{
	JButton btn;
	JTextField jtf;
	JTable table;
	boolean doubleClicked = false;
	
	public Hendler(JButton btn) {
		this.btn = btn;
	}
	
	public Hendler(JTextField jtf) {		
		this.jtf = jtf;
	}
	public Hendler(JButton btn, JTable table) {
		this.btn = btn;
		this.table = table;
		this.doubleClicked = false;
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

		if(jtf.getName() == "Index" )
		{
			System.out.println("�������");
			char c = e.getKeyChar();
			if(!Character.isDigit(c))
			{
				e.consume();
				return;
			}
		}
		
		
	}
		
		
	@Override
	public void tableChanged(TableModelEvent e) {
		
		SpaceController sc = Main.getSpaceController();
		TableModel model = (TableModel) e.getSource();
		
		String colName = null;
		int column = 0;
		int row = 0;
		int columnCode = 0;
		
		String returnChangeValue = (String) model.getValueAt(row, column);
		
		
		System.out.println("�ο� ī��Ʈ : " +  model.getRowCount());
		System.out.println("Į�� ���� : "  + model.getColumnCount());
		
		
	
		int ans;
		//if( model.isCellEditable( e.getFirstRow(), e.getColumn() ))
		if(table.getCellEditor() != null)
		{
			row = e.getFirstRow();
			column = e.getColumn();
			//changeValue = (String) model.getValueAt(row, column);
			
				ans = JOptionPane.showConfirmDialog(null, "������ ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(ans == 0)
			{
			
				if(model.getColumnCount() == 8) // �л� �÷� ī��Ʈ
				{
					
					row = e.getFirstRow();
					column = e.getColumn();
					columnCode = 0;
					System.out.println(column);
					
					
					if (column > 0) // �̸�
					{ 	
						//System.out.println("����");
						//System.out.println(column);
						//System.out.println(model.toString());
						//userCode = (String)model.getValueAt(row , columnCode);
						// �÷���ȣ�� 2�̸� "����" �÷��̴�. �÷��ε����� 0���� �����Ѵ�.
						colName = model.getColumnName(column); //�ش� �ε����� �÷��̸��� �޾ƿ´�.
						String userCode = (String)model.getValueAt(row , columnCode); // �ڵ�
						String userValue = (String) model.getValueAt(row, column); // data�� object Ÿ���̹Ƿ� ����ȯ�ؾ� �Ѵ�.	 //�н�����			
						System.out.println(userCode+ "  " + userValue);
						if(btn.getName() != "����"  )
						{
							sc.adminModifyMember(Integer.parseInt(userCode),userValue); 					
						}
					}			
				}	
				else if( model.getColumnCount() == 5)
				{
					return;
		//				row = e.getFirstRow();
		//				column = e.getColumn();	
				}			
			}
			else
			{
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				 // TableJP  ->ScollPane -> Table -> DefaultTable
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				String[] modelName = {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName),modelName) {
					 @Override
				    public boolean isCellEditable(int row, int column) {
					 
				        return column != 0;
				    }
				};
				
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�
							
				table.getModel().addTableModelListener(new Hendler(btn1Member,table));
				
				
				nameField.setName("ȸ��");
				numberField.setName(null);
				
				
				nameField.setVisible(true);
				nameField.setEnabled(true);
				
				numberField.setVisible(false);
				
				nameLabel.setVisible(true);
				indexLabel.setVisible(false);
				
				tableBackLabel.add(scrollPane,null);
				//TableJp.add(scrollPane,null);
				
				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				return;
			}
			
			
		}
		else
		{
			return;
		}
		
		
		//colName = null;
		//userCode = null;
		//userValue = null;
		//column = 0;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btn1Member)
		{
			System.out.println("ddddddddddddddddddddddddddddddddddddddd");
		}
		
	}
	
	
	@Override
	public void tableChanged(TableModelEvent e) {
		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
}


