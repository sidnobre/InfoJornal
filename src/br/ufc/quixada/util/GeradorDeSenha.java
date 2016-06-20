package br.ufc.quixada.util;

import java.util.Random;

public class GeradorDeSenha {
	
	private static final char[] CARACTERES = new char[62];
	private static final Random RANDOM = new Random();
	
	private GeradorDeSenha() {
	}
	
	//Inicia o array com os caracteres possíveis para a senha.
	static {
		for (int i = 48, j = 0; i < 123; i++) {
			if (Character.isLetterOrDigit(i)) {
				CARACTERES[j] = (char) i;
				j++;
			}
		}
	}
	
	public static String gerarSenha(final int tamanho) {
		final char[] senha = new char[tamanho];
		for (int i = 0; i < tamanho; i++) {
			senha[i] = CARACTERES[RANDOM.nextInt(CARACTERES.length)];
		}
		return new String(senha);
	}
	
	public static String gerarSenha() {
		return gerarSenha(6);
	}
}