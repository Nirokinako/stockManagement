package com.example.stockManagement.service;

import java.util.List;

import com.example.stockManagement.entity.Stock;


public interface SmService {
	/*
	 * 全件表示
	 */
	List<Stock> findAll();
	
	/*
	 * 在庫検索
	 */
	List<Stock> findStock(String stockName);
	
	/*
	 * 在庫編集（検索）
	 */
	List<Stock> showStock(Long stockId);
	
	/*
	 * 在庫登録
	 */
	void registerStock(Stock stock);
	
	/*
	 * 在庫編集（更新）
	 */
	void updateStock(Stock stock);
	
	/*
	 * 在庫編集（削除）
	 */
	void deleteStock(Long id);
	
}
