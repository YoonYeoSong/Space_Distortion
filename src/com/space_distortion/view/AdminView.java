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
			System.out.println("1. ȸ����ȸ");
			System.out.println("2. �濡 ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. Inventory");
			System.out.println("5. �ϸ���");
			System.out.println("6. ������");
			System.out.println("7. ȸ�� �̸� ��ȸ");
			System.out.println("8. ����");	
			System.out.print("��ȣ �Է� : ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:	spaceController.searchAllMember();
				break;
			case 2:	spaceController.searchAllRoomInfo();
				break;
			case 3:		
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:	System.exit(0);		
			case 7:	spaceController.searchMember();	
				break;
			case 8:	spaceController.init();
			break;

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
	

}
