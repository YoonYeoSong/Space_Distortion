
package com.space_distortion.controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.space_distortion.model.vo.RoomInfo;

public class TimerThread extends Thread{
	
	private JLabel lbl;
	private int time;
	private int timeNumer;
	private int index;
	private List<RoomInfo> roomInfoList;
	private JButton btn;
	

	public TimerThread(JLabel lbl, int time,List<RoomInfo> list, int index, JButton btn) {
		this.lbl=lbl;
		this.time=time;
		this.roomInfoList = list;
		this.index = index;
		this.btn = btn;
	}

	@Override
	public void run() {
		
	
	timeNumer = time;
	
	while(timeNumer>0)
	{
		timeNumer--;
		roomInfoList.get(index).setRemTime(timeNumer);
		btn.setEnabled(false);
		btn.setBackground(Color.red);
		
		/*
		 i / 3600 = 시간
		 (i % 3600)/60 = 분
		 ((i % 3600)%60) = 초
		 */
		
        lbl.setText((timeNumer/3600)+":"+(timeNumer % 3600)/60+":"+((timeNumer % 3600)%60));
        System.out.println(timeNumer);
        //lbl.setText(i+"초");
		//lbl.setText((i/3600)+":"+(i % 3600)/60+":"+((i % 3600)%60));
		
		if(timeNumer==0)
		{
			
			lbl.setText("");
			btn.setEnabled(true);
			btn.setBackground(null);
		}
		
		try {
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	
	
	

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTimeNumer() {
		return timeNumer;
	}

	public void setTimeNumer(int timenumer) {
		this.timeNumer = timenumer;
	}
	
	
	
	
}
