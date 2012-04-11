package com.frasesdoleandro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import android.content.Context;

public class FrasesController {

	private static FrasesController frasesController = null;
	private String texto = null;
	private List<Frase> frases = new ArrayList<Frase>();
	private Context context = null;

	public FrasesController() throws Throwable {
		frases = this.retornaListaDeFrasesDoArquivo();
	}

	public String selecionaFraseAleatoria() throws IOException {

		Random random = new Random();
		int numDaEscolha = random.nextInt(this.frases.size());
		System.out.println("Frase escolhida: "
				+ frases.get(numDaEscolha).toString() + " " + numDaEscolha);

		return frases.get(numDaEscolha).getTexto();
	}

	public List<Frase> retornaListaDeFrasesDoArquivo() throws Exception {

		Scanner leitor = new Scanner(context.getResources().openRawResource(R.raw.frases));
		String linha = leitor.nextLine();
		while (leitor.hasNext()) {
			System.out.println(linha);
			linha = leitor.nextLine();
			frases.add(new Frase(linha));
		}
		return frases;
	}

	public static FrasesController getInstance() throws Throwable {

		if (frasesController == null) {
			frasesController = new FrasesController();
		}
		return frasesController;
	}
}
