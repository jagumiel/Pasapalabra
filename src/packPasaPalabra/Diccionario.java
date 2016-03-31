package packPasaPalabra;

import java.util.HashMap;

public class Diccionario {
	private static Diccionario mDiccionario = new Diccionario();
	private HashMap<Character, ListaDefiniciones> listas;

	private Diccionario() {
		this.inicializarListas();
	}
	
	public static Diccionario getDiccionario(){
		return mDiccionario;
	}
	
	public void prepararDiccionario(){
		LectorXMLDiccionario.main(null);
	}
	
	private void inicializarListas(){
		this.listas=new HashMap<Character, ListaDefiniciones>();
		this.listas.put('A', new ListaDefiniciones());
		this.listas.put('B', new ListaDefiniciones());
		this.listas.put('C', new ListaDefiniciones());
		this.listas.put('D', new ListaDefiniciones());
		this.listas.put('E', new ListaDefiniciones());
		this.listas.put('F', new ListaDefiniciones());
		this.listas.put('G', new ListaDefiniciones());
		this.listas.put('H', new ListaDefiniciones());
		this.listas.put('I', new ListaDefiniciones());
		this.listas.put('J', new ListaDefiniciones());
		this.listas.put('K', new ListaDefiniciones());
		this.listas.put('L', new ListaDefiniciones());
		this.listas.put('M', new ListaDefiniciones());
		this.listas.put('N', new ListaDefiniciones());
		this.listas.put('Ñ', new ListaDefiniciones());
		this.listas.put('O', new ListaDefiniciones());
		this.listas.put('P', new ListaDefiniciones());
		this.listas.put('Q', new ListaDefiniciones());
		this.listas.put('R', new ListaDefiniciones());
		this.listas.put('S', new ListaDefiniciones());
		this.listas.put('T', new ListaDefiniciones());
		this.listas.put('U', new ListaDefiniciones());
		this.listas.put('V', new ListaDefiniciones());
		this.listas.put('W', new ListaDefiniciones());
		this.listas.put('X', new ListaDefiniciones());
		this.listas.put('Y', new ListaDefiniciones());
		this.listas.put('Z', new ListaDefiniciones());
	}
	
	public Definicion obtenerDefinicionAleatoria(char pLetra){
		return mDiccionario.listas.get(pLetra).obtenerDefinicionAleatoria();
	}
	
	public void anadirDefinicion(char pLetra, Definicion pDefinicion){
		this.listas.get(pLetra).anadirDefinicion(pDefinicion);
	}
	
}
