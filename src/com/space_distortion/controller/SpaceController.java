package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;

// 기능구현 클래스
public class SpaceController {
	
	List<Member> mList = new ArrayList<Member>(); //회원
	List<NonMember> nList = new ArrayList<NonMember>();  //비회원
	MainRoomView mv; // 메인 뷰
	LoginView lv = new LoginView(); //로그인뷰
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();
	private JFrame jframe;
	
	
	public void mainView()
	{
		mv = new MainRoomView(); //메인 뷰 생성
		mv.init();
		jframe = mv.getFrame();
		mv.mainView(this);       // 메인 뷰 초기화 후 setVisible(true)
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
	

