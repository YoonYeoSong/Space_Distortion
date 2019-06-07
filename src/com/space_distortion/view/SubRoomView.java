package com.space_distortion.view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.RoomInfo;

public class SubRoomView extends SpaceActionEvent implements ViewIndex {

	// private Main win;
	// private SpaceController sc = new SpaceController();
	private JLabel lb1; // 방이름
	private JLabel lb2; // 방번호
	private JLabel lb3; // 수용인원
	private JLabel lb4; // 빔프로젝트
	private JLabel lb5;
//   private JLabel lb6; // 노트북 알림
//   private JLabel lb7;
	private JButton btnBack;
	private JButton btnMember;
	private JButton btnNoMember;
	private JButton btnReservation;

	public SubRoomView() {

	}

	public void initialize(SpaceController sc, JFrame mainJframe, List roomInfoList, int roomNumber) {

		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 600, 600);
		jp.setLayout(null);

		lb1 = new JLabel("");
		lb1.setBounds(14, 12, 242, 52);
		jp.add(lb1);

		lb2 = new JLabel("");
		lb2.setBounds(14, 105, 172, 52);
		jp.add(lb2);

		lb3 = new JLabel("");
		lb3.setBounds(14, 171, 172, 52);
		jp.add(lb3);

		lb4 = new JLabel("");
		lb4.setBounds(10, 306, 230, 27);
		jp.add(lb4);

		btnBack = new JButton("처음 화면으로");
		btnBack.setBounds(840, 23, 138, 27);
		jp.add(btnBack);

		btnMember = new JButton("회원");
		btnMember.setBounds(99, 585, 121, 58);
		jp.add(btnMember);

		btnNoMember = new JButton("비회원");
		btnNoMember.setBounds(427, 585, 121, 58);
		jp.add(btnNoMember);

		btnReservation = new JButton("예약");
		btnReservation.setBounds(779, 585, 121, 58);
		jp.add(btnReservation);

		lb1.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomName());
		lb2.setText("방번호 :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomNumber())); // 스트링으러
																												// 바꿈
		lb3.setText("수용인원 :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getMaxPpl()));
		lb4.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getLightProjecter());

		JLabel lbImage = new JLabel("\uBC29\uAD6C\uC870 \uC774\uBBF8\uC9C0");
		lbImage.setBounds(288, 171, 172, 52);
		jp.add(lbImage);

//      lb4.setText("수용인원 :  " + String.valueOf(sc.roomInfoList.get(num-1).getCurPpl()));
//      lb6.setText((sc.roomInfoList.get(num-1).getNoteBook()));

		btnMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 1, sc, mainJframe, jp)); // 회원
		btnNoMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 2, sc, mainJframe, jp)); // 비회원
		btnReservation.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));// 예약
		btnBack.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 4, sc, mainJframe, jp)); // 뒤로가기

		mainJframe.add(jp);

		jp.revalidate();
		jp.repaint();

		// mainJframe.setContentPane(jp);
		// jp.setVisible(true);

//      jp.revalidate();
//      jp.repaint();
//      mainJframe.setVisible(true);

	}
}