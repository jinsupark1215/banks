package com.Jinsu.stock.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//lombok 활용~
public class StocksImfomation implements Serializable{

	/*
	 * date					/ string   / 	Formatted as YYYY-MM-DD
		high					/ number/ 	Adjusted data for historical dates. Split adjusted only.
		low					/number/  	Adjusted data for historical dates. Split adjusted only.
		volume				/number/	Adjusted data for historical dates. Split adjusted only.
		open					/number/	Adjusted data for historical dates. Split adjusted only.
		close					/number/	Adjusted data for historical dates. Split adjusted only.
		uHigh				/number	/	Unadjusted data for historical dates.
		uLow					/number/	Unadjusted data for historical dates.
		uVolume				/number/	Unadjusted data for historical dates.
		uOpen				/number/	Unadjusted data for historical dates.
		uClose				/number/	Unadjusted data for historical dates.
		changeOverTime	/number/	Percent change of each interval relative to first value. Useful for comparing multiple stocks.
		label					/number/	A human readable format of the date depending on the range.
		change				/number	/Change from previous trading day.
		changePercent	/number/	Change percent from previous trading day.
	 */
	protected String date;
	protected double open;
	protected double close;
	protected double high;
	protected double low;
	protected double volume;
	protected double uOpen;
	protected double uClose;
	protected double uHigh;
	protected double uLow;
	protected double uVolume;
	protected double change;
	protected double changePercent;
	protected String label;
	protected double changeOverTime;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getuOpen() {
		return uOpen;
	}

	public void setuOpen(double uOpen) {
		this.uOpen = uOpen;
	}

	public double getuClose() {
		return uClose;
	}

	public void setuClose(double uClose) {
		this.uClose = uClose;
	}

	public double getuHigh() {
		return uHigh;
	}

	public void setuHigh(double uHigh) {
		this.uHigh = uHigh;
	}

	public double getuLow() {
		return uLow;
	}

	public void setuLow(double uLow) {
		this.uLow = uLow;
	}

	public double getuVolume() {
		return uVolume;
	}

	public void setuVolume(double uVolume) {
		this.uVolume = uVolume;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public double getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getChangeOverTime() {
		return changeOverTime;
	}

	public void setChangeOverTime(double changeOverTime) {
		this.changeOverTime = changeOverTime;
	}

	public StocksImfomation(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8,
			Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15) {
		super();
		this.date = (String) object;
		this.open = Double.valueOf((String) object2);
		this.close = Double.valueOf((String) object3);
		this.high = Double.valueOf((String) object4);
		this.low = Double.valueOf((String) object5);
		this.volume = Double.valueOf((String)  object6);
		this.uOpen = Double.valueOf((String) object7);
		this.uClose = Double.valueOf((String)  object8);
		this.uHigh = Double.valueOf((String) object9);
		this.uLow = Double.valueOf((String) object10);
		this.uVolume = Double.valueOf((String) object11);
		this.change = Double.valueOf((String)  object12);
		this.changePercent = Double.valueOf((String) object13);
		this.label = (String) object14;
		this.changeOverTime = Double.valueOf((String)  object15);
	}
}
