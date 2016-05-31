package br.ufc.quixada.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorTest {
	
	public static void main(String[] args) {
		String s = "eder";
		
		 //Pattern p = Pattern.compile("^[a-zA-Z]+\\s*[a-zA-Z]*\\s*[a-zA-Z]*\\s*[a-zA-Z]*\\s*[a-zA-Z]*\\s*[a-zA-Z]*\\s*[a-zA-Z]*$");
		//Pattern p = Pattern.compile("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$");
		Pattern p = Pattern.compile("^([a-zA-Z]+[a-zA-Z0-9]*){4,20}$");
		Matcher m = p.matcher(s);  
		 m.matches(); 
		
		if(m.matches())
			System.out.println("Válido");
		else
			System.out.println("Inválido");
	}
}
