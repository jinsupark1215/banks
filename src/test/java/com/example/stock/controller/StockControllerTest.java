package com.example.stock.controller;

import com.Jinsu.stock.Repository.StockRepository;
import com.Jinsu.stock.configuration.InitConfiguration;
import com.Jinsu.stock.controller.StockController;
import com.Jinsu.stock.domain.StocksNameList;
import com.Jinsu.stock.service.StockService;
import com.Jinsu.stock.util.GetAPI;
import com.example.stock.configuration.InitConfigurationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;

@Description("Controller test")
@SpringBootTest(classes = {StockController.class, StockService.class, StockRepository.class, GetAPI.class})
@Import(InitConfigurationTest.class)
public class StockControllerTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StockController stockController;

    @Test
    public void testGetStock() throws Exception {
        logger.debug("result==>" + stockController.getStock("AAPL"));
    }

    @Test
    public void testSearchName() throws Exception {
        logger.debug("result==>" + stockController.searchName("A"));
    }
}
