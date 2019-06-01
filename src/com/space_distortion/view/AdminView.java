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
			System.out.println("1. 일반 회원조회");
			System.out.println("2. 방에 대한 정보");
			System.out.println("3. 예약 정보");
			System.out.println("4. Inventory");
			System.out.println("5. 일매출");
			System.out.println("6. 음료");
			System.out.println("7. 회원 이름 조회");
			System.out.println("8. 생성");	
			System.out.println("9. 관리자 회원 전부 출력");	
			System.out.println("10. 관리자 회원 이름으로 찾기");	
			System.out.println("11. 관리자 회원코드로 회원 삭제");	
			System.out.println("12. 관리자 회원 전부 출력");	
			System.out.println("13. 음료/과자 모두 검색");
			System.out.println("14. 음료 과자 판별");
			System.out.println("15. 음료나 과자 수량 수정");
			System.out.println("16. 음료나 과자 삭제");

			System.out.print("번호 입력 : ");
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
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		return memberName;
	}
	public int searchMemberKey()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("회원코드 입력 : ");
		int memberCode = sc.nextInt();
		return memberCode;
	}
	
	public int searchSnackIndex()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("과자 :1 / 음료 2  입력 : ");
		int snackIndex = sc.nextInt();
		return snackIndex;
	}
	
	public int searchSnackQuntity()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("수량 입력 : ");
		int snackQuntity = sc.nextInt();
		return snackQuntity;
	}
	

	public String searchSnackName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("스낵 이름 입력 : ");
		String snackName = sc.next();
		return snackName;
	}
	
	
	

}
