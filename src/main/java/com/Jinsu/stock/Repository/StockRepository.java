package com.Jinsu.stock.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksInfomation;

@Repository("stockRepository")
public class StockRepository implements IStockRepository{

	private static final Logger log = LoggerFactory.getLogger(StockRepository.class);
	
	/*
	 * 
	@Autowired
	public StockRepository() {
		
	}
	 */

	@Override
	public Answer getstock(List<StocksInfomation> list) {
		// 알고리즘 사용해서 답 도출 ~ ( 구간합)?
		int HighIdx = 0;
		int LowIdx = 0;
		int ansLowIdx = 0;
		int ansHighIdx = 0;
		double MaxGain = 0;
		double MaxHigh = 0;
		double MaxLow = Double.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			StocksInfomation si = list.get(i);
			if(MaxLow > si.getLow()) {
				MaxLow = si.getLow();
				LowIdx = i;
			}
			if(MaxHigh < si.getHigh()) {
				MaxHigh = si.getHigh();
				HighIdx = i;
			}
			if(LowIdx <= HighIdx) {
				MaxGain = Math.max(MaxGain, MaxHigh - MaxLow);
				ansLowIdx = LowIdx;
				ansHighIdx = HighIdx;
			}
		}
		Answer answer = new Answer(list.get(ansLowIdx).getDate(),list.get(ansHighIdx).getDate(), list);
		return answer;
	}

}
