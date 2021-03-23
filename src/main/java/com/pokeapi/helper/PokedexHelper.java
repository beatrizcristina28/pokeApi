package com.pokeapi.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.pokeapi.model.Pokemon;

public class PokedexHelper {
	private static final String PATH_CSV = "C:/Users/blima/Documents/ESR/Java/pokemons.csv";
	private static final String PATH_TXT = "C:/Users/blima/Documents/ESR/Java/pokemons.txt";

	public static void gravaArquivoCsv(List<Pokemon> lista) {

		try {
			System.out.println("gravando csv");

			Writer writer = new FileWriter(PATH_CSV);

			StatefulBeanToCsv<Pokemon> sbc = new StatefulBeanToCsvBuilder<Pokemon>(writer)
					.withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

			sbc.write(lista);
			writer.close();
			System.out.println("dados:" + lista);
			System.out.println("arquivo gravado");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void gravaArquivoTxt(List<Pokemon> lista) {

		try {
			System.out.println("gravando txt");

			File file = new File(PATH_TXT);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);

			for (Pokemon pokemon : lista) {
				pw.println("Nome: " + pokemon.getName() + "| Url: " + pokemon.getUrl());
			}

			pw.close();

			System.out.println("arquivo gravado");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
