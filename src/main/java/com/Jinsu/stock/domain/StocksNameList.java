package com.Jinsu.stock.domain;

import java.util.List;

import org.springframework.context.annotation.Description;

@Description("회사이름 리스트 domain")
public class StocksNameList {
    List<StocksName> stocksNameList;

    public List<StocksName> getStocksNameList() {
        return stocksNameList;
    }

    public void setStocksNameList(List<StocksName> stocksNameList) {
        this.stocksNameList = stocksNameList;
    }

    @Override
    public String toString() {
        return "StocksNameList{" +
                "stocksNameList=" + stocksNameList +
                '}';
    }
}
