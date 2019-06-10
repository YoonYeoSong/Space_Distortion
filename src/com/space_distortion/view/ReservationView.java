package com.space_distortion.view;

import com.space_distortion.controller.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.space_distortion.controller.SpaceController;

public class ReservationView implements ItemListener
{
	SpaceController sc;
	private JPanel p1, p2, p3;
	private JComboBox month;
	private JComboBox year;
	private int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    private JLabel st;
    
    private JLabel h;
    
    private JLabel m;
    
    private JLabel mut;
    
    private JLabel mh;
    
    private Choice ch;
    
    private Choice ch1;
    
    private Choice ch2;
    
//    private JComboBox hr;
//    
//    private JComboBox mn;
//    
//    private JComboBox ut;

    
	public ReservationView ()
    { 
		
		
    	
 

//    	JPanel bg = new JPanel();
//    	bg.setBounds(0,0,1024,768);
//    	
//        p1 = new JPanel();
//        p1.setBackground(Color.gray);
//        //p1.setSize(350, 30);
//        //p1.setLayout(new FlowLayout());
//        month = new JComboBox();
//        for(int i=0;i< months.length;i++)
//        {
//            month.addItem(months[i]);
//        }
//        month.addItemListener(this);
//        p1.add(month);
//        
//        year = new JComboBox();
//        for(int i=1980;i<=2099;i++)
//        {
//            year.addItem(i);
//        }
//        year.addItemListener(this);
//        
//        p1.add(year);
//        
//        p2 = new JPanel();
//        p2.setLayout(new GridLayout(0,7,5,5));
//        p2.setBackground(Color.red);
//        Date date = new Date();
//        drawCalendar(months[date.getMonth()], (1900+date.getYear()));
//        year.setSelectedItem((1900+date.getYear()));
//        month.setSelectedItem(months[date.getMonth()]);
//        
////        Container c=getContentPane();
////        c.setLayout(new FlowLayout());
//        bg.add(p1);
//        bg.add(p2);
        
//        setSize(500,500);
//        setResizable(false);
       

    }
//    public static void main(String args[])
//    {
//    	ReservationView f = new ReservationView();
//
////        CalenderDemo frame = new CalenderDemo();
////        add(bg);
//        
//        
//    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            drawCalendar((String)month.getSelectedItem(), (Integer)year.getSelectedItem());
        }
    }
    
    public void drawCalendar(String inputMonth, int inputYear)
    {
        p2.removeAll();
        for(int i=0;i< weekdays.length;i++)
        {
            JLabel label = new JLabel(weekdays[i]);
            label.setOpaque(true); 
            label.setBackground(Color.orange);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            p2.add(label);
        }
        Date date = new Date("01-"+inputMonth+"-"+inputYear);
        int noOfDaysInMonth = days[date.getMonth()];
        if(date.getYear()%4==0 && date.getMonth()==1)
        {
            noOfDaysInMonth = 29;
        }

        for(int i=1, day=1;day<=noOfDaysInMonth;i++)
        {
            for(int j=0;j<7;j++)
            { 
                if(day==1)
                {
                    if(j==date.getDay())
                    {
                    	JButton daybuts = new JButton(String.valueOf(day));
                    	daybuts.setHorizontalAlignment(SwingConstants.CENTER);
                        p2.add(daybuts);
                        day++;
                        
//                        daybuts.addActionListener(new ActionListener() {});
                        
                    }
                    else
                    {
                    	JButton daybuts = new JButton("");
                        p2.add(daybuts);
                    }
                }
                else
                {
                	JButton daybuts = new JButton(String.valueOf(day));
                	daybuts.setHorizontalAlignment(SwingConstants.CENTER);
                    p2.add(daybuts);
                    day++;
                }
                if(day>noOfDaysInMonth)
                {
                    break;
                }
            }
        }
        p2.validate();
//        setTitle(inputMonth+", "+inputYear);
        
        
        
    }

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(SpaceController spaceController, JFrame mainJframe) {
		// TODO Auto-generated method stub
		
		JPanel bg = new JPanel();
    	bg.setBounds(0,0,1024,768);
    	bg.setLayout(null);

    	
        p1 = new JPanel();
        p1.setBounds(0,0,1024,100);
        p1.setBackground(Color.WHITE);
        //p1.setSize(350, 30);
        //p1.setLayout(new FlowLayout());
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.addItemListener(this);
        p1.add(month);
        
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
            year.addItem(i);
        }
        year.addItemListener(this);
        
        p1.add(year);
        
        p2 = new JPanel();
        p2.setBounds(0,100,1024,500);
        p2.setLayout(new GridLayout(0,7,5,5));
        p2.setBackground(Color.WHITE);
        Date date = new Date();
        drawCalendar(months[date.getMonth()], (1900+date.getYear()));
        year.setSelectedItem((1900+date.getYear()));
        month.setSelectedItem(months[date.getMonth()]);
        p3 = new JPanel();
        p3.setBounds(0,600,1024,168);
        p3.setBackground(Color.WHITE);
        p3.setLayout(null);
		
		
		
		JButton btnbutton = new JButton("Back");
		btnbutton.setBounds(898, 70, 100, 20);
		p3.add(btnbutton);
		btnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spaceController.mainView();
				mainJframe.remove(bg);
			}
		});
		
//		ccl.setVisible(true);
//		add(ccl);
		
		st=new JLabel("시작 시간");
		st.setBounds(270,10,100,20);
		p3.add(st);
		
		h=new JLabel("시");
		h.setBounds(200,30,100,20);
		p3.add(h);
		
		m=new JLabel("분");
		m.setBounds(400,30,100,20);
		p3.add(m);
		
		mut=new JLabel("총 사용 시간");
		mut.setBounds(600,10,100,20);
		p3.add(mut);
		
		mh=new JLabel("시간");
		mh.setBounds(700,70,100,20);
		p3.add(mh);
		
		    ch = new Choice();
	        // 콤보 박스 아이템 생성
	        ch.addItem("8");
	        ch.addItem("9");
	        ch.addItem("10");
	        ch.addItem("11");
	        ch.addItem("12");
	        ch.addItem("13");
	        ch.addItem("14");
	        ch.addItem("15");
	        ch.addItem("16");
	        ch.addItem("17");
	        ch.addItem("18");
	        ch.addItem("19");
	        ch.addItem("20");
	        // 추가
	        p3.add(ch);
	        ch.setBounds(150,70,100,20);
	        ch.setVisible(true);
	        
	        ch1 = new Choice();
	        // 콤보 박스 아이템 생성
	        ch1.addItem("10");
	        ch1.addItem("20");
	        ch1.addItem("30");
	        ch1.addItem("40");
	        ch1.addItem("50");
	        // 추가
	        p3.add(ch1);
	        ch1.setBounds(350,70,100,20);
	        ch1.setVisible(true);
	        
	        ch2 = new Choice();
	        // 콤보 박스 아이템 생성
	        ch2.addItem("1");
	        ch2.addItem("2");
	        ch2.addItem("3");
	        ch2.addItem("4");
	        ch2.addItem("5");
	        // 추가
	        p3.add(ch2);
	        ch2.setBounds(590,70,100,20);
	        ch2.setVisible(true);
	        
	        
	        
	    
	

//		String[] hour = { "8","9","10","11","12","13","14","15","16","17","18","19","20" };
//		hr=new JComboBox();
//		hr.setBounds(150,70,100,20);
//		p3.add(hr);
//        hr.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				System.out.println(e.getItem());
//				System.out.println(e.getStateChange());
//				System.out.println(e.getSource());
//				
//			}
//		});
//		add(hr);
////		bottom.add(hr);
//		JList<String> list=new JList<String>(hour);
//		list.setBounds(150,70,100,20);
//		list.setVisible(true);
//		list.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				System.out.println(e.getFirstIndex());
//				System.out.println(e.getLastIndex());
//				System.out.println(e.getSource());
//			}
//		});
////		add(list);
//		p3.add(list);
////		bottom.add(hr);
//		
//		
//		String[] minute = { "0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59" };
//		mn=new JComboBox();
//		mn.setBounds(350,70,100,20);
//		p3.add(mn);
//        mn.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				System.out.println(e.getItem());
//				System.out.println(e.getStateChange());
//				System.out.println(e.getSource());
//				
//			}
//		});
//		add(mn);
////		bottom.add(mn);
//		JList<String> list1=new JList<String>(minute);
//		list1.setBounds(350,70,100,20);
//		list1.setVisible(true);
//		list1.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				System.out.println(e.getFirstIndex());
//				System.out.println(e.getLastIndex());
//				System.out.println(e.getSource());
//			}
//		});
////		add(list1);
//		p3.add(list1);
////		bottom.add(mn);
//		
//		String[] maxtime = { "1","2","3","4","5" };
//		ut=new JComboBox();
//		ut.setBounds(590,70,100,20);
//		p3.add(ut);
//        ut.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				System.out.println(e.getItem());
//				System.out.println(e.getStateChange());
//				System.out.println(e.getSource());
//				
//			}
//		});
//		add(ut);
////		bottom.add(ut);
//		JList<String> list2=new JList<String>(maxtime);
//		list2.setBounds(590,70,100,20);
//		list2.setVisible(true);
//		list2.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				System.out.println(e.getFirstIndex());
//				System.out.println(e.getLastIndex());
//				System.out.println(e.getSource());
//			}
//		});
////		add(list2);
//		p3.add(list2);
////		bottom.add(ut);

        
        
//        Container c=getContentPane();
//        c.setLayout(new FlowLayout());
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
		mainJframe.setBounds(0,0,1024,768);
		mainJframe.getContentPane().setLayout(new GridLayout());
		mainJframe.getContentPane().add(bg);
//      jfrm.setDefaultCloseOperation(3);
		mainJframe.setVisible(true);
		
		
		
	}

		
	

	private void add(JComboBox hr2) {
		// TODO Auto-generated method stub
		
	}
}
        
        
        



