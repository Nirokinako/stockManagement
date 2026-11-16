package com.example.stockManagement.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stockManagement.entity.Stock;
import com.example.stockManagement.service.SmServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stockSearch")
public class SmController {

	private final SmServiceImpl ss;
	
	/*
	 * 在庫検索フォーム表示
	 */
	@GetMapping("/search-form")
	private String formDisplay() {
		return "search-form";
	}
	
	/*
	 * 全件表示
	 */
	@PostMapping("/search-all-result")
	private String resultDisplay(Model model) {
		
		List<Stock> list = ss.findAll();
		
		model.addAttribute("stockList" ,list);
		
		return "search-form";
	}
	
	/*
	 * 在庫検索
	 */
	@PostMapping("/search-stock-result")
	private String stockResultDisplay(@RequestParam String stockName, Model model) {
		
		List<Stock> stockResult = ss.findStock(stockName);
		
		/*
		 * データが渡されているかチェック
		 */
		if(stockResult != null) {
			System.out.println("stock中身：" + stockResult);
		} else {
			System.out.println("データが格納されていません！！");
		}
		
		model.addAttribute("ssResult", stockResult);
		
		return "search-form";
	}
	
	/*
	 * 在庫編集(検索→編集画面表示)
	 */
	@GetMapping("/{stockId}/edit")
	private String editDisplay(@PathVariable Long stockId, Model model) {
		
		List<Stock> stockEditResult = ss.showStock(stockId);
		/*
		 * データが渡されているかチェック
		 */
		if(stockEditResult != null) {
			System.out.println("stock中身(ID指定)：" + stockEditResult);
		} else {
			System.out.println("データが格納されていません！！");
		}
		
		model.addAttribute("seResult", stockEditResult);
		
		return "edit-stock";
	}
	
	/*
	 * 在庫登録（画面表示）
	 */
	@PostMapping("/register-form")
	private String registerDisplay() {
		return "register-form";
	}
	
	/*
	 * 在庫登録(登録)
	 */
	@PostMapping("/insert")
	private String insertStockDisplay(Stock stock) {
		ss.registerStock(stock);
		return "register-result";
	}
	
	/*
	 * 在庫編集（更新）
	 */
	@PostMapping("/edit")
	private String editStock(Stock stock) {
		
		ss.updateStock(stock);
		
		return "edit-result";
	}
	
	/*
	 * 在庫編集（削除確認）
	 */
	@GetMapping("/{stockId}/delete")
	private String deleteStock(@PathVariable Long stockId) {
		
		ss.deleteStock(stockId);
		
		return "delete-result";
	}
}
