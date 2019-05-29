package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;

// ��ɱ��� Ŭ����
public class SpaceController {
	
	List<Member> mList = new ArrayList<Member>(); //ȸ��
	List<NonMember> nList = new ArrayList<NonMember>();  //��ȸ��
	MainRoomView mv; // ���� ��
	LoginView lv = new LoginView(); //�α��κ�
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();
	private JFrame jframe;
	
	
	public void mainView()
	{
		mv = new MainRoomView(); //���� �� ����
		mv.init();
		jframe = mv.getFrame();
		mv.mainView(this);       // ���� �� �ʱ�ȭ �� setVisible(true)
	}
	
	// ȸ���������� 
	public void loginView()
	{
		lv.loginView(this);
	}

	public JFrame getJframe() {
		return jframe;
	}
	
	
}
	

