package com.Jinsu.stock.service;

import com.Jinsu.stock.domain.StocksName;
import com.Jinsu.stock.util.GetAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${stocks.name.list.file}")
	private String stocksNameListFileName;

	@Qualifier("stockRepository")
	@Autowired
	private IStockRepository stockRepository;

	@Autowired
	private GetAPI getAPI;

	@Override
	public Answer stockService(String name) {
		// api token 보내서 긁어오기
		Answer ans = stockRepository.getstock(getAPI.getPriceAPI(priceSite + name + token));
		return ans;
	}

	@Override
	public List<StocksName> getNameList() {
		ClassPathResource resource = new ClassPathResource(stocksNameListFileName);
		List<StocksName> nameList;
		try {
			Path path = Paths.get(resource.getURI());
			String jsonString = Files.readAllLines(path).get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			nameList = objectMapper.readValue(jsonString, new TypeReference<List<StocksName>>() {});
		} catch (IOException e) {
			nameList = new ArrayList<>();
		}
		return nameList;
	}
}
