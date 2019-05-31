package com.space_distortion.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.view.AccountView;
import com.space_distortion.view.LoginView;

public class SpaceActionEvent implements MouseListener{

	
	private int index;
	private SpaceController sc;
	private JPanel jp;
	
	
	
	public SpaceActionEvent(int index, SpaceController sc, JPanel jp) {
		super();
		this.index = index;
		this.sc = sc;
		this.jp = jp;
	}



	public SpaceActionEvent() {
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(index == 1) {
			
			sc.loginView();
			jp.setVisible(false);
		}
		else if(index == 2) {
		}
		else
			System.out.println("버튼 없음");
			
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		lvRegister = (JButton)e.getSource();
//		if(lvRegister ==lv.getBtn_Register() )
//		{
//			//회원가입뷰로
//			av.showThisView();
//		}		
//	}

	
	
	
	
}
