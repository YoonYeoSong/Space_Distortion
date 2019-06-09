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


// 메인 패널 생성
// 좌 우 패널 생성
// 좌 상단 아이콘 버튼 패널
// 좌 하단 : jlist, 버튼 2개

// 우
// 우 상당 라벨 ->
// 우 하단 : 토탈 테이블(&&라벨), 뒤로, 다음 버튼

public class SnackBarView implements ViewIndex{

	private JPanel leftTopIconPj;
	private JButton leftItemBtn[];
	private JPanel jSrpColumnpanel[];
	private JLabel leftItemLb[];
	private JPanel rightJp, rightMiJp;
	private JPanel rightTopPj;
	private int index = 1;	// jlist 인덱스
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

		// 프레임 위에 메인 패널
		JPanel mainJp = new JPanel();
		mainJp.setBounds(0, 0, mainJFrame.getWidth(), mainJFrame.getHeight()); //(0,0,1024,768)
		mainJp.setLayout(null);

		//////////// 좌우 패널 셋팅   ////////////
		// 좌측 패널
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

		// 우측 패널
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
		
		
		//////////// 상단 패널 셋팅   ////////////
		
		// 좌측 상단 패널1
		leftTopIconPj = new JPanel();
//		leftTopIconPj.setBounds(0, 0, leftJp.getWidth()/2, leftJp.getHeight()/3);
		leftTopIconPj.setBorder(BorderFactory.createLineBorder(Color.red));

		// 스크롤 패널 추가
		jSrp = new JScrollPane(leftTopIconPj);	// 스크롤에 패널추가
		jSrp.setBounds(leftJp.getWidth()/6, leftJp.getHeight()/7, leftJp.getWidth()/6 *4, (leftJp.getHeight()/7) * 3);
//		jSrp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		jSrp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 4 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		leftTopIconPj.setPreferredSize(new Dimension((120*list.size()), 100));		// 내부 패널의  사이즈를 가져와 지정 (가로 600까지 늘어나고 , 세로 100까지)
																					// 내부 패널 갯수만큼 사이즈 조
		// 좌측 상단 버튼 추가(호출)
		leftBtnInit(smc, list, index);

		// 우 상단 패널 생성
		rightTopPj = new JPanel();
		rightTopPj.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7, rightJp.getWidth()/6 * 4, (rightJp.getHeight()/7) * 3);
		rightTopPj.setBackground(Color.cyan);
		rightTopPj.setLayout(new GridLayout());

		// 우 상단 테이블 생성

		String columnNames[] = {
				"상품이름", "수량", "상품가격"
		};

		DefaultTableModel dfTableModel = new DefaultTableModel(null, columnNames);
		JTable jTb = new JTable(dfTableModel);
		JScrollPane jScpane = new JScrollPane(jTb);

		rightTopPj.add(jScpane);

		// test 행 한줄 추가!
//		Object [] temporaryObject = { 4, "초코송이", 500};
//		dfTableModel.addRow(temporaryObject);

		//행과 열 갯수 구하기
//		System.out.println(dfTableModel.getRowCount());
//		System.out.println(dfTableModel.getColumnCount());

		//컬럼(열)의 index는 0부터 시작한다!!
//		System.out.println(dfTableModel.getColumnName(0));

		//0행을 삭제하면 제목행을 제외하고 첫째행을 삭제한다!!
//		dfTableModel.removeRow(0);

		//값을 얻어올 때도 0부터 index가 시작된다는 것에 주의한다!!
//		System.out.println(dfTableModel.getValueAt(2, 2));

		//특정 좌표의 값을 바꾸는 것은 setValueAt()
//		dfTableModel.setValueAt("5000", 2, 2);

		//테이블에 Row를 미리 선택한 상태로 만들기!
//		jTb.setRowSelectionInterval(0, 0);

		//////////// 하단 패널 셋팅   ////////////
		
		// 좌측 하단 패널2
		JPanel leftMiPj = new JPanel();
		leftMiPj.setBounds(leftJp.getWidth()/6, leftJp.getHeight()/5 + jSrp.getHeight() - 15
		, jSrp.getWidth(), jSrp.getHeight() / 2);
//		leftMiPj.setBackground(Color.lightGray);
		leftMiPj.setLayout(null);

		// 우 중단 패널2
		rightMiJp = new JPanel();
		rightMiJp.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7 + rightTopPj.getHeight()
				, rightTopPj.getWidth(), rightTopPj.getHeight()/4);
		rightMiJp.setLayout(null);
//		rightMiPj.setBackground(Color.orange);
		
		////// 우측 레이블 , 라디오 버튼 생성
		
		// 콤보박스 테스트
//		this.rightComboInit(smc);
		

		// 우 하단 패널3
		JPanel rightBtPj = new JPanel();
		rightBtPj.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/4 + rightTopPj.getHeight() + 15
				, rightTopPj.getWidth(), rightTopPj.getHeight()/3 - 10);
		rightBtPj.setLayout(null);



		// 좌측 버튼 생성 하단 (음료, 과자)
		JButton leftDrinkBtn = new JButton("홈으로");
		leftDrinkBtn.setBounds(0, (leftMiPj.getHeight()/5)*4, 100, 30);

		// 좌측 버튼(이벤트)
		leftDrinkBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainJp));

		// 우측 버튼 생성 하단 (뒤로가기, 다음)
		JButton rightBackBtn = new JButton("수량 변경");
		rightBackBtn.setBounds(30, 0, 100, 30);
		JButton rightNextBtn = new JButton("결  재");
		rightNextBtn.setBounds(30, (rightMiJp.getHeight()/8)*5, 100, 30);
		
		// 우측 버튼(이벤트)
		rightNextBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainJp));

		////////////////////////////////////////////////////////////////////////////////////
		// 파싱
		
		String[] fstr = smc.snackTitle();
//		System.out.println(fstr[1]);
		JList jlist = new JList(fstr);
//		char str = Character.toLowerCase('a');
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	// 단일 선택
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

				// 리스트의 아이템을 가져옴	
				String str = jlist.getSelectedValue().toString();
				// 간식 리스트의 종류의 인덱스를 설정
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
		 *  패널 합
		 */

		// 스크롤 추가jSrp
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
	
	
	//	스낵 이미지 버튼 생성  
	public void leftBtnInit(SpaceController smc, List<SnackBar> list, int index) {
	
	list = smc.snackSel(index);

	leftTopIconPj.removeAll(); // 기존에 있던 패널의 아이콘 클리어
//	if(rightMiJp == null) {
//		rightMiJp = new JPanel();
//	}
	
	leftItemBtn = new JButton[list.size()];	// 아이템 갯수만큼 크기를 가져와야함
	jSrpColumnpanel = new JPanel[list.size()];
	leftItemLb = new JLabel[list.size()];
	
	leftTopIconPj.setLayout(new GridLayout(3, 10, 10, 10));
//	leftTopIconPj.setPreferredSize(new Dimension(100,110));

//	jSrp.revalidate();
	leftTopIconPj.revalidate();
	leftTopIconPj.repaint();
	
//	int width = 0; // 스크롤 크기에 대한 정보변
	// 스크롤 내부 패널 추가
//	System.out.println("사이즈 : " + list.size());
	for (int i = 0; i < list.size(); i++) {
		
//		if(i != 0) width += 120;
		// 패널 생성
		jSrpColumnpanel[i] = new JPanel();
		jSrpColumnpanel[i].setBackground(Color.blue);
//		jSrpColumnpanel[i].setBounds(0, 0, 90, 95);
		jSrpColumnpanel[i].setPreferredSize( new Dimension(90 , 95 ));
		jSrpColumnpanel[i].setLayout(null);
		

		// 내부 패널의 버튼 생성
		leftItemBtn[i] = new JButton(list.get(i).getSnack() + " Image");
		leftItemBtn[i].setBounds(2, 2, 86, 75);
		
		leftItemBtn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		// 내부 레이블 생성
		leftItemLb[i] = new JLabel();
		leftItemLb[i].setText(list.get(i).getSnack() + "  " + list.get(i).getSnackPrice());
		leftItemLb[i].setBounds(2, 81, 86, 12);
		leftItemLb[i].setForeground(Color.orange);

		jSrpColumnpanel[i].add(leftItemBtn[i]);
		jSrpColumnpanel[i].add(leftItemLb[i]);
		leftTopIconPj.add(jSrpColumnpanel[i]);
		
//		System.out.println(width);
//		if (i == list.size()) {
//			System.out.println("사이즈 수치 : " + jSrpColumnpanel[i].getX());				
//		}

		}// for
	}//leftBtnInit
	
	
	//	버튼으로 상품 선택시 테이블 재 생성
	public void rightTableInit(SpaceController smc) {

		rightTopPj.removeAll(); // 테이블 초기화

		// 우 상단 테이블 생성
		String columnNames[] = {
				"상품이름", "수량", "상품가격"
		};

		snackOrderList = new ArrayList<SnackBar>();
		snackOrderList = smc.snackSelList();
//		snackOrderList.add(new SnackBar(1, "yyy", 44, 223332)); // 임시 자료

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
				// 셀선택
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
		
		// 콤보 박스 아이템 갯수 +1로 0부터 갯수 까지입
		Integer[] num = new Integer[val+1];
		for(int i = 0; i <= val; i++) {
			num[i] = i;
		}

		// 콤보 박스 아이템 초기
		rightMiCombo =  new JComboBox<Integer>(num);
		rightMiCombo.setBounds(130, 10, 60, 30);
		rightMiCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("콤보 이벤트 발생");
				// 콤보 박스아이템이 0 일경우 삭제
				snackOrderList = smc.snackSelList();
				smc.snackComboSelected(row, rightMiCombo.getSelectedItem().toString());
				int ix = (int)rightMiCombo.getSelectedItem();
				if( ix == 0) {
					snackOrderList.remove(row);
				}
				// 선택된 아이템을 가져와다시 출력
				rightTopPj.removeAll();
				rightTableInit(smc);
				
			}
		});
		
		rightMiJp.add(rightMiLb);
		rightMiJp.add(rightMiCombo);
		
		rightMiJp.revalidate();
		rightMiJp.repaint();
		
	}// rightComboInit
	
	// 버튼 선택시 콤보박스 제거 & 숨김 
	public void rightComboDel(SpaceController smc) {
		
		if(rightMiJp != null) {
			rightMiJp.removeAll();
			rightMiJp.revalidate();
			rightMiJp.repaint();
		}
	}//rightComboDel

	
	
} //class




















/*
// 패널1
class JPanelR01 extends JPanel implements ViewIndex{
	
	private SnackBarView sv;
	
	public JPanelR01(SnackBarView sv, SpaceController smc, int size) {
		
		// 초기 디폴트 버튼 생성
		JButton[] btn = new JButton[size];
		
		this.sv = sv;
		this.setLayout(new GridLayout(3,5));
		this.setBackground(Color.red);

		for (int i = 0; i < size; i++) {	// 개체 수만큼 버튼을 생성
			this.add(btn[i] = new JButton(i + "aaaaa"));
			btn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		}
		
	}
	
	
}
//패널2
class JPanelR02 extends JPanel implements ViewIndex{
	
	private SnackBarView sv;
	
	public JPanelR02(SnackBarView sv, SpaceController smc, int size) {
		
		this.sv = sv;
		this.setLayout(new GridLayout(5,5));
		this.setBackground(Color.red);

	}
}

// 메인 클래
public class SnackBarView implements ViewIndex{

	// 간식 판매 리스트 뷰
	
	// 시작시 데이터 list 를 로드
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
		
		// 다음, 취소 버튼 이벤트
		btnCancle.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainPl));
		btnNext.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainPl));
		
		jpD.add(btnCancle);
		jpD.add(btnNext);
		
//		System.out.println("리스트 사이즈 :" + list.size());
		
		// 좌측에 서로 바꿔줄 패널 2개 객체 생성
		jp01 = new JPanelR01(this, smc, list.size());
		jp01.setBounds(180, 10, 500, 500);
		jp02 = new JPanelR02(this, smc, list.size());
		jp02.setBounds(180, 10, 500, 500);
	
		
		
		mainPl.add(jpD);
		mainPl.add(jpL);
		mainPl.add(jp01);
		
		mainJFrame.add(mainPl);
		
		// 음료 버튼후 패널 교체
		btnDrink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smc.snackSel(2);	// 음료 객체 수
				JButton[] btnDrinkArray = new JButton[list.size()];
				
				jp02.removeAll();	//	중복 되지 않게 패널의 버튼을 클리어
				mainJFrame.remove(jp01);	// 패널 교체를 위한 패널을 제거
				jp02.setLayout(new GridLayout(3,2));
				
				for (int i = 0; i < list.size(); i++) {	// 개체 수만큼 버튼을 생성

//					jp02.add(btnDrinkArray[i] = new JButton(i + "aaaaa"));
					btnDrinkArray[i] = new JButton(i + "aaaaa");
					btnDrinkArray[i].setBounds(50, 50, 550, 550);
					btnDrinkArray[i].setLayout(null);
					jp02.add(btnDrinkArray[i]);
					btnDrinkArray[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));
				}
				
				mainJFrame.add(jp02);	// 생성후 패널을 추가

				jp02.revalidate();
				jp02.repaint();
//				mainJFrame.revalidate();
//				mainJFrame.repaint();
				
			}
		});

		// 스낵 버튼 후 패널 교체
		btnSnack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smc.snackSel(1);	// 과자 객체 수
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
	
	
	// 화면 새로 고침
	public void jFrameClear() {
	
	}
		
		
		 //  수정전 코드
		 
		
		
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
		
		// 버튼 선택시 좌, 우측 이벤트
		btnDrink.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_DRINK_LEFT, smc, mainJFrame, jpR));
		btnSnack.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_SNACK_LEFT, smc, mainJFrame, jpR));
		
		
		
/////////////////////////////////////////////////////////////////////////////
//		list.add();
//		System.out.println(list);
		
		// 1 과자
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 1) {
//				System.out.println("음료 =/= " + snack);
//			}
//		}
		
//		list = smc.snackSel();		// 기본 음료선택으로 셋팅
//		System.out.println(list.get(0));
		
//		System.out.println(list.get(0).getSnack());
//		System.out.println(((SnackBar)list).getSnackComment());
		
//		for (int i = 0; i < list.size(); i++) {
//			jpR.add( btn = new JButton(i + " " +list.get(i).getSnack()) );
//			btn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc, mainJFrame, jpR));
//		}

		
//		JButton btn1 = new JButton()

//		// 1 과자
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 1) {
//				System.out.println("과자 / " + snack);
//			}
//		}
//		
//		// 2 음료
//		for (SnackBar snack : list) {
//			if(snack.getSnackBarIndex() == 2) {
//				System.out.println("음료 / " + snack);
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
