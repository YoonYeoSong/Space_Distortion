package com.space_distortion.model.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {

	
	private Map adminMemberMap; // �����ڿ� ��� ��
	private List adminPaymentList; //���̸�Ʈ ����Ʈ	
	private List adminRoomInfoList;   // ������
	private List<SnackBar> adminSnackBarList; // �����ڿ� ���� ����Ʈ
	
	// ��ȸ��
	
	
	public Admin() 
	{
		adminPaymentList = new ArrayList();
		adminRoomInfoList = new ArrayList();
		adminSnackBarList = new ArrayList<SnackBar>();
		adminMemberMap = new HashMap();
	}
	
	
	

	public Admin(Map adminMemberMap, List adminPaymentList, List adminRoomInfoList, List<SnackBar> adminSnackBarList) {
		super();
		this.adminMemberMap = adminMemberMap;
		this.adminPaymentList = adminPaymentList;
		this.adminRoomInfoList = adminRoomInfoList;
		this.adminSnackBarList = adminSnackBarList;
	}



	public Map getAdminMemberMap() {
		return adminMemberMap;
	}

	public void setAdminMemberMap(Map adminMemberMap) {
		this.adminMemberMap = adminMemberMap;
	}

	public List getAdminPaymentList() {
		return adminPaymentList;
	}

	public void setAdminPaymentList(List adminPaymentList) {
		this.adminPaymentList = adminPaymentList;
	}

	public List getAdminRoomInfoList() {
		return adminRoomInfoList;
	}

	public void setAdminRoomInfoList(List adminRoomInfoList) {
		this.adminRoomInfoList = adminRoomInfoList;
	}

	public List<SnackBar> getAdminSnackBarList() {
		return adminSnackBarList;
	}

	public void setAdminSnackBarList(List<SnackBar> adminSnackBarList) {
		this.adminSnackBarList = adminSnackBarList;
	}
	
	

	
	
	
	
	
}
