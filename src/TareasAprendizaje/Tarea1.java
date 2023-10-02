package TareasAprendizaje;
import java.util.Scanner;

public class Tarea1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ejercicio1();
	}

	
	public static void ejercicio1() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el nombre del directorio que quieres comprobar: ");
		String nombre = teclado.nextLine();
		teclado.close();
		//File fichero = new File(nombre);
		System.out.println("comprobando " + nombre);
	}
}
