package assignment2;

import java.sql.Timestamp;

public class Transaction {

	private Integer id;

	private String nameOnCard;

	private String cardNo;

	private Float unitPrice;

	private Integer quantity;

	private Float totalPrice;

	private String expDate;

	private Timestamp createdOn;

	private String createdBy;

	private String cardType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[id:");
		sb.append(id);
		sb.append(" ,nameOnCard:");
		sb.append(nameOnCard);
		sb.append(" ,cardNo:");
		sb.append(cardNo);
		sb.append(" ,unitPrice:");
		sb.append(unitPrice);
		sb.append(" ,quantity:");
		sb.append(quantity);
		sb.append(" ,totalPrice:");
		sb.append(totalPrice);
		sb.append(" ,expDate:");
		sb.append(expDate);
		sb.append(" ,createdOn:");
		sb.append(createdOn);
		sb.append(" ,createdBy:");
		sb.append(createdBy);
		sb.append(" ,cardType:");
		sb.append(cardType);
		sb.append("]");
		return sb.toString();

	}
}
