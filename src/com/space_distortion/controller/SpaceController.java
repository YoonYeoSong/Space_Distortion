package com.space_distortion.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.Coupon;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.model.vo.Payment;
import com.space_distortion.model.vo.Reservation;
import com.space_distortion.model.vo.RoomInfo;
import com.space_distortion.model.vo.SnackBar;
import com.space_distortion.view.AccountView;
import com.space_distortion.view.AccountView2;
import com.space_distortion.view.AddTimeRoomView;
import com.space_distortion.view.AdminSnackView;
import com.space_distortion.view.AdminView;
import com.space_distortion.view.FinalPaymentView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;
import com.space_distortion.view.NaccountView;
import com.space_distortion.view.PaymentView;
import com.space_distortion.view.ReservationView;
import com.space_distortion.view.SnackBarView;
import com.space_distortion.view.SubRoomView;
import com.space_distortion.view.ViewIndex;

// 기능구현 클래스
public class SpaceController implements ViewIndex{
	
	//잠시 관리자에 에 쓰이는 변수
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	static int couponCount = 0;
	
	/////////////////////////////// Model.vo 객체 리스트///////////
	private List<Member> mList = new ArrayList<Member>();
	private List<NonMember> nList = new ArrayList<NonMember>();
	private List<Coupon> couponList = new ArrayList<Coupon>();
	private Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // 회원 맵
	private Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // 비회원 맵
	private List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // 룸에 대한 리스트
	private List<Payment> paymentList = new ArrayList<Payment>();  // 페이먼트 대한 리스트
	private List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // 스낵관련리스트
	private List<SnackBar> snackTmpList = new ArrayList<SnackBar>(); // 스낵/ 음료의 임시 리스트
	private List<SnackBar> snackPaylList = new ArrayList<SnackBar>(); // 결재에 넘결줄 상풍 리스트
	
	private Admin admin = new Admin();
	
	///////////////////////Model.vo 뷰/////////////////////////////////////////
	
	private static MainRoomView mv = new MainRoomView(); // 메인 뷰
	private SpaceActionEvent sAe = new SpaceActionEvent();
	private MainRoomView mRv = new MainRoomView();                  //메인 뷰 생성
	private SubRoomView subRoomV = new SubRoomView();       // 서브룸
	private LoginView lv = new LoginView();                  //로그인뷰
	private AccountView accountV = new AccountView();		//회원 가입 뷰 생성
	private AccountView2 subAccountV = new AccountView2();	//회원 가입 뷰 생성
	private NaccountView nAccountV = new NaccountView();    // 비회원 뷰
	private AddTimeRoomView addTimeV = new AddTimeRoomView();	//추가시간 뷰 생성
	private AdminView adminV1 = new AdminView();				//관리자 뷰 생성
	private PaymentView payV = new PaymentView();			//결재 뷰 생성
	private SnackBarView snackV = new SnackBarView();		//간식 뷰 생성
	private FinalPaymentView finalpv = new FinalPaymentView(); // 마지막 뷰 창
	private JFrame mainJframe;			//메인 프레임 생성
	private int finalTime; // 최종 시가을 보여주는 변수
	private int finalroomNumber; // 방번호를 받아온다.
	private AdminSnackView adminSnackV = new AdminSnackView(); // 관리자 스낵 추가뷰
	private List tempPayment = new ArrayList();
	private ReservationView reV = new ReservationView();
	
	
	/* 메인 컨트롤러 생성자 */
	public SpaceController() {
		this.init();
			
		
		this.initConsol();  // 관리자 테스트 생성자
		this.snackViewDidload();
	}
	
	
	
	// 메인 프레임 생성
	public void init()
	{
		
//		roomInfoList.add(new RoomInfo("HARVARD ROOM", 1, 4, ""));
//        roomInfoList.get(0).setRemTime(5000);
//        roomInfoList.add (new RoomInfo("USC ROOM", 2, 8, ""));
//        roomInfoList.get(1).setRemTime(3);
//        roomInfoList.add (new RoomInfo("CORNELL ROOM", 3, 8, ""));
//        roomInfoList.get(2).setRemTime(14);
//        roomInfoList.add (new RoomInfo("BROWN ROOM",4, 8, ""));
//        roomInfoList.get(3).setRemTime(11);
//        roomInfoList.add(new RoomInfo("YALE ROOM", 5, 8, ""));
//        roomInfoList.get(4).setRemTime(10);
//        roomInfoList.add (new RoomInfo("PRINCETON ROOM",6, 12, ""));
//        roomInfoList.get(5).setRemTime(10);
//        roomInfoList.add(new RoomInfo("COLUMBIA ROOM", 7, 12, ""));
//        roomInfoList.get(6).setRemTime(8);
//        roomInfoList.add(new RoomInfo("STANFORD ROOM", 8, 12, ""));
//        roomInfoList.get(7).setRemTime(9);
//        
//        
		snackBarList.add(new SnackBar(1, "튀김", 11, 5000, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "버터칩", 11, 3333, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "별사탕", 11, 1200, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "새우깡", 11, 1000, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "오리온땅꽁", 11, 1200, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "치토스", 30, 1400, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "칸쵸", 11, 1200, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "포카칩", 20, 1500, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "허니땅콩", 11, 2222, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 2000, "물량부족", 1, "과자"));
		snackBarList.add(new SnackBar(2, "마운틴듀", 33, 1000, "물량부족", 1, "음료"));
		snackBarList.add(new SnackBar(2, "콜라", 10, 1200, "물량부족", 1, "음료"));
		snackBarList.add(new SnackBar(2, "포카리", 15, 900, "물량부족", 1, "음료"));
//        snackBarList.add(new SnackBar(3, "허니버터칩", 11, 4444, "물량부족", 1));
//        snackBarList.add(new SnackBar(3, "허니버터칩", 11, 5555, "물량부족", 1));
		
		mainJframe = new JFrame("Space Distorition");
		mainJframe.setBounds(0, 0, 1024, 768);
		mainJframe.setLayout(null);
		mainJframe.setDefaultCloseOperation(3);
		mainJframe.setResizable(false);
		mainJframe.setVisible(true);	
		
		mainJframe.addWindowListener(new SpaceActionEvent(ViewIndex.WINDOWEIXT,1,this,this.mainJframe));
	}
	
	
	public void dataInit() {
		snackPaylList.clear();
		tempPayment.clear();
	}
	
	
	

	AdminView adminView;
		
		
	
/////////////////////////////////////(동규)로그인 기능 시작///////////////////////////////////////////
	
	// 비회원
	public void initNonMember(String name, String phone)
	{
		nList.add(new NonMember());
		nList.get(nList.size()-1).setnMemberName(name);
		nList.get(nList.size()-1).setPhoneNumber(phone);
		
		nMap.put(nKeyNumber++, nList.get(nList.size()-1));
	}
	
	
	// LoginView 로그인확인
	public boolean logincheck(String inputid, String inputpw) {
		System.out.println(inputid);
		System.out.println(inputpw);

		boolean check = false;
		System.out.println("맵 사이즈 : " + mMap.size()); // 맴버 사이즈 확인

		
		for (int i = 0; i < mMap.size(); i++) {
			if (((Member) mMap.get(i)).getEmailId().equals(inputid)
					&& ((Member) mMap.get(i)).getMemberPw().equals(inputpw)) {
				System.out.println("로그인 : " + ((Member) mMap.get(i)).getEmailId().equals(inputid));// 아이디가 일치하는지,
																									// 일치하면true출력
				System.out.println("로그인 : " + ((Member) mMap.get(i)).getMemberPw().equals(inputpw));// 패스워드가 일치하는지, 일치하면
																									// true출력

				// 로그인한 맴버 키값 구하기
				for (Object o : mMap.keySet()) {
					if (mMap.get(o).getEmailId().equals(mMap.get(i).getEmailId())) {
						System.out.println("로그인한 키 값 : " + o);
					}
				}

				check = true;
			}

		}
		return check;
	}
		
	
	//AcountView(회원가입 1번 창)
	public void initMember(String name, String phone)
	{
		mList.add(new Member());
	    mList.get(mList.size()-1).setMemberName(name);
		mList.get(mList.size()-1).setPhoneNumber(phone);
	}
	  
	//AcountView2(회원가입 2번 창)
	public void initMember2(String email, String pw)
	{
		mList.get(mList.size()-1).setEmailId(email);
		mList.get(mList.size()-1).setMemberPw(pw);
		//mList.get(mList.size()).setStudentIsTrue(isTrueStudent);
		mMap.put(mKeyNumber++,mList.get(mList.size()-1));
	}
	  
	//Email Check(이메일 중복 체크)
	public boolean emailCheck(String email)
	{
		System.out.println("여기 들어왔음 : " + email);

		boolean check = false;
		Set<Entry<Integer, Member>> set;
		set = mMap.entrySet();
		
		Iterator<Entry<Integer, Member>> it = set.iterator();
			
		while(it.hasNext())
		{
			Entry<Integer, Member> obj = it.next();
			if(obj.getValue().getEmailId().equals(email))  // 중복된 아이디가 있음
			{
				check = true;
			}
		}
		return check;
		

	}
	
	
	
			
		
/////////////////////////////////(동규)로그인기능 끝///////////////////////////////////////////
	
	
	
	
	
////////////////////////////////////// (헌수)스낵 관련 기능 시작//////////////////////////	

	/*
	 * 1 : 과자 2 : 음료
	 */

	// 사용 안됨  *****
	// 스낵 뷰가 로드될때 데이터 로드
	public void snackViewDidload() {
		// 음료만 리스트로 생성
		for (SnackBar sb : snackBarList) {
			if (sb.getSnackBarIndex() == 1) {
				snackTmpList.add(sb);
//				System.out.println("kkk"+snackTmpList.size());

			}
		} // for
	} // snackViewDidload

	// 스낵 코너의 스낵 종류 분류해서 snackTmpList 추가
	public List<SnackBar> snackSel(int i) {
		// 초기화
		if (!snackTmpList.isEmpty()) {
			snackTmpList.clear();
		}
//		System.out.println("iiii == " + i);
//		System.out.println("ss : " + snackBarList.size());
		for (SnackBar sb : snackBarList) {
			if (sb.getSnackBarIndex() == i) {
//				System.out.println("temp : " + snackTmpList.size());
				snackTmpList.add(sb);
			}
		} // for
		return snackTmpList;

	}// snackSel

	// 과자버튼 선택 후 과자 종류 선택
	public List<SnackBar> snackSelList(int btnIndex) {
//		System.out.println("과자 세부선택");
//		System.out.println("2 :" +snackBarList.get(btnIndex).getSnack());
//		System.out.println("1 :" +((SnackBar)snackBarList).getSnackComment());	//err

		boolean snackOverlapChk = false;

		int tmpIndext = 0;
		// 기존 주문한 상품이 없을경우 상품을 추가 (비여있을경우 null error)
		if (snackPaylList.isEmpty()) {
			snackPaylList.add(snackTmpList.get(btnIndex));
			return snackPaylList;
		}
		// 같은 상품이 있는지 체크후 주문한 상품의 리스트 인덱스를 저장
		for (int i = 0; i < snackPaylList.size(); i++) {
			if (snackTmpList.get(btnIndex).getSnack().equals(snackPaylList.get(i).getSnack())) {
				snackOverlapChk = true;
				tmpIndext = i;
			}
		}
		
		// 주문한 상품의 수량을 추가
		if (snackOverlapChk)
		{
//			System.out.println("상품 갯수 추가");
			snackPaylList.get(tmpIndext).setSnackQty( snackPaylList.get(tmpIndext).getSnackQty() + 1 );
			tmpIndext = 0;
			snackOverlapChk = false;
		}else
		{
			snackPaylList.add(snackTmpList.get(btnIndex));
		}

		return snackPaylList;
	}// snackSelList

	// 선택된 간식 리스트
	public List<SnackBar> snackSelList() {
		return snackPaylList;
	}// snackSel

	// 스낵뷰의 테이블 재 생성, 콤보(레이블) 제거
	public void snackTableRe() {
		snackV.rightTableInit(this);
		snackV.rightComboDel(this);
	}
	
	// 간식의 종류 이름 
	public String[] snackTitle() {
		
	
		Set<String> set = new HashSet();
		
		for (SnackBar s : snackBarList) {
			set.add(s.getSnackKind());
		}
		
		List list = new ArrayList(set);
		
//		System.out.println("정렬 전 : " + list);
//		Collections.sort(list);
//		System.out.println("정렬 후 : " + list);

		String str[] = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			str[i] = list.get(i).toString();
		}
		
//		for (SnackBar s : list) {
//			str[0] = s.getSnackKind();
//		}
//		
//		System.out.println(list.size()+ " + error");
//			String str1 = list.get(i).toString();
//			System.out.println(str1);
		set.clear();
		list.clear();
		return str;
	}
	
	
	// 선택된 콤보 수량 반
	public void snackComboSelected(int row, String i) {
		snackPaylList.get(row).setSnackQty( Integer.parseInt(i) );
		
	}
	
	// 리스트 반환 테스
	public void snackTtttttttttttt() {
		
		for (SnackBar s : snackPaylList) {
			System.out.println(s);
		}
	}
//////////////////////////////////////(헌수)스낵 기능 끝/////////////////////
	
//////////방에 대한 번호를 받아온다/////////////////
public void roomNumber(int num)
{
	finalroomNumber = num;
}
	
	
//////////////////////////////////////////////
	
	
	
	
	
/////////////////////////////////////(무관)Payment 기능 시작 //////////////////////////////

	public void dataInputForPayment() {
		
		if(tempPayment != null)
			tempPayment.clear();
		
		tempPayment = new ArrayList();
		tempPayment.add(finalroomNumber);
		tempPayment.add(snackPaylList);
		tempPayment.add("nonMember");
	}
	
	public void dataInputForPaymentMember() {
		
		if(tempPayment != null)
			tempPayment.clear();
		
		tempPayment = new ArrayList();
		tempPayment.add(finalroomNumber);
		tempPayment.add(snackPaylList);
		tempPayment.add("Member");
	}


	// 모든 가격을 계산하고 프린트함
	public void totalCostCalculator(List<Payment> list) {
			
		// 화이트보드를 빌린다면 가격에 3000원 오름. 아니면 빵원
		if((list.get(list.size()-1)).getWhiteBoardUsage() == 1) {
			(list.get(list.size()-1)).setWhiteBoardCost(3000);
		}else 
		{
			(list.get(list.size()-1)).setWhiteBoardCost(0);
		}
		
		// 빔프로젝트 빌린다면 가격에 3000원 오름. 아니면 빵원
		if((list.get(list.size()-1)).getBeamProjectorUsage() == 1) {
			(list.get(list.size()-1)).setBeamProjectorCost(3000);
		}else 
		{
			(list.get(list.size()-1)).setBeamProjectorCost(0);
		}
//			 이 메소드는 디스카운트를 받을지 안 받을지 알려주는 메소드
		if ((list.get(list.size()-1)).getUser() == "member") {
			(list.get(list.size()-1)).setDiscountRate(0.7);
		}else {
			(list.get(list.size()-1)).setDiscountRate(1.0);
		}
		
		System.out.println("getHour before hourlyCalc:   "+(list.get(list.size()-1)).getHour());
		System.out.println("getHourlyCost before hourlyCalc: "+(list.get(list.size()-1)).getHourlyCost());
		System.out.println("getTotalHourlyCost before hourlyCalc: "+(list.get(list.size()-1)).getTotalHourlyCost());
		System.out.println("getPpl before hourlyCalc: "+(list.get(list.size()-1)).getPpl());
		
		hourlyCostCalculator(list);
		
		
		
		(list.get(list.size()-1)).setTotalCost((list.get(list.size()-1)).getTotalHourlyCost()+
				(list.get(list.size()-1)).getWhiteBoardCost()+(list.get(list.size()-1)).getBeamProjectorCost()+
				(list.get(list.size()-1)).getTotalLaptopCost());
		
		
		(list.get(list.size()-1)).setFinalCost((int) ((list.get(list.size()-1)).getTotalCost()*(list.get(list.size()-1)).getDiscountRate()));
		
		String finalCost = String.valueOf((list.get(list.size()-1)).getFinalCost());
		payV.getDisplayPriceAfterDiscount().setText(finalCost);
		String totalCost = String.valueOf((list.get(list.size()-1)).getTotalCost());
		payV.getDisplayTotalCost().setText(totalCost);
		
		paymentList.add(list.get(list.size()-1)); //
	}

//	최종 받아야할 금액을 계산해주는 메소드
	public void hourlyCostCalculator(List<Payment> list) {
		(list.get(list.size()-1)).setTotalHourlyCost(
				((list.get(list.size()-1)).getHour()*
				(list.get(list.size()-1)).getHourlyCost()*
				(list.get(list.size()-1)).getPpl())+
				((list.get(list.size()-1)).getLaptop()*
				(list.get(list.size()-1)).getLaptopCost())
				
				);
//			System.out.println("getHour: " + (list.get(list.size()-1)).getHour());
		System.out.println("getHourlyCost during hourlyCalc: "+ (list.get(list.size()-1)).getHourlyCost());
		System.out.println("getPpl during hourlyCalc: "+ (list.get(list.size()-1)).getPpl());
	}
	
	// 거스름돈이 얼마인지 계산해주는 메소드
	// 달력도 보여줌
	public int changeCalculator(JButton confirmButton, List<Payment> list, JTextField inputCash) {
		String text = inputCash.getText();
		list.get(list.size()-1).setInputtedCash(Integer.parseInt(text));
		System.out.println(list.get(list.size()-1).getInputtedCash());
		int changePrice = list.get(list.size()-1).getInputtedCash()-list.get(list.size()-1).getFinalCost();
		
		return changePrice;
	}
	
	public void finalTime(int finalTime) {
		this.finalTime = finalTime;		
		roomInfoList.get(finalroomNumber-1).setRemTime(finalTime*3600);
		//finalTime = 0;
		//finalroomNumber = 0;
	}
		
		
		// 돈이 부족할때 나오는 팝업 프레임
		public void popUp() {
			JFrame popUpMessage = new JFrame();
			popUpMessage.setBounds(300, 300, 200, 100);
			
			JPanel popUpPanel = new JPanel();
			popUpPanel.setBounds(500, 500, 100, 100);
			
			JLabel inefficientFund = new JLabel("돈이 모자릅니다. 돈 더 넣으세요");
			inefficientFund.setVisible(true);
			popUpPanel.add(inefficientFund);
			
			JButton exitButton = new JButton("확인");
			exitButton.setBounds(50, 50, 150, 150);
			exitButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
				
					popUpMessage.dispose();
				}
			});
			inefficientFund.setVisible(true);
			popUpPanel.add(exitButton);
			
			popUpPanel.setVisible(true);
			popUpMessage.add(popUpPanel);
			
			popUpMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			popUpMessage.setVisible(true);
		}
		
//		지불이 완료됬을때 팝업
		public void paymentDonePopUp() {
			JFrame popUpMessage = new JFrame();
			popUpMessage.setBounds(300, 300, 200, 100);
			
			JPanel popUpPanel = new JPanel();
			popUpPanel.setBounds(500, 500, 100, 100);
			
			JLabel inefficientFund = new JLabel("결제 완료");
			inefficientFund.setVisible(true);
			popUpPanel.add(inefficientFund);
			
			JButton exitButton = new JButton("확인");
			exitButton.setBounds(50, 50, 150, 150);
			exitButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
				
					popUpMessage.dispose();
				}
			});
			inefficientFund.setVisible(true);
			popUpPanel.add(exitButton);
			
			popUpPanel.setVisible(true);
			popUpMessage.add(popUpPanel);
			
			popUpMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			popUpMessage.setVisible(true);
			
		}
/////////////////////////////////////(무관)Payment 기능 끝//////////////////////////////
	
	
	
		
	
	//  관리자 테스트 객체 생성자
	public void initConsol()
	{
	
		//임시 회원 생성
		mMap.put(mKeyNumber++,new Member("윤여송", "1234", "dbsduthd123@naver.com", "경기도 부천", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("김여송1", "12714110", "duthd123@naver.com", "서울", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("차여송2", "12341020", "yeosong92@gmail.com", "부산", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("다여송", "1234", "yeo90@gmail.com", "대전", "010378801", "1972/04/27", 1));
		mMap.put(mKeyNumber++,new Member("챙송", "1234", "yeo90@gmail.com", "대전", "010378801", "1972/04/27", 1));
		mMap.put(mKeyNumber++,new Member("123", "123", "123", "경기도", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("admin", "1234", "admin", "경기도 부천", "01054035883", "1992/04/27", 1));
		
		
		roomInfoList.add(new RoomInfo("HARVARD ROOM", 1, 4, ""));
        roomInfoList.get(0).setRemTime(5000);
        roomInfoList.add (new RoomInfo("USC ROOM", 2, 8, ""));
        roomInfoList.get(1).setRemTime(3);
        roomInfoList.add (new RoomInfo("CORNELL ROOM", 3, 8, ""));
        roomInfoList.get(2).setRemTime(14);
        roomInfoList.add (new RoomInfo("BROWN ROOM",4, 8, ""));
        roomInfoList.get(3).setRemTime(11);
        roomInfoList.add(new RoomInfo("YALE ROOM", 5, 8, ""));
        roomInfoList.get(4).setRemTime(10);
        roomInfoList.add (new RoomInfo("PRINCETON ROOM",6, 12, ""));
        roomInfoList.get(5).setRemTime(10);
        roomInfoList.add(new RoomInfo("COLUMBIA ROOM", 7, 12, ""));
        roomInfoList.get(6).setRemTime(8);
        roomInfoList.add(new RoomInfo("STANFORD ROOM", 8, 12, ""));
        roomInfoList.get(7).setRemTime(9);
		
		//임시 스낵 생성
//		snackBarList.add(new SnackBar(1, "치토스", 30, 1000,"물량부족"));
//		snackBarList.add(new SnackBar(1, "포카칩", 20,1000, "물량부족"));
//		snackBarList.add(new SnackBar(2, "포카리", 15,1000, "물량부족"));
//		snackBarList.add(new SnackBar(2, "콜라", 10,1000, "물량부족"));
//		snackBarList.add(new SnackBar(2, "마운틴듀", 33,1000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));		
//		snackBarList.add(new SnackBar(1, "치토스", 30, 1400, "물량부족"));
//		snackBarList.add(new SnackBar(1, "포카칩", 20, 1500, "물량부족"));
//		snackBarList.add(new SnackBar(2, "포카리", 15, 600, "물량부족"));
//		snackBarList.add(new SnackBar(2, "콜라", 10, 700, "물량부족"));
//		snackBarList.add(new SnackBar(2, "마운틴듀", 33, 1000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 4000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 1111, "물량부족"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 2222, "물량부족"));
//		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 3333, "물량부족"));
//		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 4444, "물량부족"));
//		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 5555, "물량부족"));
//		snackBarList.add(new SnackBar(1, "새우깡", 11, 6000, "물량부족"));
//		snackBarList.add(new SnackBar(1, "칸쵸", 11, 1200, "물량부족"));
//		snackBarList.add(new SnackBar(1, "개구리", 11, 10000, "물량부족"));
//        snackBarList.add(new SnackBar(1, "치토스", 30, 1400, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "포카칩", 20, 1500, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 2000, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "새우깡", 11, 1000, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "칸쵸", 11, 1200, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "개구리", 11, 5000, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(2, "포카리", 15, 900, "물량부족", 1, "음료"));
//		snackBarList.add(new SnackBar(2, "콜라", 10, 1200, "물량부족", 1, "음료"));
//		snackBarList.add(new SnackBar(2, "마운틴듀", 33, 1000, "물량부족", 1, "음료"));
//		snackBarList.add(new SnackBar(1, "오리온땅꽁", 11, 1200, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "별사탕", 11, 1200, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "허니땅콩", 11, 2222, "물량부족", 1, "과자"));
//		snackBarList.add(new SnackBar(1, "버터칩", 11, 3333, "물량부족", 1, "과자"));
//		
		
		// 방이름 방번호 수용인원 빔프로젝트 사용여부
//		roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(0).setRemTime(20);
//        roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(1).setRemTime(5);
//        roomInfoList.add (new RoomInfo("USC", 2, 8, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(2).setRemTime(7200);
//        roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(3).setRemTime(8200);
//        roomInfoList.add (new RoomInfo("BROWN",4, 8, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(4).setRemTime(9200);
//        roomInfoList.add(new RoomInfo("YALE", 5, 8, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(5).setRemTime(10200);
//        roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(6).setRemTime(11200);
//        roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(7).setRemTime(12200);
		
        
        paymentList.add((new Payment("1",20,"2019/4/27")));
        paymentList.add((new Payment("2",15,"2020/4/27")));
        paymentList.add((new Payment("3",30,"2030/4/27")));
        paymentList.add((new Payment("4",100,"2040/4/27")));
        paymentList.add((new Payment("5",30,"2050/4/27")));
        paymentList.add((new Payment("6",50,"2070/4/27")));
        
      
        
		Set<Entry<Integer, Member>> set = mMap.entrySet();	
		Iterator<Map.Entry<Integer,Member>> it = set.iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Member> obj = it.next();
			mList.add(obj.getValue());
			
		}
        
		
		//관리자 리스트에 추가
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		admin.setAdminRoomInfoList(roomInfoList);
		admin.setAdminPaymentList(paymentList);
		inputList();
		readList();
		couponCreat();
	}
	
	// 콘솔 메인
	public void mainConsolView()
	{
		adminView = new AdminView();
		//adminView.SpaceMainMenu();
	}
	
	
	///////////////////////////////////////////////////(여송) 관리자 관리 기능 ///////////////////////////////////////////////////////////////
	
	
	
	public void adminInit()
	{
//		adminPaymentList = new ArrayList();
//		adminRoomInfoList = new ArrayList();
//		adminSnackBarList = new ArrayList<SnackBar>();
//		adminMemberMap = new HashMap();
//		adminCouponList = new ArrayList<Coupon>();
		
		
		admin.setAdminMemberMap(mMap);
		admin.setAdminRoomInfoList(roomInfoList);
		admin.setAdminPaymentList(paymentList);
		admin.setAdminSnackBarList(snackBarList);
	}
	
	public void couponCreat() {
		
		//쿠폰 사이즈
		int couponSize = 500;
		//중복 체크 하려고 셋을 이용
		Set<Coupon> couponSet = new HashSet<Coupon>();
		// char형 배열 62개를 생성
		char[] coupon = new char[62];
		// char = 48 = 아스키 코드상 숫자 0
		char ascCode = 48;
		for (int i = 0; i < 62; i++) {
			if (i < 10) {
				coupon[i] = ascCode; // 0 1 2 3 4 5 6 7 8 9
			} // 0 1 2 3 4 5 6 7 8 9
			else if (i == 10) {
				ascCode = 65; // 10 A
				coupon[i] = ascCode;

			} else if (i > 10 && i < 36) // 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35
			{ // B C D E F G H I J K L N M O P Q R S T U V W X Y Z
				coupon[i] = ascCode;

			} else if (i == 36) {
				ascCode = 97; // 36 a
				coupon[i] = ascCode;
			} else if (i > 36 && i < 62) // 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61
			{ // b c d e f g h i j k l n m o p q r s t u v w x y z
				coupon[i] = ascCode;
			}
			ascCode++;
		}

		// 쿠폰 카운트 쿠폰 길이만큼
		int couponCount = coupon.length;

		// 랜덤 발생
		Random randomNumber = new Random();
		int index = 0;
		int i = 0;
		
		// 인덱스가 쿠폰의 사이즈 보다 작을때
		while (index < couponSize) {
			//StringBuffer 사용
			StringBuffer stringBuf = new StringBuffer(16);
			// 16자리
			for (i = 16; i > 0; i--) {
				// 문자 배열 데이터를 현재 문자열 끝에 추가한다.
				// 문자열을 조작 하기 위해서는 캐릭터형 배열로 되어있는 StringBuffer이용하는것이 메모리적으로도 좋다.
				// StringBuffer는 내부적으로 String 객체가 아닌 Char[]을 사용하기 때문.
				// String으로 문자열을 계속적으로 + 할경우 객체를 생성하게 되고, 그 과정이 가벼운 작업이 아니므로
				// 퍼포먼스 또한 나빠지게 됩니다 메모리적으로도 좋지 않다.
				// 예) String str = "a";    str +=b str+=c    str = new StringBuffer(str).append("b").toString();
				// 예) StringBuffer buf = new StringBuffer("a")  buf.append("b") 객체를 생성하지 않음
				
				// 0 ~ coponCount = 62까지
				stringBuf.append(coupon[randomNumber.nextInt(couponCount)]);
			}

			String couponNumber = stringBuf.toString();
			System.out.println("발행번호 : " + couponNumber);
			//셋으로 중복 체크 하기 위해서 사용
			couponSet.add(new Coupon(null, couponNumber));
			index++;
		}
		
		//이터레이터로 출력
		Iterator<Coupon> it = couponSet.iterator();
		
		while(it.hasNext())
		{
			Coupon c = it.next();
			couponList.add(c);
		}
		// 리스트 정렬
		Collections.sort(couponList,new AscMember());
		
		admin.setAdminCouponList(couponList);
	}
	

	// 저장하기
	public void inputList()
	{
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try
		{
			out = new FileOutputStream("adminMember.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			List<Member> memberList = mList;
			
			oout.writeObject(memberList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try
			{
				oout.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	// 읽어오기
	public void readList()
	{
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
	
		try
		{
			in = new FileInputStream("adminMember.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			List<Member> tempList = (List<Member>)oin.readObject();
			for(Member s : tempList)
				s.printMember();
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				oin.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	// 컨트롤러 셋
	public void seachMem()
	{
		Set mSet;
		mSet = mMap.entrySet();
		Iterator it = mSet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			System.out.println("key : " +obj.getKey() +" " + " value : "+ obj.getValue());
		}
		System.out.println("헤이");
	}
	
	//관리자용 모든 멤버 검색(오름차순)
	public String[][] adminSearchAllMember(String[] modelName)
	{
		//테이블에 대한 2차원 배열
		String[][] membrContents = new String[admin.getAdminMemberMap().size()][modelName.length];
		
		
		// 회원은 맵을 사용
		Set mSet;
		//entrySet과 keySet을 사용하여 key와 value가 필요할때
		//골라서 사용 할 수 있다.
		//맵은 Iter를 사용할수 없기 때문에 set으로 객체를 반환후 Iter사용
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			list.add(((Member)obj.getValue()));
		}
		//오름차순 정렬
		Collections.sort(list,new AscMember());
		
		
		
		// {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1","쿠폰"}
		// 리스트를 이용하여 이터레이터를 돌려서 각 테이블에 값을 전달
		int i = 0;
		for(Iterator<Member> itList = list.iterator(); itList.hasNext();)
		{
			Member m = (Member)itList.next();
			
			for(int j = 0; j < membrContents[i].length; j++)
			{
				if(j == 0)
				{
					membrContents[i][j] = String.valueOf(m.getUserCode());
				}
				else if(j == 1) 
				{
					membrContents[i][j] = m.getMemberName();
				}
				else if(j == 2)
				{
					membrContents[i][j] = m.getEmailId();
				}
				else if(j == 3)
				{
					membrContents[i][j] = String.valueOf(m.getMemberPw());
				}
				else if(j == 4)
				{
					membrContents[i][j] = m.getAddress();
				}
				else if(j == 5)
				{
					membrContents[i][j] = m.getPhoneNumber();
				}
				else if(j == 6)
				{
					membrContents[i][j] = m.getBirthDay();
				}
				else if(j == 7)
				{
					membrContents[i][j] = String.valueOf(m.getStudentIsTrue());
				}else if(j == 8)
				{
					membrContents[i][j] = m.getCoupon();
				}
			}
			i++;
		}
		
		return membrContents;	
	}
	
	
	
	
	//관리자용 이름으로 찾기
	public String[][] adminSearchMember(String[] modelName, String jtfName)
	{
		// 이름을 전달받는다
		String searchName = jtfName;
		
		// 맵은 iter를 돌릴수 없기때문에 Set으로 반환 후 이터로 돌림 
		Set mSet;
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		// 지역 리스트를 만듬
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			//key와 Value를 가지고 값을 찾기 
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(searchName) )
				list.add(((Member)obj.getValue()));
		}
		// 오름차순 정렬
		Collections.sort(list,new AscMember());
		
		
		//검색한 사람 수만큼 행 컬럼수만큼 열을 늘린다.
		String[][] membrContents = new String[list.size()][modelName.length];
		
		// {"회원코드","이름","이메일","비밀번호","주소","핸드폰 번호","생년월일","학생이면 1"}
		
		int i = 0;
		for(Iterator<Member> itList = list.iterator(); itList.hasNext();)
		{
			Member m = (Member)itList.next();
			
			for(int j = 0; j < membrContents[i].length; j++)
			{
				if(j == 0)
				{
					membrContents[i][j] = String.valueOf(m.getUserCode());
				}
				else if(j == 1) 
				{
					membrContents[i][j] = m.getMemberName();
				}
				else if(j == 2)
				{
					membrContents[i][j] = m.getEmailId();
				}
				else if(j == 3)
				{
					membrContents[i][j] = String.valueOf(m.getMemberPw());
				}
				else if(j == 4)
				{
					membrContents[i][j] = m.getAddress();
				}
				else if(j == 5)
				{
					membrContents[i][j] = m.getPhoneNumber();
				}
				else if(j == 6)
				{
					membrContents[i][j] = m.getBirthDay();
				}
				else if(j == 7)
				{
					membrContents[i][j] = String.valueOf(m.getStudentIsTrue());
				}				
			}
			i++;
		}
		
		return membrContents;	
	}


	// 회원코드로 키값 찾아 비밀번호 변경
	public void adminModifyMember(int userCode , String userValue)
	{	
		
		//맵에 엔트리셋을 이용하여 iter로 출력
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		
		int memberCode = userCode;  //유저코드
		String memberPw = userValue; // 유저 비밀번호
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		// for each // Iterator iter사용
		while(it.hasNext())
		{
			
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				// 유저코드가 같다면
				// 그에 해당하는 키값을 받아
				deleteIndex = obj.getKey();
				
			}
		}
		
		// 그키에 해당하는 비밀번호 변경
		((Member)admin.getAdminMemberMap() .get(deleteIndex)).setMemberPw(memberPw);
		mMap = admin.getAdminMemberMap();	
	}
	
	
	
	//관리자 쿠폰 발행
	public void adminCouponSend(int userCode)
	{
		int userCodeNum = userCode;
		
		// 맵은 key value를 한세트로 저장하기 때문에 iter를 직접 호출 할수는 없고
		// 엔트리셋과 키셋을 이용하여 iter로 호출
		// Map.Entry는 Map 내부 인터페이스 이다.
		Set<Map.Entry<Integer, Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer, Member>> it = mSet.iterator();
		int Index = 0;

		while (it.hasNext()) {
			
			// hash맵에 저장된 value가 저장된 set으로 반환
			// 테이블에 선택된 유저 코드를 비교
			Map.Entry<Integer, Member> obj = (Entry<Integer, Member>) it.next();
			if (((Member) obj.getValue()).getUserCode() == memberCode) {
				Index = obj.getKey();
			}
		}
		
		// 키값을 받아와 쿠폰이 있는지 없는지 비교 하고 리스트에 저장된 0번 째 인덱스부터 뿌리고 카운트 증가
		if(   ( (Member)admin.getAdminMemberMap().get(Index) ).getCoupon().equals("없음")    )
		{
			((Member)admin.getAdminMemberMap().get(Index)).setCoupon(admin.getAdminCouponList().get(couponCount).getCoupontNumber());
			admin.getAdminCouponList().get(couponCount).setUserCode(  String.valueOf(  ((Member)admin.getAdminMemberMap().get(Index)).getUserCode()) );
			couponCount++;
		}	
	}
	

	
	// 관리자용 회원 코드를 이용해 회원 삭제
	public void adminDelMember(int userCode)
	{	
		//Iter를 사용하기 위해 set을 값을 반환하고 iter를 이용
		// 엔트리셋은 key값과 value를 둘다 받아 올수있다.
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		
		while(it.hasNext())
		{
			// 유저 코드를 비교해 키값을 얻는다
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				deleteIndex = obj.getKey();
			}
		}
		
		// 키값을 얻어 회원삭제
		admin.getAdminMemberMap() .remove(deleteIndex);
		mMap = admin.getAdminMemberMap();	
	}
	

//	// 관리자 모든 드링크 검색
//	public void adminSearchAllSnack(String[] modelName)
//	{
//		
//		
//		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
//			
//		for(Iterator<SnackBar> it = admin.getAdminSnackBarList().iterator(); it.hasNext();)
//		{
//			System.out.println(it.next());
//		}
//		
//
//	}
	
	// 관리자 모든 스낵 검색
	public String[][] adminSearchAllSnack(String[] modelName)
	{
		// modelName을 받아 열을 나타내고, 스낵에 대한 리스트를 받아 행을 만든다.
		String[][] snackContetnts = new String[admin.getAdminSnackBarList().size()][modelName.length];
		// 오름 차순 정렬
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
			
		int i = 0;
		// Iter를 이용해 리스트를 순차적으로 돌려 테이블에 대한 값을 적용
		for(Iterator<SnackBar> it = admin.getAdminSnackBarList().iterator(); it.hasNext();)
		{
			SnackBar sb = it.next();
			
			for(int j = 0; j < snackContetnts[i].length; j++)
			{
				if(j == 0)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackBarIndex());
				}
				else if(j == 1) 
				{
					snackContetnts[i][j] = sb.getSnack();
				}
				else if(j == 2)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackQuantity());
				}
				else if(j == 3)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackPrice());
				}
				else if(j == 4)
				{
					snackContetnts[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		//마지막에 2차원 배열 반환
		return snackContetnts;
	}
	
	
	// 관리자용 음료인지 과자인지 판별
	public String[][] adminSearchSnack(int index, String name, String[] modelName)
	{	
		//String[][] snackContents;
		//스낵에 대한 인덱스를 가져와
		
		
		
		// 스낵에 대한 인댁스 0
		int snackIndex = 0;
		// 스낵 이름 Null
		String snackName = null;	
		// 빈 리스트를 생성
		List<SnackBar> tempList = new ArrayList<SnackBar>();
		
		
		
		// 인덱스가 0 인지  스낵 이름이 Null이 아닌지 판단
		if(index != 0)
			snackIndex = index;
		else 
			snackIndex = 0;
		
		if(name != null)
			snackName = name;
		else
			snackName = null;
		
		// 오름차순 정렬
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		
		/// 1 ~ 2 인경우 이름이 있는경우
		// 1~2가 인경우 이름이없는경우
		// 1~2가 아니고 이름이 있는경우
		// 1~2가 아니고 이름이 없는경우
		
		if(snackIndex != 0 && snackName != null)
		{
			//스낵번호가 1인경우
			if(snackIndex == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(  (admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex) 
							&& (admin.getAdminSnackBarList().get(i).getSnack().equals(snackName)) )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}
				
			}
			//스낵번호가 2인경우
			else if(snackIndex == 2)
			{				
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(  (admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex) 
							&& (admin.getAdminSnackBarList().get(i).getSnack().equals(snackName)) )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}
				
			}	
		}
		else if( snackIndex != 0 && snackName == null)
		{
			//스낵번호가 1인경우
			if(snackIndex == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if( admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}						
			}
			//스낵번호가 2인경우
			else if(snackIndex == 2)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if( admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}	
			}
		}	
		else if(snackIndex == 0 && snackName != null)
		{
			for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
			{
				if( admin.getAdminSnackBarList().get(i).getSnack().equals(snackName) )
				{				
					tempList.add(admin.getAdminSnackBarList().get(i));
				}
			}
		}
		
		//스낵에 대해 리스트로 테이블 작성
		String[][] snackContents = new String[tempList.size()][modelName.length];
		
		int i = 0;
		for(Iterator<SnackBar> it = tempList.iterator(); it.hasNext();)
		{
			SnackBar sb = it.next();
			
			for(int j = 0; j < snackContents[i].length; j++)
			{
				if(j == 0)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackBarIndex());
				}
				else if(j == 1) 
				{
					snackContents[i][j] = sb.getSnack();
				}
				else if(j == 2)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackQuantity());
				}
				else if(j == 3)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackPrice());
				}
				else if(j == 4)
				{
					snackContents[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		return snackContents;
	}
	
	
	// 관리자 스낵 수량 수정
	// (콘솔용)
	public void adminModifySnack()
	{
		String snackName = "콜라";
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if( ((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName)  )
			{
				indexNum = i;
			}
		}
		//출력
		System.out.println(((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity());
		
		((SnackBar)admin.getAdminSnackBarList().get(indexNum)).
		setSnackQuantity( ((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity()+10);		
	}
	 
	// 관리자 스낵 이름으로 삭제
	//(콘솔용)
	public void adminDelSnack(String name)
	{
//		String snackName = adminView.searchSnackName();
//		int indexNum = 0;
//		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
//		{
//			if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName))
//			{
//				
//				indexNum = i;
//			}
//		}
//		admin.getAdminSnackBarList().remove(indexNum);
//		snackBarList = admin.getAdminSnackBarList();
		
		String snackName = name;
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName))
			{
				
				indexNum = i;
			}
		}
		admin.getAdminSnackBarList().remove(indexNum);
		snackBarList = admin.getAdminSnackBarList();
				
	}
	
	// 관지라 스낵 서치
	public void SnackSeach()
	{	
		for(int i = 0 ; i < snackBarList.size(); i++)
		{
			System.out.println(snackBarList.get(i));
		}
	}
			
	//관리자 방관리
	//{"룸 번호","룸 이름","최대 인원","노트북"};
	
	// 모든 방검색
	public String[][] adminSearchAllRoomInfo(String[] modelName)
	{
		String[][] roomInfoContents = new String[admin.getAdminRoomInfoList().size()][modelName.length];
		int i = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			for(int j = 0; j < admin.getAdminRoomInfoList().size(); j++)
			{
				if(j == 0)
				{
					roomInfoContents[i][j] =  String.valueOf(r.getRoomNumber());
				}
				else if(j == 1)
				{
					roomInfoContents[i][j] = r.getRoomName();
				}
				else if(j == 2)
				{
					roomInfoContents[i][j] = String.valueOf(r.getMaxPpl());
				}
				else if(j == 3)
				{
					roomInfoContents[i][j] = String.valueOf(r.getNoteBook());
				}
			}
			i++;
		}
		
		return roomInfoContents;
	}
	
	
	// 방 번호로 찾기
	// (콘솔용)
	public void adminSearchRoomInfo()
	{
		int roomNum = 1;
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				System.out.println(r);
			}
		}
	}
	 
	// 룸 수정 노트북 갯수
	public void adminModifyRoom()
	{
		int roomNum = 1;
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				r.setNoteBook(r.getNoteBook() + 1 );
				System.out.println(r);
			}
		}		 
	}
	

	//관리자 Payment
	//매출 검색
	public String[][] adminSearchTotalPay(String[] modelName)
	{
		//원래 테이블 보다 Row 행 을 하나 더 생성
		String[][] paymentContents = new String[admin.getAdminPaymentList().size()+1][modelName.length];
		int num = 0;
		int i = 0;
		for(Iterator<Payment> it = admin.getAdminPaymentList().iterator(); it.hasNext();)
		{					
			Payment p = it.next();
			
			// 테이블에 대한 값을 넣어주기
			for(int j = 0; j < paymentContents[i].length; j++)
			{			
				if(i < admin.getAdminPaymentList().size())
				{
					if(j == 0)
					{
						paymentContents[i][j] = p.getUser();
					}	
					else if(j == 1)
					{				
						paymentContents[i][j] = String.valueOf(p.getFinalCost());
						num += p.getFinalCost();			
					}
					else if(j == 2)
					{
						paymentContents[i][j] = p.getDate();
					}
				}
			}
			i++;	
		}
		System.out.println(i);
		System.out.println(admin.getAdminPaymentList().size());
		
		// 마지막줄에 일매출과 다녀간 인원 String으로 테이블 작성 
		if(i == admin.getAdminPaymentList().size())
		{
			System.out.println("여기옴");
			paymentContents[admin.getAdminPaymentList().size()][0] = "일 매출";
			paymentContents[admin.getAdminPaymentList().size()][1] = "총합 :  "+ String.valueOf(num)+"원";
			paymentContents[admin.getAdminPaymentList().size()][2] = "오늘 다녀간 인원 :" + admin.getAdminPaymentList().size()+"명" ;
		}
		
		return paymentContents;	
	}
	
/////////////////////////////////////////////(여송)관리자 기능 끝////////////////////////////////////////////////////	
		
	
	// 메인뷰
	public void mainView()
	{
		mv.initialize(this, mainJframe, this.roomInfoList);       // 메인 뷰 초기화
	}
	
	// sub room view
	public void subRoomView(int roomNumber)
	{
		subRoomV.initialize(this, mainJframe,this.roomInfoList, roomNumber);
	}
	
	// 로긴 뷰 
	public void loginView()
	{
		lv.initialize(this, mainJframe);
	}

	// 회원 가입
	public void accoutView() {
		accountV.initialize(this, mainJframe);
	}

	// 회원 가입
	public void accoutView2() {
		subAccountV.initialize(this, mainJframe);
	}
	
	public void nAccountView()
	{
		nAccountV.initialize(this, mainJframe);
	}
	
	// 추가시간 뷰
	public void addTiemView() {
		
	}
	
	// 관리자 
	public void adminView() {
		adminV1.initialize(this, mainJframe);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	// 결재정보 뷰
	public void paymentView() {
		
	//			paymentList.add(new Payment());
	//			pm = new Payment();
	//			 To use the getters, use the constructor to send the Collection list
		
	//			Method 1 (the create a new object)
		//paymentList.add(new Payment());
		payV.initialize(this, mainJframe, paymentList,tempPayment);
	}
	
	// 마지막 결제뷰
	public void finalPaymentView() {
		finalpv.initialize(this, mainJframe, paymentList);
	}
	
	
	// 간식 뷰
	public void snackView() {
		snackV.initialize(this, mainJframe, snackTmpList);
	}
	
	public void adminSnackView()
	{
		adminSnackV.initialize(this, mainJframe, snackBarList);
	}
	
	public void reserView() {
		reV.initialize(this, mainJframe);
	}

}
	

