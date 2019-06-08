package com.space_distortion.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Admin;
import com.space_distortion.model.vo.Coupon;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.NonMember;
import com.space_distortion.model.vo.Payment;
import com.space_distortion.model.vo.RoomInfo;
import com.space_distortion.model.vo.SnackBar;
import com.space_distortion.view.AccountView;
import com.space_distortion.view.AccountView2;
import com.space_distortion.view.AddTimeRoomView;
import com.space_distortion.view.AdminView;
import com.space_distortion.view.FinalPaymentView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;
import com.space_distortion.view.NaccountView;
import com.space_distortion.view.PaymentView;
import com.space_distortion.view.SnackBarView;
import com.space_distortion.view.SubRoomView;
import com.space_distortion.view.ViewIndex;

// ��ɱ��� Ŭ����
public class SpaceController implements ViewIndex{
	
	//��� �����ڿ� �� ���̴� ����
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	static int couponCount = 0;
	
	/////////////////////////////// Model.vo ��ü ����Ʈ///////////
	private List<Member> mList = new ArrayList<Member>();
	private List<NonMember> nList = new ArrayList<NonMember>();
	private List<Coupon> couponList = new ArrayList<Coupon>();
	private Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // ȸ�� ��
	private Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // ��ȸ�� ��
	private List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // �뿡 ���� ����Ʈ
	private List<Payment> paymentList = new ArrayList<Payment>();  // ���̸�Ʈ ���� ����Ʈ
	private List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // �������ø���Ʈ
	private List<SnackBar> snackTmpList = new ArrayList<SnackBar>(); // ����/ ������ �ӽ� ����Ʈ
	private List<SnackBar> snackPaylList = new ArrayList<SnackBar>(); // ���翡 �Ѱ��� ��ǳ ����Ʈ
	
	private Admin admin = new Admin();
	
	///////////////////////Model.vo ��/////////////////////////////////////////
	
	private static MainRoomView mv = new MainRoomView(); // ���� ��
	private SpaceActionEvent sAe = new SpaceActionEvent();
	private MainRoomView mRv = new MainRoomView();                  //���� �� ����
	private SubRoomView subRoomV = new SubRoomView();       // �����
	private LoginView lv = new LoginView();                  //�α��κ�
	private AccountView accountV = new AccountView();		//ȸ�� ���� �� ����
	private AccountView2 subAccountV = new AccountView2();	//ȸ�� ���� �� ����
	private NaccountView nAccountV = new NaccountView();    // ��ȸ�� ��
	private AddTimeRoomView addTimeV = new AddTimeRoomView();	//�߰��ð� �� ����
	private AdminView adminV1 = new AdminView();				//������ �� ����
	private PaymentView payV = new PaymentView();			//���� �� ����
	private SnackBarView snackV = new SnackBarView();		//���� �� ����
	private FinalPaymentView finalpv = new FinalPaymentView(); // ������ �� â
	private JFrame mainJframe;			//���� ������ ����
	
	/* ���� ��Ʈ�ѷ� ������ */
	public SpaceController() {
		this.init();
			
		
		this.initConsol();  // ������ �׽�Ʈ ������
		this.snackViewDidload();
	}
	
	
	
	// ���� ������ ����
	public void init()
	{
		
		// ������ �ҷ�����
		// ���̸� ���ȣ �����ο� ��������Ʈ ��뿩��
		// ���̸� ���ȣ �����ο� ��������Ʈ ��뿩��
//        roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(0).setRemTime(2);
//        roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(1).setRemTime(5400);
//        roomInfoList.add (new RoomInfo("USC", 2, 8, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(2).setRemTime(7200);
//        roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(3).setRemTime(8200);
//        roomInfoList.add (new RoomInfo("BROWN",4, 8, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(4).setRemTime(9200);
//        roomInfoList.add(new RoomInfo("YALE", 5, 8, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(5).setRemTime(10200);
//        roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(6).setRemTime(11200);
//        roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(7).setRemTime(12200);
//        roomInfoList.add(new RoomInfo("STANFORD", 8, 12, "�� ��������Ʈ��밡�� ��"));
//        roomInfoList.get(8).setRemTime(13200);
//		
//        
//        
//      snackBarList.add(new SnackBar(1, "ġ�佺", 30, 1400, "��������"));
//		snackBarList.add(new SnackBar(1, "��īĨ", 20, 1500, "��������"));
//		snackBarList.add(new SnackBar(2, "��ī��", 15, 600, "��������"));
//		snackBarList.add(new SnackBar(2, "�ݶ�", 10, 700, "��������"));
//		snackBarList.add(new SnackBar(2, "����ƾ��", 33, 1000, "��������"));
//		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 4000, "��������"));
//		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 1111, "��������"));
//		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 2222, "��������"));
//		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 3333, "��������"));
//		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 4444, "��������"));
//		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 5555, "��������"));
//		snackBarList.add(new SnackBar(1, "�����", 11, 6000, "��������"));
//		snackBarList.add(new SnackBar(1, "ĭ��", 11, 1200, "��������"));
//		snackBarList.add(new SnackBar(1, "������", 11, 10000, "��������"));
        
		
		mainJframe = new JFrame("Space Distorition");
		mainJframe.setBounds(0, 0, 1024, 768);
		mainJframe.setLayout(null);
		mainJframe.setDefaultCloseOperation(3);
		
		mainJframe.setVisible(true);	
		
		mainJframe.addWindowListener(new SpaceActionEvent(ViewIndex.WINDOWEIXT,1,this,this.mainJframe));
	}
	
	
	public void dataInit() {
		snackPaylList.clear();
	}

	AdminView adminView;
		
		
	
/////////////////////////////////////(����)�α��� ��� ����///////////////////////////////////////////
	
	// ��ȸ��
	public void initNonMember(String name, String phone)
	{
		nList.add(new NonMember());
		nList.get(nList.size()-1).setnMemberName(name);
		nList.get(nList.size()-1).setPhoneNumber(phone);
		
		nMap.put(nKeyNumber++, nList.get(nList.size()-1));
	}
	
	
	// LoginView �α���Ȯ��
	public boolean logincheck(String inputid, String inputpw) 
	{	
		System.out.println(inputid);
		System.out.println(inputpw);
		
		boolean check = false;
		System.out.println("�� ������ : " + mMap.size()); //�ɹ� ������ Ȯ��
		
		
//		Set<Entry<Integer, Member>> set = mMap.entrySet();	
//		Iterator<Map.Entry<Integer,Member>> it = set.iterator();
//		
//		while(it.hasNext())
//		{
//			Entry<Integer, Member> obj = it.next();
//			
//			if( (obj.getValue().getEmailId().equals(inputid)) && (obj.getValue().getMemberPw().equals(inputpw)) )
//			{
//				check = true;
//			}
//		}
		
		for(int i=0;i<mMap.size();i++) {
			System.out.println(((Member)mMap.get(i)).getEmailId().equals(inputid));//���̵� ��ġ�ϴ���, ��ġ�ϸ�true���
			System.out.println(((Member)mMap.get(i)).getMemberPw().equals(inputpw));//�н����尡 ��ġ�ϴ���, ��ġ�ϸ� true���
			if(((Member)mMap.get(i)).getEmailId().equals(inputid) && ((Member)mMap.get(i)).getMemberPw().equals(inputpw)) {
					//System.out.println("�α��� Ȯ��");
				System.out.println("�α���"+  ((Member)mMap.get(i)).getEmailId().equals(inputid));//���̵� ��ġ�ϴ���, ��ġ�ϸ�true���
				System.out.println("�α���"+((Member)mMap.get(i)).getMemberPw().equals(inputpw));//�н����尡 ��ġ�ϴ���, ��ġ�ϸ� true���
				check = true;		
			}
			
		}
		return check;
	}
		
	
	//AcountView(ȸ������ 1�� â)
	public void initMember(String name, String phone)
	{
		mList.add(new Member());
	    mList.get(mList.size()-1).setMemberName(name);
		mList.get(mList.size()-1).setPhoneNumber(phone);
	}
	  
	//AcountView2(ȸ������ 2�� â)
	public void initMember2(String email, String pw)
	{
		mList.get(mList.size()-1).setEmailId(email);
		mList.get(mList.size()-1).setMemberPw(pw);
		//mList.get(mList.size()).setStudentIsTrue(isTrueStudent);
		mMap.put(mKeyNumber++,mList.get(mList.size()-1));
	}
	  
	//Email Check(�̸��� �ߺ� üũ)
	public boolean emailCheck(String email)
	{
		System.out.println("���� ������ : " + email);

		boolean check = false;
		Set<Entry<Integer, Member>> set;
		set = mMap.entrySet();
		
		Iterator<Entry<Integer, Member>> it = set.iterator();
			
		while(it.hasNext())
		{
			Entry<Integer, Member> obj = it.next();
			if(obj.getValue().getEmailId().equals(email))  // �ߺ��� ���̵� ����
			{
				check = true;
			}
		}
		return check;
		

	}
			
		
/////////////////////////////////(����)�α��α�� ��///////////////////////////////////////////
	
	
	
	
	
////////////////////////////////////// (���)���� ���� ��� ����//////////////////////////	
	
	
	/*
	 * 1 : ����
	 * 2 : ����
	 */
	
	// ���� �䰡 �ε�ɶ� ������ �ε�
	public void snackViewDidload() {
			
		// ���Ḹ ����Ʈ�� ����
		for (SnackBar snackBar : snackBarList) {
			if(snackBar.getSnackBarIndex() == 2) {
				snackTmpList.add(snackBar);
			}
		}//for
	} //snackViewDidload
		
	public void snackSel(int i) {
		
		// �ʱ�ȭ
		if(!snackTmpList.isEmpty())
			snackTmpList.clear();
		
		if(i == 2) {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 2) {
					snackTmpList.add(snackBar);
				}
			}//for
		}else {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 1) {
					snackTmpList.add(snackBar);
				}
			
			}//for
		}//else

	}// snackSel
	
	// ���ڹ�ư ���� �� ���� ���� ����
	public List<SnackBar> snackSelList(int btnIndex) {
//		System.out.println("���� ���μ���");
//		System.out.println("2 :" +snackBarList.get(btnIndex).getSnack());
//		System.out.println("1 :" +((SnackBar)snackBarList).getSnackComment());	//err

		boolean snackOverlapChk = false;
		
		if(snackPaylList.isEmpty()) {
			snackPaylList.add(snackTmpList.get(btnIndex));
//			snackPaylList.get(btnIndex).setSnackQuantity(1);
			return snackPaylList;
		}
		
		System.out.println(snackPaylList);
		
		for (int i = 0; i < snackPaylList.size(); i++) {
			if( snackTmpList.get(btnIndex).getSnack().equals(
					snackPaylList.get(i).getSnack()
					)){
				snackOverlapChk = true;
//				snackPaylList.get(i).setSnackQuantity(1);
			}
		}

		if(!snackOverlapChk)
//		{
//			System.out.println("��ǰ ���� �߰�");
//			
//			// ��ǰ ���� ���� ���� �ڵ� �ʿ�
//			//
//			//
//			//
//		}else
			{
			snackPaylList.add(snackTmpList.get(btnIndex));
//			snackPaylList.get(btnIndex).setSnackQuantity(1);
			}

		return snackPaylList;
	}//snackSelList
		
//			if( ((SnackBar)snackPaylList).getSnack().equals(
//					snackPaylList.get(btnIndex).getSnack()
//					)){
//				System.out.println("���� ��ǰ ����");
//				break;
//			}else {
//				System.out.println("�ٸ� ��ǰ ����");
//				snackPaylList.add(snackTmpList.get(btnIndex));
//				break;
//			}
		
		
		
//		snackPaylList.add(snackTmpList.get(btnIndex));
//		for (SnackBar s : snackPaylList) {
//			System.out.println(s);
//		}

	// ���õ� ���� ����Ʈ
	public List<SnackBar> snackSelList() {
		return snackPaylList;
	}//snackSel
	
	public void snackTableRe() {
		snackV.rightTableInit(this);
	}
		
//		List<SnackBar> tmpList = new ArrayList<SnackBar>(); // = snackTmpList;
		
//		System.out.println(tmpList);
//		System.out.println(snackBarList.get(0).getSnackBarIndex());
		
//		System.out.println(tmpList.get(btnIndex).getSnackBarIndex());
	
//		SnackBar snackTmp = new SnackBar();
		
//		tmpList.add(e)
		
//		int a = 0;
//		a += tmpList.get(btnIndex).getSnackPrice();

//		if ( tmpList.get(btnIndex).getSnackBarIndex() == 1) {
//			System.out.println("dfdfdfdfadfwerwer");
//		}
		
//		if(((SnackBar)snackBarList).getSnackBarIndex() == 1) {
//			tmpList = snackBarList;
//			
//		}
//		
//		if(((SnackBar)snackBarList).getSnackBarIndex() == 2) {
//			tmpList = snackBarList;
			
//		}//if
		
	
//	public List<SnackBar> snackPay(){
//		return this.snackPaylList;
//	}
	
	
	
	
	
//////////////////////////////////////(���)���� ��� ��/////////////////////
	
	
	
	
	
	
	
/////////////////////////////////////(����)Payment ��� ���� //////////////////////////////
	// ��� ������ ����ϰ� ����Ʈ��
	public void totalCostCalculator(List<Payment> list) {
			
		// ȭ��Ʈ���带 �����ٸ� ���ݿ� 3000�� ����. �ƴϸ� ����
		if((list.get(list.size()-1)).getWhiteBoardUsage() == 1) {
			(list.get(list.size()-1)).setWhiteBoardCost(3000);
		}else 
		{
			(list.get(list.size()-1)).setWhiteBoardCost(0);
		}
		
		// ��������Ʈ �����ٸ� ���ݿ� 3000�� ����. �ƴϸ� ����
		if((list.get(list.size()-1)).getBeamProjectorUsage() == 1) {
			(list.get(list.size()-1)).setBeamProjectorCost(3000);
		}else 
		{
			(list.get(list.size()-1)).setBeamProjectorCost(0);
		}
//			 �� �޼ҵ�� ��ī��Ʈ�� ������ �� ������ �˷��ִ� �޼ҵ�
		if ((list.get(list.size()-1)).getUser() == "member") {
			(list.get(list.size()-1)).setDiscountRate(0.7);
		}else {
			(list.get(list.size()-1)).setDiscountRate(1.0);
		}
		
		System.out.println("getHour before hourlyCalc:   "+(list.get(list.size()-1)).getHour());
		System.out.println("getHourlyCost before hourlyCalc: "+(list.get(list.size()-1)).getHourlyCost());
		System.out.println("getTotalHourlyCost before hourlyCalc: "+(list.get(list.size()-1)).getTotalHourlyCost());
		System.out.println("getPpl before hourlyCalc: "+(list.get(list.size()-1)).getPpl());
		
		hourlyCostCalculator(list);
		
		
		
		(list.get(list.size()-1)).setTotalCost((list.get(list.size()-1)).getTotalHourlyCost()+
				(list.get(list.size()-1)).getWhiteBoardCost()+(list.get(list.size()-1)).getBeamProjectorCost()+
				(list.get(list.size()-1)).getTotalLaptopCost());
		
		
		(list.get(list.size()-1)).setFinalCost((int) ((list.get(list.size()-1)).getTotalCost()*(list.get(list.size()-1)).getDiscountRate()));
		
		String finalCost = String.valueOf((list.get(list.size()-1)).getFinalCost());
		payV.getDisplayPriceAfterDiscount().setText(finalCost);
		String totalCost = String.valueOf((list.get(list.size()-1)).getTotalCost());
		payV.getDisplayTotalCost().setText(totalCost);
		
		paymentList.add(list.get(list.size()-1)); //
	}

		
	public void hourlyCostCalculator(List<Payment> list) {
		(list.get(list.size()-1)).setTotalHourlyCost(
				((list.get(list.size()-1)).getHour()*
				(list.get(list.size()-1)).getHourlyCost()*
				(list.get(list.size()-1)).getPpl())+
				((list.get(list.size()-1)).getLaptop()*
						(list.get(list.size()-1)).getLaptopCost()));
//			System.out.println("getHour: " + (list.get(list.size()-1)).getHour());
		System.out.println("getHourlyCost during hourlyCalc: "+ (list.get(list.size()-1)).getHourlyCost());
		System.out.println("getPpl during hourlyCalc: "+ (list.get(list.size()-1)).getPpl());
	}
		
	
/////////////////////////////////////(����)Payment ��� ��//////////////////////////////
	
	
	
	//  ������ �׽�Ʈ ��ü ������
	public void initConsol()
	{
	
		//�ӽ� ȸ�� ����
		mMap.put(mKeyNumber++,new Member("������", "1234", "dbsduthd123@naver.com", "��⵵ ��õ", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("�迩��1", "12714110", "duthd123@naver.com", "����", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("������2", "12341020", "yeosong92@gmail.com", "�λ�", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("�ٿ���", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		mMap.put(mKeyNumber++,new Member("ì��", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		mMap.put(mKeyNumber++,new Member("123", "123", "123", "��⵵ ��õ", "01054035883", "1992/04/27", 1));
		
		
		//�ӽ� ���� ����
		snackBarList.add(new SnackBar(1, "ġ�佺", 30, 1000,"��������"));
		snackBarList.add(new SnackBar(1, "��īĨ", 20,1000, "��������"));
		snackBarList.add(new SnackBar(2, "��ī��", 15,1000, "��������"));
		snackBarList.add(new SnackBar(2, "�ݶ�", 10,1000, "��������"));
		snackBarList.add(new SnackBar(2, "����ƾ��", 33,1000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11,1000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11,1000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11,1000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11,1000, "��������"));		
		snackBarList.add(new SnackBar(1, "ġ�佺", 30, 1400, "��������"));
		snackBarList.add(new SnackBar(1, "��īĨ", 20, 1500, "��������"));
		snackBarList.add(new SnackBar(2, "��ī��", 15, 600, "��������"));
		snackBarList.add(new SnackBar(2, "�ݶ�", 10, 700, "��������"));
		snackBarList.add(new SnackBar(2, "����ƾ��", 33, 1000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 4000, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 1111, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, 2222, "��������"));
		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 3333, "��������"));
		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 4444, "��������"));
		snackBarList.add(new SnackBar(2, "��Ϲ���Ĩ", 11, 5555, "��������"));
		snackBarList.add(new SnackBar(1, "�����", 11, 6000, "��������"));
		snackBarList.add(new SnackBar(1, "ĭ��", 11, 1200, "��������"));
		snackBarList.add(new SnackBar(1, "������", 11, 10000, "��������"));
		
		
		// ���̸� ���ȣ �����ο� ��������Ʈ ��뿩��
		roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(0).setRemTime(20);
        roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(1).setRemTime(5);
        roomInfoList.add (new RoomInfo("USC", 2, 8, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(2).setRemTime(7200);
        roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(3).setRemTime(8200);
        roomInfoList.add (new RoomInfo("BROWN",4, 8, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(4).setRemTime(9200);
        roomInfoList.add(new RoomInfo("YALE", 5, 8, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(5).setRemTime(10200);
        roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(6).setRemTime(11200);
        roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "�� ��������Ʈ��밡�� ��"));
        roomInfoList.get(7).setRemTime(12200);
		
        
        paymentList.add((new Payment("1",20,"2019/4/27")));
        paymentList.add((new Payment("2",15,"2020/4/27")));
        paymentList.add((new Payment("3",30,"2030/4/27")));
        paymentList.add((new Payment("4",100,"2040/4/27")));
        paymentList.add((new Payment("5",30,"2050/4/27")));
        paymentList.add((new Payment("6",50,"2070/4/27")));
        
      
        
		Set<Entry<Integer, Member>> set = mMap.entrySet();	
		Iterator<Map.Entry<Integer,Member>> it = set.iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Member> obj = it.next();
			mList.add(obj.getValue());
			
		}
        
		
		//������ ����Ʈ�� �߰�
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		admin.setAdminRoomInfoList(roomInfoList);
		admin.setAdminPaymentList(paymentList);
		inputList();
		readList();
		couponCreat();
	}
	
	// �ܼ� ����
	public void mainConsolView()
	{
		adminView = new AdminView();
		//adminView.SpaceMainMenu();
	}
	
	
	///////////////////////////////////////////////////(����) ������ ���� ��� ///////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public void couponCreat() {
		int couponSize = 500;
		Set<Coupon> couponSet = new HashSet<Coupon>();
		char[] coupon = new char[62];
		char ascCode = 48;
		for (int i = 0; i < 62; i++) {
			if (i < 10) {
				coupon[i] = ascCode; // 0 1 2 3 4 5 6 7 8 9
			} // 0 1 2 3 4 5 6 7 8 9
			else if (i == 10) {
				ascCode = 65; // 10 A
				coupon[i] = ascCode;

			} else if (i > 10 && i < 36) // 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35
			{ // B C D E F G H I J K L N M O P Q R S T U V W X Y Z
				coupon[i] = ascCode;

			} else if (i == 36) {
				ascCode = 97; // 36 a
				coupon[i] = ascCode;
			} else if (i > 36 && i < 62) // 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61
			{ // b c d e f g h i j k l n m o p q r s t u v w x y z
				coupon[i] = ascCode;

			}
			ascCode++;
		}

		int couponCount = coupon.length;

		Random randomNumber = new Random();
		int index = 0;
		int i = 0;
		while (index < couponSize) {
			StringBuffer stringBuf = new StringBuffer(16);
			// i�� 8�ڸ��� �������� �ǹ�
			for (i = 16; i > 0; i--) {
				// ���� �迭 �����͸� ���� ���ڿ� ���� �߰��Ѵ�.
				stringBuf.append(coupon[randomNumber.nextInt(couponCount)]);
			}

			String couponNumber = stringBuf.toString();
			System.out.println("�����ȣ : " + couponNumber);
			couponSet.add(new Coupon(null, couponNumber));
			index++;
		}
		
		Iterator<Coupon> it = couponSet.iterator();
		
		while(it.hasNext())
		{
			Coupon c = it.next();
			couponList.add(c);
		}
		
		Collections.sort(couponList,new AscMember());
		
		admin.setAdminCouponList(couponList);
	}
	
	
	
	

	// �����ϱ�
	public void inputList()
	{
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try
		{
			out = new FileOutputStream("Member.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			List<Member> memberList = mList;
			
			oout.writeObject(memberList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try
			{
				oout.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	// �о����
	public void readList()
	{
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
	
		try
		{
			in = new FileInputStream("Member.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			List<Member> tempList = (List<Member>)oin.readObject();
			for(Member s : tempList)
				s.printMember();
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				oin.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	// ��Ʈ�ѷ� ��
	public void seachMem()
	{
		Set mSet;
		mSet = mMap.entrySet();
		Iterator it = mSet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			System.out.println("key : " +obj.getKey() +" " + " value : "+ obj.getValue());
		}
		System.out.println("����");
	}
	
	//�����ڿ� ��� ��� �˻�(��������)
	public String[][] adminSearchAllMember(String[] modelName)
	{
		String[][] membrContents = new String[admin.getAdminMemberMap().size()][modelName.length];
		
		
		
		Set mSet;
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			list.add(((Member)obj.getValue()));
		}
		Collections.sort(list,new AscMember());
		
		
		
		// {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"}
		
		int i = 0;
		for(Iterator<Member> itList = list.iterator(); itList.hasNext();)
		{
			Member m = (Member)itList.next();
			
			for(int j = 0; j < membrContents[i].length; j++)
			{
				if(j == 0)
				{
					membrContents[i][j] = String.valueOf(m.getUserCode());
				}
				else if(j == 1) 
				{
					membrContents[i][j] = m.getMemberName();
				}
				else if(j == 2)
				{
					membrContents[i][j] = m.getEmailId();
				}
				else if(j == 3)
				{
					membrContents[i][j] = String.valueOf(m.getMemberPw());
				}
				else if(j == 4)
				{
					membrContents[i][j] = m.getAddress();
				}
				else if(j == 5)
				{
					membrContents[i][j] = m.getPhoneNumber();
				}
				else if(j == 6)
				{
					membrContents[i][j] = m.getBirthDay();
				}
				else if(j == 7)
				{
					membrContents[i][j] = String.valueOf(m.getStudentIsTrue());
				}else if(j == 8)
				{
					membrContents[i][j] = m.getCoupon();
				}
			}
			i++;
		}
		
		return membrContents;	
	}
	
	
	
	
	//�����ڿ� �̸����� ã��
	public String[][] adminSearchMember(String[] modelName, String jtfName)
	{
		
		String searchName = jtfName;
		
		
		Set mSet;
		mSet = admin.getAdminMemberMap().entrySet();
		Iterator it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(searchName) )
				list.add(((Member)obj.getValue()));
		}
		Collections.sort(list,new AscMember());
		
		
		//�˻��� ��� ����ŭ �� �÷�����ŭ ���� �ø���.
		String[][] membrContents = new String[list.size()][modelName.length];
		
		// {"ȸ���ڵ�","�̸�","�̸���","��й�ȣ","�ּ�","�ڵ��� ��ȣ","�������","�л��̸� 1"}
		
		int i = 0;
		for(Iterator<Member> itList = list.iterator(); itList.hasNext();)
		{
			Member m = (Member)itList.next();
			
			for(int j = 0; j < membrContents[i].length; j++)
			{
				if(j == 0)
				{
					membrContents[i][j] = String.valueOf(m.getUserCode());
				}
				else if(j == 1) 
				{
					membrContents[i][j] = m.getMemberName();
				}
				else if(j == 2)
				{
					membrContents[i][j] = m.getEmailId();
				}
				else if(j == 3)
				{
					membrContents[i][j] = String.valueOf(m.getMemberPw());
				}
				else if(j == 4)
				{
					membrContents[i][j] = m.getAddress();
				}
				else if(j == 5)
				{
					membrContents[i][j] = m.getPhoneNumber();
				}
				else if(j == 6)
				{
					membrContents[i][j] = m.getBirthDay();
				}
				else if(j == 7)
				{
					membrContents[i][j] = String.valueOf(m.getStudentIsTrue());
				}				
			}
			i++;
		}
		
		return membrContents;	
	}


	// ȸ���ڵ�� ã��
	public void adminModifyMember(int userCode , String userValue)
	{	
		
		//�ʿ� ��Ʈ������ �̿��Ͽ� iter�� ���
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		
		int memberCode = userCode;  //�����ڵ�
		String memberPw = userValue; // ���� ��й�ȣ
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		while(it.hasNext())
		{
			
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				deleteIndex = obj.getKey();
				
			}
		}
		
		((Member)admin.getAdminMemberMap() .get(deleteIndex)).setMemberPw(memberPw);
		mMap = admin.getAdminMemberMap();	
	}
	
	
	
	//������ ���� ����
	public void adminCouponSend(int userCode)
	{
		int userCodeNum = userCode;
		
		// �ʿ� ��Ʈ������ �̿��Ͽ� iter�� ���
		Set<Map.Entry<Integer, Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer, Member>> it = mSet.iterator();
		int Index = 0;

		while (it.hasNext()) {
			Map.Entry<Integer, Member> obj = (Entry<Integer, Member>) it.next();
			if (((Member) obj.getValue()).getUserCode() == memberCode) {
				Index = obj.getKey();
			}
		}
		System.out.println(    ((Member)admin.getAdminMemberMap().get(Index) ).getCoupon());
		if(   ( (Member)admin.getAdminMemberMap().get(Index) ).getCoupon().equals("����")    )
		{
			((Member)admin.getAdminMemberMap().get(Index)).setCoupon(admin.getAdminCouponList().get(couponCount).getCoupontNumber());
			admin.getAdminCouponList().get(couponCount).setUserCode(  String.valueOf(  ((Member)admin.getAdminMemberMap().get(Index)).getUserCode()) );
			couponCount++;
		}	
	}
	

	
	// �����ڿ� ȸ�� �ڵ�� ����
	public void adminDelMember(int userCode)
	{	
		//�ʿ� ��Ʈ������ �̿��Ͽ� iter�� ���
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = userCode;
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		int deleteIndex = 0;
		
		while(it.hasNext())
		{
			Map.Entry<Integer,Member> obj = (Entry<Integer, Member>) it.next();
			if( ((Member)obj.getValue()).getUserCode() == memberCode )
			{		
				deleteIndex = obj.getKey();
			}
		}
		
		admin.getAdminMemberMap() .remove(deleteIndex);
		mMap = admin.getAdminMemberMap();	
	}
	

//	// ������ ��� �帵ũ �˻�
//	public void adminSearchAllSnack(String[] modelName)
//	{
//		
//		
//		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
//			
//		for(Iterator<SnackBar> it = admin.getAdminSnackBarList().iterator(); it.hasNext();)
//		{
//			System.out.println(it.next());
//		}
//		
//
//	}
	
	public String[][] adminSearchAllSnack(String[] modelName)
	{
		
		String[][] snackContetnts = new String[admin.getAdminSnackBarList().size()][modelName.length];
		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
			
		int i = 0;
		for(Iterator<SnackBar> it = admin.getAdminSnackBarList().iterator(); it.hasNext();)
		{
			SnackBar sb = it.next();
			
			for(int j = 0; j < snackContetnts[i].length; j++)
			{
				if(j == 0)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackBarIndex());
				}
				else if(j == 1) 
				{
					snackContetnts[i][j] = sb.getSnack();
				}
				else if(j == 2)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackQuantity());
				}
				else if(j == 3)
				{
					snackContetnts[i][j] = String.valueOf(sb.getSnackPrice());
				}
				else if(j == 4)
				{
					snackContetnts[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		return snackContetnts;
	}
	
	
	// �������� �������� �Ǻ�
	public String[][] adminSearchSnack(int index, String name, String[] modelName)
	{
		
		//String[][] snackContents;
		//������ ���� �ε����� ������
		
		
		int snackIndex = 0;
		String snackName = null;
		List<SnackBar> tempList = new ArrayList<SnackBar>();
		
		
		
		// �ε����� 0 ����  ���� �̸��� Null�� �ƴ��� �Ǵ�
		if(index != 0)
			snackIndex = index;
		else 
			snackIndex = 0;
		
		if(name != null)
			snackName = name;
		else
			snackName = null;
		
		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		
		/// 1 ~ 2 �ΰ�� �̸��� �ִ°��
		// 1~2�� �ΰ�� �̸��̾��°��
		// 1~2�� �ƴϰ� �̸��� �ִ°��
		// 1~2�� �ƴϰ� �̸��� ���°��
		
		if(snackIndex != 0 && snackName != null)
		{
			//������ȣ�� 1�ΰ��
			if(snackIndex == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(  (admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex) 
							&& (admin.getAdminSnackBarList().get(i).getSnack().equals(snackName)) )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}
				
			}
			//������ȣ�� 2�ΰ��
			else if(snackIndex == 2)
			{				
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(  (admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex) 
							&& (admin.getAdminSnackBarList().get(i).getSnack().equals(snackName)) )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}
				
			}	
		}
		else if( snackIndex != 0 && snackName == null)
		{
			//������ȣ�� 1�ΰ��
			if(snackIndex == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if( admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}						
			}
			//������ȣ�� 2�ΰ��
			else if(snackIndex == 2)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if( admin.getAdminSnackBarList().get(i).getSnackBarIndex() == snackIndex )
					{				
						tempList.add(admin.getAdminSnackBarList().get(i));
					}
				}	
			}
		}	
		else if(snackIndex == 0 && snackName != null)
		{
			for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
			{
				if( admin.getAdminSnackBarList().get(i).getSnack().equals(snackName) )
				{				
					tempList.add(admin.getAdminSnackBarList().get(i));
				}
			}
		}
		
		String[][] snackContents = new String[tempList.size()][modelName.length];
		
		int i = 0;
		for(Iterator<SnackBar> it = tempList.iterator(); it.hasNext();)
		{
			SnackBar sb = it.next();
			
			for(int j = 0; j < snackContents[i].length; j++)
			{
				if(j == 0)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackBarIndex());
				}
				else if(j == 1) 
				{
					snackContents[i][j] = sb.getSnack();
				}
				else if(j == 2)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackQuantity());
				}
				else if(j == 3)
				{
					snackContents[i][j] = String.valueOf(sb.getSnackPrice());
				}
				else if(j == 4)
				{
					snackContents[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		return snackContents;
	}
	
	
	// ���� ���� ����
	public void adminModifySnack()
	{
		String snackName = "�ݶ�";
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if( ((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName)  )
			{
				indexNum = i;
			}
		}
		
		
		//���
		System.out.println(((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity());
		
		((SnackBar)admin.getAdminSnackBarList().get(indexNum)).
		setSnackQuantity( ((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity()+10);
		
		
	}
	 
	// ���� �̸����� ����
	public void adminDelSnack(String name)
	{
//		String snackName = adminView.searchSnackName();
//		int indexNum = 0;
//		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
//		{
//			if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName))
//			{
//				
//				indexNum = i;
//			}
//		}
//		admin.getAdminSnackBarList().remove(indexNum);
//		snackBarList = admin.getAdminSnackBarList();
		
		String snackName = name;
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnack().equals(snackName))
			{
				
				indexNum = i;
			}
		}
		admin.getAdminSnackBarList().remove(indexNum);
		snackBarList = admin.getAdminSnackBarList();
				
	}
	
	public void SnackSeach()
	{	
		for(int i = 0 ; i < snackBarList.size(); i++)
		{
			System.out.println(snackBarList.get(i));
		}
	}
			
	//������ �����
	//{"�� ��ȣ","�� �̸�","�ִ� �ο�","��Ʈ��"};
	
	// ��� ��˻�
	public String[][] adminSearchAllRoomInfo(String[] modelName)
	{
		String[][] roomInfoContents = new String[admin.getAdminRoomInfoList().size()][modelName.length];
		int i = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			for(int j = 0; j < admin.getAdminRoomInfoList().size(); j++)
			{
				if(j == 0)
				{
					roomInfoContents[i][j] =  String.valueOf(r.getRoomNumber());
				}
				else if(j == 1)
				{
					roomInfoContents[i][j] = r.getRoomName();
				}
				else if(j == 2)
				{
					roomInfoContents[i][j] = String.valueOf(r.getMaxPpl());
				}
				else if(j == 3)
				{
					roomInfoContents[i][j] = String.valueOf(r.getNoteBook());
				}
			}
			i++;
		}
		
		return roomInfoContents;
	}
	
	
	// �� ��ȣ�� ã��
	public void adminSearchRoomInfo()
	{
		int roomNum = 1;
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				System.out.println(r);
			}
		}
	}
	 
	// �� ���� ��Ʈ�� ����
	public void adminModifyRoom()
	{
		int roomNum = 1;
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				r.setNoteBook(r.getNoteBook() + 1 );
				System.out.println(r);
			}
		}		
	}
	

	///�����ʿ�
	//������ Payment
	//���� �˻�
	public String[][] adminSearchTotalPay(String[] modelName)
	{
		String[][] paymentContents = new String[admin.getAdminPaymentList().size()+1][modelName.length];
		int num = 0;
		int i = 0;
		for(Iterator<Payment> it = admin.getAdminPaymentList().iterator(); it.hasNext();)
		{					
			Payment p = it.next();
			
			for(int j = 0; j < paymentContents[i].length; j++)
			{			
				if(i < admin.getAdminPaymentList().size())
				{
					if(j == 0)
					{
						paymentContents[i][j] = p.getUser();
					}	
					else if(j == 1)
					{				
						paymentContents[i][j] = String.valueOf(p.getFinalCost());
						num += p.getFinalCost();			
					}
					else if(j == 2)
					{
						paymentContents[i][j] = p.getDate();
					}
				}
			}
			i++;	
		}
		System.out.println(i);
		System.out.println(admin.getAdminPaymentList().size());
		
		if(i == admin.getAdminPaymentList().size())
		{
			System.out.println("�����");
			paymentContents[admin.getAdminPaymentList().size()][0] = "�� ����";
			paymentContents[admin.getAdminPaymentList().size()][1] = "���� :  "+ String.valueOf(num)+"��";
			paymentContents[admin.getAdminPaymentList().size()][2] = "���� �ٳణ �ο� :" + admin.getAdminPaymentList().size()+"��" ;
		}
		
		return paymentContents;	
	}
	
/////////////////////////////////////////////(����)������ ��� ��////////////////////////////////////////////////////	
		
	
	// ���κ�
	public void mainView()
	{
		mv.initialize(this, mainJframe, this.roomInfoList);       // ���� �� �ʱ�ȭ
	}
	
	// sub room view
	public void subRoomView(int roomNumber)
	{
		subRoomV.initialize(this, mainJframe,this.roomInfoList, roomNumber);
	}
	
	// �α� �� 
	public void loginView()
	{
		lv.initialize(this, mainJframe);
	}

	// ȸ�� ����
	public void accoutView() {
		accountV.initialize(this, mainJframe);
	}

	// ȸ�� ����
	public void accoutView2() {
		subAccountV.initialize(this, mainJframe);
	}
	
	public void nAccountView()
	{
		nAccountV.initialize(this, mainJframe);
	}
	
	// �߰��ð� ��
	public void addTiemView() {
		
	}
	
	// ������ 
	public void adminView() {
		adminV1.initialize(this, mainJframe);
	}

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	// �������� ��
	public void paymentView() {
		
	//			paymentList.add(new Payment());
	//			pm = new Payment();
	//			 To use the getters, use the constructor to send the Collection list
		
	//			Method 1 (the create a new object)
		//paymentList.add(new Payment());
		payV.initialize(this, mainJframe);
	}
	
	// ������ ������
	public void finalPaymentView() {
		finalpv.initialize(this, mainJframe, paymentList);
	}
	
	
	// ���� ��
	public void snackView() {
		snackV.initialize(this, mainJframe, snackTmpList);
	}
	
	
	
	
	
}
	

