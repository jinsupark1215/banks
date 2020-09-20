package com.Jinsu.stock.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksInfomation;
import com.Jinsu.stock.util.GetAPI;
import com.Jinsu.stock.util.GetAlgorithm;

@Repository("stockRepository")
public class StockRepository implements IStockRepository{

	private static final Logger log = LoggerFactory.getLogger(StockRepository.class);

	@Autowired
	private GetAlgorithm getAlgorithm;
	
	@Description("알고리즘 활용 답 도출")
	@Override
	public Answer getstock(List<StocksInfomation> list) {
		Answer answer = null;
		if(list.size() != 0) {
			//api 정상작동 시
			answer = getAlgorithm.getAlgorithm(list);
		}
		return answer;
		
	}

}
