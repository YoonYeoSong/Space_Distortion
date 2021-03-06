package com.space_distortion.model.vo;

//룸에 대한 정보


public class RoomInfo {

    private int roomNumber;  // 룸 번호
    private String roomName; // 룸 이름
    private int maxPpl;  // 최대 수용인원 인원 1부터 시작
    private String lightProjecter;  // 빔 1이면 true 0이면 false
    
    private int noteBook;  //랜덤으로 방마다 장비를 뿌린다
    private int remTime = 0;  // 남은시간
    private int curPpl;  // 현재 인원
    
    public RoomInfo() {
        
    }
     
    public RoomInfo(String roomName, int roomNumber, int maxPpl, String lightProjecter) {
        super();
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.maxPpl = maxPpl;
        this.lightProjecter = lightProjecter;
    }
    

    public RoomInfo(int roomNumber, String roomName,int maxPpl, int curPpl, int remTime, int noteBook, String lightProjecter) {
        super();
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.maxPpl = maxPpl;
        this.curPpl = curPpl;
        this.remTime = remTime;
        this.noteBook = noteBook;
        this.lightProjecter = lightProjecter;
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


    public int getMaxPpl() {
        return maxPpl;
    }


    public void setMaxPpl(int maxPpl) {
        this.maxPpl = maxPpl;
    }


    public String getLightProjecter() {
        return lightProjecter;
    }


    public void setLightProjecter(String lightProjecter) {
        this.lightProjecter = lightProjecter;
    }


    public int getNoteBook() {
        return noteBook;
    }


    public void setNoteBook(int noteBook) {
        this.noteBook = noteBook;
    }


    public int getRemTime() {
        return remTime;
    }


    public void setRemTime(int remTime) {
        this.remTime = remTime;
    }


    public int getCurPpl() {
        return curPpl;
    }


    public void setCurPpl(int curPpl) {
        this.curPpl = curPpl;
    }


    @Override
    public String toString() {
        return "RoomInfo [roomNumber=" + roomNumber + ", roomName=" + roomName + ", maxPpl=" + maxPpl
                + ", lightProjecter=" + lightProjecter + ", noteBook=" + noteBook + ", remTime=" + remTime + ", curPpl="
                + curPpl + "]";
    }

	

	
}
