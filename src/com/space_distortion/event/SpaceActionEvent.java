package com.space_distortion.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.main.Main;
import com.space_distortion.view.ViewIndex;

public class SpaceActionEvent implements MouseListener, ViewIndex, TableModelListener {

	
	private SpaceController spaceController = Main.getSpaceController();
	private int viewIndex; // ����ϴ� ���� �ε���
	private int buttonIndex;
	private SpaceController sc;
	private JFrame jf;
	private JPanel jp;
	private JPanel jp1;
	private JTable jt;
	private JTextField jtf;
	private DefaultTableModel dt;
	
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JFrame jf ,JPanel jp) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jf = jf;
		this.jp = jp;
		//System.out.println("������ : " + this.buttonIndex + " / " + buttonIndex);
	}
	
	
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JFrame jf) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jf = jf;
	}
	
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
	}
	

	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JPanel jp ,JPanel jp1, JFrame jf) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jp = jp;
		this.jp1 = jp1;
		this.jf = jf;
		//System.out.println("������ : " + this.buttonIndex + " / " + buttonIndex);
	}
	
	
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JFrame jf ,JPanel jp, JTable jt, DefaultTableModel dt,JTextField jtf) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jp = jp;
		this.jf = jf;
		this.jt = jt;
		this.dt = dt;
		this.jtf = jtf;
		//System.out.println("������ : " + this.buttonIndex + " / " + buttonIndex);
	}
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JFrame jf ,JPanel jp, JTable jt, DefaultTableModel dt) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jp = jp;
		this.jf = jf;
		this.jt = jt;
		this.dt = dt;

		//System.out.println("������ : " + this.buttonIndex + " / " + buttonIndex);
	}
	
	

///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public SpaceActionEvent() {
		//System.out.println("�⺻ ������ :" + buttonIndex);
		// TODO Auto-generated constructor stub
	}
	
/////////  �� �̺�Ʈ �޼ҵ�  /////////////////////////////////////////////////////////////////
	
	// ���κ� ��ư �̺�Ʈ
	public void mainViewSelected() {
		System.out.println("���ι�ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("1���� ����");
			jf.remove(jp);
			//jp.revalidate();
			//jp.repaint();
			sc.subRoomView(buttonIndex);
			// ���� �α��� ��
		} 
		else if(buttonIndex == 2) {
			System.out.println("2���� ����");
		}
		else if(buttonIndex == 3) {
			System.out.println("���� �մϴ�.");
//			System.out.println(this.buttonIndex);
			System.exit(0);
		}	
		else if(buttonIndex == 4)
		{
			jf.remove(jp);
			//sc.adminView();
			
		}	
		else if(buttonIndex == 9)
		{
			//�����ں���̵�
			jf.remove(jp);
			sc.adminView();
		}
			System.out.println("err....");
	}

	// ���κ� ���� �̺�Ʈ
	public void subRoomViewSelected() {
		System.out.println("���� ����� �̺�Ʈ");
		// ȸ��, ��ȸ��, ����, Ȩ����
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ��ư ����");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.loginView();
		}
		System.out.println(buttonIndex);
		if(buttonIndex == 2) {
			System.out.println("�� ȸ�� ����");
			jf.remove(jp);
			sc.nAccountView();
			
		}else if(buttonIndex == 3) {
			System.out.println("���� ����");
//			System.out.println(this.buttonIndex);
			// ���� view load
		}else if(buttonIndex == 4) {
			System.out.println("�ڷ� ���� ����");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");
		
		
		
	}
	
	// �α� ��ư �̺�Ʈ
	public void loginViewSelected() {
		System.out.println("�α��ư Ŭ�� �̺�Ʈ");
		// ȸ�� ����, �α�, ID & PW ã��
		
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ���� ����");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("��ȸ�� �α� ����");
			
			// ��ȸ���α��� �ٷ� ���̸�Ʈ�� �̵�
			
			jf.remove(jp);
			sc.paymentView();
		}else if(buttonIndex == 3) {
			
			//�α���
			// �α��� ������ ���̸�Ʈ ��� �̵�
			jf.remove(jp);
			sc.paymentView();
			// ã�� �������� �̵�
		}else
			//���� �ؾߵǴ� �κ�
			//System.out.println("ID & PW ã��");
			
			//
			System.out.println("err....");

	}
	
	// ȸ�� ���� �̺�Ʈ
	public void accountViewSelected() {
		System.out.println("ȸ�� ���� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("��������");
			jf.remove(jp);
			sc.accoutView2();
		}	
	}
	
	// ȸ�� ���� ���� �̺�Ʈ
	public void subAccountViewSelected() {
		System.out.println("���� ȸ�� ���� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("ȸ�� ���� Ȯ��");
			jf.remove(jp);
			sc.loginView();
		}
		
	}
	
	// ��ȸ�� �̺�Ʈ
	public void nAccountViewSelected()
	{
		if(buttonIndex == 1)
		{
			jf.remove(jp);
			sc.paymentView();
		}
	}
	
	// �߰��ð� �̺�Ʈ
	public void addTimeRoomViewSelected() {
		System.out.println("�߰� �ð� ��ư Ŭ�� �̺�Ʈ");
		
	}
	
	// ������ �̺�Ʈ
	public void adminViewSelected() {
		if(buttonIndex == ADMIN_VIEW_BUTTON1)
		{
			
			jf.remove(jp);
			
			//sc.adminMemberTable();
			
		}
		else if(buttonIndex == ADMIN_VIEW_BUTTON2)
		{
			
			jf.remove(jp);
			//sc.adminRoomInfoTable();
		}
		else if(buttonIndex == ADMIN_VIEW_BUTTON3)
		{
			jf.remove(jp);
			
			//sc.adminSnackTable();
			
			
		}	
		else if(buttonIndex == ADMIN_VIEW_BUTTON4)
		{
			
			jf.remove(jp);
			//sc.adminReservationTable();
		}	//
		else if(buttonIndex == ADMIN_VIEW_BUTTON5)
		{
			
			jf.remove(jp);
			//sc.adminPayTable();
		}
		else if(buttonIndex == ADMIN_VIEW_BUTTON6)
		{
			if(jt.getSelectedRow() == -1)
				
			{
				return;
			}
			else
			{
				if( jt.getColumnCount() == 4) // �϶� ����
				{
					int row = jt.getSelectedRow();
					int column = jt.getSelectedColumn();
					//System.out.println(jt.getColumnCount());
					String selectName = jt.getValueAt(row, 1).toString();
					sc.adminDelSnack(selectName);
					dt.removeRow(jt.getSelectedRow());
					//jt.setce					
				}
				else if(jt.getColumnCount() == 8) // 8�϶� ȸ��
				{
					int row = jt.getSelectedRow();
					int column = jt.getSelectedColumn();
					System.out.println(jt.getColumnCount());
					String selectNum = jt.getValueAt(row, 0).toString();
					System.out.println(selectNum);
					sc.adminDelMember(Integer.parseInt(selectNum));
					dt.removeRow(jt.getSelectedRow());
				}
			}		
			
			
			//System.out.println(jt.getValueAt(row, column));
			
		}
		else if(buttonIndex == ADMIN_VIEW_BUTTON7)
		{				
			jf.remove(jp);

			String jtfText = jtf.getText();
			//sc.adminMemberTable(jtfText);
		}
	}
	
	// �������� �̺�Ʈ
	public void paymentViewSelected() {
		System.out.println("�������� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ���� ����");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("���� �ϱ�");
			// ���� ����
			jf.remove(jp);
			sc.paymentView();
			
		}else if(buttonIndex == 3) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");
		
	}
	
	// ���� �� �̺�Ʈ
	public void snackViewSelected() {
//		System.out.println("���� ��ư Ŭ���� �̺�Ʈ");
		
		/*
		 * ��ư ������ ���� �̺�Ʈ ó��
		 */
		switch (buttonIndex) {
			case SNACK_BAR_VIEW_NEXT:
				jf.remove(jp);
				System.out.println("������ ����⼺��");
				sc.paymentView();
				break;
			case SNACK_BAR_VIEW_CANSLE:
//				System.out.println("��ư �ε��� 2 :" + buttonIndex);
				jf.remove(jp);
				System.out.println("������ ����⼺��2");
				sc.subRoomView(buttonIndex);
				break;
			default:
				sc.snackSelList(buttonIndex);
				break;
		}
		
//		System.out.println("�ε����� ����:??? " + buttonIndex);
//		System.out.println(buttonIndex);
//		System.out.println();
//		if(buttonIndex == 1) {	// ���Ḧ ������ ���
//			System.out.println("���� �̺�Ʈ");
//			sc.snackSel(1);
//			System.out.println("���� ��ư �ε��� : " + buttonIndex);
				
			
//		}else if(buttonIndex == 2) { // ���ڸ� ������ ���
//			System.out.println("���� �̺�Ʈ");
//			sc.snackSel(2);
//			List<SnackBar> list = sc.snackSel(2);
//			sc.snackSelList();
//
//		}else
//			System.out.println("snack err...");
		
		
	}

	
///////// �� �̺�Ʈ          /////////////////////////////////////////////////////////////////
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		switch (viewIndex) {
		case MAIN_ROOM_VIEW_NUM:
			this.mainViewSelected();
			break;
		case SUB_ROOM_VIEW_NUM:
			this.subRoomViewSelected();
			break;
		case LOGIN_VIEW:
			this.loginViewSelected();
			break;
		case ACCOUNT_VIEW_NUM:
			this.accountViewSelected();
			break;
		case ACCOUNT_SUB_LOGIN_VIEW:
			this.subAccountViewSelected();
			break;
		case ADD_TIME_ROOM_VIEW_NUM:
			this.addTimeRoomViewSelected();
			break;
		case ADMIN_VIEW_NUM:
			this.adminViewSelected();
			break;
		case PAYMENT_VIEW_NUM:
			this.paymentViewSelected();
			break;
		case SNACK_BAR_VIEW_NUM:
			this.snackViewSelected();
			break;
		case NACCOUNT_VIEW:
			this.nAccountViewSelected();
			break;

		default:
			break;
		}

			
		
		
	}
	
	
	
//	@Override
//	public void tableChanged(TableModelEvent e) {
//		// TODO Auto-generated method stub
//		
//		SpaceController sc = Main.getSpaceController();
//		TableModel model = (TableModel) e.getSource();
//		String colName = null;
//		String userValue = null;
//		String userCode = null;
//		int column = 0;
//		int row = 0;
//		int columnCode = 0;
//		
//		
//		System.out.println("�ο� ī��Ʈ : " +  model.getRowCount());
//		System.out.println("Į�� ���� : "  + model.getColumnCount());
//		
//		if(model.getColumnCount() == 8) // �л� �÷� ī��Ʈ
//		{
//			
//			row = e.getFirstRow();
//			column = e.getColumn();
//			columnCode = 0;
//			System.out.println(column);
//			
//			
//			if (column > 0) // �̸�
//			{ 	
//				//System.out.println("����");
//				//System.out.println(column);
//				//System.out.println(model.toString());
//				//userCode = (String)model.getValueAt(row , columnCode);
//				// �÷���ȣ�� 2�̸� "����" �÷��̴�. �÷��ε����� 0���� �����Ѵ�.
//				colName = model.getColumnName(column); //�ش� �ε����� �÷��̸��� �޾ƿ´�.
//				userCode = (String)model.getValueAt(row , columnCode); // �ڵ�
//				userValue = (String) model.getValueAt(row, column); // data�� object Ÿ���̹Ƿ� ����ȯ�ؾ� �Ѵ�.	 //�н�����			
//				System.out.println(userCode+ "  " + userValue);
//			}			
//			//if(e.getSource() == )
//			sc.adminModifyMember(Integer.parseInt(userCode),userValue); 
//		}
//		
//		else if( model.getColumnCount() == 4)
//		{
//			return;
////			row = e.getFirstRow();
////			column = e.getColumn();	
//		}
//		
//		//colName = null;
//		//userCode = null;
//		//userValue = null;
//		//column = 0;
//	}
//	
	

	@Override
	public void tableChanged(TableModelEvent e) {
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
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
