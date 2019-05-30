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
			System.out.println("1. 회원조회");
			System.out.println("2. 방에 대한 정보");
			System.out.println("3. 예약 정보");
			System.out.println("4. Inventory");
			System.out.println("5. 일매출");
			System.out.println("6. 끝내기");
			System.out.println("7. 회원 이름 조회");
			System.out.println("8. 생성");	
			System.out.print("번호 입력 : ");
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
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		return memberName;
	}
	

}
