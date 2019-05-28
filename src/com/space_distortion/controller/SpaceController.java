package com.space_distortion.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.view.MainRoomView;

// 기능구현 클래스
public class SpaceController {
	
	List<Member> mList = new ArrayList<Member>(); //회원
	List<NonMember> nList = new ArrayList<NonMember>();  //비회원
	MainRoomView mv;
	
	public void mainView()
	{
		mv = new MainRoomView();
		mv.showMainView();
	}

}
