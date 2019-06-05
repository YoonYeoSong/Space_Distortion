package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;

import com.space_distorition.comparator.AscMember;
import com.space_distortion.event.SpaceActionEvent;
import com.space_distortion.model.vo.Admin;
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
import com.space_distortion.view.PaymentView;
import com.space_distortion.view.SnackBarView;
import com.space_distortion.view.SubRoomView;

// ��ɱ��� Ŭ����
public class SpaceController {
	
	//��� �����ڿ� �� ���̴� ����
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	
	
	
	/////////////////////////////// Model.vo ��ü ����Ʈ///////////
	private List<Member> mList = new ArrayList<Member>();
	private Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // ȸ�� ��
	private Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // ��ȸ�� ��
	private List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // �뿡 ���� ����Ʈ
	private List<Payment> paymentList = new ArrayList<Payment>();  // ���̸�Ʈ ���� ����Ʈ
	private List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // �������ø���Ʈ
	private List<SnackBar> snackTmpList = new ArrayList<SnackBar>(); // ����/ ������ �ӽ� ����Ʈ
	private List<SnackBar> snackLocalList = new ArrayList<SnackBar>(); // ���翡 �Ѱ��� ��ǳ ����Ʈ
	
	private Admin admin = new Admin();
	
	///////////////////////Model.vo ��/////////////////////////////////////////
	
	private MainRoomView mv = new MainRoomView(); // ���� ��
	private SpaceActionEvent sAe = new SpaceActionEvent();
	private MainRoomView mRv = new MainRoomView();                  //���� �� ����
	private SubRoomView subRoomV = new SubRoomView();       // �����
	private LoginView lv = new LoginView();                         //�α��κ�
	private AccountView accountV = new AccountView();		//ȸ�� ���� �� ����
	private AccountView2 subAccountV = new AccountView2();	//ȸ�� ���� �� ����
	private AddTimeRoomView addTimeV = new AddTimeRoomView();	//�߰��ð� �� ����
	private AdminView adminV1 = new AdminView();				//������ �� ����
	private PaymentView payV = new PaymentView();			//���� �� ����
	private SnackBarView snackV = new SnackBarView();		//���� �� ����
	private FinalPaymentView finalpv = new FinalPaymentView(); // ������ �� â
	private JFrame mainJframe;			//���� ������ ����
	public Payment pm;
	
	/* ���� ��Ʈ�ѷ� ������ */
	public SpaceController() {
		this.init();
		
		
		
		initConsol();  // ������ �׽�Ʈ ������
		//this.snackViewDidload();
	}
	
	// ���� ������ ����
		public void init()
		{
			
			// ������ �ҷ�����
			// ���̸� ���ȣ �����ο� ��������Ʈ ��뿩��
			roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add (new RoomInfo("USC", 2, 8, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add (new RoomInfo("BROWN",4, 8, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add(new RoomInfo("YALE", 5, 8, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "�� ��������Ʈ��밡�� ��"));
			roomInfoList.add(new RoomInfo("STANFORD", 8, 12, "�� ��������Ʈ��밡�� ��"));
			
			
			mainJframe = new JFrame("Space Distorition");
			mainJframe.setBounds(0, 0, 1024, 768);
//			mainJframe.setLayout(new FlowLayout());
			mainJframe.setDefaultCloseOperation(3);
			mainJframe.setVisible(true);	
		}
	
		AdminView adminView;
	
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	
	
		
		
	
///////////////////�α��� ��� ����///////////////////////////////////////////
	
	// LoginView �α���Ȯ��
	public void logincheck(String inputid, char[] inputpw) {
	
		for(int i=0;i<mMap.size();i++) {
			if(((Member)mMap.get(i)).getEmailId().equals(inputid)) {
				if(((Member)mMap.get(i)).getMemberPw().equals(inputpw)) {
					System.out.println("�α��� Ȯ��");
					//JOptionPane.showMessageDialog(null, "�α��� Ȯ��");
					//�α���Ȯ��, �� ����Ʈ ���
					
				} else { 
					//JOptionPane.showMessageDialog(null, "�н����尡 Ʋ�Ƚ��ϴ�.");
					System.out.println("�н����� ����"); }
			} else { 
				//JOptionPane.showMessageDialog(null, "���̵� Ʋ�Ƚ��ϴ�."); 
				System.out.println("���̵� ����");	}
	
		}
		
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
	public void emailCheck(String email)
	{
		for(int i = 0; i < mList.size(); i++)
		{
			if( !(mList.get(i).getEmailId().equals(email)))
		    {                
		    System.out.println("��밡���� ���̵� �Դϴ�");
		     //JOptionPane.showMessageDialog(null, "��밡���մϴ�");
		    } else {
		     // �Ұ���
		    //JOptionPane.showMessageDialog(null, "���Ұ����մϴ�");
		    System.out.println("�ߺ��� ���̵� �Դϴ�.");
		    }
		}
	}
	
	
	
		
		
		
		
/////////////////////////////////�α��α��////////////////////////////
	
	
	
	
	
////////////////////////////////////// ���� ���� ���/////////////////	
	
	
	/*
	 * 1 : ����
	 * 2 : ����
	 */
	
	// ���� �䰡 �ε�ɶ� ������ �ε�
	public void snackViewDidload() {
			
		for (SnackBar snackBar : snackBarList) {
			if(snackBar.getSnackBarIndex() == 2) {
				snackTmpList.add(snackBar);
			}
		}//for
	} //snackViewDidload
	
	
	public void snackSel(int i) {
		
		if(snackTmpList != null)
			snackTmpList.clear();
		
		if(i == 2) {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 2) {
					snackTmpList.add(snackBar);
//					System.out.println(snackBar);
					
				}
			
			}//for
		}else {
			for (SnackBar snackBar : snackBarList) {
				if(snackBar.getSnackBarIndex() == 1) {
					snackTmpList.add(snackBar);
//					System.out.println(snackBar);
				}
			
			}//for
		}//else

	}// snackSel
	
	
	
	
	// ���ڹ�ư ���� �� ���� ���� ����
	public List<SnackBar> snackSelList(int btnIndex) {
		System.out.println("���� ���μ���");
		snackLocalList.add(snackTmpList.get(btnIndex));
		
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
		for (SnackBar s : snackLocalList) {
			System.out.println(s);
		}
		
		return snackLocalList;

	}//snackSel
	
	
	
	
	
	
//////////////////////////////////////�������ñ��/////////////////////
	
	
	
	
	
	
	
/////////////////////////////////////Payment//////////////////////////////
	// ��� ������ ����ϰ� ����Ʈ��
	public void totalCostCalculator() {
		
	// ȭ��Ʈ���带 �����ٸ� ���ݿ� 3000�� ����. �ƴϸ� ����
	if(pm.getWhiteBoardUsage() == 1) {
		pm.setWhiteBoardCost(3000);
	}else 
	{
		pm.setWhiteBoardCost(0);
	}
	
	// ��������Ʈ �����ٸ� ���ݿ� 3000�� ����. �ƴϸ� ����
	if(pm.getBeamProjectorUsage() == 1) {
		pm.setBeamProjectorCost(3000);
	}else 
	{
		pm.setBeamProjectorCost(0);
	}
//			 �� �޼ҵ�� ��ī��Ʈ�� ������ �� ������ �˷��ִ� �޼ҵ�
	if (pm.getUser() == "member") {
		pm.setDiscountRate(0.7);
	}else {
		pm.setDiscountRate(1.0);
	}
	
	hourlyCostCalculator();
	
	System.out.println("hour:   "+pm.getHour());
	System.out.println(pm.getHourlyCost());
	System.out.println("hchc"+pm.getTotalHourlyCost());
	System.out.println(pm.getPpl());
	
	
	pm.setTotalCost(pm.getTotalHourlyCost()+
			pm.getWhiteBoardCost()+pm.getBeamProjectorCost()+
			pm.getTotalLaptopCost());
	
	
	pm.setFinalCost((int) (pm.getTotalCost()*pm.getDiscountRate()));
	
	String finalCost = String.valueOf(pm.getFinalCost());
	payV.getDisplayPriceAfterDiscount().setText(finalCost);
	String totalCost = String.valueOf(pm.getTotalCost());
	payV.getDisplayTotalCost().setText(totalCost);
//			System.out.println(getPm());
	}
	
	public void hourlyCostCalculator() {
		pm.setTotalHourlyCost((pm.getHour()*pm.getHourlyCost()*pm.getPpl())
				+(pm.getLaptop()*pm.getLaptopCost()));
	}
	
	
/////////////////////////////////////Payment//////////////////////////////
	
	
	
	//  ������ �׽�Ʈ ��ü ������
	public void initConsol()
	{
	
		
		
		//�ӽ� ȸ�� ����
		mMap.put(mKeyNumber++,new Member("������", "1234", "dbsduthd123@naver.com", "��⵵ ��õ", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("�迩��1", "12714110", "duthd123@naver.com", "����", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("������2", "12341020", "yeosong92@gmail.com", "�λ�", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("�ٿ���", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		mMap.put(mKeyNumber++,new Member("ì��", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		
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
		
		
		
		
		
		// ���̸� ���ȣ �����ο� ��������Ʈ ��뿩��
		roomInfoList.add(new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add (new RoomInfo("HARVARD", 1, 4, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add (new RoomInfo("USC", 2, 8, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add (new RoomInfo("CORNELL", 3, 8, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add (new RoomInfo("BROWN",4, 8, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add(new RoomInfo("YALE", 5, 8, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add (new RoomInfo("PRINCETON",6, 12, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add(new RoomInfo("COLUMBIA", 7, 12, "�� ��������Ʈ��밡�� ��"));
		roomInfoList.add(new RoomInfo("STANFORD", 8, 12, "�� ��������Ʈ��밡�� ��"));
		
		
		
		
		
		//�ӽ� �� ����
//		roomInfoList.add(new RoomInfo(1, "A", 4, 4, 0, 4, 1) );
//		roomInfoList.add(new RoomInfo(2, "B", 6, 5, 0, 6, 0) );
//		roomInfoList.add(new RoomInfo(3, "C", 6, 4, 0, 6, 1) );
//		roomInfoList.add(new RoomInfo(4, "D", 4, 2, 0, 4, 1) );
//		roomInfoList.add(new RoomInfo(5, "E", 8, 8, 0, 8, 1) );
//		roomInfoList.add(new RoomInfo(6, "F", 8, 5, 0, 8, 0) );
//		roomInfoList.add(new RoomInfo(7, "G", 8, 6, 0, 8, 0) );
//		roomInfoList.add(new RoomInfo(8, "H", 16, 14, 0, 12, 0) );
		
		//�ӽ� ���̸�Ʈ ����
		//paymentList.add(new Payment(roomNumberInUse, user, hourlyCost, hour, ppl, discountRate, whiteBoard, beamProjector, whiteBoardCost, beamProjectorCost, laptopCost, laptop, totalHourlyCost, totalLaptopCost, totalCost, finalCost))
		
		
		//������ ����Ʈ�� �߰�
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		admin.setAdminRoomInfoList(roomInfoList);
		
//		mSet = mMap.entrySet();
//		Iterator itEntrySet = mSet.iterator();
//		List<Member> tempList = new ArrayList<Member>();
//			
//		while(itEntrySet.hasNext())
//		{
//			Map.Entry obj = (Map.Entry)itEntrySet.next();
//			tempList.add( ((Member)obj.getValue()) );
//		}
//		
//		mSet = mMap.keySet();
//		Iterator itkeySet = mSet.iterator();
//		
//		while(it.hasNext())
//			System.out.println(it.next());
	
		
	}
	
	// �ܼ� ����
	public void mainConsolView()
	{
		adminView = new AdminView();
		//adminView.SpaceMainMenu();
	}
	
	
	/////////////////////////////////////////////////// ������ ��� ���� ��� ///////////////////////////////////////////////////////////////
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
	
	
	
////////////////////////////////////////////////////SnackBar///////////////////////////////////////////////////////////

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
					snackContents[i][j] = sb.getSnackComment();
				}				
			}
			i++;
		}
		
		return snackContents;
	}
	
	
	// ���� ����
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
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
//////////////////////////////////////////////////������ �� ����////////////////////////////////////////////////////////
	// ��� ��˻�
	public void adminSearchAllRoomInfo()
	{
		for(Iterator it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			System.out.println(it.next());
		}
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
	
/////////////////////////////////////////////������ Payment///////////////////////////////////////
	
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
				if(i == admin.getAdminPaymentList().size() )
					break;
				if(j == 0)
				{
					paymentContents[i][j] = String.valueOf(p.getFinalCost());
					num += p.getFinalCost();				
				}
			}
			i++;
		
		}
		paymentContents[admin.getAdminPaymentList().size()][modelName.length] = "���� :  "+String.valueOf(num)+"��";
		
		return paymentContents;	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
/////////////////////////////////////////////////////////////////////////////////////Consol////////////////////////////////////////////////////////////////////		
	
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
	
	// �߰��ð� ��
	public void addTiemView() {
		
	}
	
	// ������ 
	public void adminView() {
		adminV1.initialize(this, mainJframe);
	}

	/////////////////////////////////////////////////////////////////////

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	// �������� ��
	public void paymentView() {
		pm = new Payment();
		payV.initialize(this, mainJframe);
	}
	
	// ���� ��
	public void snackView() {
		snackV.initialize(this, mainJframe, snackTmpList);
	}
	
}
	

