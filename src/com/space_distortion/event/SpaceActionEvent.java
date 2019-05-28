package com.space_distortion.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.space_distortion.view.AccountView;
import com.space_distortion.view.LoginView;

public class SpaceActionEvent implements ActionListener{

	LoginView lv = new LoginView(); // 로그인뷰
	AccountView av = new AccountView();  // 회원 가입뷰
	private JButton lvRegister;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lvRegister = (JButton)e.getSource();
		if(lvRegister ==lv.getBtn_Register() )
		{
			//회원가입뷰로
			av.showThisView();
		}		
	}
}
