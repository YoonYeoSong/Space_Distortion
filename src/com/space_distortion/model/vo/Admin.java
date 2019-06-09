package com.space_distortion.model.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {

	
	private Map adminMemberMap; // 관리자용 멤버 맵
	private List adminPaymentList; //페이먼트 리스트	
	private List adminRoomInfoList;   // 방정보
	private List<SnackBar> adminSnackBarList; // 관리자용 스낵 리스트
	private List<Coupon> adminCouponList; // 쿠폰 리스트
	
	// 비회원
	public Admin() 
	{
		adminPaymentList = new ArrayList();
		adminRoomInfoList = new ArrayList();
		adminSnackBarList = new ArrayList<SnackBar>();
		adminMemberMap = new HashMap();
		adminCouponList = new ArrayList<Coupon>();
	}
	
	public Admin(Map adminMemberMap, List adminPaymentList, List adminRoomInfoList, List<SnackBar> adminSnackBarList,List<Coupon> adminCouponList) {
		super();
		this.adminMemberMap = adminMemberMap;
		this.adminPaymentList = adminPaymentList;
		this.adminRoomInfoList = adminRoomInfoList;
		this.adminSnackBarList = adminSnackBarList;
		this.adminCouponList = adminCouponList;
	}


	public List<Coupon> getAdminCouponList() {
		return adminCouponList;
	}

	public void setAdminCouponList(List<Coupon> adminCouponList) {
		this.adminCouponList = adminCouponList;
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
