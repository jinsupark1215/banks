package com.Jinsu.stock.service;

import com.Jinsu.stock.domain.StocksName;
import com.Jinsu.stock.domain.StocksNameList;
import com.Jinsu.stock.util.GetAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Jinsu.stock.Repository.IStockRepository;
import com.Jinsu.stock.domain.Answer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service("stockService")
public class StockService implements IStockService{

	private static final Logger log = LoggerFactory.getLogger(StockService.class);
	
	@Value("${iexcloud.price.site}")
	private String priceSite;
	@Value("${iexcloud.price.token}")
	private String token;

	@Qualifier("stockRepository")
	@Autowired
	private IStockRepository stockRepository;

	@Autowired
	private GetAPI getAPI;

	@Autowired
	private StocksNameList stocksNameList;

	@Override
	public Answer stockService(String name) {
		// api token 보내서 긁어오기
		Answer ans = stockRepository.getstock(getAPI.getPriceAPI(priceSite + name + token));
		return ans;
	}

	@Override
	public List<StocksName> searchName(String input) {
		List<StocksName> nameList = new ArrayList<>();
		for(StocksName stocksName : stocksNameList.getStocksNameList()) {
			if(stocksName.contains(input)) {
				nameList.add(stocksName);
			}
		}
		return nameList;
	}
}
