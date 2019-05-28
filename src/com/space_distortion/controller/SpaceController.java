package com.space_distortion.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.view.MainRoomView;

// ��ɱ��� Ŭ����
public class SpaceController {
	
	List<Member> mList = new ArrayList<Member>(); //ȸ��
	List<NonMember> nList = new ArrayList<NonMember>();  //��ȸ��
	MainRoomView mv;
	
	public void mainView()
	{
		mv = new MainRoomView();
		mv.showMainView();
	}

}
