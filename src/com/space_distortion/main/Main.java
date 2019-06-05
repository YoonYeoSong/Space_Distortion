package com.space_distortion.main;

import com.space_distortion.controller.SpaceController;

//메인클래스
public class Main {

	private static SpaceController spaceController = new SpaceController();
	
	public static SpaceController getSpaceController()
	{
		
		// 테스트
		return spaceController;
	}
	
	
	public static void main(String[] args) {
		
		spaceController.mainView();
		//spaceController.mainConsolView();
	}

}
