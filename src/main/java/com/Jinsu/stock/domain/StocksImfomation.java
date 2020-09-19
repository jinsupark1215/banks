package com.Jinsu.stock.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

//lombok 활용~
@JsonIgnoreProperties(ignoreUnknown = true)
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
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	protected LocalDate date;
	protected double high;
	protected double low;
	protected double open;
	protected double close;

	public StocksImfomation() {

	}

	public StocksImfomation(LocalDate date, double high, double low, double open, double close) {
		this.date = date;
		this.high = high;
		this.low = low;
		this.open = open;
		this.close = close;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "StocksImfomation{" +
				"date=" + date +
				", high=" + high +
				", low=" + low +
				", open=" + open +
				", close=" + close +
				'}';
	}
}
