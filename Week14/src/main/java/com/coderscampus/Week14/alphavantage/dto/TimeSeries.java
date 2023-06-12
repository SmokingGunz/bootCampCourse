package com.coderscampus.Week14.alphavantage.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSeries {

	@JsonProperty("2023-06-02 19:55:00")
	private StockData stockData1;

	@JsonProperty("2023-06-02 19:50:00")
	private StockData stockData2;

	@JsonProperty("2023-06-02 19:45:00")
	private StockData stockData3;

	@JsonProperty("2023-06-02 19:40:00")
	private StockData stockData4;

	@JsonProperty("2023-06-02 19:35:00")
	private StockData stockData5;

	public StockData getStockData1() {
		return stockData1;
	}

	public void setStockData1(StockData stockData1) {
		this.stockData1 = stockData1;
	}

	public StockData getStockData2() {
		return stockData2;
	}

	public void setStockData2(StockData stockData2) {
		this.stockData2 = stockData2;
	}

	public StockData getStockData3() {
		return stockData3;
	}

	public void setStockData3(StockData stockData3) {
		this.stockData3 = stockData3;
	}

	public StockData getStockData4() {
		return stockData4;
	}

	public void setStockData4(StockData stockData4) {
		this.stockData4 = stockData4;
	}

	public StockData getStockData5() {
		return stockData5;
	}

	public void setStockData5(StockData stockData5) {
		this.stockData5 = stockData5;
	}

}
