package TareasAprendizaje;

import java.io.File;

public class Ejercicio21 {
	
	public static void main(String[] args) {
		
		String ruta = "C:" + File.separator + "Windows";
		if (args.length>=1) {
			ruta = args[0];
		}
		File fichero = new File(ruta);
			
		if (!fichero.exists()) {
			System.out.println("No existe el fichero o directorio " + ruta + " .");
			
		} else {
			if(fichero.isFile()) {
				System.out.println(fichero + " existe y es un fichero ");
			
			} else {
				//verDirectorio(ruta, fichero);
				verArchivos(ruta, fichero);	
			}
		}
		
	}

	public static void verDirectorio(String ruta, File fichero) {
		
		System.out.println(ruta + " es un directorio y contiene: ");
		File[] archivos = fichero.listFiles();
		for(File f : archivos) {
			System.out.println();
			
			if (f.isFile()) {
				System.out.println(f.getName() + "(archivo)");
			} else if (f.isDirectory()) {
				System.out.println(f.getName() + "(directorio)");
				verDirectorio(ruta+File.separator+f.getName(), f);
			} else {
				System.out.println("?");
			}
			
			
		}
	}
	
	public static void verArchivos(String ruta, File fichero) {
		
		String[] archivos = fichero.list();
		System.out.printf("%s es un directorio y contiene %d archivos o directorios:%n", ruta, archivos.length);
		for(int i=0; i<archivos.length;i++) {
			System.out.printf("%d.- %s%n", i, archivos[i]);
		}
	}
}
