package com.Jinsu.stock.service;

import java.util.List;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksImfomation;
import com.Jinsu.stock.domain.StocksName;

public interface IStockService {

	Answer stockService(String name);
	List<StocksName> getNameList();
}
