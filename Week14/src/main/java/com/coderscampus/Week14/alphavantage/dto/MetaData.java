package com.coderscampus.Week14.alphavantage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {

	@JsonProperty("1. Information")
	private String information;
	@JsonProperty("2. Symbol")
	private String symbol;
	@JsonProperty("3. Last Refreshed")
	private String lastRefreshed;
	@JsonProperty("4. Interval")
	private String interval;
	@JsonProperty("5. Output Size")
	private String outputSize;
	@JsonProperty("6. Time Zone")
	private String timeZone;
	
	public MetaData() {
        
    }

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLastRefreshed() {
		return lastRefreshed;
	}

	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(String outputSize) {
		this.outputSize = outputSize;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

}
