package com.Jinsu.stock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.service.IStockService;

@CrossOrigin(origins = { "*" })
@RestController
public class StockController {
	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	private IStockService stockService;
	
	/*
	 * 
	@Autowired
	public StockController(IStockService stockService) {
		this.stockService = stockService;
	}
	 */
	
	@GetMapping(path="stock/{name}")
	public Answer GetStock(@PathVariable String name) {
		Assert.notNull(name, " 기업이름 반드시 필요!");
		
		System.out.println("컨트롤");
		Answer answer = this.stockService.stockService(name);
		System.out.println("컨트롤  Answer  " + answer.toString());
		return answer;
	}
}
