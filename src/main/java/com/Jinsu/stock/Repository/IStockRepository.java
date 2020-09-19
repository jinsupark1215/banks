package com.Jinsu.stock.Repository;

import java.util.List;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksImfomation;

public interface IStockRepository {

	Answer getstock(List<StocksImfomation> list);
}
