package com.Jinsu.stock.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Description;

@Description("알고리즘 결과 domain")
public class Answer implements Serializable{

	protected LocalDate purchase;
	protected LocalDate selling;
	protected double purchasePrice;
	protected double sellingPrice;
	protected int percent;
	
	
	public Answer(LocalDate purchase, LocalDate selling, double purchasePrice, double sellingPrice, int percent,
			List<StocksInfomation> stocksInfomationList) {
		super();
		this.purchase = purchase;
		this.selling = selling;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.percent = percent;
		this.stocksInfomationList = stocksInfomationList;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	protected List<StocksInfomation> stocksInfomationList;
	
	
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
