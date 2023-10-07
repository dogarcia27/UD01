package TareasAprendizaje;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio31 {
	
	private static final int[] CABECERA_PNG = {137, 80, 78, 71, 13, 10, 26, 10};
	public static void main(String[] args) {
		
		File fichero = new File("."+ File.separator + "src" + File.separator + "TareasAprendizaje" + File.separator + "descarga.png");
	    
	    int[] cabecera = new int[8]; 
		try {
			FileInputStream fileIS = new FileInputStream(fichero);
			for(int i=0;i<cabecera.length;i++) {
				cabecera[i] = fileIS.read(); //recupera el nombre
				
				System.out.println(cabecera[i]);        
			}
			fileIS.close();		//cerrar stream  
		}catch (IOException eo) {}
		
		if(mismaCabecera(cabecera)) {
			System.out.println("Es un archivo PNG");
		
		} else {
			System.out.println("No es un archivo PNG");
		}
	  
	}
	
	private static boolean mismaCabecera(int[] cabecera) {
			
		for(int i=0;i<cabecera.length; i++) {
			if(cabecera[i] != CABECERA_PNG[i]) {
				return false;
			}
		}
		return true;
	}
}
