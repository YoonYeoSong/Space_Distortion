package com.space_distortion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import com.space_distortion.view.AdminView;
import com.space_distortion.view.LoginView;
import com.space_distortion.view.MainRoomView;

// ��ɱ��� Ŭ����
public class SpaceController {
	static int mKeyNumber = 0;
	static int nKeyNumber = 0;
	
	
	List<Member> mList = new ArrayList<Member>(); //ȸ��
	List<NonMember> nList = new ArrayList<NonMember>();  //��ȸ��
	
	
	/////////////////////////////// Model.vo ��ü ����Ʈ///////////
	Map<Integer,Member> mMap = new HashMap<Integer, Member>(); // ȸ�� ��
	Map<Integer,NonMember> nMap = new HashMap<Integer, NonMember>(); // ��ȸ�� ��
	List<RoomInfo> roomInfoList = new ArrayList<RoomInfo>(); // �뿡 ���� ����Ʈ
	List<Payment> paymentList = new ArrayList<Payment>();  // ���̸�Ʈ ���� ����Ʈ
	List<SnackBar> snackBarList = new ArrayList<SnackBar>(); // �������ø���Ʈ
	Admin admin = new Admin();
	
	
	
	
	///////////////////////Model.vo��ü����Ʈ/////////////////////////////////////////
	
	MainRoomView mv; // ���� ��
	LoginView lv = new LoginView(); //�α��κ�
	SpaceActionEvent sAe = new SpaceActionEvent();
	MainRoomView mRv = new MainRoomView();
	private JFrame jframe;
	
///////////////////////////////////////////////////////////////////////////consol ///////////////////////////////////////////////////////////////////////	
	
	AdminView adminView;
	
	public void init()
	{
		mMap.put(mKeyNumber++,new Member("������", "1234", "dbsduthd123@naver.com", "��⵵ ��õ", "01054035883", "1992/04/27", 1));
		mMap.put(mKeyNumber++,new Member("�迩��1", "12714110", "duthd123@naver.com", "����", "01054035883", "1990/04/27", 0));
		mMap.put(mKeyNumber++,new Member("������2", "12341020", "yeosong92@gmail.com", "�λ�", "01011135883", "1981/04/27", 0));
		mMap.put(mKeyNumber++,new Member("�ٿ���", "1234", "yeo90@gmail.com", "����", "010378801", "1972/04/27", 1));
		
		
		snackBarList.add(new SnackBar(1, "ġ�佺", 30, "��������"));
		snackBarList.add(new SnackBar(1, "��īĨ", 20, "��������"));
		snackBarList.add(new SnackBar(2, "��ī��", 15, "��������"));
		snackBarList.add(new SnackBar(2, "�ݶ�", 10, "��������"));
		snackBarList.add(new SnackBar(2, "����ƾ��", 33, "��������"));
		snackBarList.add(new SnackBar(1, "��Ϲ���Ĩ", 11, "��������"));
		
		admin.setAdminMemberMap(mMap);
		admin.setAdminSnackBarList(snackBarList);
		
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
			System.out.println("key : " +obj.getKey()+" " + " value : "+ obj.getValue());
		}
	}
	
	//�����ڿ� ��� ��� �˻�(��������)
	public void adminSearchAllMember()
	{
		
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
		
		Iterator itList = list.iterator();
		
		while(itList.hasNext())
			System.out.println(itList.next());
		
	}
	
	// �����ڿ� �̸����� �˻����
	public void adminSearchMemberName()
	{	
		//�̸����� ã��
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		String mName = adminView.searchMemberName();	
		Iterator<Map.Entry<Integer,Member>> it = mSet.iterator();
		List list = new ArrayList();
		
		while(it.hasNext())
		{
			Map.Entry obj = (Map.Entry)it.next();
			if( ((Member)obj.getValue()).getMemberName().equals(mName)   )
			{
				list.add( ((Member)obj.getValue()) );
			}
		}
		Collections.sort(list,new AscMember());
		
		Iterator itList = list.iterator();
		while(itList.hasNext())
			System.out.println(itList.next());
	}
	
	// �����ڿ� ȸ�� �ڵ�� ����
	public void adminDelMember()
	{	
		Set<Map.Entry<Integer,Member>> mSet = admin.getAdminMemberMap().entrySet(); // entrySet
		int memberCode = adminView.searchMemberKey();
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
		admin.getAdminMemberMap().remove(deleteIndex);
		mMap = admin.getAdminMemberMap();	
	}
	
	
	
////////////////////////////////////////////////////SnackBar///////////////////////////////////////////////////////////

	// ������ ��� �帰ũ �˻�
	public void adminSearchAllSnack()
	{
		
		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		
		for(int i = 0; i <admin.getAdminSnackBarList().size(); i++)
		{
			System.out.println(admin.getAdminSnackBarList().get(i).toString());
		}

	}
	
	
	// �������� �������� �Ǻ�
	public void adminSearchSnack()
	{
		int num = adminView.searchSnackIndex();		
		Collections.sort(admin.getAdminSnackBarList(),new AscMember());
		int count = 0;
		if(num == 1 || num == 2)
		{
			if(num == 1)
			{
				for(int i = 0; i < admin.getAdminSnackBarList().size(); i++)
				{
					if(((SnackBar)admin.getAdminSnackBarList().get(i)).getSnackBarIndex() == num)
					{
						System.out.println(admin.getAdminSnackBarList().get(i));
						count++;
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
						count++;
					}
				}
			
			}	
		}	
		else
		{
			System.out.println("����");
		}
		System.out.println(count);
	}
	
	
	// ���� ����
	public void adminModifySnack()
	{
		String snackName = adminView.searchSnackName();
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if( ((SnackBar)admin.getAdminPaymentList().get(i)).getSnack() == snackName   )
			{
				indexNum = i;
			}
			//System.out.println(admin.getAdminSnackBarList().get(i));
		}
		System.out.println(indexNum);
		((SnackBar)admin.getAdminPaymentList().get(indexNum)).
		setSnackQuantity( ((SnackBar)admin.getAdminPaymentList().get(indexNum)).getSnackQuantity()+adminView.searchSnackQuntity());
		
	}
	 
	// ����
	public void adminDelSnack()
	{
		String snackName = adminView.searchSnackName();
		int indexNum = 0;
		for(int i = 0 ; i < admin.getAdminSnackBarList().size(); i++)
		{
			if(((SnackBar)admin.getAdminPaymentList().get(i)).getSnack() == snackName)
			{
				indexNum = i;
			}
		}
		admin.getAdminPaymentList().remove(indexNum);
		
	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
//////////////////////////////////////////////////������ �� ����////////////////////////////////////////////////////////
	// ��� ��˻�
	public void adminSearchAllRoomInfo()
	{
		
	}
	
	
	// �� ��ȣ�� ã��
	public void adminSearchRoomInfo()
	{
		
	}
	
	// ���� 
	public void adminDelRoom()
	{
		
	}
	
/////////////////////////////////////////////������ Payment///////////////////////////////////////
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
/////////////////////////////////////////////////////////////////////////////////////Consol////////////////////////////////////////////////////////////////////		
	
	
	public void mainView()
	{

//		mv = new MainRoomView(); //���� �� ����
//		mv.init();
//		jframe = mv.getFrame();
//		mv.mainView(this);       // ���� �� �ʱ�ȭ �� setVisible(true)
	}
	
	// ȸ���������� 
	public void loginView()
	{
		lv.loginView(this);
	}

	public JFrame getJframe() {
		return jframe;
	}
	
	
}
	

