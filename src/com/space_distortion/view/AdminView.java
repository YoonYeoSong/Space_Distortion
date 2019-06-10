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
	
	// 전체 패널
	private JPanel jp;
	// 멤버 방 스낵 예약 페이 버튼 담고있는 패널
	private JPanel menuJp;
	// 테이블을 담고 있는 패널
	private JPanel TableJp;
	// 검색 삭제 쿠폰 발행 파일 텍스트 담고있는 패널
	private JPanel subMenuJp;
	// 멤버 버튼
	private JButton btn1Member;
	// 룸 버튼
	private JButton btn2RoomInfo;
	// 스낵 버튼
	private JButton btn3Snack;
	// 예약 버튼
	private JButton btn4Reservation; 
	// 페이먼트 버튼
	private JButton btn5TotalPay; 
	// 삭제 버튼
	private JButton btn6Delete; 
	// 검색 버튼
	private JButton btn7Search;
	// 백 버튼
	private JButton btn8Back;
	// 쿠폰 버튼
	private JButton btnCoupon; 
	// adminSnack
	private JButton btnAdminSnack;
	// 이름 입력 텍스트
	private JTextField nameField;
	// 인덱스 입력 텍스트
	private JTextField numberField;
	//메인 배경 라벨
	JLabel mainBackLabel; 
	// 메뉴 배경 라벨
	JLabel menuBackLabel; 
	// 테이블 배경 라벨
	JLabel tableBackLabel;
	// 서브 배경 라벨
	JLabel subBackLabel;
	// 이름 라벨
	JLabel nameLabel;
	// 인덱스 라벨
	JLabel indexLabel;
	// 메뉴 라벨
	JLabel menuLabel;
	// 서브 메뉴 라벨
	JLabel subMenuLabel;
	// 로고 라벨(아직 미사용)
	JLabel logoLabel;
	// 어드민
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
		
		//메인JP
		jp = new JPanel();
		jp.setBounds(0, 0, 1024, 768);
		jp.setLayout(null);
		
		mainBackLabel = new JLabel();
		URL mainBackpath = this.getClass().getResource("main.png");
		mainBackLabel.setIcon(new ImageIcon(mainBackpath));
		mainBackLabel.setBounds(0, 0, 1024, 768);
				
		//menuJP
		menuJp = new JPanel();
		menuJp.setBounds(12, 20, 990, 164);
		menuJp.setLayout(null);
		
		menuBackLabel = new JLabel();
		menuBackLabel.setBounds(0, 0, 1024, 164);
		menuBackLabel.setLayout(null);
		URL menuBackpath = this.getClass().getResource("sub.png");
		menuBackLabel.setIcon(new ImageIcon(menuBackpath));
		
		// 테이블 JP
		TableJp = new JPanel();
		TableJp.setBounds(12, 194, 990, 365);
		TableJp.setLayout(null);
		
		
		tableBackLabel = new JLabel();
		tableBackLabel.setIcon(new ImageIcon(AdminView.class.getResource("/com/space_distortion/view/sub.png")));
		tableBackLabel.setBounds(0, 0, 1024, 365);
		
		// 멤버 버튼
		btn1Member = new JButton();
		URL memberpath = this.getClass().getResource("Member1.png");	
		btn1Member.setIcon(new ImageIcon(memberpath));
		btn1Member.setBounds(20, 100, 140, 55);
		btn1Member.setBorderPainted(false);
		btn1Member.setContentAreaFilled(false);
		btn1Member.setFocusPainted(false);
		btn1Member.setOpaque(false);
		menuBackLabel.add(btn1Member);
		
		// 룸 버튼
		btn2RoomInfo = new JButton();
		URL roomInfopath = this.getClass().getResource("RoomInfo1.png");
		btn2RoomInfo.setIcon(new ImageIcon(roomInfopath));
		btn2RoomInfo.setBounds(btn1Member.getX()+200, btn1Member.getY(), 140, 55);
		btn2RoomInfo.setBorderPainted(false);
		btn2RoomInfo.setContentAreaFilled(false);
		btn2RoomInfo.setFocusPainted(false);
		btn2RoomInfo.setOpaque(false);		
		menuBackLabel.add(btn2RoomInfo);		
			
		// 스낵 버튼
		btn3Snack = new JButton();
		btn3Snack.setBounds(btn2RoomInfo.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());		
		URL snackpath = this.getClass().getResource("snack1.png");	
		btn3Snack.setIcon(new ImageIcon(snackpath));
		btn3Snack.setBorderPainted(false);
		btn3Snack.setContentAreaFilled(false);
		btn3Snack.setFocusPainted(false);
		btn3Snack.setOpaque(false);		
		menuBackLabel.add(btn3Snack);
		
		
		// 페이먼트 버튼
		btn5TotalPay = new JButton(); //setBounds(btn3Snack.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		btn5TotalPay.setBounds(btn3Snack.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());	
		URL totalpaypath = this.getClass().getResource("TotalPay1.png");	
		btn5TotalPay.setIcon(new ImageIcon(totalpaypath));
		btn5TotalPay.setBorderPainted(false);
		btn5TotalPay.setContentAreaFilled(false);
		btn5TotalPay.setFocusPainted(false);
		btn5TotalPay.setOpaque(false);		
		menuBackLabel.add(btn5TotalPay);
		
		// 예약 버튼
		btn4Reservation = new JButton(); //setBounds(btn4Reservation.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		btn4Reservation.setBounds(btn5TotalPay.getX()+200, btn1Member.getY(), btn1Member.getWidth(), btn1Member.getHeight());
		URL reservationpath = this.getClass().getResource("admin1.png");	
		btn4Reservation.setIcon(new ImageIcon(reservationpath));
		btn4Reservation.setBorderPainted(false);
		btn4Reservation.setContentAreaFilled(false);
		btn4Reservation.setFocusPainted(false);
		btn4Reservation.setOpaque(false);		
		menuBackLabel.add(btn4Reservation);
		
		//메뉴 글씨
		menuLabel = new JLabel("Admin Management");
		menuLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		menuLabel.setFont(new Font("Verdana", Font.PLAIN, 60));
		menuLabel.setBounds(219, 0, 751, 74);
		menuBackLabel.add(menuLabel);
		
		//백 버튼
		btn8Back = new JButton();
		URL backpath = this.getClass().getResource("back1.png");		
		btn8Back.setIcon(new ImageIcon(backpath));
		btn8Back.setBounds(30, 10, 100, 40);		
		btn8Back.setBorderPainted(false);
		btn8Back.setContentAreaFilled(false);
		btn8Back.setFocusPainted(false);
		btn8Back.setOpaque(false);
		
		
		
		
		// 버튼 이미지 이벤트
		btn1Member.addMouseListener(new MouseAdapter() {
			
			//마우스버튼이 눌러졌을떄
			@Override
			public void mousePressed(MouseEvent e) {
				URL memberPressed = this.getClass().getResource("Member2.png");
				btn1Member.setIcon(new ImageIcon(memberPressed));
			}
			
			// 마우스 버튼이 떼어질때
			@Override
			public void mouseReleased(MouseEvent e) {
				URL memberReleased = this.getClass().getResource("Member1.png");
				btn1Member.setIcon(new ImageIcon(memberReleased));
			}
			
		});
		
		// 버튼 이미지 이벤트
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
		
		
		// 버튼 이미지 이벤트
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
		
		// 버튼 이미지 이벤트
		btn4Reservation.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL reservationPressed = this.getClass().getResource("admin2.png");
				btn4Reservation.setIcon(new ImageIcon(reservationPressed));
			}
					
			@Override
			public void mouseReleased(MouseEvent e) {
				URL reservationReleased = this.getClass().getResource("admin1.png");
				btn4Reservation.setIcon(new ImageIcon(reservationReleased));
			}
			
		});
		
		// 버튼 이미지 이벤트
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
		

		// 버튼 이미지 이벤트
		btn8Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton)e.getSource();
				System.out.println("클릭");
				URL backPressed = this.getClass().getResource("back2.png");
				btn8Back.setIcon(new ImageIcon(backPressed));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL backReleased = this.getClass().getResource("back1.png");
				btn8Back.setIcon(new ImageIcon(backReleased));
			}
			
			
			
		});
			
		// 백 버튼 메인으로		
		btn8Back.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, 8, sc, mainJframe, jp));
		menuBackLabel.add(btn8Back);
		
		
		
		
		//메뉴 배경라벨
		menuJp.add(menuBackLabel);
		
		// 기본 테이블모델을 설정
		defaultModel = new DefaultTableModel(0, 0);
		// 기본 테이블을 테이블에 결합
		table = new JTable(defaultModel);
		// 스크롤 펜에 테이블을 넣는다
		scrollPane = new JScrollPane(table);
		scrollPane.setLocation(12, 10);
		scrollPane.setSize(960, 340);  // 960 340
		
		tableBackLabel.add(scrollPane,null);
	
		
		TableJp.add(tableBackLabel);
		
		defaultModel = new DefaultTableModel(0,0);
		table = new JTable(defaultModel);
			
		// 서브 메뉴 JP
		subMenuJp = new JPanel();
		subMenuJp.setBounds(12, 570, 990, 140);
		subMenuJp.setLayout(null);
		
		// 흰색 바탕의 서브 메뉴라벨
		subBackLabel = new JLabel();
		subBackLabel.setBounds(0, 0, 990, 140);
		subBackLabel.setLayout(null);
		URL subBackpath = this.getClass().getResource("sub.png");
		subBackLabel.setIcon(new ImageIcon(subBackpath));
		
		
		
		// 멤버 이름 찾기 또는 과자이름
		nameField = new JTextField(); 
		nameField.setBounds(571, 75, 149, 48);
		subBackLabel.add(nameField);
		// 인덱스 찾기 
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
				
		// 삭제 버튼
		btn6Delete = new JButton();
		btn6Delete.setBounds(847, 74, 117, 48);
		btn6Delete.setName("삭제");
		URL deletepath = this.getClass().getResource("delete1.png");	
		btn6Delete.setIcon(new ImageIcon(deletepath));
		btn6Delete.setBorderPainted(false);
		btn6Delete.setContentAreaFilled(false);
		btn6Delete.setFocusPainted(false);
		btn6Delete.setOpaque(false);
		subBackLabel.add(btn6Delete);
		
		// 검색 버튼
		btn7Search = new JButton();
		btn7Search.setBounds(726, 74, 117, 48);
		btn7Search.setName("검색");
		URL searchpath = this.getClass().getResource("search1.png");	
		btn7Search.setIcon(new ImageIcon(searchpath));
		btn7Search.setBorderPainted(false);
		btn7Search.setContentAreaFilled(false);
		btn7Search.setFocusPainted(false);
		btn7Search.setOpaque(false);
		
		// 쿠폰 발행 버튼
		btnCoupon = new JButton();
		btnCoupon.setName("쿠폰");
		URL couponPath = this.getClass().getResource("Coupon1.png");		
		btnCoupon.setIcon(new ImageIcon(couponPath));
		btnCoupon.setBounds(10, 74, 117, 48);	
		btnCoupon.setBorderPainted(false);
		btnCoupon.setContentAreaFilled(false);
		btnCoupon.setFocusPainted(false);
		btnCoupon.setOpaque(false);	
		subBackLabel.add(btnCoupon);
		
		
		btnAdminSnack = new JButton();
		btnAdminSnack.setName("AdminSnack");
		btnAdminSnack.setBounds(10, 30, 117, 48);	
		btnAdminSnack.setBorderPainted(false);
		btnAdminSnack.setContentAreaFilled(false);
		btnAdminSnack.setFocusPainted(false);
		btnAdminSnack.setOpaque(false);	
		subBackLabel.add(btnAdminSnack);
		
		
		btnAdminSnack.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_NUM, ADMIN_VIEW_BUTTON9, sc, mainJframe,jp));
		
		// 삭제 버튼 이미지
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
		
		// 검색 버튼 이미지
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
		
		
		
		
		btnCoupon.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				URL couponPressed = this.getClass().getResource("Coupon2.png");
				btnCoupon.setIcon(new ImageIcon(couponPressed));
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				URL couponReleased = this.getClass().getResource("Coupon1.png");
				btnCoupon.setIcon(new ImageIcon(couponReleased));
			}
			
		});
		
		
		subBackLabel.add(btn7Search);
		
		
		//subMenuJp.add(logoLabel);
		
		
		// 검색 기능에서 입력한 값에 대한 판별 
		// 명칭만 가능 ( 특수문자 숫자 가 들어가면 바로바로 삭제 )
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
		
		// 스낵 관련 검색
		// 스낵관련 인덱스 1,2만가능 다른게 들어가면 바로 삭제
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
		
		
		// 회원 버튼
		btn1Member.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("하이");
				
				//URL memberPressed = this.getClass().getResource("Member2.png");
				//btn1Member.setIcon(new ImageIcon(memberPressed));
				// 기본 테이블이 있는지 값을 가지고 있는지 판별 있다면 초기화
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				//TableJP  ->ScollPane -> Table -> DefaultTable
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				
				// modelName 열에 대한 배열
				// adminSearchAllMember 메소드 실행 controller에 있는 메소드
				// 인자값으로 modelName을 받는다.
				String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1","쿠폰"};
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName),modelName) {
					
					@Override
					public boolean isCellEditable(int row, int column) {

						// 칼럼에 대한 true 이면 컬럼 edit가능 false면 불가능
						// 예시로 비밀번호 컬럼만 수정가능
						if (0 <= column && column < 3) {
							return false;
						} else if (column == 3) {
							return true;
						} else if (column > 3 && column < 9) {
							return false;
						} else {
							return false;
						}
					}
				};
				
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				// 한개의 Row만 선택가능
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// 열에 대한 컬럼을 못움직이게 함
				table.getTableHeader().setReorderingAllowed(false);
				// 테이블에 대한 에디터
				// 임시로 내부 클래스를 받아 사용
				table.getModel().addTableModelListener(new Hendler(btn1Member, table));

				nameField.setName("회원");
				numberField.setName(null);

				nameField.setVisible(true);
				nameField.setEnabled(true);

				numberField.setVisible(false);

				nameLabel.setVisible(true);
				indexLabel.setVisible(false);

				btn6Delete.setVisible(true);
				btn7Search.setVisible(true);

				tableBackLabel.add(scrollPane, null);
				// TableJp.add(scrollPane,null);

				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				// TableJp.revalidate();
				// TableJp.repaint();

			}
		});
		
		
		btn2RoomInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 초기화
				if (defaultModel != null || table != null) {
					defaultModel = null;
					table = null;
				}

				// TableJP ->ScollPane -> Table -> DefaultTable
				// TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);

				// 룸에 대한 메소드 발생 테이블 작성
				String[] modelName = { "룸 번호", "룸 이름", "최대 인원(명)", "노트북(수량)" };
				defaultModel = new DefaultTableModel(spaceController.adminSearchAllRoomInfo(modelName), modelName) {
					@Override
					public boolean isCellEditable(int row, int column) {

						// 모든 컬럼 조작 불가능
						return false;
					}
				};

				// 테이블 생성
				table = new JTable(defaultModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setLocation(12, 10);
				scrollPane.setSize(960, 340);
				// 한개의 Row만 선택 가능
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// 테이블에 대한 칼럼을 못움직이게함
				table.getTableHeader().setReorderingAllowed(false);

				// table.getModel().addTableModelListener(new Hendler(btn1Member));

				nameField.setName("회원");
				numberField.setName(null);

				nameField.setVisible(false);
				nameField.setEnabled(false);

				numberField.setVisible(false);
				numberField.setVisible(false);

				nameLabel.setVisible(false);
				indexLabel.setVisible(false);

				// TableJp.add(scrollPane,null);
				tableBackLabel.add(scrollPane);

				tableBackLabel.revalidate();
				tableBackLabel.repaint();
				// TableJp.revalidate();
				// TableJp.repaint();

			}
		});
			
		// 스낵 버튼
		btn3Snack.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("스낵");
							
				if(defaultModel != null || table != null)
				{
					defaultModel = null;
					table = null;					
				}
				
				//TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);
				// 스낵에 대한 정보 가져오기
				String[] modelName = {"스낵인덱스","스낵이름","수량","가격","코멘트"};
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
				// 한개의 Row를 가져와 선택
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
				// 칼럼 못움직이게 하기
				table.getTableHeader().setReorderingAllowed(false);	
				
				
				table.getModel().addTableModelListener(new Hendler(btn6Delete,table));
				
				
				System.out.println(table.getModel().getColumnCount());
							
				nameField.setName("스낵");
				numberField.setName("스낵번호");
				
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
		
		//예약 
		btn4Reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				if(defaultModel != null || table != null)
//				{
//					defaultModel = null;
//					table = null;					
//				}
//				
//				tableBackLabel.remove(scrollPane);
//				// 예약쪽은 미구현중 디폴트 값에 로우 하나만 들어가있다.
//				String[] modelName = {"예약"};
//				String[][] reservation = new String[1][1];
//				reservation[0][0] = "아직 구현 중 (미 구 현)";
//				defaultModel = new DefaultTableModel(reservation,modelName){
//					 @Override
//					    public boolean isCellEditable(int row, int column) {
//						 
//					        return false;
//					    }
//					};
//							
//				table = new JTable(defaultModel);
//				scrollPane = new JScrollPane(table);
//				scrollPane.setLocation(12, 10);
//				scrollPane.setSize(960, 340);
//				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
//				table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기			
//				
//				
//				//table.getModel().addTableModelListener(new Hendler(btn6Delete,table));
//				
//		
//				nameField.setVisible(false);
//				nameField.setEnabled(false);
//				
//				numberField.setVisible(false);
//				numberField.setEnabled(false);
//				
//				nameLabel.setVisible(false);
//				indexLabel.setVisible(false);
//				
//				btn6Delete.setVisible(false);
//				btn7Search.setVisible(false);
//				
//				
//				//TableJp.add(scrollPane,null);	
//				//TableJp.revalidate();
//				//TableJp.repaint();
//				
//				tableBackLabel.add(scrollPane);
//				tableBackLabel.revalidate();
//				tableBackLabel.repaint();
				int ans = JOptionPane.showConfirmDialog(null, "List들을 추가 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(ans == 0)
				{
					sc.adminInit();					
				}
				else
				{
					return;
				}
				
				
				
			}
		});
		
		
		// 매출 총액	
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
				// 매출에 대한 정보를 가져온다.
				String[] modelName = {"userCode","매출","날짜"};
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
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
				table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기			
				
				
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
					// 삭제할지 말지 다이얼로그로 판별
					int ans = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					// true 0
					if(ans == 0)
					{					
						// 칼럼의 수로 스낵 판별 5 
						if(table.getColumnCount() == 5)
						{
							int row = table.getSelectedRow(); // 선택된 줄
							String selectName = table.getValueAt(row, 1).toString(); // 선택된 줄 에 1번째 칼럼 
							spaceController.adminDelSnack(selectName);
							defaultModel.removeRow(table.getSelectedRow());
						}
						// 칼럼의 수로 회원 판별 9
						else if(table.getColumnCount() == 9) 
						{
							int row = table.getSelectedRow(); // 선택된 줄
							String selectName = table.getValueAt(row, 0).toString(); // 선택줄에 0번째 칼럼
							spaceController.adminDelMember(Integer.parseInt(selectName));
							defaultModel.removeRow(table.getSelectedRow());
						}
						// 다른 경우 경고 메시지
						else if(table.getColumnCount() == 4)
						{
							JOptionPane.showMessageDialog(null, "방 정보는 지울 수 없어!", "경고", JOptionPane.WARNING_MESSAGE);
							return;
						}
						// 다른 경우 경고 메시지
						else if(table.getColumnCount() == 3)
						{
							JOptionPane.showMessageDialog(null, "매출 정보를 지울 수 없어!", "경고", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
					}else
					{
						return;
					}
					
				}				
			}
		});
			
		// 이름 검색
		btn7Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (defaultModel != null || table != null) {
					defaultModel = null;
					table = null;
				}

				// TableJp.remove(scrollPane);
				tableBackLabel.remove(scrollPane);

				if (nameField.getName() == "회원") {
					
					// 회원쪽에 제대로 입력 했는지 판별 후 값을 메소드로 넘겨준다.
					String[] modelName = { "회원코드", "이름", "이메일", "비밀번호", "주소", "핸드폰 번호", "생년월일", "학생이면 1" };
					defaultModel = new DefaultTableModel(
							spaceController.adminSearchMember(modelName, nameField.getText()), modelName) {
						@Override
						public boolean isCellEditable(int row, int column) {

							return column != 0;
						}
					};

					table = new JTable(defaultModel);
					scrollPane = new JScrollPane(table);
					scrollPane.setLocation(12, 10);
					scrollPane.setSize(960, 340);
					// 한개의 로우만 선택 가능
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
					// 칼럼을 못움직이게 하기
					table.getTableHeader().setReorderingAllowed(false); 

				} else if (nameField.getName() == "스낵" && numberField.getName() == "스낵번호") {

					tableBackLabel.remove(scrollPane);
					// TableJp.remove(scrollPane);
					System.out.println("여기 이름 텍스트 " + nameField.getText());
					System.out.println("여기는 넘버 텍스트 : " + numberField.getText());

					numberField.addKeyListener(new KeyAdapter() {

						@Override
						public void keyPressed(KeyEvent e) {
							char c = e.getKeyChar();
							if (!Character.isDigit(c)) {
								e.consume();
								return;
							}
						}
					});

					String[] modelName = { "스낵인덱스", "스낵이름", "수량", "코멘트" };

					int index = 0;
					String name = null;

					// 널인지 체크하고 값을 넘겨준다
					if (nameField.getText().equals(""))
						name = null;
					else
						name = nameField.getText();

					if (numberField.getText().equals(""))
						index = 0;
					else
						index = Integer.parseInt(numberField.getText());

					// 체크가 끝난 후 형식에 맞춰 인덱스와 이름 칼럼의 수를 반환
					defaultModel = new DefaultTableModel(spaceController.adminSearchSnack(index, name, modelName),
							modelName) {
						@Override
						public boolean isCellEditable(int row, int column) {

							return false;
						}
					};

					table = new JTable(defaultModel);
					scrollPane = new JScrollPane(table);
					scrollPane.setLocation(12, 0);
					scrollPane.setSize(961, 365);
					// 한개의 Row만 선택가능
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					// 컬럼을 못움직이게 하기
					table.getTableHeader().setReorderingAllowed(false); 

				}

				nameField.setText(null);
				numberField.setText(null);

				// TableJp.add(scrollPane,null);

				// TableJp.revalidate();
				// TableJp.repaint();

				tableBackLabel.add(scrollPane);
				tableBackLabel.revalidate();
				tableBackLabel.repaint();

			}
		});
		
		// 쿠폰 버튼 클릭 이벤트
		btnCoupon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectedRow() == -1)
				{
					return;
				}
				else
				{
					//선택된 줄에 쿠폰을 발행 할지 여부를 묻는다.
					int ans = JOptionPane.showConfirmDialog(null, "쿠폰을 발행 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					// 0 이면 true
					if(ans == 0)
					{					
						// 컬럼의 카운트 수로 회원인지 룸인지 등 판별
						// 회원수 5 스낵
						if(table.getColumnCount() == 5)
						{
							JOptionPane.showMessageDialog(null, "잘못 접근 했어!", "경고", JOptionPane.WARNING_MESSAGE);
							return;
						}
						//칼럼수 9 회원
						else if(table.getColumnCount() == 9)
						{
							// 선댁된 줄
							int row = table.getSelectedRow();
							// 0 번째 컬럼
							String selectCode = table.getValueAt(row, 0).toString(); 
							// 회원의 0번째 컬럼은 유저 코드 이다.
							spaceController.adminCouponSend(Integer.parseInt(selectCode));
							
							// 기존에 테이블에 남아있는지 체크 후 초기화
							if(defaultModel != null || table != null)
							{
								defaultModel = null;
								table = null;					
							}
							
							// TableJP  ->ScollPane -> Table -> DefaultTable
							// TableJp.remove(scrollPane);
							tableBackLabel.remove(scrollPane);
							
							// 쿠폰 발행 후 수정된 테이블을 다시 리페인트
							// 참 리페인트 개많이 해야됨 ;;
							String[] modelName = {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1","쿠폰"};
							defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName),modelName) {
								 @Override
							    public boolean isCellEditable(int row, int column) {
								 
									 if(0 <= column && column < 3)
									 {
										 return false;
									 }
									 else if(column == 3)
									 {
										 return true;
									 }
									 else if(column > 3 && column < 9)
									 {
										 return false;
									 }
									 else
									 {
										 return false;
									 }
									 
							    }
							};
							
							table = new JTable(defaultModel);
							scrollPane = new JScrollPane(table);
							scrollPane.setLocation(12, 10);
							scrollPane.setSize(960, 340);
							// 한개의 Row만 선택 가능
							table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							// 칼럼을 못움직이게 하기
							table.getTableHeader().setReorderingAllowed(false); 
										
							table.getModel().addTableModelListener(new Hendler(btn1Member,table));
							
							
							nameField.setName("회원");
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
							

							
						}
						else if(table.getColumnCount() == 4)
						{
							JOptionPane.showMessageDialog(null, "잘못 접근 했어!", "경고", JOptionPane.WARNING_MESSAGE);
							return;
						}
						else if(table.getColumnCount() == 3)
						{
							JOptionPane.showMessageDialog(null, "잘못 접근 했어!", "경고", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
					}else
					{
						return;
					}
					
				}
				
			}
		});
	
	
		subMenuJp.add(subBackLabel);
		mainBackLabel.add(menuJp);
		mainBackLabel.add(TableJp);
		mainBackLabel.add(subMenuJp);
		
		
		
		// 리 페인트
		jp.add(mainBackLabel);
//		jp.add(menuJp);
//		jp.add(TableJp);
//		jp.add(subMenuJp);
		jp.setVisible(true);
		
		mainJframe.getContentPane().add(jp);
		jp.revalidate();
		jp.repaint();
		
			
	}
	

// 내부 클래스 테이블에 대한 에디터 등 이벤트 발생
class Hendler implements TableModelListener,KeyListener, MouseListener
{
	// 생성자로 필요한 버튼 텍스트파일 테이블 등 받아온다.
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

//		if(jtf.getName() == "Index" )
//		{
//			System.out.println("여기왔음");
//			char c = e.getKeyChar();
//			if(!Character.isDigit(c))
//			{
//				e.consume();
//				return;
//			}
//		}	
	}	
		@Override
		public void tableChanged(TableModelEvent e) {

			SpaceController sc = Main.getSpaceController();
			TableModel model = (TableModel) e.getSource();

			String colName = null;
			int column = 0;
			int row = 0;
			int columnCode = 0;

			// String returnChangeValue = (String) model.getValueAt(row, column);

			System.out.println("로우 카운트 : " + model.getRowCount());
			System.out.println("칼럼 갯수 : " + model.getColumnCount());

			int ans;
			if (table.getCellEditor() != null) {
				// 선택된 줄
				row = e.getFirstRow();
				// 칼럼이 몇인지
				column = e.getColumn();
						
				// 메세지 다이얼로그
				ans = JOptionPane.showConfirmDialog(null, "정말로 수정 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE);
				if (ans == 0) {

					if (model.getColumnCount() == 9) // 학생 컬럼 카운트
					{

						row = e.getFirstRow();
						column = e.getColumn();
						columnCode = 0;
						System.out.println(column);

						if (column > 0) // 이름
						{						
							// 컬럼번호가 2이면 "나이" 컬럼이다. 컬럼인덱스는 0부터 시작한다.
							colName = model.getColumnName(column); // 해당 인덱스의 컬럼이름을 받아온다.
							String userCode = (String) model.getValueAt(row, columnCode); // 코드
							String userValue = (String) model.getValueAt(row, column);  //data는 object 타입이므로 형변환해야 한다.
																						// //패스워드
							System.out.println(userCode + "  " + userValue);
							// 버튼에 대한 이름이 삭제가 아닐경우 발생
							// 실제 에디터로 셀을 바꿔서 직접 컨트롤러에서 값을 변경우 Admin과 controller에 모두 리스트를 수정
							if (btn.getName() != "삭제") {
								sc.adminModifyMember(Integer.parseInt(userCode), userValue);
							}
						}
					} else if (model.getColumnCount() == 5) {
						return;
						// row = e.getFirstRow();
						// column = e.getColumn();
					}
				} else {
					// 수정후 다시 출력
					// 자바 스윙이 그지같아서 리페인트 또해줘야한다.
					
					if (defaultModel != null || table != null) {
						defaultModel = null;
						table = null;
					}

					// TableJP ->ScollPane -> Table -> DefaultTable
					// TableJp.remove(scrollPane);
					tableBackLabel.remove(scrollPane);

					String[] modelName = { "회원코드", "이름", "이메일", "비밀번호", "주소", "핸드폰 번호", "생년월일", "학생이면 1", "쿠폰" };
					defaultModel = new DefaultTableModel(spaceController.adminSearchAllMember(modelName), modelName) {
						@Override
						public boolean isCellEditable(int row, int column) {

							if (0 <= column && column < 3) {
								return false;
							} else if (column == 3) {
								return true;
							} else if (column > 3 && column < 9) {
								return false;
							} else {
								return false;
							}

						}
					};

					table = new JTable(defaultModel);
					scrollPane = new JScrollPane(table);
					scrollPane.setLocation(12, 10);
					scrollPane.setSize(960, 340);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 로우만 선택
					table.getTableHeader().setReorderingAllowed(false); // 컬럼 못움직이게 하기

					table.getModel().addTableModelListener(new Hendler(btn1Member, table));

					nameField.setName("회원");
					numberField.setName(null);

					nameField.setVisible(true);
					nameField.setEnabled(true);

					numberField.setVisible(false);

					nameLabel.setVisible(true);
					indexLabel.setVisible(false);

					btn6Delete.setVisible(true);
					btn7Search.setVisible(true);

					tableBackLabel.add(scrollPane, null);
					// TableJp.add(scrollPane,null);

					tableBackLabel.revalidate();
					tableBackLabel.repaint();
					return;
				}

			} else {
				return;
			}

			// colName = null;
			// userCode = null;
			// userValue = null;
			// column = 0;
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


