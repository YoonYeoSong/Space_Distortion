package com.space_distortion.view;

import java.awt.Font;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.controller.TimerThread;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.RoomInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainRoomView extends SpaceActionEvent implements ViewIndex {

	public MainRoomView() {

	}

	// ±Û¾¾Ã¼ ¸¼Àº °íµñ Semilight Yu Gothic UI
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe, List<RoomInfo> roomInfoList) {
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1008, 728);
		jp.setLayout(null);

		JButton btnRoom1 = new JButton("1\uBC88\uBC29");
		btnRoom1.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom1.setBorderPainted(false);
		btnRoom1.setBounds(77, 290, 198, 150);

		// ¾²·¹µå¶óº§1
		JLabel lbTime1 = new JLabel("");
		lbTime1.setForeground(Color.RED);
		lbTime1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime1.setBounds(112, 239, 187, 49);
		jp.add(lbTime1);
		CallThread(lbTime1, roomInfoList.get(0).getRemTime(), roomInfoList, 0, btnRoom1);

		JButton btnRoom2 = new JButton("2\uBC88\uBC29");
		btnRoom2.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom2.setBorderPainted(false);
		btnRoom2.setBounds(311, 290, 198, 150);

		// ¾²·¹µå¶óº§2
		JLabel lbTime2 = new JLabel("");
		lbTime2.setForeground(Color.RED);
		lbTime2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime2.setBounds(342, 239, 211, 49);
		jp.add(lbTime2);
		CallThread(lbTime2, roomInfoList.get(1).getRemTime(), roomInfoList, 1, btnRoom2);

		JButton btnRoom3 = new JButton("3\uBC88\uBC29");
		btnRoom3.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom3.setBorderPainted(false);
		btnRoom3.setBounds(535, 290, 198, 150);

		// ¾²·¹µå¶óº§3
		JLabel lbTime3 = new JLabel("");
		lbTime3.setForeground(Color.RED);
		lbTime3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime3.setBounds(567, 239, 194, 49);
		jp.add(lbTime3);
		CallThread(lbTime3, roomInfoList.get(2).getRemTime(), roomInfoList, 2, btnRoom3);

		JButton btnRoom4 = new JButton("4\uBC88\uBC29");
		btnRoom4.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom4.setBorderPainted(false);
		btnRoom4.setBounds(761, 290, 198, 150);
		// ¾²·¹µå¶óº§
		JLabel lbTime4 = new JLabel("");
		lbTime4.setForeground(Color.RED);
		lbTime4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime4.setBounds(785, 239, 186, 49);
		jp.add(lbTime4);
		CallThread(lbTime4, roomInfoList.get(3).getRemTime(), roomInfoList, 3, btnRoom4);

		JButton btnRoom5 = new JButton("5\uBC88\uBC29");
		btnRoom5.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom5.setBounds(77, 535, 198, 150);
		btnRoom5.setBorderPainted(false);
		// ¾²·¹µå¶óº§
		JLabel lbTime5 = new JLabel("");
		lbTime5.setForeground(Color.RED);
		lbTime5.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime5.setBounds(112, 493, 187, 49);
		jp.add(lbTime5);
		CallThread(lbTime5, roomInfoList.get(4).getRemTime(), roomInfoList, 4, btnRoom5);

		JButton btnRoom6 = new JButton("6\uBC88\uBC29");
		btnRoom6.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom6.setBounds(311, 535, 198, 150);
		btnRoom6.setBorderPainted(false);
		// ¾²·¹µå¶óº§
		JLabel lbTime6 = new JLabel("");
		lbTime6.setForeground(Color.RED);
		lbTime6.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime6.setBounds(342, 493, 211, 49);
		jp.add(lbTime6);
		CallThread(lbTime6, roomInfoList.get(5).getRemTime(), roomInfoList, 5, btnRoom6);

		JButton btnRoom7 = new JButton("7\uBC88\uBC29");
		btnRoom7.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom7.setBorderPainted(false);
		btnRoom7.setBounds(535, 535, 198, 150);
		// ¾²·¹µå¶óº§
		JLabel lbTime7 = new JLabel("");
		lbTime7.setForeground(Color.RED);
		lbTime7.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime7.setBounds(567, 493, 194, 49);
		jp.add(lbTime7);
		CallThread(lbTime7, roomInfoList.get(6).getRemTime(), roomInfoList, 6, btnRoom7);

		JButton btnRoom8 = new JButton("8\uBC88\uBC29");
		btnRoom8.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder1.jpg")));
		btnRoom8.setBorderPainted(false);
		btnRoom8.setBounds(761, 535, 198, 150);
		// ¾²·¹µå¶óº§
		JLabel lbTime8 = new JLabel("");
		lbTime8.setForeground(Color.RED);
		lbTime8.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		lbTime8.setBounds(785, 493, 186, 49);
		jp.add(lbTime8);
		CallThread(lbTime8, roomInfoList.get(7).getRemTime(), roomInfoList, 7, btnRoom8);

		// Åõ¸í??
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

		btnAdmin.setBounds(889, 12, 105, 27);
		jp.add(btnAdmin); // °ü¸®ÀÚ¹öÆ°

		btnRoom1.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 1, sc, mainJframe, jp));
		btnRoom2.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 2, sc, mainJframe, jp));
		btnRoom3.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 3, sc, mainJframe, jp));
		btnRoom4.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 4, sc, mainJframe, jp));
		btnRoom5.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 5, sc, mainJframe, jp));
		btnRoom6.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 6, sc, mainJframe, jp));
		btnRoom7.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 7, sc, mainJframe, jp));
		btnRoom8.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 8, sc, mainJframe, jp));
		btnAdmin.addMouseListener(new SpaceActionEvent(MAIN_ROOM_VIEW_NUM, 9, sc, mainJframe, jp));

		mainJframe.getContentPane().add(jp);
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn1.setBorderPainted(false);
		btn1.setBounds(77, 290, 198, 150);
		jp.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn2.setBorderPainted(false);
		btn2.setBounds(311, 290, 198, 150);
		jp.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn3.setBorderPainted(false);
		btn3.setBounds(535, 290, 198, 150);
		jp.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn4.setBorderPainted(false);
		btn4.setBounds(761, 290, 198, 150);
		jp.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn5.setBorderPainted(false);
		btn5.setBounds(77, 535, 198, 150);
		jp.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn6.setBorderPainted(false);
		btn6.setBounds(311, 535, 198, 150);
		jp.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn7.setBorderPainted(false);
		btn7.setBounds(535, 535, 198, 150);
		jp.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/folder2.png")));
		btn8.setBorderPainted(false);
		btn8.setBounds(761, 535, 198, 150);
		jp.add(btn8);
		
		JLabel lblRoom2 = new JLabel("USC ROOM");
		lblRoom2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom2.setBounds(350, 200, 129, 49);
		jp.add(lblRoom2);
		
		JLabel lblRoom1 = new JLabel("HARVARD ROOM");
		lblRoom1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom1.setBounds(94, 200, 181, 49);
		jp.add(lblRoom1);
		
		JLabel lblBackground = new JLabel("");
		
		URL path = MainRoomView.class.getResource("Main.jpg");
		
		JLabel lblRoom3 = new JLabel("CORNELL ROOM");
		lblRoom3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom3.setBounds(555, 200, 181, 49);
		jp.add(lblRoom3);
		
		JLabel lblRoom4 = new JLabel("BROWN ROOM");
		lblRoom4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom4.setBounds(785, 200, 168, 49);
		jp.add(lblRoom4);
		
		JLabel lblRoom5 = new JLabel("YALE ROOM");
		lblRoom5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom5.setBounds(120, 452, 129, 49);
		jp.add(lblRoom5);
		
		JLabel lblRoom6 = new JLabel("PRINCETON ROOM");
		lblRoom6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom6.setBounds(321, 452, 208, 49);
		jp.add(lblRoom6);
		
		JLabel lblRoom7 = new JLabel("COLUMBIA ROOM");
		lblRoom7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom7.setBounds(545, 452, 181, 49);
		jp.add(lblRoom7);
		
		JLabel lblRoom8 = new JLabel("STANFORD ROOM");
		lblRoom8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblRoom8.setBounds(771, 452, 190, 49);
		jp.add(lblRoom8);
		
		JLabel lblSpace = new JLabel("Space Distorition");
		lblSpace.setFont(new Font("Yu Gothic UI", Font.BOLD, 50));
		lblSpace.setBounds(104, 12, 405, 127);
		jp.add(lblSpace);
		lblBackground.setIcon(new ImageIcon(MainRoomView.class.getResource("/com/space_distortion/view/Main.jpg")));
		
		lblBackground.setBounds(0, 0, 1008, 728);
		jp.add(lblBackground);
		jp.revalidate();
		jp.repaint();

		// jp.setVisible(true);
		// mainJframe.setVisible(true);
	}

/////¾²·¹µå////////   
	public void CallThread(JLabel lbl, int remTime, List<RoomInfo> list, int index, JButton btn) {
		TimerThread tt = new TimerThread(lbl, remTime, list, index, btn);

		tt.start();
	}
}