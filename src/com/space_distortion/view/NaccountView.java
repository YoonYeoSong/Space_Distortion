package com.space_distortion.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		JPanel jp = new JPanel();
		jp.setBounds(10, 10, 1024, 768);
		jp.setLayout(null);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(273, 273, 313, 64);
		
		JTextField phoneNumberText = new JTextField();
		phoneNumberText.setBounds(273, 414, 313, 64);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(326, 618, 200, 64);
		nextBtn.setLayout(null);
		
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(194, 272, 57, 64);
		nameLabel.setLayout(null);
		
		JLabel phoneNumberLabel = new JLabel("핸드폰");
		phoneNumberLabel.setBounds(171, 414, 80, 64);
		phoneNumberLabel.setLayout(null);
		
		nextBtn.addMouseListener(new SpaceActionEvent(NACCOUNT_VIEW, 1, sc, mainJframe, jp));
		
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.initNonMember(nameText.getText(),phoneNumberText.getText());
			}
		});
		

		jp.add(phoneNumberLabel);
		jp.add(nameLabel);
		jp.add(nextBtn);
		jp.add(nameText);
		jp.add(phoneNumberText);
		
		mainJframe.add(jp);
		
		jp.revalidate();
		jp.repaint();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


