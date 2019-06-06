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
	private int viewIndex; // 사용하는 뷰의 인덱스
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
		//System.out.println("생성자 : " + this.buttonIndex + " / " + buttonIndex);
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
		//System.out.println("생성자 : " + this.buttonIndex + " / " + buttonIndex);
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
		//System.out.println("생성자 : " + this.buttonIndex + " / " + buttonIndex);
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

		//System.out.println("생성자 : " + this.buttonIndex + " / " + buttonIndex);
	}
	
	

///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public SpaceActionEvent() {
		//System.out.println("기본 생성자 :" + buttonIndex);
		// TODO Auto-generated constructor stub
	}
	
/////////  뷰 이벤트 메소드  /////////////////////////////////////////////////////////////////
	
	// 메인뷰 버튼 이벤트
	public void mainViewSelected() {
		System.out.println("메인버튼 클릭 이벤트");
		
		if(buttonIndex == 1) {
			System.out.println("1번방 선택");
			jf.remove(jp);
			//jp.revalidate();
			//jp.repaint();
			sc.subRoomView(buttonIndex);
			// 서브 로그인 뷰
		} 
		else if(buttonIndex == 2) {
			System.out.println("2번방 선택");
		}
		else if(buttonIndex == 3) {
			System.out.println("종료 합니다.");
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
			//관리자뷰로이동
			jf.remove(jp);
			sc.adminView();
		}
			System.out.println("err....");
	}

	// 메인뷰 서브 이벤트
	public void subRoomViewSelected() {
		System.out.println("메인 서브뷰 이벤트");
		// 회원, 비회원, 예약, 홈으로
		if(buttonIndex == 1) {
			System.out.println("회원 버튼 선택");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.loginView();
		}
		System.out.println(buttonIndex);
		if(buttonIndex == 2) {
			System.out.println("비 회원 선택");
			jf.remove(jp);
			sc.nAccountView();
			
		}else if(buttonIndex == 3) {
			System.out.println("예약 선택");
//			System.out.println(this.buttonIndex);
			// 예약 view load
		}else if(buttonIndex == 4) {
			System.out.println("뒤로 가기 선택");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");
		
		
		
	}
	
	// 로긴 버튼 이벤트
	public void loginViewSelected() {
		System.out.println("로긴버튼 클릭 이벤트");
		// 회원 가입, 로긴, ID & PW 찾기
		
		if(buttonIndex == 1) {
			System.out.println("회원 가입 선택");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("비회원 로긴 선택");
			
			// 비회원로그인 바로 페이먼트로 이동
			
			jf.remove(jp);
			sc.paymentView();
		}else if(buttonIndex == 3) {
			
			//로그인
			// 로그인 성공시 페이먼트 뷰로 이동
			jf.remove(jp);
			sc.paymentView();
			// 찾기 페이지로 이동
		}else
			//생성 해야되는 부분
			//System.out.println("ID & PW 찾기");
			
			//
			System.out.println("err....");

	}
	
	// 회원 가입 이벤트
	public void accountViewSelected() {
		System.out.println("회원 관리 버튼 클릭 이벤트");
		
		if(buttonIndex == 1) {
			System.out.println("홈으로");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("다음으로");
			jf.remove(jp);
			sc.accoutView2();
		}	
	}
	
	// 회원 가입 서브 이벤트
	public void subAccountViewSelected() {
		System.out.println("서브 회원 관리 버튼 클릭 이벤트");
		
		if(buttonIndex == 1) {
			System.out.println("홈으로");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("회원 가입 확인");
			jf.remove(jp);
			sc.loginView();
		}
		
	}
	
	// 비회원 이벤트
	public void nAccountViewSelected()
	{
		if(buttonIndex == 1)
		{
			jf.remove(jp);
			sc.paymentView();
		}
	}
	
	// 추가시간 이벤트
	public void addTimeRoomViewSelected() {
		System.out.println("추가 시간 버튼 클릭 이벤트");
		
	}
	
	// 관리자 이벤트
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
				if( jt.getColumnCount() == 4) // 일때 스낵
				{
					int row = jt.getSelectedRow();
					int column = jt.getSelectedColumn();
					//System.out.println(jt.getColumnCount());
					String selectName = jt.getValueAt(row, 1).toString();
					sc.adminDelSnack(selectName);
					dt.removeRow(jt.getSelectedRow());
					//jt.setce					
				}
				else if(jt.getColumnCount() == 8) // 8일때 회원
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
	
	// 결재정보 이벤트
	public void paymentViewSelected() {
		System.out.println("지불정보 버튼 클릭 이벤트");
		
		if(buttonIndex == 1) {
			System.out.println("회원 가입 선택");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("지불 하기");
			// 결재 지불
			jf.remove(jp);
			sc.paymentView();
			
		}else if(buttonIndex == 3) {
			System.out.println("홈으로");
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");
		
	}
	
	// 간식 뷰 이벤트
	public void snackViewSelected() {
//		System.out.println("간식 버튼 클릭시 이벤트");
		
		/*
		 * 버튼 갯수에 따른 이벤트 처리
		 */
		switch (buttonIndex) {
			case SNACK_BAR_VIEW_NEXT:
				jf.remove(jp);
				System.out.println("프레임 지우기성공");
				sc.paymentView();
				break;
			case SNACK_BAR_VIEW_CANSLE:
//				System.out.println("버튼 인덱스 2 :" + buttonIndex);
				jf.remove(jp);
				System.out.println("프레임 지우기성공2");
				sc.subRoomView(buttonIndex);
				break;
			default:
				sc.snackSelList(buttonIndex);
				break;
		}
		
//		System.out.println("인덱스가 뭐냐:??? " + buttonIndex);
//		System.out.println(buttonIndex);
//		System.out.println();
//		if(buttonIndex == 1) {	// 음료를 선택한 경우
//			System.out.println("과자 이벤트");
//			sc.snackSel(1);
//			System.out.println("과자 버튼 인덱스 : " + buttonIndex);
				
			
//		}else if(buttonIndex == 2) { // 과자를 선택한 경우
//			System.out.println("음료 이벤트");
//			sc.snackSel(2);
//			List<SnackBar> list = sc.snackSel(2);
//			sc.snackSelList();
//
//		}else
//			System.out.println("snack err...");
		
		
	}

	
///////// 뷰 이벤트          /////////////////////////////////////////////////////////////////
	
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
//		System.out.println("로우 카운트 : " +  model.getRowCount());
//		System.out.println("칼럼 갯수 : "  + model.getColumnCount());
//		
//		if(model.getColumnCount() == 8) // 학생 컬럼 카운트
//		{
//			
//			row = e.getFirstRow();
//			column = e.getColumn();
//			columnCode = 0;
//			System.out.println(column);
//			
//			
//			if (column > 0) // 이름
//			{ 	
//				//System.out.println("여기");
//				//System.out.println(column);
//				//System.out.println(model.toString());
//				//userCode = (String)model.getValueAt(row , columnCode);
//				// 컬럼번호가 2이면 "나이" 컬럼이다. 컬럼인덱스는 0부터 시작한다.
//				colName = model.getColumnName(column); //해당 인덱스의 컬럼이름을 받아온다.
//				userCode = (String)model.getValueAt(row , columnCode); // 코드
//				userValue = (String) model.getValueAt(row, column); // data는 object 타입이므로 형변환해야 한다.	 //패스워드			
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
