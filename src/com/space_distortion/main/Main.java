package com.space_distortion.main;

import com.space_distortion.controller.SpaceController;

//����Ŭ����
public class Main {

	private static SpaceController spaceController = new SpaceController();
	
	public static SpaceController getSpaceController()
	{
		
		// �׽�Ʈ
		return spaceController;
	}
	
	
	public static void main(String[] args) {
		
		spaceController.mainView();
		//spaceController.mainConsolView();
	}

}
