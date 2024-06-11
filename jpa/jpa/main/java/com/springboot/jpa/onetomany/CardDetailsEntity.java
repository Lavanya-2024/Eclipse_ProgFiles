package com.springboot.jpa.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carddetails")
public class CardDetailsEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "cardid")
	private long cardid;
	@Column(name = "cardtype")
	private String cardType;//credit/debit
	@Column(name = "cardnumber")
	private String cardnumber;
	@Column(name = "nameonthecard")
	private String nameonthecard;
	
	
	@ManyToOne
    @JoinColumn(name="card_userid", nullable=false,referencedColumnName = "id")
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
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
