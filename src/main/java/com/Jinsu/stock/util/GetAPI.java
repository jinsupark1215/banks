package com.Jinsu.stock.util;

import com.Jinsu.stock.domain.StocksImfomation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAPI {
    public List<StocksImfomation> getPriceAPI(String site) {
        List<StocksImfomation> list = new ArrayList<StocksImfomation>();

        //api 없는 회사주식인 경우 ,  오류 체크하기!!!!!!!
        try {

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);

            ResponseEntity<String> result = restTemplate.getForEntity(site, String.class);
            ObjectMapper objectMapper = new ObjectMapper();

            list = objectMapper.readValue(result.getBody(), new TypeReference<List<StocksImfomation>>() {});
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return list;
    }
}
