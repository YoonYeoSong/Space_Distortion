package com.space_distortion.model.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {

	
	private List adminPaymentList; // �����ڿ� ���¹� ���� ����Ʈ
	private List adminTotalPaymentList; // �����ڿ� ��� ���� ����Ʈ(�����)
	private List adminRoomInfoList;
	private List<SnackBar> adminSnackBarList; // �����ڿ� ���� ����Ʈ
	private Map adminMemberMap; // �����ڿ� ��� ��
	
	// ��ȸ��
	
	
	public Admin() 
	{
		adminPaymentList = new ArrayList();
		adminTotalPaymentList = new ArrayList();
		adminRoomInfoList = new ArrayList();
		adminSnackBarList = new ArrayList<SnackBar>();
		adminMemberMap = new HashMap();
	}
	
	

	public Admin(List adminPaymentList, List adminTotalPaymentList, List adminRoomInfoList, List adminSnackBarList,
			Map adminMemberMap) {
		super();
		this.adminPaymentList = adminPaymentList;
		this.adminTotalPaymentList = adminTotalPaymentList;
		this.adminRoomInfoList = adminRoomInfoList;
		this.adminSnackBarList = adminSnackBarList;
		this.adminMemberMap = adminMemberMap;
	}



	public List getAdminPaymentList() {
		return adminPaymentList;
	}

	public void setAdminPaymentList(List adminPaymentList) {
		this.adminPaymentList = adminPaymentList;
	}

	public List getAdminTotalPaymentList() {
		return adminTotalPaymentList;
	}

	public void setAdminTotalPaymentList(List adminTotalPaymentList) {
		this.adminTotalPaymentList = adminTotalPaymentList;
	}

	public List getAdminRoomInfoList() {
		return adminRoomInfoList;
	}

	public void setAdminRoomInfoList(List adminRoomInfoList) {
		this.adminRoomInfoList = adminRoomInfoList;
	}

	public List getAdminSnackBarList() {
		return adminSnackBarList;
	}

	public void setAdminSnackBarList(List adminSnackBarList) {
		this.adminSnackBarList = adminSnackBarList;
	}

	public Map getAdminMemberMap() {
		return adminMemberMap;
	}

	public void setAdminMemberMap(Map adminMemberMap) {
		this.adminMemberMap = adminMemberMap;
	}
	
	public void totalPrint()
	{
		
	}
	
	
}
