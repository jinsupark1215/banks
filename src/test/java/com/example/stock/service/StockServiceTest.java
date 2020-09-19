package com.example.stock.service;

import com.Jinsu.stock.Repository.StockRepository;
import com.Jinsu.stock.service.IStockService;
import com.Jinsu.stock.service.StockService;
import com.Jinsu.stock.util.GetAPI;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {StockService.class, StockRepository.class, GetAPI.class})
public class StockServiceTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Qualifier("stockService")
    @Autowired
    private IStockService stockService;

    @Test
    public void testStockService() throws Exception {
        logger.debug("result==>" + stockService.stockService("AAPL"));
    }

    @Test
    public void testGetNameList() throws Exception {
        logger.debug("result==>" + stockService.getNameList());
    }
}
