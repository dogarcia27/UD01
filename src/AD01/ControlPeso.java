package AD01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class ControlPeso {

    public static final String ARCHIVO = "." +File.separator+ "src" +File.separator+ "AD01" +File.separator+ "Marvel.dat";
   
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el DNI (con letra) del personaje para control de peso:\n");
        String dniBuscado = teclado.nextLine();
        System.out.print("Introduzca su peso actual: ");
        int peso = teclado.nextInt();
        teclado.close();
        
        File fichero = new File(ARCHIVO);
        int posicionNombre = buscarDni(fichero, dniBuscado);
        if(posicionNombre > 0) {
        	compararPesos(fichero, peso, posicionNombre);
        } else if(posicionNombre == 0) {
        	System.out.println("Ese DNI no se corresponde con ningun personaje");
        } else {
        	System.out.println("Error en la ejecución");
        }
    }

    public static int buscarDni(File archivo, String dniBuscado) {

    	try {
        	RandomAccessFile file = new RandomAccessFile(archivo, "r");
        	int posicion = 4; // empiezo a leer aqui porque el id ocupa 4 bytes
        	char[] dni = new char[9];
        	
        	while (file.getFilePointer() != file.length()) {
        		file.seek(posicion);
        		
        		for(int i=0;i<dni.length;i++) {
        			dni[i] = file.readChar();
        		}
        		if(Arrays.equals(dni, dniBuscado.toCharArray())) {
        			return posicion + 9;
        		} else {
        			posicion += 51;
        		}
        	}
        	file.close();
        	return 0;
        } catch (IOException ioe) {
        	
        }
    	return -1;
    }

    public static void compararPesos(File archivo, int peso, int posicionNombre) {

    	try {
    		RandomAccessFile file = new RandomAccessFile(archivo, "rw");
    		file.seek(posicionNombre);
    		char[] nombre = new char[10];
    		
    		for(int i=0; i<nombre.length; i++) {
    			nombre[i] = file.readChar();
    			
    		}
    		String nom = new String(nombre);
    		file.seek(posicionNombre + 80);
    		int pesoAnterior = file.readInt();
    		if(peso < pesoAnterior) {
    			System.out.printf("%s ha adelgazado %d kilos", nom, pesoAnterior - peso);
    		} else if(peso > pesoAnterior) {
    			System.out.printf("%s ha engordado %d kilos", nom, peso - pesoAnterior);
    		} else {
    			System.out.printf("%s se mantiene en su peso anterior", nom);
    		}
    		file.seek(posicionNombre + 80);
    		file.writeInt(peso);
    		file.close();
    	} catch (IOException ioe) {}
    }
}