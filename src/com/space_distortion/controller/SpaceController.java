package com.space_distortion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;

// 기능구현 클래스
public class SpaceController implements ActionListener{
	
	List<Member> mList = new ArrayList<Member>(); //회원
	List<NonMember> nList = new ArrayList<NonMember>();  //비회원
	MainRoomView mv; // 메인 뷰
	LoginView lv = new LoginView(); //로그인뷰
	SpaceActionEvent sAe = new SpaceActionEvent();
	
	public void mainView()
	{
		mv = new MainRoomView(); //메인 뷰 생성
		mv.showMainView();       // 메인 뷰 초기화 후 setVisible(true)
	}
	
	// 회원가입으로 
	public void setRegisterButton()
	{
		lv.getBtn_Register().addActionListener(sAe);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
	

