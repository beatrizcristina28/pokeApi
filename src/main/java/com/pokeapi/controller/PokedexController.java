package com.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.helper.PokedexHelper;
import com.pokeapi.service.PokedexService;

@RestController
@RequestMapping(value = "/pokedex", method = RequestMethod.GET)

public class PokedexController {

	@Autowired
	static PokedexService service;

	@Autowired
	static PokedexHelper helper;

	@RequestMapping(value = "/exibirPokemons", method = RequestMethod.GET)
	@GetMapping
	static Object getPokedex() {

		return PokedexService.getPokedex();
	}

	@RequestMapping(value = "/gravarCsv", method = RequestMethod.GET)
	@GetMapping
	static void getPokedexCSV() {

		PokedexHelper.gravaArquivoCsv(PokedexService.getPokedex().getResults());

	}
	
	@RequestMapping(value = "/gravarTxt", method = RequestMethod.GET)
	@GetMapping
	static void getPokedexTXT() {

		PokedexHelper.gravaArquivoTxt(PokedexService.getPokedex().getResults());

	}
}
