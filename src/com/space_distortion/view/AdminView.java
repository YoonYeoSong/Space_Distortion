package com.space_distortion.view;

import java.util.Scanner;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.main.Main;

public class AdminView {
	
	SpaceController spaceController = Main.getSpaceController();
	
	
	public void SpaceMainMenu()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Space_Distorition");
			System.out.println("1. �Ϲ� ȸ����ȸ");
			System.out.println("2. �濡 ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. Inventory");
			System.out.println("5. �ϸ���");
			System.out.println("6. ����");
			System.out.println("7. ȸ�� �̸� ��ȸ");
			System.out.println("8. ����");	
			System.out.println("9. ������ ȸ�� ���� ���");	
			System.out.println("10. ������ ȸ�� �̸����� ã��");	
			System.out.println("11. ������ ȸ���ڵ�� ȸ�� ����");	
			System.out.println("12. ������ ȸ�� ���� ���");	
			System.out.println("13. ����/���� ��� �˻�");
			System.out.println("14. ���� ���� �Ǻ�");
			System.out.println("15. ���ᳪ ���� ���� ����");
			System.out.println("16. ���ᳪ ���� ����");

			System.out.print("��ȣ �Է� : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	spaceController.seachMem();
				break;
			case 2:	//spaceController.searchAllRoomInfo();
				break;
			case 3:		//spaceController.search();
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:		
			case 7:	//spaceController.adminSearchMemberName();
				break;
			case 8:	spaceController.initConsol();
				break;
			case 9: spaceController.adminSearchAllMember();
				break;
			case 10: spaceController.adminSearchMemberName();
			break;
			case 11: spaceController.adminDelMember();
			break;
			case 12: spaceController.adminDelMember();
			break;
			case 13: spaceController.adminSearchAllSnack();
			break;
			case 14: spaceController.adminSearchSnack();
			break;
			case 15: spaceController.adminModifySnack();
			break;
			case 16: spaceController.adminDelSnack();
			break;
			case 17: spaceController.SnackSeach();
			break;
//			case 18: spaceController.adminDelMember();
//			break;
			
			default:
				break;
			}
		}
	}
	
	public String searchMemberName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String memberName = sc.next();
		return memberName;
	}
	public int searchMemberKey()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("ȸ���ڵ� �Է� : ");
		int memberCode = sc.nextInt();
		return memberCode;
	}
	
	public int searchSnackIndex()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� :1 / ���� 2  �Է� : ");
		int snackIndex = sc.nextInt();
		return snackIndex;
	}
	
	public int searchSnackQuntity()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int snackQuntity = sc.nextInt();
		return snackQuntity;
	}
	

	public String searchSnackName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �̸� �Է� : ");
		String snackName = sc.next();
		return snackName;
	}
	
	
	

}
