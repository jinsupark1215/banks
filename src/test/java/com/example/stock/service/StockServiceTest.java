package com.example.stock.service;

import com.Jinsu.stock.Repository.StockRepository;
import com.Jinsu.stock.configuration.InitConfiguration;
import com.Jinsu.stock.domain.StocksNameList;
import com.Jinsu.stock.service.IStockService;
import com.Jinsu.stock.service.StockService;
import com.Jinsu.stock.util.GetAPI;
import com.example.stock.configuration.InitConfigurationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = {StockService.class, StockRepository.class, GetAPI.class})
@Import(InitConfigurationTest.class)
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
    public void testSearchName() throws Exception {
        logger.debug("result==>" + stockService.searchName("A"));
    }
}
