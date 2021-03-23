package com.pokeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokeapi.model.Pokedex;

@Service
public class PokedexService {
	
	@Autowired
	static RestTemplate template = new RestTemplate();
	
	public static Pokedex getPokedex() {
		return template.getForObject("https://pokeapi.co/api/v2/pokemon?limit=10", Pokedex.class);
	}
	
}
