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
	private ImageIcon rightImage, leftImage;
	private JScrollPane jSrp;
	private JComboBox<Integer> rightMiCombo;
	private JLabel rightMiLb;
//	private int snackSum = 1;
	
	
	public void initialize(SpaceController smc, JFrame mainJFrame, List<SnackBar> list) {

		System.out.println("list size : " + list.size());
		rightImage = new ImageIcon(this.getClass().getResource("right_bg.png"));
		
		mainJFrame.setLayout(null);

		// 프레임 위에 메인 패널
		JPanel mainJp = new JPanel();
		mainJp.setBounds(0, 0, mainJFrame.getWidth(), mainJFrame.getHeight()); //(0,0,1024,768)
		mainJp.setLayout(null);
		
		// 타이틀 레이블
		JLabel titleLb = new JLabel("SNACK");
		titleLb.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		titleLb.setBounds(90, 45, 500, 50);
		mainJp.add(titleLb);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBorder(new LineBorder(Color.GRAY));
		lblNewLabel_5.setBounds(85, 95, 335, 2);
		mainJp.add(lblNewLabel_5);
		

		//////////// 좌우 패널 셋팅   ////////////
		// 좌측 패널
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
		leftTopIconPj.setBorder(BorderFactory.createLineBorder(Color.gray));

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
//		rightTopPj.setBackground(Color.cyan);
		rightTopPj.setBorder(BorderFactory.createLineBorder(Color.gray));
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
//		leftMiPj.setBackground(Color.white);
		leftMiPj.setBorder(BorderFactory.createLineBorder(Color.gray));
		leftMiPj.setLayout(null);

		// 우 중단 패널2
		rightMiJp = new JPanel();
		rightMiJp.setBounds(rightJp.getWidth()/6, rightJp.getHeight()/7 + rightTopPj.getHeight() + 10
				, rightTopPj.getWidth(), rightTopPj.getHeight()/4);
		rightMiJp.setBorder(BorderFactory.createLineBorder(Color.gray));
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
		URL menuBackpath = this.getClass().getResource("next.png");
		leftDrinkBtn.setIcon(new ImageIcon(menuBackpath));
		leftDrinkBtn.setBounds(5, (leftMiPj.getHeight()/5)*4 - 20, 330, 50);

		// 좌측 버튼(이벤트)
		leftDrinkBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_CANSLE,smc , mainJFrame, mainJp));

		// 우측 버튼 생성 하단 (뒤로가기, 다음)
		JButton rightBackBtn = new JButton("수량 변경");
		rightBackBtn.setBounds(30, 0, 100, 30);
		rightBackBtn.setVisible(false);
		URL menuBackpath1 = this.getClass().getResource("pay_now.png");
		JButton rightNextBtn = new JButton("결  재");
		rightNextBtn.setIcon(new ImageIcon(menuBackpath1));
		rightNextBtn.setBounds(5, (rightMiJp.getHeight()/5)*4 - 20, 330, 50);
		
		// 우측 버튼(이벤트)
		rightNextBtn.addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, SNACK_BAR_VIEW_NEXT, smc, mainJFrame, mainJp));

		////////////////////////////////////////////////////////////////////////////////////
		// 파싱
		
		String[] fstr = smc.snackTitle();
		
//		for (int i = 0; i < fstr.length; i++) {
//			System.out.println("리스트 순서 : " + fstr[i]);
//		}
		
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
		jsr.setBounds(10, 15, jSrp.getWidth()-20, leftMiPj.getHeight()/2);

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

//		mainJFrame.setDefaultCloseOperation(3);
//		mainJFrame.setVisible(true);

	}
	
	
	//	스낵 이미지 버튼 생성  
	public void leftBtnInit(SpaceController smc, List<SnackBar> list, int index) {
	
	list = smc.snackSel(index);

	leftTopIconPj.removeAll(); // 기존에 있던 패널의 아이콘 클리어
//	if(rightMiJp == null) {
//		rightMiJp = new JPanel();
//	}
	
	int iconNum = 0;
	String strTmp[] = new String[smc.snackTitle().length];
//	Arrays.sort(strTmp);
	strTmp = smc.snackTitle();
	
	// 9가지 900 종류의 아이콘 이미지
	int intTmp[] = {0, 100, 200, 300, 400, 500, 600, 700, 800, 900};
	
	// 콤보박스의 아이템 갯수를 구해 첫번째 값과 일치하면 intTmp의 첫번째 배열과 매칭하여
	// 아이콘 숫자를 리턴한다. 
	
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
	
	
	
	leftItemBtn = new JButton[list.size()];	// 아이템 갯수만큼 크기를 가져와야함
	jSrpColumnpanel = new JPanel[list.size()];
	leftItemLb = new JLabel[list.size()];
	
	leftTopIconPj.setLayout(new GridLayout(3, 10, 10, 10));
	leftTopIconPj.setBackground(Color.white);

	leftTopIconPj.revalidate();
	leftTopIconPj.repaint();
	
//	int width = 0; // 스크롤 크기에 대한 정보변
	// 스크롤 내부 패널 추가
//	System.out.println("사이즈 : " + list.size());
	String[] strImg = new String[list.size()];
	
	
	for (int i = 0; i < list.size(); i++) {
		
//		if(i != 0) width += 120;
		// 패널 생성
		jSrpColumnpanel[i] = new JPanel();
		jSrpColumnpanel[i].setBackground(Color.lightGray);
//		jSrpColumnpanel[i].setBounds(0, 0, 90, 95);
		jSrpColumnpanel[i].setPreferredSize( new Dimension(90 , 95 ));
		jSrpColumnpanel[i].setLayout(null);
		
		// icon 0 번째  + 배열 아이콘 크기 + 1 개로 아이콘 이름을 넘겨줌
		strImg[i] = (i + iconNum + 1) + ".png";
		
		// 이미지 파닐 체크후 없으면 기본값 이미지를 사용
		String imgStr = "/com/space_distortion/view/" + strImg[i];
		if( SnackBarView.class.getResource(imgStr) == null){
			System.out.println("이미지 파일 없음 !!!!!!!!!");
			imgStr = "/com/space_distortion/view/empty1.png";
		}
		ImageIcon imgCon = new ImageIcon(SnackBarView.class.getResource(imgStr));
		// 내부 패널의 버튼 생성
//		System.out.println("i 값 : " + i);
		leftItemBtn[i] = new JButton(list.get(i).getSnack() + " Image");
		leftItemBtn[i].setIcon(imgCon);
		leftItemBtn[i].setBounds(2, 2, 86, 75);
		
		leftItemBtn[i].addMouseListener(new SpaceActionEvent(SNACK_BAR_VIEW_NUM, i, smc));

		// 내부 레이블 생성
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
		rightMiLb.setBounds(200, 21, 100, 30);
		
		if(!rightMiLb.getText().equals(str))
			rightMiLb.setText(str);
		
//		rightMiLb.setBackground(Color.red);
		
		// 콤보 박스 아이템 갯수 +1로 0부터 갯수 까지입
		Integer[] num = new Integer[val+1];
		for(int i = 0; i <= val; i++) {
			num[i] = i;
		}

		// 콤보 박스 아이템 초기
		rightMiCombo =  new JComboBox<Integer>(num);
		rightMiCombo.setBounds(265, 20, 60, 30);
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
					rightMiCombo.setVisible(false);
					rightMiLb.setVisible(false);
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


