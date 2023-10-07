package AD01;

import java.io.*;

public class Inversor {

	public final static String FICHERO_ENTRADA = "docE1.txt";
	public final static String FICHERO_SALIDA = "docE1Invertido.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String textoFichero = leerFichero();
		textoFichero = invertirTexto(textoFichero);
		guardarFichero(textoFichero);
			
	}
		
	private static String leerFichero() {
			
		String texto = "";
		try {
			File fichero = new File("."+ File.separator + "src" + File.separator + "AD01" + File.separator + FICHERO_ENTRADA);
			FileReader lectorFichero = new FileReader(fichero);
			int i;
			
			while((i=lectorFichero.read()) != -1) {
				texto += (char) i;
			}
			lectorFichero.close();
		
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: Archivo no encontrado");
		} catch (IOException ioe) {
			System.out.println("Error: fallo al recibir los datos");
		}
		return texto;
	}
		
	private static void guardarFichero(String texto) {
		
		try {
			FileWriter escritorFichero = new FileWriter(new File(".\\src\\AD01\\" + FICHERO_SALIDA));
			char[] caracteres = texto.toCharArray();
		
			for(int i=0; i<caracteres.length; i++) {
				escritorFichero.write(caracteres[i]);
				System.out.print(caracteres[i]);
			}
			escritorFichero.close();
		} catch (IOException ioe) {
			System.out.print("Error: IOExcepcion");
		}
	}
	
	public static String invertirTexto(String texto) {
		
		char[] caracteres = texto.toCharArray();
		texto = "";
		for(int i=caracteres.length -1; i>=0; i--) {
			texto += caracteres[i];
		}
		return texto;
	}
}
