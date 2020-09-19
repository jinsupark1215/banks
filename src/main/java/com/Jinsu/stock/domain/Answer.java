package com.Jinsu.stock.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Answer implements Serializable{

	protected LocalDate purchase;
	protected LocalDate selling;
	protected List<StocksImfomation> stocksImfomationList;
	
	
	public Answer(LocalDate purchase, LocalDate selling, List<StocksImfomation> stocksImfomationList) {
		super();
		this.purchase = purchase;
		this.selling = selling;
		this.stocksImfomationList = stocksImfomationList;
	}
	@Override
	public String toString() {
		return "Answer [purchase=" + purchase + ", selling=" + selling + ", stocksInformationList=" + stocksImfomationList + "]";
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
	public List<StocksImfomation> getStocksInformationList() {
		return stocksImfomationList;
	}
	public void setStocksImfomationList(List<StocksImfomation> stocksImfomationList) {
		this.stocksImfomationList = stocksImfomationList;
	}
}
