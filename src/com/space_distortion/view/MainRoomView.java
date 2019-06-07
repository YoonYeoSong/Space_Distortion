package com.space_distortion.view;

import java.awt.SystemColor;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.controller.TimerThread;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.RoomInfo;

public class MainRoomView extends SpaceActionEvent implements ViewIndex {

	public MainRoomView() {

	}

	public void initialize(SpaceController sc, JFrame mainJframe, List<RoomInfo> roomInfoList) {
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1008, 728);
		jp.setLayout(null);

		JButton btnRoom1 = new JButton("1\uBC88\uBC29");
		btnRoom1.setBounds(88, 166, 105, 49);

		// 쓰레드라벨1
		JLabel lbTime1 = new JLabel("");
		lbTime1.setBounds(120, 122, 62, 49);
		jp.add(lbTime1);
		CallThread(lbTime1, roomInfoList.get(0).getRemTime(), roomInfoList, 0, btnRoom1);

		JButton btnRoom2 = new JButton("2\uBC88\uBC29");
		btnRoom2.setBounds(327, 166, 105, 49);

		// 쓰레드라벨2
		JLabel lbTime2 = new JLabel("");
		lbTime2.setBounds(360, 122, 105, 49);
		jp.add(lbTime2);
		CallThread(lbTime2, roomInfoList.get(1).getRemTime(), roomInfoList, 1, btnRoom2);

		JButton btnRoom3 = new JButton("3\uBC88\uBC29");
		btnRoom3.setBounds(578, 166, 105, 49);

		// 쓰레드라벨3
		JLabel lbTime3 = new JLabel("");
		lbTime3.setBounds(610, 122, 105, 49);
		jp.add(lbTime3);
		CallThread(lbTime3, roomInfoList.get(2).getRemTime(), roomInfoList, 2, btnRoom3);

		JButton btnRoom4 = new JButton("4\uBC88\uBC29");
		btnRoom4.setBounds(804, 166, 105, 49);
		// 쓰레드라벨
		JLabel lbTime4 = new JLabel("");
		lbTime4.setBounds(836, 122, 105, 49);
		jp.add(lbTime4);
		CallThread(lbTime4, roomInfoList.get(3).getRemTime(), roomInfoList, 3, btnRoom4);

		JButton btnRoom5 = new JButton("5\uBC88\uBC29");
		btnRoom5.setBounds(88, 355, 105, 49);
		// 쓰레드라벨
		JLabel lbTime5 = new JLabel("");
		lbTime5.setBounds(120, 312, 105, 49);
		jp.add(lbTime5);
		CallThread(lbTime5, roomInfoList.get(4).getRemTime(), roomInfoList, 4, btnRoom5);

		JButton btnRoom6 = new JButton("6\uBC88\uBC29");
		btnRoom6.setBounds(327, 355, 105, 49);
		// 쓰레드라벨
		JLabel lbTime6 = new JLabel("");
		lbTime6.setBounds(360, 312, 105, 49);
		jp.add(lbTime6);
		CallThread(lbTime6, roomInfoList.get(5).getRemTime(), roomInfoList, 5, btnRoom6);

		JButton btnRoom7 = new JButton("7\uBC88\uBC29");
		btnRoom7.setBounds(578, 355, 105, 49);
		// 쓰레드라벨
		JLabel lbTime7 = new JLabel("");
		lbTime7.setBounds(610, 312, 105, 49);
		jp.add(lbTime7);
		CallThread(lbTime7, roomInfoList.get(6).getRemTime(), roomInfoList, 6, btnRoom7);

		JButton btnRoom8 = new JButton("8\uBC88\uBC29");
		btnRoom8.setBounds(804, 355, 105, 49);
		// 쓰레드라벨
		JLabel lbTime8 = new JLabel("");
		lbTime8.setBounds(836, 312, 105, 49);
		jp.add(lbTime8);
		CallThread(lbTime8, roomInfoList.get(7).getRemTime(), roomInfoList, 7, btnRoom8);

		// 투명??
		// btnRoom8.setBackground(SystemColor.textHighlightText);

		jp.add(btnRoom1);
		jp.add(btnRoom2);
		jp.add(btnRoom3);
		jp.add(btnRoom4);
		jp.add(btnRoom5);
		jp.add(btnRoom6);
		jp.add(btnRoom7);
		jp.add(btnRoom8);

		JButton btnAdmin = new JButton("\uAD00\uB9AC\uC790");

		btnAdmin.setBounds(27, 626, 105, 27);
		jp.add(btnAdmin); // 관리자버튼

		btnRoom1.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 1, sc, mainJframe, jp));
		btnRoom2.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 2, sc, mainJframe, jp));
		btnRoom3.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));
		btnRoom4.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 4, sc, mainJframe, jp));
		btnRoom5.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 5, sc, mainJframe, jp));
		btnRoom6.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 6, sc, mainJframe, jp));
		btnRoom7.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 7, sc, mainJframe, jp));
		btnRoom8.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 8, sc, mainJframe, jp));
		btnAdmin.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 9, sc, mainJframe, jp));

		mainJframe.add(jp);
		jp.revalidate();
		jp.repaint();

		// jp.setVisible(true);
		// mainJframe.setVisible(true);
	}

/////쓰레드////////   
	public void CallThread(JLabel lbl, int remTime, List<RoomInfo> list, int index, JButton btn) {
		TimerThread tt = new TimerThread(lbl, remTime, list, index, btn);

		tt.start();
	}

}