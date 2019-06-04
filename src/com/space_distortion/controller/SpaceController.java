package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
	
	List<Member> mList = new ArrayList<Member>();
	
	
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
	private AdminView adminV1 = new AdminView();				//관리자 뷰 생성
	private PaymentView payV = new PaymentView();			//결재 뷰 생성
	private SnackBarView snackV = new SnackBarView();		//간식 뷰 생성
	private JFrame mainJframe = new JFrame();				//메인 프레임 생성
	
	/* 메인 컨트롤러 생성자 */
	public SpaceController() {
		this.init();
		initConsol();
	}
	
	// 메인 프레임 생성
		public void init()
		{
			mainJframe = new JFrame("Space Distorition");
			mainJframe.setBounds(100, 100, 1024, 768);
//			mainJframe.setLayout(new FlowLayout());
			mainJframe.setDefaultCloseOperation(3);
//			mainJframe.setVisible(true);	
		}
	
	
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	AdminView adminView;
	
	
	
	public void initConsol()
	{
	
		
		
		//임시 회원 생성
		mMap.put(mKeyNumber++,new Member("윤여송", "1234", "dbsduthd123@naver.com", "경기도 부천", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("김여송1", "12714110", "duthd123@naver.com", "서울", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("차여송2", "12341020", "yeosong92@gmail.com", "부산", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("다여송", "1234", "yeo90@gmail.com", "대전", "010378801", "1972/04/27", 1));
		
		//임시 스낵 생성
		snackBarList.add(new SnackBar(1, "치토스", 30, "물량부족"));
		snackBarList.add(new SnackBar(1, "포카칩", 20, "물량부족"));
		snackBarList.add(new SnackBar(2, "포카리", 15, "물량부족"));
		snackBarList.add(new SnackBar(2, "콜라", 10, "물량부족"));
		snackBarList.add(new SnackBar(2, "마운틴듀", 33, "물량부족"));
		snackBarList.add(new SnackBar(1, "허니버터칩", 11, "물량부족"));
		
		
		//임시 방 생성
		roomInfoList.add(new RoomInfo(1, "A", 4, 4, 0, 4, 1) );
		roomInfoList.add(new RoomInfo(2, "B", 6, 5, 0, 6, 0) );
		roomInfoList.add(new RoomInfo(3, "C", 6, 4, 0, 6, 1) );
		roomInfoList.add(new RoomInfo(4, "D", 4, 2, 0, 4, 1) );
		roomInfoList.add(new RoomInfo(5, "E", 8, 8, 0, 8, 1) );
		roomInfoList.add(new RoomInfo(6, "F", 8, 5, 0, 8, 0) );
		roomInfoList.add(new RoomInfo(7, "G", 8, 6, 0, 8, 0) );
		roomInfoList.add(new RoomInfo(8, "H", 16, 14, 0, 12, 0) );
		
		//임시 페이먼트 생성
		//paymentList.add(new Payment(roomNumberInUse, user, hourlyCost, hour, ppl, discountRate, whiteBoard, beamProjector, whiteBoardCost, beamProjectorCost, laptopCost, laptop, totalHourlyCost, totalLaptopCost, totalCost, finalCost))
		
		
		//관리자 리스트에 추가
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		admin.setAdminRoomInfoList(roomInfoList);
		
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
	
	
	
////////////////////////////////////////////////////SnackBar///////////////////////////////////////////////////////////

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
					snackContetnts[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		return snackContetnts;
	}
	
	
	// 음료인지 과자인지 판별
	public void adminSearchSnack()
	{
		//스낵에 대한 인덱스를 가져와
		int num = adminView.searchSnackIndex();
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		
		if(num == 1 || num == 2)
		{
			if(num == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));
						
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
					}
				}
			
			}	
		}	
		else
		{
			System.out.println("오류");
		}
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
		}
		
		
		//출력
		System.out.println(((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity());
		
		((SnackBar)admin.getAdminSnackBarList().get(indexNum)).
		setSnackQuantity( ((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity()+adminView.searchSnackQuntity());
		
		
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
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
//////////////////////////////////////////////////관리자 방 관리////////////////////////////////////////////////////////
	// 모든 방검색
	public void adminSearchAllRoomInfo()
	{
		for(Iterator it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			System.out.println(it.next());
		}
	}
	
	
	// 방 번호로 찾기
	public void adminSearchRoomInfo()
	{
		int roomNum = adminView.searchRoomNum();
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
		int roomNum = adminView.searchRoomNum();
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				r.setNoteBook(r.getNoteBook() + adminView.searchRoomNum() );
				System.out.println(r);
			}
		}		
	}
	
/////////////////////////////////////////////관리자 Payment///////////////////////////////////////
	
	//매출 검색
	public int adminSearchTotalPay()
	{
		int num = 0;
		for(Iterator<Payment> it = admin.getAdminPaymentList().iterator(); it.hasNext();)
		{
			Payment p = it.next();
			num += p.getFinalCost();
		}
		System.out.println(num);
		
		return num;	
	}
	
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
		adminV1.initialize(this, mainJframe);
	}

	/////////////////////////////////////////////////////////////////////

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	// 결재정보 뷰
	public void paymentView() {
		payV.initialize(this, mainJframe);
	}
	
	// 간식 뷰
	public void snackView() {
		
	}
	
}
	

