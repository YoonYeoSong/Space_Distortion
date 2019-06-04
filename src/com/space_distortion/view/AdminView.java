package com.space_distortion.view;

import java.awt.Component;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.xml.ws.handler.MessageContext.Scope;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.main.Main;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.SnackBar;

public class AdminView extends SpaceActionEvent implements ViewIndex, TableCellRenderer {
	
	SpaceController spaceController = Main.getSpaceController();
	
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollpane;
	
	;
	Admin admin = new Admin();
	public AdminView()
	{
		
	}
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe)
	{
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		JPanel menuJp = new JPanel();
		menuJp.setBounds(12, 5, 1000, 82);
		menuJp.setLayout(null);
		
		JPanel TableJp = new JPanel();
		TableJp.setBounds(12, 114, 1000, 599);
		TableJp.setLayout(null);
		
		JButton btn1 = new JButton("Member");
		btn1.setBounds(55, 10, 117, 37);
		menuJp.add(btn1);
		
		
		JButton btn2 = new JButton("RoomInfo");
		btn2.setBounds(229, 10, 117, 37);
		menuJp.add(btn2);		
		
		
		JButton btn3 = new JButton("Snack");
		btn3.setBounds(429, 10, 117, 37);
		menuJp.add(btn3);
		
		JButton btn4 = new JButton("Reservation");
		btn4.setBounds(636, 10, 117, 37);
		menuJp.add(btn4);
		
		JButton btn5 = new JButton("TotalPay");
		btn5.setBounds(825, 10, 117, 37);
		menuJp.add(btn5);
		
		btn1.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON1, sc, mainJframe ,jp)); // member
		btn2.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON2, sc, mainJframe ,jp)); // roomInfo
		btn3.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON3, sc, mainJframe ,jp)); // snackbar
		btn4.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON4, sc, mainJframe ,jp)); // reservation
		btn5.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON5, sc, mainJframe ,jp)); // totalPay
		
		

		DefaultTableModel defaultModel = new DefaultTableModel(0, 0);
		JTable defaultTable = new JTable(defaultModel);
		JScrollPane scrollPane = new JScrollPane(defaultTable);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(988, 480);
				
		TableJp.add(scrollPane,null);
	
		jp.add(menuJp);
		jp.add(TableJp);
		
			
//		JButton btn6 = new JButton("삭제");
//		btn6.setBounds(871, 504, 117, 48);
//		TableJp.add(btn6);
//		
//		JButton btn7= new JButton("검색");
//		btn7.setBounds(750, 504, 117, 48);
//		TableJp.add(btn7);
//		
//		JTextField nameField = new JTextField(5);
//		nameField.setBounds(595, 505, 149, 48);
//		TableJp.add(nameField);
		
		
		
		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();
		
		
	}
	
	
	
	
	
	public void memberTableInitialize(SpaceController sc ,JFrame mainJframe)
	{	
		
	
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		JPanel menuJp = new JPanel();
		menuJp.setBounds(12, 5, 1000, 82);
		menuJp.setLayout(null);
		

		JPanel TableJp = new JPanel();
		TableJp.setBounds(12, 114, 1000, 599);
		TableJp.setLayout(null);
		
		JButton btn1 = new JButton("Member");
		btn1.setBounds(55, 10, 117, 37);
		menuJp.add(btn1);
		
		
		JButton btn2 = new JButton("RoomInfo");
		btn2.setBounds(229, 10, 117, 37);
		menuJp.add(btn2);		
		
		
		JButton btn3 = new JButton("Snack");
		btn3.setBounds(429, 10, 117, 37);
		menuJp.add(btn3);
		
		JButton btn4 = new JButton("Reservation");
		btn4.setBounds(636, 10, 117, 37);
		menuJp.add(btn4);
		
		JButton btn5 = new JButton("TotalPay");
		btn5.setBounds(825, 10, 117, 37);
		menuJp.add(btn5);
	
		
		JButton btn6 = new JButton("삭제");
		btn6.setBounds(871, 504, 117, 48);
		TableJp.add(btn6);
		
		JButton btn7= new JButton("검색");
		btn7.setBounds(750, 504, 117, 48);
		TableJp.add(btn7);
		
		JTextField nameField = new JTextField(5);
		nameField.setBounds(595, 505, 149, 48);
		TableJp.add(nameField);
		
		
		
		
			
		String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1"};
		model = new DefaultTableModel(sc.adminSearchAllMember(modelName),modelName) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
				 
			        return column != 0;
			    }
			};
			
		
		table = new JTable(model);
		
		
//      나중에 수정할 코드
//		if(table != null)
//		{
//			table 
//		}
		
		scrollpane = new JScrollPane(table);
		scrollpane.setLocation(0, 0);
		scrollpane.setSize(1000, 480);
		TableJp.add(scrollpane,null);
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기
		table.getModel().addTableModelListener(this);
		
		
			
		
		
		
		
		
		btn1.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON1, sc, mainJframe ,jp)); // member
		btn2.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON2, sc, mainJframe ,jp)); // roomInfo
		btn3.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON3, sc, mainJframe ,jp)); // snackbar
		btn4.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON4, sc, mainJframe ,jp)); // reservation
		btn5.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON5, sc, mainJframe ,jp)); // totalPay
		btn6.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON6, sc, mainJframe ,jp, table, model)); // Delete
		btn7.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON7, sc, mainJframe, jp, table, model, nameField));
		
		
		
		
	
		
	
		jp.add(menuJp);
		jp.add(TableJp);
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		
		System.out.println("회원");
		
	
	}
	
	
	public void memberTableInitialize( SpaceController sc ,JFrame mainJframe, String jtf)
	{	JPanel jp = null;
		
	
		
		jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		JPanel menuJp = new JPanel();
		menuJp.setBounds(12, 5, 1000, 82);
		menuJp.setLayout(null);
		

		JPanel TableJp = new JPanel();
		TableJp.setBounds(12, 114, 1000, 599);
		TableJp.setLayout(null);
		
		JButton btn1 = new JButton("Member");
		btn1.setBounds(55, 10, 117, 37);
		menuJp.add(btn1);
		
		
		JButton btn2 = new JButton("RoomInfo");
		btn2.setBounds(229, 10, 117, 37);
		menuJp.add(btn2);		
		
		
		JButton btn3 = new JButton("Snack");
		btn3.setBounds(429, 10, 117, 37);
		menuJp.add(btn3);
		
		JButton btn4 = new JButton("Reservation");
		btn4.setBounds(636, 10, 117, 37);
		menuJp.add(btn4);
		
		JButton btn5 = new JButton("TotalPay");
		btn5.setBounds(825, 10, 117, 37);
		menuJp.add(btn5);
	
		
		JButton btn6 = new JButton("삭제");
		btn6.setBounds(871, 504, 117, 48);
		TableJp.add(btn6);
		
		JButton btn7= new JButton("검색");
		btn7.setBounds(750, 504, 117, 48);
		TableJp.add(btn7);
		
		JTextField nameField = new JTextField(5);
		nameField.setBounds(595, 505, 149, 48);
		TableJp.add(nameField);
		
		
		
		scrollpane.remove(table);
		scrollpane = null;
		//TableJp.remove(scrollpane);
		model = null;
		
		
		String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1"};
		model = new DefaultTableModel(sc.adminSearchMember(modelName,jtf),modelName) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
				 
			        return column != 0;
			    }
			};
		
		table = new JTable(model);
		

		
		scrollpane = new JScrollPane(table);
		scrollpane.setLocation(0, 0);
		scrollpane.setSize(1000, 480);
		TableJp.add(scrollpane,null);
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기
		table.getModel().addTableModelListener(this);
		
		
			
		
		
		
		
		
		btn1.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON1, sc, mainJframe ,jp)); // member
		btn2.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON2, sc, mainJframe ,jp)); // roomInfo
		btn3.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON3, sc, mainJframe ,jp)); // snackbar
		btn4.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON4, sc, mainJframe ,jp)); // reservation
		btn5.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON5, sc, mainJframe ,jp)); // totalPay
		btn6.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON6, sc, mainJframe ,jp, table, model)); // Delete
		btn7.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON7, sc, mainJframe, jp, table, model, nameField));
		
		
		
		
	
		
	
		jp.add(menuJp);
		jp.add(TableJp);
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		
		System.out.println("회원");
		
	
	}
	
	
	public void roomInfoTableInitialize(SpaceController sc ,JFrame mainJframe )
	{
		
	}
	
	
	public void snackTableInitialize(SpaceController sc ,JFrame mainJframe)
	{
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		JPanel menuJp = new JPanel();
		menuJp.setBounds(12, 5, 1000, 82);
		menuJp.setLayout(null);
		

		JPanel TableJp = new JPanel();
		TableJp.setBounds(12, 114, 1000, 599);
		TableJp.setLayout(null);
		
		JButton btn1 = new JButton("Member");
		btn1.setBounds(55, 10, 117, 37);
		menuJp.add(btn1);
		
		
		JButton btn2 = new JButton("RoomInfo");
		btn2.setBounds(229, 10, 117, 37);
		menuJp.add(btn2);		
		
		
		JButton btn3 = new JButton("Snack");
		btn3.setBounds(429, 10, 117, 37);
		menuJp.add(btn3);
		
		JButton btn4 = new JButton("Reservation");
		btn4.setBounds(636, 10, 117, 37);
		menuJp.add(btn4);
		
		JButton btn5 = new JButton("TotalPay");
		btn5.setBounds(825, 10, 117, 37);
		menuJp.add(btn5);
		
		JButton btn6 = new JButton("Delete");
		btn6.setBounds(871, 504, 117, 48);
		TableJp.add(btn6);
		
		JButton btn7= new JButton("Search");
		btn7.setBounds(750, 504, 117, 48);
		TableJp.add(btn7);
		
		JTextField nameField = new JTextField(5);
		nameField.setBounds(595, 505, 149, 48);
		TableJp.add(nameField);
	
		
		
		String[] modelName = {"스낵인덱스","스낵이름","수량","코멘트"};
		DefaultTableModel snackModel = new DefaultTableModel(sc.adminSearchAllSnack(modelName),modelName);
		JTable table = new JTable(snackModel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setLocation(0, 0);
		scrollpane.setSize(1000, 480);
		TableJp.add(scrollpane,null);
		
		
		
		
		btn1.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON1, sc, mainJframe ,jp)); // member
		btn2.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON2, sc, mainJframe ,jp)); // roomInfo
		btn3.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON3, sc, mainJframe ,jp)); // snackbar
		btn4.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON4, sc, mainJframe ,jp)); // reservation
		btn5.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON5, sc, mainJframe ,jp)); // totalPay
		btn6.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON6, sc, mainJframe ,jp, table, snackModel)); // Delete
			
		jp.add(menuJp);
		jp.add(TableJp);
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		System.out.println("스낵");
		
	}
	
	public void ReservationTableInitialize(SpaceController sc ,JFrame mainJframe )
	{
		
	}
	
	public void payTableInitialize(SpaceController sc ,JFrame mainJframe )
	{
		
	}
	

	
	
//	public void snackTablePrint(SpaceController sc, JPanel tableJp, int num )
//	{
//		
//		String[] modelName = {"스낵인덱스","스낵이름","수량","코멘트"};
//		DefaultTableModel snackModel = new DefaultTableModel(sc.adminSearchAllSnack(modelName),modelName);
//		JTable table = new JTable(snackModel);
//		JScrollPane scrollpane = new JScrollPane(table);
//		scrollpane.setLocation(0, 0);
//		scrollpane.setSize(1000, 480);
//		tableJp.add(scrollpane,null);
//	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////consol//////////////////////////////////////////////////////////////////
	public void SpaceMainMenu()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Space_Distorition");
			System.out.println("1. 일반 회원조회");
			System.out.println("2. 방에 대한 정보");
			System.out.println("3. 예약 정보");
			System.out.println("4. Inventory");
			System.out.println("5. 일매출");
			System.out.println("6. 음료");
			System.out.println("7. 회원 이름 조회");
			System.out.println("8. 생성");	
			System.out.println("9. 관리자 회원 전부 출력");	
			System.out.println("10. 관리자 회원 이름으로 찾기");	
			System.out.println("11. 관리자 회원코드로 회원 삭제");	
			System.out.println("12. 관리자 회원 전부 출력");	
			System.out.println("13. 음료/과자 모두 검색");
			System.out.println("14. 음료 과자 판별");
			System.out.println("15. 음료나 과자 수량 수정");
			System.out.println("16. 음료나 과자 삭제");

			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	spaceController.seachMem();
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
			case 8:	spaceController.initConsol();
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
			case 14: spaceController.adminSearchSnack();
			break;
			case 15: spaceController.adminModifySnack();
			break;
			case 16: //spaceController.adminDelSnack();
			break;
			case 17: spaceController.SnackSeach();
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
			System.out.println("1. 모든방 검색 ");
			System.out.println("2. 방번호로 찾기");
			System.out.println("3. 룸 수정 노트북 갯수");
			System.out.println("4. 모든 매출" );		
			System.out.println("5. back");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	spaceController.adminSearchAllRoomInfo();
				break;
			case 2:	spaceController.adminSearchRoomInfo();
				break;
			case 3:	spaceController.adminModifyRoom();
				break;
			case 4: spaceController.adminSearchTotalPay();
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
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		return memberName;
	}
	public int searchMemberKey()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("회원코드 입력 : ");
		int memberCode = sc.nextInt();
		return memberCode;
	}
	
	public int searchSnackIndex()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("과자 :1 / 음료 2  입력 : ");
		int snackIndex = sc.nextInt();
		return snackIndex;
	}
	
	public int searchSnackQuntity()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("수량 입력 : ");
		int snackQuntity = sc.nextInt();
		return snackQuntity;
	}
	

	public String searchSnackName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("스낵 이름 입력 : ");
		String snackName = sc.next();
		return snackName;
	}
	
	public int searchRoomNum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("룸 번호 입력 : ");
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
