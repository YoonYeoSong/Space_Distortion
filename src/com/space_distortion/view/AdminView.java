package com.space_distortion.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
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

public class AdminView extends SpaceActionEvent implements ViewIndex, TableCellRenderer, TableModelListener {
	
	
	SpaceController spaceController; 
	
	private DefaultTableModel defaultModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	private JPanel jp; // 전체 패널
	private JPanel menuJp; // 멤버,방,스낵,예약,페이 버튼담고있는 패널
	private JPanel TableJp; // 테이블을 담고있는 패널
	private JPanel subMenuJp;
	
	private JButton btn1Member; // 멤버 버튼
	private JButton btn2RoomInfo; // 룸 정보 버튼
	private JButton btn3Snack; // 스낵 버튼
	private JButton btn4Reservation; // 예약 버튼
	private JButton btn5TotalPay; // 전체 페이 버튼
	private JButton btn6Delete; // 
	private JButton btn7Search;
	
	private JTextField nameField;
	
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
		
		
		table.getModel().addTableModelListener(this);
		
		subMenuJp = new JPanel();
		subMenuJp.setBounds(24, 498, 976, 90);
		subMenuJp.setLayout(null);
		
		nameField = new JTextField(5);
		nameField.setBounds(570, 28, 149, 48);
		subMenuJp.add(nameField);
		
		btn6Delete = new JButton("삭제");
		btn6Delete.setBounds(846, 27, 117, 48);
		subMenuJp.add(btn6Delete);
		
		btn7Search = new JButton("검색");
		btn7Search.setBounds(725, 27, 117, 48);
		subMenuJp.add(btn7Search);
		
		
		
		// 회원 버튼
		btn1Member.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("하이");
				
				
				defaultModel = (DefaultTableModel)table.getModel();
				defaultModel.setNumRows(0);
				TableJp.remove(scrollPane);
				
				
				String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1"};
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
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
				table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기
							
				TableJp.add(scrollPane,null);
				
				TableJp.revalidate();
				TableJp.repaint();
			
			}
		});
		
		// 스낵 버튼
		btn3Snack.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("스낵");
				defaultModel = (DefaultTableModel)table.getModel();
				defaultModel.setNumRows(0);
				
				
				TableJp.remove(scrollPane);
				
				String[] modelName = {"스낵인덱스","스낵이름","수량","코멘트"};
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
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
				table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기
				
				
				
				
				TableJp.add(scrollPane,null);
				
				TableJp.revalidate();
				TableJp.repaint();
				
				
			}
		});
		
		
		// 줄 삭제 기능
		btn6Delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() == -1)
				{
					return;
				}
				else
				{
					if(table.getColumnCount() == 4) //  컬럼수 스낵일때 4
					{
						int row = table.getSelectedRow(); // 선택된 줄
						String selectName = table.getValueAt(row, 1).toString(); // 선택된 줄 에 1번째 칼럼 
						spaceController.adminDelSnack(selectName);
						defaultModel.removeRow(table.getSelectedRow());
					}
					else if(table.getColumnCount() == 8) // 칼럼수 회원 8
					{
						int row = table.getSelectedRow(); // 선택된 줄
						String selectName = table.getValueAt(row, 0).toString(); // 선택줄에 0번째 칼럼
						spaceController.adminDelMember(Integer.parseInt(selectName));
						defaultModel.removeRow(table.getSelectedRow());
					}
				}
				
			}
		});
		
		
		//이름 검색	
		btn7Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							 
				
				
				defaultModel = (DefaultTableModel)table.getModel();
				defaultModel.setNumRows(0);
				
				
				TableJp.remove(scrollPane);
					
					
				String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1"};
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
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
				table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기
				
				
				TableJp.add(scrollPane,null);
				
				TableJp.revalidate();
				TableJp.repaint();
				 
				
			}
		});
		
		
		
		
		
		table.getModel().addTableModelListener(this);
	
		
		
		
		
		
		
		jp.add(menuJp);
		jp.add(TableJp);
		jp.add(subMenuJp);
		jp.setVisible(true);
		
		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();
		
		
	}
	
	
	class EventHandler implements TableModelListener
	{
		
		@Override
		public void tableChanged(TableModelEvent e) {
			
			TableModel model = (TableModel) e.getSource();
			String colName = null;
			String userValue = null;
			String userCode = null;
			int column = 0;
			int row = 0;
			int columnCode = 0;
			
			
				
			if(model.getColumnCount() == 8) // 학생 컬럼 카운트
			{
				
				row = e.getFirstRow();
				column = e.getColumn();
				columnCode = 0;
				System.out.println(column);
				
				
				if (column > 0) // 이름
				{ 	
					userCode = (String)model.getValueAt(row , columnCode);
					// 컬럼번호가 2이면 "나이" 컬럼이다. 컬럼인덱스는 0부터 시작한다.
					colName = model.getColumnName(column); //해당 인덱스의 컬럼이름을 받아온다.
					userCode = (String)model.getValueAt(row , columnCode); // 코드
					userValue = (String) model.getValueAt(row, column); // data는 object 타입이므로 형변환해야 한다.	 //패스워드			
				}			
				
				spaceController.adminModifyMember(Integer.parseInt(userCode),userValue); 
			}			
			
			colName = null;
			userCode = null;
			userValue = null;
			column = 0;
		}
			
		
			
	}
	

	
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
			System.out.println("1. 모든방 검색 ");
			System.out.println("2. 방번호로 찾기");
			System.out.println("3. 룸 수정 노트북 갯수");
			System.out.println("4. 모든 매출" );		
			System.out.println("5. back");
			System.out.print("번호 입력 : ");
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


