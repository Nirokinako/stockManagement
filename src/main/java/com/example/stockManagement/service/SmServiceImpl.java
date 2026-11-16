package com.example.stockManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockManagement.entity.Stock;
import com.example.stockManagement.repository.SmRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SmServiceImpl implements SmService {

	private final SmRepository sr;
	
	@Override
	@Transactional(readOnly = true)
	public List<Stock> findAll(){
		
		List<Stock> list = sr.selectListAll();
		
		return list;
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Stock> findStock(String stockName){
		
		List <Stock> stockResult = sr.selectListStock(stockName);
		
		return stockResult;
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Stock> showStock(Long stockId){
		
		List<Stock> showStock = sr.selectEditStock(stockId);
		
		return showStock;
		
	}
	
	@Override
	public void registerStock(Stock stock) {
		
		sr.insertStock(stock);
		
	}
	
	
	@Override
	//@Transactional(readOnly = true)
	public void updateStock(Stock stock){
		
		sr.updateStock(stock);
		
	}
	
	
	@Override
	public void deleteStock(Long stockId){
		
		sr.deleteStock(stockId);
		
	}
}
