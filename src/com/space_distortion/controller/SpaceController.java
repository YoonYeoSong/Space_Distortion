package com.space_distortion.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

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
	
	
	public void mainView()
	{
		mv = new MainRoomView(); //���� �� ����		
		mv.showMainView();       // ���� �� �ʱ�ȭ �� setVisible(true)
	}
	
	// ȸ���������� 
	public void setRegisterButton(JButton btn)
	{
		//btn.addActionListener(sAe);		
	}
	
}
	

