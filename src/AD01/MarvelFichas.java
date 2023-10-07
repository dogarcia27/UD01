package AD01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 *  Por lo que he entendido del enunciado, esta clase es basicamente para crear el archivo Marvel.dat a partir de los arrays dados,
 *  por eso compruebo si existe el ficherro y de ser así no hago nada más aquí
 */
public class MarvelFichas {

	// constantes para mantenimiento
	private static final String ARCHIVO = "." +File.separator+ "src" +File.separator+ "AD01" +File.separator+ "Marvel.dat";
		
	public static void main(String[] args) {
		
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		File fichero = new File(ARCHIVO);
		if(!fichero.exists()) {
			if(grabarDatos(fichero, ids, dnis, noms, identidades, tipos, pesos, alturas)) {
				System.out.println("La carga de los personajes ha terminado correctamente");
			}
		} else {
			System.out.println("El fichero ya existe");	  
		}
	}
	
	public static boolean grabarDatos(File fichero, int[] ids, String[] dnis, String[] noms, String[] identidades, String [] tipos, int[] pesos, int[] alturas) {
		
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			for (int i=0;i<ids.length; i++){           	  
				 
				file.writeInt(ids[i]);
			     
				String texto = ajustarCadena(dnis[i], 9);      
			    file.writeChars(texto);
			    texto = ajustarCadena(noms[i], 10);      
			    file.writeChars(texto);
			    texto = ajustarCadena(identidades[i], 20);      
			    file.writeChars(texto);
			    texto = ajustarCadena(tipos[i], 10);      
			    file.writeChars(texto);
			    
			    file.writeInt(pesos[i]);       
				file.writeInt(alturas[i]);
				String mensaje = String.format("Personaje [dni=%s, nombre=%-15s, identidad=%-20s, tipo=%-10s, peso=%d, altura=%d]",
						dnis[i], noms[i], identidades[i], tipos[i], pesos[i], alturas[i]);
				System.out.println(mensaje);
			}
			file.close();
			return true;
			
		} catch (IOException ioe) {}
			return false;
	}
	
	private static String ajustarCadena(String cadena, int longitud) {
		
		StringBuffer buffer = new StringBuffer(cadena);      
	    buffer.setLength(longitud);
		return buffer.toString();
	}

}
