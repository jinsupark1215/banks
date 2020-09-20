package com.Jinsu.stock.controller;

import com.Jinsu.stock.domain.StocksName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.service.IStockService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StockController {
	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	@Qualifier("stockService")
	@Autowired
	private IStockService stockService;
	
	@Description("회사 symbol로 6개월 간의 기록 호출")
	@GetMapping(path="stock/{name}")
	public Answer getStock(@PathVariable(required = true) String name) {
		Answer answer = this.stockService.stockService(name);
		return answer;
	}

	@Description("회사이름 기준으로 검색리스트 추가")
	@GetMapping(path="stock/search/{input}")
	public List<StocksName> searchName(@PathVariable(required = true) String input) {
		List<StocksName> nameList = this.stockService.searchName(input);
		return nameList;
	}
}
