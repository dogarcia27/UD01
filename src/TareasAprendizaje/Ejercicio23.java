package TareasAprendizaje;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio23 {
	
	private static final String PALABRA_BUSCADA = "la";
	public static void main(String[] args) {
		
		try {
			BufferedReader bfreader= new BufferedReader(new FileReader("D:\\Formacion\\Java\\Eclipse\\AccesoDatos1\\src\\TareasAprendizaje\\documento.txt"));
			String linea;
			int i = 0;
		
			while((linea = bfreader.readLine())!=null) { 
				i++;
				System.out.printf("%d.- %s%n", i, linea);
				comprobarPalabra(linea, i);
			}
			bfreader.close();
		} catch (FileNotFoundException fn ){       
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
	    }
	}
	
	public static void comprobarPalabra(String linea, int fila) {
		
		String palabra = "";
		int posicion = 0;
		Scanner leerLinea = new Scanner(linea);
		while(leerLinea.hasNext() && !palabra.equals(PALABRA_BUSCADA)) {
			posicion++;
			palabra = leerLinea.next();
		}
		if(palabra.equals(PALABRA_BUSCADA)) {
			System.out.printf("La palabra '%s' aparece en la fila %d, y es la palabra %d de esa fila%n", PALABRA_BUSCADA, fila, posicion);
		} else {
			System.out.println("La palabra buscada no se encuentra en la linea " + fila);
		}
		leerLinea.close();
		
	}
}
