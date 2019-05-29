package com.space_distortion.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.space_distortion.view.AccountView;
import com.space_distortion.view.LoginView;

public class SpaceActionEvent implements MouseListener{

	
	LoginView lv = new LoginView(); // ·Î±×ÀÎºä
	AccountView av = new AccountView();  // È¸¿ø °¡ÀÔºä
	private JButton lvRegister;
	
	
	
	public SpaceActionEvent() {
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
//			//È¸¿ø°¡ÀÔºä·Î
//			av.showThisView();
//		}		
//	}

	
	
	
	
}
