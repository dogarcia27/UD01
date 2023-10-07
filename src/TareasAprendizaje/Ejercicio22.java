package TareasAprendizaje;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio22 {

	public static void main(String[] args) {
		
		try {
			BufferedReader bfReader= new BufferedReader(new FileReader(args[0]));
			String linea;
			int i = 0;
		
			while((linea = bfReader.readLine())!=null) { 
				i++;
				System.out.printf("%d.- %s%n", i, linea); 
				 
			}
			bfReader.close();
		} catch (FileNotFoundException fn ){       
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
	    }
		System.out.println();
	}
}
