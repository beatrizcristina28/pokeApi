package com.pokeapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pokeapi.helper.PokedexHelper;
import com.pokeapi.model.Pokemon;
import com.pokeapi.service.PokedexService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PokedexController.class)
public class PokedexControllerTest {

	@Autowired
	private PokedexController pokedexController;

	@MockBean
	private PokedexService service;

	@MockBean
	static PokedexHelper helper;

	@MockBean
	static RestTemplate template;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.pokedexController);
	}

	@Test
	public void testePokedexController() throws Exception {

		List<Pokemon> pokemons = new ArrayList<>();
		Pokemon pokemon = new Pokemon();

		pokemon.setName("bulbasaur");
		pokemon.setUrl("teste.com.br");

		pokemons.add(pokemon);

		Mockito.when(template.getForEntity("https://pokeapi.co/api/v2/pokemon?limit=1", Pokemon.class))
				.thenReturn(new ResponseEntity(pokemons, HttpStatus.OK));
	}
}
