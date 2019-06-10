package com.space_distortion.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.SnackBar;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.border.LineBorder;

public class AdminSnackView implements ViewIndex {
	
	private JTextField qty;
	private JTextField price;
	private JTextField kind;
	private JTextField snackName;
//	private JPanel mainJp;
	private ImageIcon bgImage;
	private JLabel lblNewLabel_7;
	private JPanel mainJp;
	private JButton adminSnackNext;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController smc, JFrame mainJframe, List<SnackBar> list)
	{	
//		bgImage = new ImageIcon("C:\\workspace\\Space_Distortion\\src\\right_bg.png");
		bgImage = new ImageIcon(this.getClass().getResource("admin_snack_bg.png"));
		mainJframe.setBounds(25, 25, 359, 538);
		
		System.out.println(list);
		String[] nameStr = smc.snackTitle();
//		Arrays.sort(nameStr);
		
		
		mainJp = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgImage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		mainJp.setBounds(0, 0, 1024, 768);
		
		mainJp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC00 \uACA9");
		lblNewLabel.setBounds(48, 206, 61, 16);
		mainJp.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD488 \uBA85");
		lblNewLabel_1.setBounds(48, 127, 61, 16);
		mainJp.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218 \uB7C9");
		lblNewLabel_2.setBounds(48, 168, 61, 16);
		mainJp.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC885 \uB958");
		lblNewLabel_3.setBounds(48, 253, 61, 16);
		mainJp.add(lblNewLabel_3);
		
		qty = new JTextField();
		qty.setBounds(121, 164, 166, 26);
		qty.setColumns(10);
		
		// 
		qty.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar() >= 48 && e.getKeyChar() <= 57)
					System.out.println("dd");
				else
					qty.setText(null);
			}
		});
		mainJp.add(qty);

		
		
		price = new JTextField();
		price.setBounds(121, 202, 166, 26);
		mainJp.add(price);
		price.setColumns(10);

		
		price.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57))
					price.setText(null);
//				else
//					System.out.println("dd");
			}
		});
		
		
		kind = new JTextField();
		kind.setEditable(false);
		kind.setBounds(121, 243, 166, 26);
		mainJp.add(kind);
		kind.setColumns(10);
		
		kind.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar() > 32 && e.getKeyChar() < 65)
					kind.setText(null);
				else if(e.getKeyChar() > 90 && e.getKeyChar() < 97)
					kind.setText(null);
				else if(e.getKeyChar() > 122 && e.getKeyChar() < 127)
					kind.setText(null);
			
			}
		});
		
		
		snackName = new JTextField();
		snackName.setBounds(121, 123, 166, 26);
		mainJp.add(snackName);
		snackName.setColumns(10);
		
		snackName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
	
				if(e.getKeyChar() > 32 && e.getKeyChar() < 48)
					snackName.setText(null);
				else if(e.getKeyChar() > 57 && e.getKeyChar() < 65)
					snackName.setText(null);
				else if(e.getKeyChar() > 90 && e.getKeyChar() < 97)
					snackName.setText(null);
				else if(e.getKeyChar() > 122 && e.getKeyChar() < 127)
					snackName.setText(null);

			}
		});
		
		
		
		adminSnackNext = new JButton("\uB4F1   \uB85D");
		adminSnackNext.setBounds(195, 361, 92, 37);
		mainJp.add(adminSnackNext);
		
		JList listSnack = new JList(nameStr);
//		listSnack.setSelectionModel(new DisabledItemSelectionModel());
		
		listSnack.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSnack.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JList listCombo = new JList();
				listCombo = (JList)e.getSource();
				kind.setText("" +listCombo.getSelectedValue());
				
			}
		});
//		listSnack.setBounds(35, 288, 106, 76);
//		mainJp.add(listSnack);
		
//		JScrollBar scrollBar = new JScrollBar(listSnack);
//		scrollBar.setBounds(126, 288, 15, 76);
//		mainJp.add(scrollBar);
		
		
		listSnack.setVisibleRowCount(5);
		JScrollPane jsr = new JScrollPane(listSnack);
		jsr.setBounds(48, 361, 136, 86);
		mainJp.add(jsr);
		
		JTextArea txtA = new JTextArea();
		txtA.setBounds(48, 291, 239, 60);
		mainJp.add(txtA);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setBorder(new LineBorder(Color.GRAY));
		lblNewLabel_4.setBounds(47, 106, 239, 2);
		mainJp.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
//		lblNewLabel_5.setBackground(Color.RED);
		lblNewLabel_5.setBorder(new LineBorder(Color.GRAY));
		lblNewLabel_5.setBounds(48, 279, 239, 2);
		mainJp.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
//		lblNewLabel_6.setBackground(Color.red);
		URL searchpath = this.getClass().getResource("empty1.png");
		lblNewLabel_6.setIcon(new ImageIcon(searchpath));
		lblNewLabel_6.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblNewLabel_6.setBounds(231, 48, 45, 45);
		mainJp.add(lblNewLabel_6);
		
		JLabel label = new JLabel("상품 추가");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		label.setBounds(48, 77, 61, 16);
		mainJp.add(label);
		
		lblNewLabel_7 = new JLabel("\uB2EB  \uAE30");
		lblNewLabel_7.setBounds(418, 137, 265, 400);
		mainJp.add(lblNewLabel_7);
		
//		adminSnackNext.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_SNACK, 1, smc, mainJframe, mainJp));
		
		//qty,  price,  kind, snackName, txtA
		adminSnackNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int snackQty = 0, snackPrice = 0, tempIndext = 0;
				int len = smc.snackTitle().length;
				
				if(!qty.getText().isEmpty())
					snackQty =  Integer.parseInt(qty.getText());
				if(!price.getText().isEmpty())
					snackPrice = Integer.parseInt(price.getText());
				
				String str[] = new String[len];
				str = smc.snackTitle();
				
				// 새로운 아이템 체크
				for(int i = 0; i < len; i++) {
//					if(  kind.getText().equals( str[i].toString() )) {
					if(  kind.getText().equals( str[i].toString() )) {
						tempIndext = i+1;
						break;
					}else {
						tempIndext = i+1;
						//
					}
				}// for
				
				int msgOk = 0;
				String s1 = qty.getText();
				String s2 = price.getText();

				
				if(snackName.getText().isEmpty() || kind.getText().isEmpty() || s1.isEmpty()
						|| s2.isEmpty()) {

					msgOk = 1;
					
				}else {
					int a1 = Integer.parseInt(s1);
					int a2 = Integer.parseInt(s2);
					if( a1 < 1 || a2 < 1 ) {
						msgOk = 1;
					}
					else
						msgOk = JOptionPane.showConfirmDialog(null, "추가하시겠습니까?", "ok", JOptionPane.YES_NO_OPTION);
				}
				
				
				
				// 확인 했을경우 데이터를 저장
				if (msgOk == 0) {
//					System.out.println(list);
					list.add(new SnackBar( tempIndext, snackName.getText(), snackQty , snackPrice , kind.getText(), txtA.getText() ));
					snackName.setText("");
					kind.setText("");
					qty.setText("");
					price.setText("");
					txtA.setText("");
					

//					adminSnackNext.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_SNACK, 1, smc, mainJframe, mainJp));
					System.out.println("마지막2");
					System.out.println(list);
				}
				else
					JOptionPane.showConfirmDialog(null, "잘 못 되었습니다", "OK", JOptionPane.CLOSED_OPTION);

				
			}
			
		});		
		mainJframe.getContentPane().add(mainJp);
		
		JButton closeBtn = new JButton("\uB2EB  \uAE30");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		closeBtn.setBounds(195, 408, 92, 39);
		closeBtn.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_SNACK, 2, smc, mainJframe, mainJp));
		mainJp.add(closeBtn);

		mainJp.revalidate();
		mainJp.repaint();
		
		
	}//initialize
}
