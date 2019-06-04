package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
	
	List<Member> mList = new ArrayList<Member>();
	
	
	/////////////////////////////// Model.vo ��ü ����Ʈ///////////
	Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // ȸ�� ��
	Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // ��ȸ�� ��
	List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // �뿡 ���� ����Ʈ
	List<Payment> paymentList = new ArrayList<Payment>();  // ���̸�Ʈ ���� ����Ʈ
	List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // �������ø���Ʈ
	
	
	Admin admin = new Admin();
	
	///////////////////////Model.vo ��/////////////////////////////////////////
	
	MainRoomView mv = new MainRoomView(); // ���� ��
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();                  //���� �� ����
	private SubRoomView subRoomV = new SubRoomView();       // �����
	private LoginView lv = new LoginView();                         //�α��κ�
	private AccountView accountV = new AccountView();		//ȸ�� ���� �� ����
	private AccountView2 subAccountV = new AccountView2();	//ȸ�� ���� �� ����
	private AddTimeRoomView addTimeV = new AddTimeRoomView();	//�߰��ð� �� ����
	private AdminView adminV1 = new AdminView();				//������ �� ����
	private PaymentView payV = new PaymentView();			//���� �� ����
	private SnackBarView snackV = new SnackBarView();		//���� �� ����
	private JFrame mainJframe = new JFrame();				//���� ������ ����
	
	/* ���� ��Ʈ�ѷ� ������ */
	public SpaceController() {
		this.init();
		initConsol();
	}
	
	// ���� ������ ����
		public void init()
		{
			mainJframe = new JFrame("Space Distorition");
			mainJframe.setBounds(100, 100, 1024, 768);
//			mainJframe.setLayout(new FlowLayout());
			mainJframe.setDefaultCloseOperation(3);
//			mainJframe.setVisible(true);	
		}
	
	
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	AdminView adminView;
	
	
	
	public void initConsol()
	{
	
		
		
		//�ӽ� ȸ�� ����
		mMap.put(mKeyNumber++,new Member("������", "1234", "dbsduthd123@naver.com", "��⵵ ��õ", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("�迩��1", "12714110", "duthd123@naver.com", "����", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("������2", "12341020", "yeosong92@gmail.com", "�λ�", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("�ٿ���", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		
		//�ӽ� ���� ����
		snackBarList.add(new SnackBar(1, "ġ�佺", 30, "��������"));
		snackBarList.add(new SnackBar(1, "��īĨ", 20, "��������"));
		snackBarList.add(new SnackBar(2, "��ī��", 15, "��������"));
		snackBarList.add(new SnackBar(2, "�ݶ�", 10, "��������"));
		snackBarList.add(new SnackBar(2, "����ƾ��", 33, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, "��������"));
		
		
		//�ӽ� �� ����
		roomInfoList.add(new RoomInfo(1, "A", 4, 4, 0, 4, 1) );
		roomInfoList.add(new RoomInfo(2, "B", 6, 5, 0, 6, 0) );
		roomInfoList.add(new RoomInfo(3, "C", 6, 4, 0, 6, 1) );
		roomInfoList.add(new RoomInfo(4, "D", 4, 2, 0, 4, 1) );
		roomInfoList.add(new RoomInfo(5, "E", 8, 8, 0, 8, 1) );
		roomInfoList.add(new RoomInfo(6, "F", 8, 5, 0, 8, 0) );
		roomInfoList.add(new RoomInfo(7, "G", 8, 6, 0, 8, 0) );
		roomInfoList.add(new RoomInfo(8, "H", 16, 14, 0, 12, 0) );
		
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
		adminView.SpaceMainMenu();
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
	public void adminSearchSnack()
	{
		//������ ���� �ε����� ������
		int num = adminView.searchSnackIndex();
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		
		if(num == 1 || num == 2)
		{
			if(num == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));
						
					}
				}
			}
			else
			{
				
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));						
					}
				}
			
			}	
		}	
		else
		{
			System.out.println("����");
		}
	}
	
	
	// ���� ����
	public void adminModifySnack()
	{
		String snackName = adminView.searchSnackName();
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
		setSnackQuantity( ((SnackBar)admin.getAdminSnackBarList().get(indexNum)).getSnackQuantity()+adminView.searchSnackQuntity());
		
		
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
		int roomNum = adminView.searchRoomNum();
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
		int roomNum = adminView.searchRoomNum();
		int number = 0;
		for(Iterator<RoomInfo> it = admin.getAdminRoomInfoList().iterator(); it.hasNext();)
		{
			RoomInfo r = it.next();
			if( r.getRoomNumber() == roomNum )
			{
				r.setNoteBook(r.getNoteBook() + adminView.searchRoomNum() );
				System.out.println(r);
			}
		}		
	}
	
/////////////////////////////////////////////������ Payment///////////////////////////////////////
	
	//���� �˻�
	public int adminSearchTotalPay()
	{
		int num = 0;
		for(Iterator<Payment> it = admin.getAdminPaymentList().iterator(); it.hasNext();)
		{
			Payment p = it.next();
			num += p.getFinalCost();
		}
		System.out.println(num);
		
		return num;	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
/////////////////////////////////////////////////////////////////////////////////////Consol////////////////////////////////////////////////////////////////////		
	
	// ���κ�
	public void mainView()
	{
		mv.initialize(this, mainJframe);       // ���� �� �ʱ�ȭ
	}
	
	// sub room view
	public void subRoomView()
	{
		subRoomV.initialize(this, mainJframe);
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
		payV.initialize(this, mainJframe);
	}
	
	// ���� ��
	public void snackView() {
		
	}
	
}
	

