package com.Jinsu.stock.domain;

import java.util.ArrayList;
import java.util.List;

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
