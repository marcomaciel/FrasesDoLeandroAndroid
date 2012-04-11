package com.frasesdoleandro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FrasesDoLeandroActivity extends Activity {
	
	TextView txtFrase;
	Button btnOutraFrase;
	String textoFrase;
	
	List<Frase> frases = new ArrayList<Frase>();
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		txtFrase = (TextView) findViewById(R.id.txtFrase);
		btnOutraFrase = (Button) findViewById(R.id.btnOutraFrase);
		btnOutraFrase.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					//FrasesController fc = new FrasesController();
					textoFrase = selecionaFraseAleatoria();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtFrase.setText(textoFrase);

			}
		});
	}
	
	public String selecionaFraseAleatoria() throws IOException {
		
		Scanner leitor = new Scanner(getResources().openRawResource(R.raw.frases));

		String linha = leitor.nextLine();
		
		while (leitor.hasNext()) {
			System.out.println(linha);
			linha = leitor.nextLine();
			frases.add(new Frase(linha));
		}
		
		Random random = new Random();
		int numDaEscolha = random.nextInt(frases.size());
		System.out.println("Frase escolhida: "
				+ frases.get(numDaEscolha).toString() + " " + numDaEscolha);

		return frases.get(numDaEscolha).getTexto();
	}


}