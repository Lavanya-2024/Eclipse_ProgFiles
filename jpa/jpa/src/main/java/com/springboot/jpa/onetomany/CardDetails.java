package com.springboot.jpa.onetomany;

public class CardDetails {
	private long cardid;
	private String cardType;//credit/debit
	private String cardnumber;
	private String nameonthecard;
	
	private User user;
	public long getCardid() {
		return cardid;
	}
	public void setCardid(long cardid) {
		this.cardid = cardid;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getNameonthecard() {
		return nameonthecard;
	}
	public void setNameonthecard(String nameonthecard) {
		this.nameonthecard = nameonthecard;
	}
	

}
