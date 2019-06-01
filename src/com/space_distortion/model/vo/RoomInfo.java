package com.space_distortion.model.vo;

//�뿡 ���� ����
public class RoomInfo {

	private int roomNumber;  // �� ��ȣ
	private String roomName; // �� �̸�
	private int maxPpl;  // �ִ� �����ο� �ο� 1���� ����
	private int curPpl;  // ���� �ο�
	private int remTime = 0;  // �����ð�
	private int noteBook;  //�������� �渶�� ��� �Ѹ���
	private int LightProjecter;  // �� 1�̸� true 0�̸� false
	
	
	
	public RoomInfo() {
		
	}

	public RoomInfo(int roomNumber, String roomName,int maxPpl, int curPpl, int remTime, int noteBook, int lightProjecter) {
		super();
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.maxPpl = maxPpl;
		this.curPpl = curPpl;
		this.remTime = remTime;
		this.noteBook = noteBook;
		this.LightProjecter = lightProjecter;
	}


	public int getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}



	public int getCurPpl() {
		return curPpl;
	}



	public void setCurPpl(int curPpl) {
		this.curPpl = curPpl;
	}



	public int getRemTime() {
		return remTime;
	}



	public void setRemTime(int remTime) {
		this.remTime = remTime;
	}



	public int getNoteBook() {
		return noteBook;
	}



	public void setNoteBook(int noteBook) {
		this.noteBook = noteBook;
	}



	public int getLightProjecter() {
		return LightProjecter;
	}



	public void setLightProjecter(int lightProjecter) {
		LightProjecter = lightProjecter;
	}

	public int getMaxPpl() {
		return maxPpl;
	}

	public void setMaxPpl(int maxPpl) {
		this.maxPpl = maxPpl;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomNumber=" + roomNumber + ", roomName=" + roomName + ", maxPpl=" + maxPpl + ", curPpl="
				+ curPpl + ", remTime=" + remTime + ", noteBook=" + noteBook + ", LightProjecter=" + LightProjecter
				+ "]";
	}
	
	

	
}
