package com.example.stock.util;

import com.Jinsu.stock.Repository.IStockRepository;
import com.Jinsu.stock.Repository.StockRepository;
import com.Jinsu.stock.service.StockService;
import com.Jinsu.stock.util.GetAPI;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {GetAPI.class})
public class GetAPITest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${iexcloud.price.site}")
    private String priceSite;
    @Value("${iexcloud.price.token}")
    private String token;
    @Autowired
    private GetAPI getAPI;

    @Test
    public void testGetPriceAPI() throws Exception {
        logger.debug("result===>" + getAPI.getPriceAPI(priceSite + "AAPL" + token));
    }
}
