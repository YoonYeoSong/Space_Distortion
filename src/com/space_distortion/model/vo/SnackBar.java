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
	private int snackQty = 1;
	private String snackKind;
	
	public SnackBar() {
		// 기본 생성자
	}
	
	public SnackBar(int snackBarIndex, String snack, int snackQuantity, int snackPrice, String snackComment,
			int snackQty, String snackKind) {
		super();
		this.snackBarIndex = snackBarIndex;
		this.snack = snack;
		this.snackQuantity = snackQuantity;
		this.snackPrice = snackPrice;
		this.snackComment = snackComment;
		this.snackQty = snackQty;
		this.snackKind = snackKind;
	}

	public SnackBar(int snackBarIndex, String snack, int snackQuantity, int snackPrice, String snackComment,
			int snackQty) {
		super();
		this.snackBarIndex = snackBarIndex;
		this.snack = snack;
		this.snackQuantity = snackQuantity;
		this.snackPrice = snackPrice;
		this.snackComment = snackComment;
		this.snackQty = snackQty;
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
	
	public SnackBar(int snackBarIndex, String snack, int snackQuantity, int snackPrice, String snackKind, String snackComment) {
		super();
		this.snackBarIndex = snackBarIndex;
		this.snack = snack;
		this.snackQuantity = snackQuantity;
		this.snackPrice = snackPrice;
		this.snackComment = snackComment;
		this.snackKind = snackKind;
	}

	public String getSnackKind() {
		return snackKind;
	}

	public void setSnackKind(String snackKind) {
		this.snackKind = snackKind;
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
	
	public int getSnackQty() {
		return snackQty;
	}

	public void setSnackQty(int snackQty) {
		this.snackQty = snackQty;
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
				+ ", snackPrice=" + snackPrice + ", snackComment=" + snackComment + ", snackQty=" + snackQty
				+ ", snackKind=" + snackKind + "]";
	}

	
}