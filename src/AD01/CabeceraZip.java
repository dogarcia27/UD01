package AD01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CabeceraZip {
	
	// Constantes
	private static final int[] BYTES_CABECERA = {80, 75, 3, 4};
	private static final String NOMBRE_ARCHIVO = "descarga.zip";
	
	public static void main(String[] args) {
		
		File fichero = new File("."+ File.separator + "src" + File.separator + "AD01" + File.separator + NOMBRE_ARCHIVO);
	    int[] cabecera = new int[BYTES_CABECERA.length]; 
		
	    try {
			FileInputStream fileIS = new FileInputStream(fichero);
			for(int i=0;i<cabecera.length;i++) {
				cabecera[i] = fileIS.read(); 
				System.out.println(cabecera[i]);        
			
			}
			fileIS.close();		
		}catch (IOException io) {
			System.out.println("Error: no se ha encontrado el archivo");
		}
	    if (Arrays.equals(cabecera, BYTES_CABECERA)) {
            System.out.println("Efectivamente, es uan archivo .zip");
            
        } else {
			System.out.println("No es un archivo .zip");
		}
	  
	}
	
	
}
