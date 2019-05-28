package com.space_distortion.model.vo;

//룸에 대한 정보
public class RoomInfo {

	private int roomNumber;  // 룸 번호
	private String roomName; // 룸 이름
	private final int[] MAX_PPL = {1,2,3,4,5,6,7,8};  // 최대 수용인원 인원 1부터 시작
	private int curPpl;  // 현재 인원
	private int remTime = 0;  // 남은시간
	private int startTime = 0; // 시작시간
	private String tool = "";  //랜덤으로 방마다 장비를 뿌린다
	
	

	
}
