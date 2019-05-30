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
import javax.swing.text.StyleContext.SmallAttributeSet;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.model.vo.RoomInfo;
import com.space_distortion.view.AdminView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;

// 기능구현 클래스
public class SpaceController {
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	
	
	List<Member> mList = new ArrayList<Member>(); //회원
	List<NonMember> nList = new ArrayList<NonMember>();  //비회원
	
	
	
	Map<Integer,Member> mMap = new HashMap<Integer, Member>();
	Set mSet;
	Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>();
	List<RoomInfo> roomInfo = new ArrayList<RoomInfo>();
	
	MainRoomView mv; // 메인 뷰
	LoginView lv = new LoginView(); //로그인뷰
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();
	private JFrame jframe;
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	AdminView adminView;
	
	public void init()
	{
		mMap.put(mKeyNumber++,new Member("윤여송", "1234", "dbsduthd123@naver.com", "경기도 부천", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("김여송1", "12714110", "duthd123@naver.com", "서울", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("차여송2", "12341020", "yeosong92@gmail.com", "부산", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("다여송", "1234", "yeo90@gmail.com", "대전", "010378801", "1972/04/27", 1));
		
		
//		
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
	
	public void mainConsolView()
	{
		adminView = new AdminView();
		adminView.SpaceMainMenu();
	}
	
	
	public void searchAllMember()
	{
//		key값
//		mSet = mMap.keySet();
//		Iterator itKey = mSet.iterator();
//		
//		while(itKey.hasNext())
//		{
//			Object obj = itKey.next();
//			System.out.println(mMap.get(obj));
//		}
		
		
	
		mSet = mMap.entrySet();
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
	public void searchAllRoomInfo()
	{
		
	}
	
	
	public void searchMember()
	{
		//이름으로 찾기
		String mName = adminView.searchMemberName();
		mSet = mMap.entrySet(); // entrySet
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(mName)   )
			{
				list.add( ((Member)obj.getValue()) );
				//System.out.println( ((Member)obj).toString() );
			}
		}
		Collections.sort(list,new AscMember());
		
		Iterator itList = list.iterator();
		while(itList.hasNext())
			System.out.println(itList.next());
			
		
	}
	
	public void searchRoomInfo()
	{
		
	}
	
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////Consol////////////////////////////////////////////////////////////////////		
	
	
	public void mainView()
	{

//		mv = new MainRoomView(); //메인 뷰 생성
//		mv.init();
//		jframe = mv.getFrame();
//		mv.mainView(this);       // 메인 뷰 초기화 후 setVisible(true)
	}
	
	// 회원가입으로 
	public void loginView()
	{
		lv.loginView(this);
	}

	public JFrame getJframe() {
		return jframe;
	}
	
	
}
	

