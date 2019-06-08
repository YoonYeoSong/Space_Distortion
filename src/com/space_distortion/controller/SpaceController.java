package com.space_distortion.controller;

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

import javax.swing.JFrame;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.Coupon;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.model.vo.Payment;
import com.space_distortion.model.vo.RoomInfo;
import com.space_distortion.model.vo.SnackBar;
import com.space_distortion.view.AccountView;
import com.space_distortion.view.AccountView2;
import com.space_distortion.view.AddTimeRoomView;
import com.space_distortion.view.AdminView;
import com.space_distortion.view.FinalPaymentView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;
import com.space_distortion.view.NaccountView;
import com.space_distortion.view.PaymentView;
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
	
	/* 메인 컨트롤러 생성자 */
	public SpaceController() {
		this.init();
			
		
		this.initConsol();  // 관리자 테스트 생성자
		this.snackViewDidload();
	}
	
	
	
	// 메인 프레임 생성
	public void init()
	{
		
		// 방정보 불러오기
		// 방이름 방번호 수용인원 빔프로젝트 사용여부
		// 방이름 방번호 수용인원 빔프로젝트 사용여부
//        roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(0).setRemTime(2);
//        roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(1).setRemTime(5400);
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
//        roomInfoList.add(new RoomInfo("STANFORD", 8, 12, "※ 빔프로젝트사용가능 ※"));
//        roomInfoList.get(8).setRemTime(13200);
//		
//        
//        
//      snackBarList.add(new SnackBar(1, "치토스", 30, 1400, "물량부족"));
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
        
		
		mainJframe = new JFrame("Space Distorition");
		mainJframe.setBounds(0, 0, 1024, 768);
		mainJframe.setLayout(null);
		mainJframe.setDefaultCloseOperation(3);
		
		mainJframe.setVisible(true);	
		
		mainJframe.addWindowListener(new SpaceActionEvent(ViewIndex.WINDOWEIXT,1,this,this.mainJframe));
	}
	
	
	public void dataInit() {
		snackPaylList.clear();
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
	public boolean logincheck(String inputid, String inputpw) 
	{	
		System.out.println(inputid);
		System.out.println(inputpw);
		
		boolean check = false;
		System.out.println("맵 사이즈 : " + mMap.size()); //맴버 사이즈 확인
		
		
//		Set<Entry<Integer, Member>> set = mMap.entrySet();	
//		Iterator<Map.Entry<Integer,Member>> it = set.iterator();
//		
//		while(it.hasNext())
//		{
//			Entry<Integer, Member> obj = it.next();
//			
//			if( (obj.getValue().getEmailId().equals(inputid)) && (obj.getValue().getMemberPw().equals(inputpw)) )
//			{
//				check = true;
//			}
//		}
		
		for(int i=0;i<mMap.size();i++) {
			System.out.println(((Member)mMap.get(i)).getEmailId().equals(inputid));//아이디가 일치하는지, 일치하면true출력
			System.out.println(((Member)mMap.get(i)).getMemberPw().equals(inputpw));//패스워드가 일치하는지, 일치하면 true출력
			if(((Member)mMap.get(i)).getEmailId().equals(inputid) && ((Member)mMap.get(i)).getMemberPw().equals(inputpw)) {
					//System.out.println("로그인 확인");
				System.out.println("로그인"+  ((Member)mMap.get(i)).getEmailId().equals(inputid));//아이디가 일치하는지, 일치하면true출력
				System.out.println("로그인"+((Member)mMap.get(i)).getMemberPw().equals(inputpw));//패스워드가 일치하는지, 일치하면 true출력
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
	 * 1 : 과자
	 * 2 : 음료
	 */
	
	// 스낵 뷰가 로드될때 데이터 로드
	public void snackViewDidload() {
			
		// 음료만 리스트로 생성
		for (SnackBar snackBar : snackBarList) {
			if(snackBar.getSnackBarIndex() == 2) {
				snackTmpList.add(snackBar);
			}
		}//for
	} //snackViewDidload
		
	public void snackSel(int i) {
		
		// 초기화
		if(!snackTmpList.isEmpty())
			snackTmpList.clear();
		
		if(i == 2) {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 2) {
					snackTmpList.add(snackBar);
				}
			}//for
		}else {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 1) {
					snackTmpList.add(snackBar);
				}
			
			}//for
		}//else

	}// snackSel
	
	// 과자버튼 선택 후 과자 종류 선택
	public List<SnackBar> snackSelList(int btnIndex) {
//		System.out.println("과자 세부선택");
//		System.out.println("2 :" +snackBarList.get(btnIndex).getSnack());
//		System.out.println("1 :" +((SnackBar)snackBarList).getSnackComment());	//err

		boolean snackOverlapChk = false;
		
		if(snackPaylList.isEmpty()) {
			snackPaylList.add(snackTmpList.get(btnIndex));
//			snackPaylList.get(btnIndex).setSnackQuantity(1);
			return snackPaylList;
		}
		
		System.out.println(snackPaylList);
		
		for (int i = 0; i < snackPaylList.size(); i++) {
			if( snackTmpList.get(btnIndex).getSnack().equals(
					snackPaylList.get(i).getSnack()
					)){
				snackOverlapChk = true;
//				snackPaylList.get(i).setSnackQuantity(1);
			}
		}

		if(!snackOverlapChk)
//		{
//			System.out.println("상품 갯수 추가");
//			
//			// 상품 선택 수량 증가 코드 필요
//			//
//			//
//			//
//		}else
			{
			snackPaylList.add(snackTmpList.get(btnIndex));
//			snackPaylList.get(btnIndex).setSnackQuantity(1);
			}

		return snackPaylList;
	}//snackSelList
		
//			if( ((SnackBar)snackPaylList).getSnack().equals(
//					snackPaylList.get(btnIndex).getSnack()
//					)){
//				System.out.println("같은 상품 선택");
//				break;
//			}else {
//				System.out.println("다른 상품 선택");
//				snackPaylList.add(snackTmpList.get(btnIndex));
//				break;
//			}
		
		
		
//		snackPaylList.add(snackTmpList.get(btnIndex));
//		for (SnackBar s : snackPaylList) {
//			System.out.println(s);
//		}

	// 선택된 간식 리스트
	public List<SnackBar> snackSelList() {
		return snackPaylList;
	}//snackSel
	
	public void snackTableRe() {
		snackV.rightTableInit(this);
	}
		
//		List<SnackBar> tmpList = new ArrayList<SnackBar>(); // = snackTmpList;
		
//		System.out.println(tmpList);
//		System.out.println(snackBarList.get(0).getSnackBarIndex());
		
//		System.out.println(tmpList.get(btnIndex).getSnackBarIndex());
	
//		SnackBar snackTmp = new SnackBar();
		
//		tmpList.add(e)
		
//		int a = 0;
//		a += tmpList.get(btnIndex).getSnackPrice();

//		if ( tmpList.get(btnIndex).getSnackBarIndex() == 1) {
//			System.out.println("dfdfdfdfadfwerwer");
//		}
		
//		if(((SnackBar)snackBarList).getSnackBarIndex() == 1) {
//			tmpList = snackBarList;
//			
//		}
//		
//		if(((SnackBar)snackBarList).getSnackBarIndex() == 2) {
//			tmpList = snackBarList;
			
//		}//if
		
	
//	public List<SnackBar> snackPay(){
//		return this.snackPaylList;
//	}
	
	
	
	
	
//////////////////////////////////////(헌수)스낵 기능 끝/////////////////////
	
	
	
	
	
	
	
/////////////////////////////////////(무관)Payment 기능 시작 //////////////////////////////
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

		
	public void hourlyCostCalculator(List<Payment> list) {
		(list.get(list.size()-1)).setTotalHourlyCost(
				((list.get(list.size()-1)).getHour()*
				(list.get(list.size()-1)).getHourlyCost()*
				(list.get(list.size()-1)).getPpl())+
				((list.get(list.size()-1)).getLaptop()*
						(list.get(list.size()-1)).getLaptopCost()));
//			System.out.println("getHour: " + (list.get(list.size()-1)).getHour());
		System.out.println("getHourlyCost during hourlyCalc: "+ (list.get(list.size()-1)).getHourlyCost());
		System.out.println("getPpl during hourlyCalc: "+ (list.get(list.size()-1)).getPpl());
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
		mMap.put(mKeyNumber++,new Member("123", "123", "123", "경기도 부천", "01054035883", "1992/04/27", 1));
		
		
		//임시 스낵 생성
		snackBarList.add(new SnackBar(1, "치토스", 30, 1000,"물량부족"));
		snackBarList.add(new SnackBar(1, "포카칩", 20,1000, "물량부족"));
		snackBarList.add(new SnackBar(2, "포카리", 15,1000, "물량부족"));
		snackBarList.add(new SnackBar(2, "콜라", 10,1000, "물량부족"));
		snackBarList.add(new SnackBar(2, "마운틴듀", 33,1000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11,1000, "물량부족"));		
		snackBarList.add(new SnackBar(1, "치토스", 30, 1400, "물량부족"));
		snackBarList.add(new SnackBar(1, "포카칩", 20, 1500, "물량부족"));
		snackBarList.add(new SnackBar(2, "포카리", 15, 600, "물량부족"));
		snackBarList.add(new SnackBar(2, "콜라", 10, 700, "물량부족"));
		snackBarList.add(new SnackBar(2, "마운틴듀", 33, 1000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 4000, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 1111, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, 2222, "물량부족"));
		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 3333, "물량부족"));
		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 4444, "물량부족"));
		snackBarList.add(new SnackBar(2, "허니버터칩", 11, 5555, "물량부족"));
		snackBarList.add(new SnackBar(1, "새우깡", 11, 6000, "물량부족"));
		snackBarList.add(new SnackBar(1, "칸쵸", 11, 1200, "물량부족"));
		snackBarList.add(new SnackBar(1, "개구리", 11, 10000, "물량부족"));
		
		
		// 방이름 방번호 수용인원 빔프로젝트 사용여부
		roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(0).setRemTime(20);
        roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(1).setRemTime(5);
        roomInfoList.add (new RoomInfo("USC", 2, 8, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(2).setRemTime(7200);
        roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(3).setRemTime(8200);
        roomInfoList.add (new RoomInfo("BROWN",4, 8, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(4).setRemTime(9200);
        roomInfoList.add(new RoomInfo("YALE", 5, 8, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(5).setRemTime(10200);
        roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(6).setRemTime(11200);
        roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "※ 빔프로젝트사용가능 ※"));
        roomInfoList.get(7).setRemTime(12200);
		
        
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
	
	
	
	
	
	
	public void couponCreat() {
		int couponSize = 500;
		Set<Coupon> couponSet = new HashSet<Coupon>();
		char[] coupon = new char[62];
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

		int couponCount = coupon.length;

		Random randomNumber = new Random();
		int index = 0;
		int i = 0;
		while (index < couponSize) {
			StringBuffer stringBuf = new StringBuffer(16);
			// i는 8자리의 랜덤값을 의미
			for (i = 16; i > 0; i--) {
				// 문자 배열 데이터를 현재 문자열 끝에 추가한다.
				stringBuf.append(coupon[randomNumber.nextInt(couponCount)]);
			}

			String couponNumber = stringBuf.toString();
			System.out.println("발행번호 : " + couponNumber);
			couponSet.add(new Coupon(null, couponNumber));
			index++;
		}
		
		Iterator<Coupon> it = couponSet.iterator();
		
		while(it.hasNext())
		{
			Coupon c = it.next();
			couponList.add(c);
		}
		
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
			out = new FileOutputStream("Member.txt");
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
			in = new FileInputStream("Member.txt");
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
		String[][] membrContents = new String[admin.getAdminMemberMap().size()][modelName.length];
		
		
		
		Set mSet;
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			list.add(((Member)obj.getValue()));
		}
		Collections.sort(list,new AscMember());
		
		
		
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
		
		String searchName = jtfName;
		
		
		Set mSet;
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(searchName) )
				list.add(((Member)obj.getValue()));
		}
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


	// 회원코드로 찾기
	public void adminModifyMember(int userCode , String userValue)
	{	
		
		//맵에 엔트리셋을 이용하여 iter로 출력
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		
		int memberCode = userCode;  //유저코드
		String memberPw = userValue; // 유저 비밀번호
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		while(it.hasNext())
		{
			
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				deleteIndex = obj.getKey();
				
			}
		}
		
		((Member)admin.getAdminMemberMap() .get(deleteIndex)).setMemberPw(memberPw);
		mMap = admin.getAdminMemberMap();	
	}
	
	
	
	//관리자 쿠폰 발행
	public void adminCouponSend(int userCode)
	{
		int userCodeNum = userCode;
		
		// 맵에 엔트리셋을 이용하여 iter로 출력
		Set<Map.Entry<Integer, Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer, Member>> it = mSet.iterator();
		int Index = 0;

		while (it.hasNext()) {
			Map.Entry<Integer, Member> obj = (Entry<Integer, Member>) it.next();
			if (((Member) obj.getValue()).getUserCode() == memberCode) {
				Index = obj.getKey();
			}
		}
		System.out.println(    ((Member)admin.getAdminMemberMap().get(Index) ).getCoupon());
		if(   ( (Member)admin.getAdminMemberMap().get(Index) ).getCoupon().equals("없음")    )
		{
			((Member)admin.getAdminMemberMap().get(Index)).setCoupon(admin.getAdminCouponList().get(couponCount).getCoupontNumber());
			admin.getAdminCouponList().get(couponCount).setUserCode(  String.valueOf(  ((Member)admin.getAdminMemberMap().get(Index)).getUserCode()) );
			couponCount++;
		}	
	}
	

	
	// 관리자용 회원 코드로 삭제
	public void adminDelMember(int userCode)
	{	
		//맵에 엔트리셋을 이용하여 iter로 출력
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		while(it.hasNext())
		{
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				deleteIndex = obj.getKey();
			}
		}
		
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
	
	public String[][] adminSearchAllSnack(String[] modelName)
	{
		
		String[][] snackContetnts = new String[admin.getAdminSnackBarList().size()][modelName.length];
		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
			
		int i = 0;
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
		
		return snackContetnts;
	}
	
	
	// 음료인지 과자인지 판별
	public String[][] adminSearchSnack(int index, String name, String[] modelName)
	{
		
		//String[][] snackContents;
		//스낵에 대한 인덱스를 가져와
		
		
		int snackIndex = 0;
		String snackName = null;
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
	
	
	// 스낵 수량 수정
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
	 
	// 스낵 이름으로 삭제
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
	

	///수정필요
	//관리자 Payment
	//매출 검색
	public String[][] adminSearchTotalPay(String[] modelName)
	{
		String[][] paymentContents = new String[admin.getAdminPaymentList().size()+1][modelName.length];
		int num = 0;
		int i = 0;
		for(Iterator<Payment> it = admin.getAdminPaymentList().iterator(); it.hasNext();)
		{					
			Payment p = it.next();
			
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
		payV.initialize(this, mainJframe);
	}
	
	// 마지막 결제뷰
	public void finalPaymentView() {
		finalpv.initialize(this, mainJframe, paymentList);
	}
	
	
	// 간식 뷰
	public void snackView() {
		snackV.initialize(this, mainJframe, snackTmpList);
	}
	
	
	
	
	
}
	

