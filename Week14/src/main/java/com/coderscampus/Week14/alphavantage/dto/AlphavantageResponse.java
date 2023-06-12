package com.coderscampus.Week14.alphavantage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphavantageResponse {

	// metaData is the key that the API call is looking for to map
	// So you must map out the properties you want to match the keys provided
	// Use @JsonProperty to map out the properties you want to match the keys provided
	
	@JsonProperty("Meta Data")
	private MetaData metaData;
	
	@JsonProperty("Time Series (5min)")
	private TimeSeries timeSeries;

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public TimeSeries getTimeSeries() {
		return timeSeries;
	}

	public void setTimeSeries(TimeSeries timeSeries) {
		this.timeSeries = timeSeries;
	}

}
