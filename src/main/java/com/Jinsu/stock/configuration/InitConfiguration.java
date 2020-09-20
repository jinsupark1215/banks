package com.Jinsu.stock.configuration;

import com.Jinsu.stock.domain.StocksName;
import com.Jinsu.stock.domain.StocksNameList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Description("회사이름 json 파일 얻어오기")
@Configuration
public class InitConfiguration {
    @Value("${stocks.name.list.file}")
    private String stocksNameListFileName;

    @Bean
    public StocksNameList getStocksNameList() {
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
        StocksNameList stocksNameList = new StocksNameList();
        stocksNameList.setStocksNameList(nameList);
        return stocksNameList;
    }
}
