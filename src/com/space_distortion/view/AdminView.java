package com.space_distortion.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.ws.handler.MessageContext.Scope;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.main.Main;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.SnackBar;

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
	
	private JTextField nameField;
	private JTextField numberField;
	
	JLabel nameLabel;
	JLabel indexLabel;
	
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
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		menuJp = new JPanel();
		menuJp.setBounds(12, 5, 1000, 82);
		menuJp.setLayout(null);
		
		TableJp = new JPanel();
		TableJp.setBounds(12, 114, 1000, 378);
		TableJp.setLayout(null);
		
		btn1Member = new JButton("Member");
		btn1Member.setBounds(55, 10, 117, 37);
		menuJp.add(btn1Member);
		
		
		btn2RoomInfo = new JButton("RoomInfo");
		btn2RoomInfo.setBounds(229, 10, 117, 37);
		menuJp.add(btn2RoomInfo);		
		
		
		btn3Snack = new JButton("Snack");
		btn3Snack.setBounds(429, 10, 117, 37);
		menuJp.add(btn3Snack);
		
		btn4Reservation = new JButton("Reservation");
		btn4Reservation.setBounds(636, 10, 117, 37);
		menuJp.add(btn4Reservation);
		
		btn5TotalPay = new JButton("TotalPay");
		btn5TotalPay.setBounds(825, 10, 117, 37);
		menuJp.add(btn5TotalPay);
		
		defaultModel = new DefaultTableModel(0, 0);
		table = new JTable(defaultModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setLocation(12, 0);
		scrollPane.setSize(976, 378);
				
		TableJp.add(scrollPane,null);
	
		defaultModel = new DefaultTableModel(0,0);
		table = new JTable(defaultModel);
			
		
		subMenuJp = new JPanel();
		subMenuJp.setBounds(24, 498, 976, 90);
		subMenuJp.setLayout(null);
		
		// ��� �̸� ã�� �Ǵ� �����̸�
		nameField = new JTextField(); 
		nameField.setBounds(570, 28, 149, 48);
		subMenuJp.add(nameField);
		
		numberField = new JTextField(1);
		numberField.setBounds(413, 28, 149, 48);
		subMenuJp.add(numberField);
		
		nameField.setEnabled(false);
		numberField.setEnabled(false);
		
		nameLabel = new JLabel("��Ī(�̸�");
		nameLabel.setBounds(570, 10, 58, 15);
		subMenuJp.add(nameLabel);
		
		indexLabel = new JLabel("����Index");
		indexLabel.setBounds(413, 10, 58, 15);
		subMenuJp.add(indexLabel);
				
		
		btn6Delete = new JButton("����");
		btn6Delete.setBounds(846, 27, 117, 48);
		subMenuJp.add(btn6Delete);
		
		btn7Search = new JButton("�˻�");
		btn7Search.setBounds(725, 27, 117, 48);
		subMenuJp.add(btn7Search);
		
		
		
		// ȸ�� ��ư
		btn1Member.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				 // TableJP  ->ScollPane -> Table -> DefaultTable
				TableJp.remove(scrollPane);
				
				String[] modelName = {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName),modelName) {
					 @Override
				    public boolean isCellEditable(int row, int column) {
					 
				        return column != 0;
				    }
				};
				
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 0);
				scrollPane.setSize(976, 378);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�
							
				table.getModel().addTableModelListener(new Hendler(btn1Member));
				
				
				nameField.setName("ȸ��");
				numberField.setName(null);
				
				
				nameField.setVisible(true);
				nameField.setEnabled(true);
				
				numberField.setVisible(false);
				
				nameLabel.setVisible(true);
				indexLabel.setVisible(false);
				
				
				TableJp.add(scrollPane,null);
				
				TableJp.revalidate();
				TableJp.repaint();
			
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
				
				TableJp.remove(scrollPane);
				
				String[] modelName = {"�����ε���","�����̸�","����","�ڸ�Ʈ"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllSnack(modelName),modelName){
					 @Override
					    public boolean isCellEditable(int row, int column) {
						 
					        return false;
					    }
					};
					
					
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 0);
				scrollPane.setSize(976, 378);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�			
				
				
				table.getModel().addTableModelListener(new Hendler(btn6Delete));
				
				
				System.out.println(table.getModel().getColumnCount());
				
				TableJp.add(scrollPane,null);
				
				
				
				nameField.setName("����");
				numberField.setName("������ȣ");
				
				nameField.setVisible(true);
				nameField.setEnabled(true);
				
				numberField.setVisible(true);
				numberField.setEnabled(true);
				
				nameLabel.setVisible(true);
				indexLabel.setVisible(true);
				
				
				TableJp.revalidate();
				TableJp.repaint();
				
				
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
								
				TableJp.remove(scrollPane);
				
				String[] modelName = {"����"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchTotalPay(modelName),modelName){
					 @Override
					    public boolean isCellEditable(int row, int column) {
						 
					        return false;
					    }
					};
							
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 0);
				scrollPane.setSize(976, 378);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
				table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�			
				
				
				table.getModel().addTableModelListener(new Hendler(btn6Delete));
				
				
				System.out.println(table.getModel().getColumnCount());
				
				TableJp.add(scrollPane,null);
				
				
				
				
				nameField.setVisible(false);
				nameField.setEnabled(false);
				
				numberField.setVisible(false);
				numberField.setEnabled(false);
				
				nameLabel.setVisible(false);
				indexLabel.setVisible(false);
				
				
				
				TableJp.revalidate();
				TableJp.repaint();
				
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
					if(table.getColumnCount() == 4) //  �÷��� �����϶� 4
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
				
				
				TableJp.remove(scrollPane);
					
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
					scrollPane.setLocation(12, 0);
					scrollPane.setSize(976, 378);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
					table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�									
	
				}
				else if(nameField.getName() == "����" && numberField.getName() == "������ȣ")
				{
					
					
					TableJp.remove(scrollPane);
					System.out.println("���� �̸� �ؽ�Ʈ " + nameField.getText());
					System.out.println("����� �ѹ� �ؽ�Ʈ : " + numberField.getText());
					String[] modelName = {"�����ε���","�����̸�","����","�ڸ�Ʈ"};		
					
					int index = 0;
					String name = null;
					
					if(nameField.getText().equals(""))
						name = null;
					else
						name = nameField.getText();
					
					if(numberField.getText().equals(""))
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
					scrollPane.setSize(976, 378);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �Ѱ��� �ο츸 ����
					table.getTableHeader().setReorderingAllowed(false); // �÷� �������̰� �ϱ�	
					
		
		
			
					
				}
					
				
				
				TableJp.add(scrollPane,null);
				
				TableJp.revalidate();
				TableJp.repaint();
				 
				
			}
		});
		
		
		
//		numberField.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if( numberField.getText().charAt(0) > 0 || numberField.getText().charAt(0) < 3)
//				{
//					
//				}else
//				{
//					return;
//				}
//				
//			}
//		});
		
		
		//table.getModel().addTableModelListener(this);
		
		
		jp.add(menuJp);
		jp.add(TableJp);
		jp.add(subMenuJp);
		jp.setVisible(true);
		
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		
		
		
		
		
	}
	
	class Hendler implements TableModelListener
	{
		JButton btn;
		public Hendler(JButton btn) {
			// TODO Auto-generated constructor stub
			this.btn = btn;
		}
		
		
		
		@Override
		public void tableChanged(TableModelEvent e) {
			SpaceController sc = Main.getSpaceController();
			TableModel model = (TableModel) e.getSource();
			String colName = null;
			int column = 0;
			int row = 0;
			int columnCode = 0;
			
			
			System.out.println("�ο� ī��Ʈ : " +  model.getRowCount());
			System.out.println("Į�� ���� : "  + model.getColumnCount());
			
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
					if(btn.getName() != "����")
					{
						sc.adminModifyMember(Integer.parseInt(userCode),userValue); 					
					}
				}			
			}
			
			else if( model.getColumnCount() == 4)
			{
				return;
//				row = e.getFirstRow();
//				column = e.getColumn();	
			}
			
			//colName = null;
			//userCode = null;
			//userValue = null;
			//column = 0;
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
	
	
	

	
	////////////////////////////////////////////////////////////////////////////////consol//////////////////////////////////////////////////////////////////
	public void SpaceMainMenu()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Space_Distorition");
			System.out.println("1. �Ϲ� ȸ����ȸ");
			System.out.println("2. �濡 ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. Inventory");
			System.out.println("5. �ϸ���");
			System.out.println("6. ����");
			System.out.println("7. ȸ�� �̸� ��ȸ");
			System.out.println("8. ����");	
			System.out.println("9. ������ ȸ�� ���� ���");	
			System.out.println("10. ������ ȸ�� �̸����� ã��");	
			System.out.println("11. ������ ȸ���ڵ�� ȸ�� ����");	
			System.out.println("12. ������ ȸ�� ���� ���");	
			System.out.println("13. ����/���� ��� �˻�");
			System.out.println("14. ���� ���� �Ǻ�");
			System.out.println("15. ���ᳪ ���� ���� ����");
			System.out.println("16. ���ᳪ ���� ����");

			System.out.print("��ȣ �Է� : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	//spaceController.seachMem();
				break;
			case 2:	paymentAndRoomInfo();
				break;
			case 3:		//spaceController.search();
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:		
			case 7:	//spaceController.adminSearchMemberName();
				break;
			case 8:	//spaceController.initConsol();
				break;
			case 9: //spaceController.adminSearchAllMember();
				break;
			case 10: //spaceController.adminSearchMemberName();
			break;
			case 11:// spaceController.adminDelMember();
			break;
			case 12: //spaceController.adminDelMember();
			break;
			case 13: //spaceController.adminSearchAllSnack();
			break;
			case 14: ///spaceController.adminSearchSnack();
			break;
			case 15: //spaceController.adminModifySnack();
			break;
			case 16: //spaceController.adminDelSnack();
			break;
			case 17: //spaceController.SnackSeach();
			break;
//			case 18: spaceController.adminDelMember();
//			break;
			
			default:
				break;
			}
		}
	}
	
	
	
	
	
	public void paymentAndRoomInfo()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Space_Distorition");
			System.out.println("1. ���� �˻� ");
			System.out.println("2. ���ȣ�� ã��");
			System.out.println("3. �� ���� ��Ʈ�� ����");
			System.out.println("4. ��� ����" );		
			System.out.println("5. back");
			System.out.print("��ȣ �Է� : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	//spaceController.adminSearchAllRoomInfo();
				break;
			case 2:	//spaceController.adminSearchRoomInfo();
				break;
			case 3:	//spaceController.adminModifyRoom();
				break;
			case 4: //spaceController.adminSearchTotalPay();
				break;
			case 5: 
				break;	
			default:
				break;
			}
		}
	}
	
	
	
	public String searchMemberName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String memberName = sc.next();
		return memberName;
	}
	public int searchMemberKey()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("ȸ���ڵ� �Է� : ");
		int memberCode = sc.nextInt();
		return memberCode;
	}
	
	public int searchSnackIndex()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� :1 / ���� 2  �Է� : ");
		int snackIndex = sc.nextInt();
		return snackIndex;
	}
	
	public int searchSnackQuntity()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int snackQuntity = sc.nextInt();
		return snackQuntity;
	}
	

	public String searchSnackName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �̸� �Է� : ");
		String snackName = sc.next();
		return snackName;
	}
	
	public int searchRoomNum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ��ȣ �Է� : ");
		int number = sc.nextInt();
		return number;
	}


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}


