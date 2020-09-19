package com.Jinsu.stock.Repository;

import java.util.List;

import com.Jinsu.stock.domain.Answer;
import com.Jinsu.stock.domain.StocksInfomation;

public interface IStockRepository {

	Answer getstock(List<StocksInfomation> list);
}
