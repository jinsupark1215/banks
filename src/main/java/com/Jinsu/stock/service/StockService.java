package com.Jinsu.stock.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.Jinsu.stock.Repository.IStockRepository;
import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksImfomation;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class StockService implements IStockService{

	private static final Logger log = LoggerFactory.getLogger(StockService.class);
	
	@Value("${iexcloud.site}")
	private String site;
	@Value("${iexcloud.token}")
	private String token;
	
	@Autowired
	private IStockRepository stockRepository;
	
	/*
	 * 
	@Autowired
	public StockService(IStockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	 */

	@Override
	public Answer stockService(String name) {
		// api token 보내서 긁어오기
		
		
		Answer ans = stockRepository.getstock(getAPI(site + name + token));
		System.out.println("서비스  Answer  " + ans.toString());
		return ans;
	}

	@Override
	public List<StocksImfomation> getAPI(String site) {
		List<StocksImfomation> list = new ArrayList<StocksImfomation>();
		
		//api 없는 회사주식인 경우 ,  오류 체크하기!!!!!!!
        try {
 
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);
 
            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);
 
 
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(site).build();
 
            //이 한줄의 코드로 API를 호출해 list타입으로 전달 받는다.
            ResponseEntity<List> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, List.class);
            List<Map<String,String>> tmp = new ArrayList<Map<String,String>>();
            for (int i = 0; i < result.getBody().size(); i++) {
            	LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) result.getBody().get(i);
            StocksImfomation si = new StocksImfomation(String.valueOf(map.get("date")), 
            		String.valueOf(map.get("open")),
            				String.valueOf(map.get("close")), 
            						String.valueOf(map.get("high")),
            								String.valueOf(map.get("low")),
            										String.valueOf(map.get("volume")),
            												String.valueOf(map.get("uOpen")),
            														String.valueOf(map.get("uClose")),
            																String.valueOf(map.get("uHigh")),
            																		String.valueOf(map.get("uLow")),
            																				String.valueOf(map.get("uVolume")),
            																						String.valueOf(map.get("change")),
            																								String.valueOf(map.get("changePercent")), 
            																										String.valueOf(map.get("label")),
            																												String.valueOf(map.get("changeOverTime")));
            list.add(si);
				
			}


           // list = result.getBody();
 
            //
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.toString());
 
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		
		return list;
	}

	
}
