package com.udacity.pricing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.udacity.pricing.domain.price.Price;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getPriceByIdOk() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:" + this.port + "/prices/1";
		
		ResponseEntity<Price> response = restTemplate.getForEntity(url, Price.class);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
