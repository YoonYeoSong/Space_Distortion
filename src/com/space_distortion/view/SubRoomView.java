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
	private JLabel lb1; // ���̸�
	private JLabel lb2; // ���ȣ
	private JLabel lb3; // �����ο�
	private JLabel lb4; // ��������Ʈ
	private JLabel lb5;
//   private JLabel lb6; // ��Ʈ�� �˸�
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

		btnBack = new JButton("ó�� ȭ������");
		btnBack.setBounds(840, 23, 138, 27);
		jp.add(btnBack);

		btnMember = new JButton("ȸ��");
		btnMember.setBounds(99, 585, 121, 58);
		jp.add(btnMember);

		btnNoMember = new JButton("��ȸ��");
		btnNoMember.setBounds(427, 585, 121, 58);
		jp.add(btnNoMember);

		btnReservation = new JButton("����");
		btnReservation.setBounds(779, 585, 121, 58);
		jp.add(btnReservation);

		lb1.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomName());
		lb2.setText("���ȣ :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getRoomNumber())); // ��Ʈ������
																												// �ٲ�
		lb3.setText("�����ο� :  " + String.valueOf(((RoomInfo) roomInfoList.get(roomNumber - 1)).getMaxPpl()));
		lb4.setText(((RoomInfo) roomInfoList.get(roomNumber - 1)).getLightProjecter());

		JLabel lbImage = new JLabel("\uBC29\uAD6C\uC870 \uC774\uBBF8\uC9C0");
		lbImage.setBounds(288, 171, 172, 52);
		jp.add(lbImage);

//      lb4.setText("�����ο� :  " + String.valueOf(sc.roomInfoList.get(num-1).getCurPpl()));
//      lb6.setText((sc.roomInfoList.get(num-1).getNoteBook()));

		btnMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 1, sc, mainJframe, jp)); // ȸ��
		btnNoMember.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 2, sc, mainJframe, jp)); // ��ȸ��
		btnReservation.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));// ����
		btnBack.addMouseListener(new SpaceActionEvent(SUB_ROOM_VIEW_NUM, 4, sc, mainJframe, jp)); // �ڷΰ���

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