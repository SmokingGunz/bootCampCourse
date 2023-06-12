package com.coderscampus.Week14.alphavantage;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.Week14.alphavantage.dto.AlphavantageResponse;

public class AlphavantageIntegration {
	
	@Test
	public void callApiExample() {  // how to call the API from a web service
		RestTemplate rt = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://www.alphavantage.co/query")
									  .queryParam("function", "TIME_SERIES_INTRADAY")
									  .queryParam("symbol", "TSLA")
									  .queryParam("interval", "5min")
									  .queryParam("apikey", "204C355JNNL73SLK")
									  .build()
									  .toUri();
		
//	    This is generic way to call the API without mapping the data received from the web service		
//		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
		
		// This is how you generate a response from the API call and then map the data received.
		ResponseEntity<AlphavantageResponse> response = rt.getForEntity(uri, AlphavantageResponse.class);

		System.out.println(response.getBody());
	}

}
