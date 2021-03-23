package com.pokeapi.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class PokedexServiceTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void getPokedexTest() {

		String url = "https://pokeapi.co/api/v2/pokemon?limit=10";
		ResponseEntity<String> resultado = restTemplate.getForEntity(url, String.class);

		Assert.assertEquals(200, resultado.getStatusCodeValue());
		Assert.assertEquals(true, resultado.getBody().contains("results"));
	}
}
