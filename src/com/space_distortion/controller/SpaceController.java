package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.model.vo.Payment;
import com.space_distortion.model.vo.RoomInfo;
import com.space_distortion.model.vo.SnackBar;
import com.space_distortion.view.AccountView;
import com.space_distortion.view.AccountView2;
import com.space_distortion.view.AddTimeRoomView;
import com.space_distortion.view.AdminView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;
import com.space_distortion.view.PaymentView;
import com.space_distortion.view.SnackBarView;
import com.space_distortion.view.SubRoomView;

// 기능구현 클래스
public class SpaceController {
	
	//잠시 관리자에 에 쓰이는 변수
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	
	
	
	/////////////////////////////// Model.vo 객체 리스트///////////
	Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // 회원 맵
	Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // 비회원 맵
	List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // 룸에 대한 리스트
	List<Payment> paymentList = new ArrayList<Payment>();  // 페이먼트 대한 리스트
	List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // 스낵관련리스트
	
	
	Admin admin = new Admin();
	
	///////////////////////Model.vo 뷰/////////////////////////////////////////
	
	MainRoomView mv = new MainRoomView(); // 메인 뷰
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();                  //메인 뷰 생성
	private SubRoomView subRoomV = new SubRoomView();       // 서브룸
	private LoginView lv = new LoginView();                         //로그인뷰
	private AccountView accountV = new AccountView();		//회원 가입 뷰 생성
	private AccountView2 subAccountV = new AccountView2();	//회원 가입 뷰 생성
	private AddTimeRoomView addTimeV = new AddTimeRoomView();	//추가시간 뷰 생성
	private AdminView adminV = new AdminView();				//관리자 뷰 생성
	private PaymentView payV = new PaymentView();			//결재 뷰 생성
	private SnackBarView snackV = new SnackBarView();		//간식 뷰 생성
	private JFrame mainJframe = new JFrame();				//메인 프레임 생성
	
	/* 메인 컨트롤러 생성자 */
	public SpaceController() {
		this.init();
	}
	
	// 메인 프레임 생성
		public void init()
		{
			mainJframe = new JFrame("Space Distorition");
			mainJframe.setBounds(100, 100, 800, 800);
//			mainJframe.setLayout(new FlowLayout());
			mainJframe.setDefaultCloseOperation(3);
//			mainJframe.setVisible(true);	
		}
	
	
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	AdminView adminView;
	
	public void initConsol()
	{
		mMap.put(mKeyNumber++,new Member("윤여송", "1234", "dbsduthd123@naver.com", "경기도 부천", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("김여송1", "12714110", "duthd123@naver.com", "서울", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("차여송2", "12341020", "yeosong92@gmail.com", "부산", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("다여송", "1234", "yeo90@gmail.com", "대전", "010378801", "1972/04/27", 1));
		
		
		snackBarList.add(new SnackBar(1, "치토스", 30, "물량부족"));
		snackBarList.add(new SnackBar(1, "포카칩", 20, "물량부족"));
		snackBarList.add(new SnackBar(2, "포카리", 15, "물량부족"));
		snackBarList.add(new SnackBar(2, "콜라", 10, "물량부족"));
		snackBarList.add(new SnackBar(2, "마운틴듀", 33, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, "물량부족"));
		
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		
//		mSet = mMap.entrySet();
//		Iterator itEntrySet = mSet.iterator();
//		List<Member> tempList = new ArrayList<Member>();
//			
//		while(itEntrySet.hasNext())
//		{
//			Map.Entry obj = (Map.Entry)itEntrySet.next();
//			tempList.add( ((Member)obj.getValue()) );
//		}
//		
//		mSet = mMap.keySet();
//		Iterator itkeySet = mSet.iterator();
//		
//		while(it.hasNext())
//			System.out.println(it.next());
		
		
	}
	// 콘솔 메인
	public void mainConsolView()
	{
		adminView = new AdminView();
		adminView.SpaceMainMenu();
	}
	
	
	/////////////////////////////////////////////////// 관리자 멤버 관리 기능 ///////////////////////////////////////////////////////////////
	// 컨트롤러 셋
	public void seachMem()
	{
		Set mSet;
		mSet = mMap.entrySet();
		Iterator it = mSet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			System.out.println("key : " +obj.getKey()+" " + " value : "+ obj.getValue());
		}
	}
	
	//관리자용 모든 멤버 검색(오름차순)
	public void adminSearchAllMember()
	{
		
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
		
		Iterator itList = list.iterator();
		
		while(itList.hasNext())
			System.out.println(itList.next());
		
	}
	
	// 관리자용 이름으로 검색기능
	public void adminSearchMemberName()
	{	
		//이름으로 찾기
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		String mName = adminView.searchMemberName();	
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(mName)   )
			{
				list.add( ((Member)obj.getValue()) );
			}
		}
		Collections.sort(list,new AscMember());
		
		Iterator itList = list.iterator();
		while(itList.hasNext())
			System.out.println(itList.next());
	}
	
	// 관리자용 회원 코드로 삭제
	public void adminDelMember()
	{	
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = adminView.searchMemberKey();
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
		admin.getAdminMemberMap().remove(deleteIndex);
		mMap = admin.getAdminMemberMap();	
	}
	
	
	
////////////////////////////////////////////////////SnackBar///////////////////////////////////////////////////////////

	// 관리자 모든 드린크 검색
	public void adminSearchAllSnack()
	{
		
		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		for(int i = 0; i <admin.getAdminSnackBarList().size(); i++)
		{
			System.out.println(admin.getAdminSnackBarList().get(i).toString());
		}

	}
	
	
	// 음료인지 과자인지 판별
	public void adminSearchSnack()
	{
		int num = adminView.searchSnackIndex();		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		int count = 0;
		if(num == 1 || num == 2)
		{
			if(num == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));
						count++;
					}
				}
			}
			else
			{
				
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));
						count++;
					}
				}
			
			}	
		}	
		else
		{
			System.out.println("오류");
		}
		System.out.println(count);
	}
	
	
	// 수량 수정
	public void adminModifySnack()
	{
		String snackName = adminView.searchSnackName();
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if( ((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName)  )
			{
				indexNum = i;
			}
			//System.out.println(admin.getAdminSnackBarList().get(i));
		}
		System.out.println(indexNum);
		System.out.println(adminView.searchSnackQuntity());
		System.out.println(((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity());
		
		((SnackBar)admin.getAdminSnackBarList().get(indexNum)).
		setSnackQuantity( ((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity()+adminView.searchSnackQuntity());	
		
		
	}
	 
	// 삭제
	public void adminDelSnack()
	{
		String snackName = adminView.searchSnackName();
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
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
//////////////////////////////////////////////////관리자 방 관리////////////////////////////////////////////////////////
	// 모든 방검색
	public void adminSearchAllRoomInfo()
	{
		
	}
	
	
	// 방 번호로 찾기
	public void adminSearchRoomInfo()
	{
		
	}
	
	// 삭제 
	public void adminDelRoom()
	{
		
	}
	
/////////////////////////////////////////////관리자 Payment///////////////////////////////////////
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
/////////////////////////////////////////////////////////////////////////////////////Consol////////////////////////////////////////////////////////////////////		
	
	// 메인뷰
		public void mainView()
		{
			mv.initialize(this, mainJframe);       // 메인 뷰 초기화
		}
		
		// sub room view
		public void subRoomView()
		{
			subRoomV.initialize(this, mainJframe);
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
		
		// 추가시간 뷰
		public void addTiemView() {
			
		}
		
		// 관리자 
		public void adminView() {
			
		}
		
		// 결재정보 뷰
		public void paymentView() {
			payV.initialize(this, mainJframe);
		}
		
		// 간식 뷰
		public void snackView() {
			
		}
	
	
	
}
	

