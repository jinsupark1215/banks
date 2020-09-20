package com.Jinsu.stock.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.context.annotation.Description;

@Description("회사 이름 domain")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StocksName {
    String symbol;
    String name;

	public StocksName() {
    }

    public StocksName(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StocksName{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean contains(String input) {
        return this.name.toLowerCase().contains(input.toLowerCase());
    }
}
