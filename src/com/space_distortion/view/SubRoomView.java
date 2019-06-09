package com.space_distortion.view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.RoomInfo;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel lblWifi;

	public SubRoomView() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe, List roomInfoList, int roomNumber) {

		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);

		lb1 = new JLabel("");
		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lb1.setBounds(14, 12, 377, 107);
		jp.add(lb1);

		lb2 = new JLabel("");
		lb2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		lb2.setBounds(66, 107, 172, 52);
		jp.add(lb2);

		lb3 = new JLabel("");
		lb3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		lb3.setBounds(298, 107, 172, 52);
		jp.add(lb3);

		lb4 = new JLabel("");
		lb4.setBounds(200, 107, 230, 27);
		jp.add(lb4);

		btnBack = new JButton("\uBA54\uC778 \uD654\uBA74");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.CYAN);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(394, 12, 111, 27);
		jp.add(btnBack);

		btnMember = new JButton("회원");
		btnMember.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnMember.setBackground(Color.CYAN);
		btnMember.setForeground(Color.WHITE);
		btnMember.setBorderPainted(false);
		btnMember.setBounds(34, 632, 121, 58);
		jp.add(btnMember);

		btnNoMember = new JButton("비회원");
		btnNoMember.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNoMember.setForeground(Color.WHITE);
		btnNoMember.setBackground(Color.CYAN);
		btnNoMember.setBorderPainted(false);
		btnNoMember.setBounds(198, 632, 121, 58);
		jp.add(btnNoMember);

		btnReservation = new JButton("예약");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservation.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnReservation.setForeground(Color.WHITE);
		btnReservation.setBackground(Color.CYAN);
		btnReservation.setBorderPainted(false);
		btnReservation.setBounds(352, 632, 121, 58);
		jp.add(btnReservation);

		lb1.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomName());
		lb2.setText("방번호 :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomNumber())); // 스트링으러
																												// 바꿈
		lb3.setText("수용인원 :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getMaxPpl()));
		lb4.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getLightProjecter());
		
		lblWifi = new JLabel("New label");
		lblWifi.setIcon(new ImageIcon(SubRoomView.class.getResource("/com/space_distortion/view/Wifi.png")));
		lblWifi.setBounds(316, 502, 139, 62);
		jp.add(lblWifi);
		
		JLabel lblCafe = new JLabel("New label");
		lblCafe.setIcon(new ImageIcon(SubRoomView.class.getResource("/com/space_distortion/view/Cafe.jpg")));
		lblCafe.setBounds(56, 171, 428, 434);
		jp.add(lblCafe);

		JLabel lbIBack = new JLabel("\uBC29\uAD6C\uC870 \uC774\uBBF8\uC9C0");
		lbIBack.setIcon(new ImageIcon(SubRoomView.class.getResource("/com/space_distortion/view/SubRoom.png")));
		lbIBack.setBounds(0, 0, 1024, 768);
		jp.add(lbIBack);

//      lb4.setText("수용인원 :  " + String.valueOf(sc.roomInfoList.get(num-1).getCurPpl()));
//      lb6.setText((sc.roomInfoList.get(num-1).getNoteBook()));

		btnMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 1, sc, mainJframe, jp)); // 회원
		btnNoMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 2, sc, mainJframe, jp)); // 비회원
		btnReservation.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));// 예약
		btnBack.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 4, sc, mainJframe, jp)); // 뒤로가기

		mainJframe.getContentPane().add(jp);

		jp.revalidate();
		jp.repaint();

		// mainJframe.setContentPane(jp);
		// jp.setVisible(true);

//      jp.revalidate();
//      jp.repaint();
//      mainJframe.setVisible(true);

	}
}