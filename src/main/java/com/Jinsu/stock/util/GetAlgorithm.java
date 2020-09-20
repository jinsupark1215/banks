package com.Jinsu.stock.util;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksInfomation;

@Component
public class GetAlgorithm {

	@Description("알고리즘 시간복잡도 : O(N)")
	public Answer getAlgorithm(List<StocksInfomation> list) {
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
		int percent = (int) (((list.get(ansHighIdx).getHigh() * 100)/list.get(ansLowIdx).getLow())-100);
		Answer answer = new Answer(list.get(ansLowIdx).getDate(),list.get(ansHighIdx).getDate(),
				list.get(ansLowIdx).getLow(), list.get(ansHighIdx).getHigh(), percent,list);
		
		return answer;
	}
}
