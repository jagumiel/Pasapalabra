package packPasaPalabra;

import java.util.Random;

public class ListaDefiniciones {

	private Definicion[] palabras;
	private static final int TAMANOMAXIMO = 20;
	private int tamano; 
	
	public ListaDefiniciones(){
		this.palabras=new Definicion[TAMANOMAXIMO];
		this.tamano=0;
	}
	
	private int getTamano(){
		return this.tamano;
	}
	
	private void setTamano(int pTamano){
		this.tamano=pTamano;
	}
	
	public Definicion getDefinicion(int pIndice){
		return this.palabras[pIndice];
	}
	
	public void anadirDefinicion(Definicion pDefinicion){
		if(this.getTamano()<TAMANOMAXIMO){
			this.palabras[this.getTamano()]=pDefinicion;
			this.setTamano(this.getTamano()+1);
		}else{
			System.out.println("La lista está llena");
		}
	}
	
	public Definicion obtenerDefinicionAleatoria(){
		Random rg = new Random();
		int aleatorio = rg.nextInt(this.getTamano()-1);
		return this.getDefinicion(aleatorio);
	}
}

