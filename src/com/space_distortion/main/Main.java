package com.space_distortion.main;

import com.space_distortion.controller.SpaceController;

//메인클래스
public class Main {

	static SpaceController spaceController = new SpaceController();
	
	public static SpaceController getSpaceController()
	{
		return spaceController;
	}
	
	
	public static void main(String[] args) {
		
		//spaceController.mainView();
		spaceController.mainConsolView();
	}

}
