package com.example.stock.controller;

import com.Jinsu.stock.Repository.StockRepository;
import com.Jinsu.stock.controller.StockController;
import com.Jinsu.stock.service.StockService;
import com.Jinsu.stock.util.GetAPI;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {StockController.class, StockService.class, StockRepository.class, GetAPI.class})
public class StockControllerTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StockController stockController;

    @Test
    public void testGetStock() throws Exception {
        logger.debug("result==>" + stockController.getStock("AAPL"));
    }

    @Test
    public void testGetNameList() throws Exception {
        logger.debug("result==>" + stockController.getNameList());
    }
}
