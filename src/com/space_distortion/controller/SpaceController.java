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

// ��ɱ��� Ŭ����
public class SpaceController implements ActionListener{
	
	List<Member> mList = new ArrayList<Member>(); //ȸ��
	List<NonMember> nList = new ArrayList<NonMember>();  //��ȸ��
	MainRoomView mv; // ���� ��
	LoginView lv = new LoginView(); //�α��κ�
	SpaceActionEvent sAe = new SpaceActionEvent();
	
	public void mainView()
	{
		mv = new MainRoomView(); //���� �� ����
		mv.showMainView();       // ���� �� �ʱ�ȭ �� setVisible(true)
	}
	
	// ȸ���������� 
	public void setRegisterButton()
	{
		lv.getBtn_Register().addActionListener(sAe);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
	

