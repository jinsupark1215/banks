package com.Jinsu.stock.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Answer implements Serializable{

	protected LocalDate purchase;
	protected LocalDate selling;
	protected List<StocksInfomation> stocksInfomationList;
	
	
	public Answer(LocalDate purchase, LocalDate selling, List<StocksInfomation> stocksInfomationList) {
		super();
		this.purchase = purchase;
		this.selling = selling;
		this.stocksInfomationList = stocksInfomationList;
	}
	@Override
	public String toString() {
		return "Answer [purchase=" + purchase + ", selling=" + selling + ", stocksInformationList=" + stocksInfomationList + "]";
	}
	public LocalDate getPurchase() {
		return purchase;
	}
	public void setPurchase(LocalDate purchase) {
		this.purchase = purchase;
	}
	public LocalDate getSelling() {
		return selling;
	}
	public void setSelling(LocalDate selling) {
		this.selling = selling;
	}
	public List<StocksInfomation> getStocksInformationList() {
		return stocksInfomationList;
	}
	public void setStocksImfomationList(List<StocksInfomation> stocksInfomationList) {
		this.stocksInfomationList = stocksInfomationList;
	}
}
