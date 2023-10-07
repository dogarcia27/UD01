package AD01;

import java.io.Serializable;

public class Personaje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8167160219806169917L;
	private int id;
	private char[] dni = new char[9];
	private char[] nombre = new char[10];
	private char[] alterEgo = new char[20];
	private char[] tipo = new char[10];
	private int peso;
	private int altura;

	public Personaje(int id, char[] dni, char[] nombre, char[] alterEgo, char[] tipo, int peso, int altura) {
		
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.alterEgo = alterEgo;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Personaje() {
		this(0, null, null, null, null, 0, 0);
	}
	
	public char[] getNombre() {
		return nombre;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		
		String mensaje = String.format("Personaje [dni=%s, nombre=%-15s, identidad=%-20s, tipo=%-10s, peso=%d, altura=%d]",
							encadenar(dni), encadenar(nombre), encadenar(alterEgo), encadenar(tipo), peso, altura);
		return mensaje;
	}
	
	private String encadenar(char[] caracteres) {
		
		String texto = "";
		for(int i=0; i<caracteres.length; i++) {
			texto += caracteres[i];
		}
		return texto;
	}
}
