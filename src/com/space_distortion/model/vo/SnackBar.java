package com.space_distortion.model.vo;

public class SnackBar {

	// 간식 종류
	// 은료 : 커피(5종류), 음료(10 종류)
	// 과자 : 과자(12 종류)
	private int snackBarIndex;
	private String snack;
	private int snackQuantity;
	private int snackPrice;
	private String snackComment;
	
	public SnackBar() {
		// 기본 생성자
	}

	public SnackBar(int snackBarIndex, String snack, int snackQuantity, int snackPrice, String snackComment) {
		super();
		this.snackBarIndex = snackBarIndex;
		this.snack = snack;
		this.snackQuantity = snackQuantity;
		this.snackComment = snackComment;
		this.snackPrice = snackPrice;
	}
	
	public SnackBar(int snackBarIndex, String snack, int snackQuantity, int snackPrice) {
		super();
		this.snackBarIndex = snackBarIndex;
		this.snack = snack;
		this.snackQuantity = snackQuantity;
		this.snackPrice = snackPrice;
	}

	public int getSnackBarIndex() {
		return snackBarIndex;
	}

	public void setSnackBarIndex(int snackBarIndex) {
		this.snackBarIndex = snackBarIndex;
	}

	public String getSnack() {
		return snack;
	}

	public void setSnack(String snack) {
		this.snack = snack;
	}

	public int getSnackQuantity() {
		return snackQuantity;
	}

	public void setSnackQuantity(int snackQuantity) {
		this.snackQuantity = snackQuantity;
	}

	public String getSnackComment() {
		return snackComment;
	}

	public void setSnackComment(String snackComment) {
		this.snackComment = snackComment;
	}

	public int getSnackPrice() {
		return snackPrice;
	}

	public void setSnackPrice(int snackPrice) {
		this.snackPrice = snackPrice;
	}

	@Override
	public boolean equals(Object obj) {
		SnackBar sb;
		
		if(obj instanceof SnackBar)
		{
			sb = (SnackBar)obj;
			if(snack.equals(sb.getSnack()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return "SnackBar [snackBarIndex=" + snackBarIndex + ", snack=" + snack + ", snackQuantity=" + snackQuantity
				+ ", snackPrice=" + snackPrice + ", snackComment=" + snackComment + "]";
	}

}