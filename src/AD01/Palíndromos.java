package AD01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Palíndromos {
	
	// Constantes
	private static final String DIRECTORIO = "." + File.separator + "src" + File.separator + "AD01" + File.separator;
	private static final String ARCHIVO_ENTRADA = "docE2.txt";
	private static final String ARCHIVO_SALIDA = "docPalindromos.txt";
	private static ArrayList<String> listaPalindromos = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		String linea;
		
		try {
			BufferedReader bfreader = new BufferedReader(new FileReader( DIRECTORIO + ARCHIVO_ENTRADA));
			while((linea = bfreader.readLine())!=null) {
				procesarLinea(linea);
			
			}
			bfreader.close();
		
		} catch (IOException io) {
			System.out.println("Error: no se encontró el archivo");
		
		}
		
		try {
			BufferedWriter bfwriter = new BufferedWriter(new FileWriter(DIRECTORIO+ARCHIVO_SALIDA, true));
			for(String p : listaPalindromos) {
				bfwriter.write(p + ", ");
			}
			bfwriter.newLine();
			bfwriter.close();
			System.out.printf("Se ha creado el fichero %s con los siguientes palindromos:%n%s%n", ARCHIVO_SALIDA, listaPalindromos.toString());
		} catch (IOException ioe) {}
	}
	
	private static void procesarLinea(String linea) {
		
		Scanner leerLinea = new Scanner(linea);
		String palabra;
		
		while(leerLinea.hasNext()) {
			palabra = leerLinea.next();
			comprobarPalindromo(palabra);
			
		}
		leerLinea.close();
	}
	
	private static void comprobarPalindromo(String palabra) {
		
		if(palabra.length() == 1) {
			listaPalindromos.add(palabra);
			
		} else {
			String palabraInvertida = Inversor.invertirTexto(palabra);
			if(palabraInvertida.equalsIgnoreCase(palabra)) {
				listaPalindromos.add(palabra);
			}
		}
		
	}

}
