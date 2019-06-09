package com.space_distortion.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.event.SpaceActionEvent;

public class NaccountView extends SpaceActionEvent implements ActionListener , ViewIndex{
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController sc, JFrame mainJframe)
	{
		
//		JLabel nameLabel = new JLabel("이름");
//		nameLabel.setBounds(194, 272, 57, 64);
//		nameLabel.setLayout(null);
//		
//		JLabel phoneNumberLabel = new JLabel("핸드폰");
//		phoneNumberLabel.setBounds(171, 414, 80, 64);
//		phoneNumberLabel.setLayout(null);
		
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		
		JTextField nameText = new JTextField();
		nameText.setBounds(90, 440, 300, 36);
		jp.add(nameText);
		
		JTextField phoneNumberText = new JTextField();
		phoneNumberText.setBounds(90, 540, 300, 36);
		jp.add(phoneNumberText);
		
		
//		JButton nextBtn = new JButton("Next");
//		nextBtn.setBounds(326, 618, 200, 64);
//		nextBtn.setLayout(null);
		JButton nextBtn = new JButton("");
		nextBtn.setIcon(new ImageIcon(AccountView.class.getResource("/com/space_distortion/view/next1.png")));
		nextBtn.setBorderPainted(false);
		nextBtn.setBounds(170, 590, 140, 55);
		jp.add(nextBtn);
		

		nextBtn.addMouseListener(new SpaceActionEvent(NACCOUNT_VIEW, 1, sc, mainJframe, jp));
		
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameText.getText();
				String phone=phoneNumberText.getText();
				String a="";
				
				if(name.equals(a)) {
					JOptionPane.showMessageDialog(null, "Name을 입력해주세요.");
				} else if(phone.equals(a)) {
					JOptionPane.showMessageDialog(null, "Phone Number를 입력해주세요.");
				} else {
					sc.initNonMember(name,phone);
				}
			}
		});
		
		JLabel accBackground = new JLabel("");
		URL path = LoginView.class.getResource("nonmember.png");
		accBackground.setIcon(new ImageIcon(LoginView.class.getResource("/com/space_distortion/view/nonmember.png")));
		accBackground.setBounds(0, 0, 1008, 728);
		jp.add(accBackground);
		
		
//		jp.add(phoneNumberLabel);
//		jp.add(nameLabel);


		
		mainJframe.add(jp);
		
		jp.revalidate();
		jp.repaint();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}