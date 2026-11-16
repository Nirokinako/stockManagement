package com.example.stockManagement.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.stockManagement.entity.Stock;

@Mapper
public interface SmRepository {

	//全件取得
	List<Stock> selectListAll();
	
	//在庫検索
	List<Stock> selectListStock(String stockName);
	
	//在庫登録
	void insertStock(Stock stock);
	
	//在庫編集（検索）
	List<Stock> selectEditStock(Long stockId);
	
	//在庫編集（更新）
	void updateStock(Stock stock);
	
	//在庫編集（削除）
	void deleteStock(Long id);
}
