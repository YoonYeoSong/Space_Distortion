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

public class AdminSnackView extends SpaceActionEvent implements ViewIndex {
	
	private JTextField qty;
	private JTextField price;
	private JTextField kind;
	private JTextField snackName;
//	private JPanel mainJp;
	private ImageIcon bgImage;
	
	public AdminSnackView() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController smc, JFrame mainJframe, List<SnackBar> list)
	{	
//		bgImage = new ImageIcon("C:\\workspace\\Space_Distortion\\src\\right_bg.png");
		
		//mainJframe.setBounds(0, 0, 265, 400);
		
		System.out.println(list);
		String[] nameStr = smc.snackTitle();
		
		JPanel mainJp = new JPanel();
		
		mainJp.setBounds(0, 0, 1024, 768);
		mainJp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC00 \uACA9");
		lblNewLabel.setBounds(35, 137, 61, 16);
		mainJp.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD488 \uBA85");
		lblNewLabel_1.setBounds(35, 66, 61, 16);
		mainJp.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218 \uB7C9");
		lblNewLabel_2.setBounds(35, 104, 61, 16);
		mainJp.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC885 \uB958");
		lblNewLabel_3.setBounds(35, 175, 61, 16);
		mainJp.add(lblNewLabel_3);
		
		qty = new JTextField();
		qty.setBounds(108, 99, 130, 26);
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
		price.setBounds(108, 132, 130, 26);
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
		kind.setBounds(108, 170, 130, 26);
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
		snackName.setBounds(108, 61, 130, 26);
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
		
		
		
		JButton adminSnackNext = new JButton("\uB4F1   \uB85D");
		adminSnackNext.setBounds(153, 288, 85, 76);
		mainJp.add(adminSnackNext);
		
		JList listSnack = new JList(nameStr);
//		listSnack.setSelectionModel(new DisabledItemSelectionModel());
		
		listSnack.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSnack.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {		}
			@Override
			public void mousePressed(MouseEvent e) {		}
			@Override
			public void mouseExited(MouseEvent e) {			}
			@Override
			public void mouseEntered(MouseEvent e) {	}
			
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
		jsr.setBounds(35, 290, 105, 73);
		mainJp.add(jsr);
		
		
		
		
		JTextArea txtA = new JTextArea();
		txtA.setBounds(35, 217, 204, 60);
		mainJp.add(txtA);
		
		mainJframe.getContentPane().add(mainJp);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBackground(Color.RED);
		lblNewLabel_4.setBorder(BorderFactory.createLineBorder(Color.red));
		lblNewLabel_4.setBounds(35, 48, 204, 2);
		mainJp.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
//		lblNewLabel_5.setBackground(Color.RED);
		lblNewLabel_5.setBorder(BorderFactory.createLineBorder(Color.red));
		lblNewLabel_5.setBounds(35, 203, 204, 2);
		mainJp.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
//		lblNewLabel_6.setBackground(Color.red);
		lblNewLabel_6.setBorder(BorderFactory.createLineBorder(Color.red));
		lblNewLabel_6.setBounds(203, 13, 30, 30);
		mainJp.add(lblNewLabel_6);
		
		JLabel label = new JLabel("상품 추가");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		label.setBounds(36, 30, 61, 16);
		mainJp.add(label);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(0, 0, 265, 400);
		mainJp.add(lblNewLabel_7);
		adminSnackNext.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_SNACK, 1, smc, mainJframe, mainJp));
		
		mainJframe.revalidate();
		mainJframe.repaint();
		
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
				
				for(int i = 0; i < len; i++) {
					if( str[i].equals(kind.getText()) ) {
						tempIndext = i;
						break;
					}else {
						tempIndext = i;
						//
					}
				}
				
				
				int msgOk = JOptionPane.showConfirmDialog(null, "추가하시겠습니까?", "ok", JOptionPane.YES_NO_OPTION);
				
				// 확인 했을경우 데이터를 저장
				if (msgOk == 0) {
					System.out.println(list);
					list.add(new SnackBar( tempIndext, snackName.getText(), snackQty , snackPrice , kind.getText(), txtA.getText() ));
					snackName.setText("");
					kind.setText("");
					qty.setText("");
					price.setText("");
					txtA.setText("");
					
					
					//adminSnackNext.addMouseListener(new SpaceActionEvent(ADMIN_VIEW_SNACK, 1, smc, mainJframe, mainJp));
					System.out.println("마지막");
					System.out.println(list);
				}
				else
					System.out.println("취소하셨습니다.");

				
			}
			
		});		

		
		
	}//initialize
}
