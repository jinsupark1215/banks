package com.Jinsu.stock.domain;

import java.io.Serializable;

public class Answer implements Serializable{

	protected String purchase;
	protected String selling;
	
	
	public Answer(String purchase, String selling) {
		super();
		this.purchase = purchase;
		this.selling = selling;
	}
	@Override
	public String toString() {
		return "Answer [purchase=" + purchase + ", selling=" + selling + "]";
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public String getSelling() {
		return selling;
	}
	public void setSelling(String selling) {
		this.selling = selling;
	}
}
