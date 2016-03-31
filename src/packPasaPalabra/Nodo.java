package packPasaPalabra;

public class Nodo {
	
	private Definicion definicion;
	private Nodo anterior;
	private Nodo siguiente;
	
	public Nodo(Definicion pDefinicion){
		this.definicion=pDefinicion;
	}
	
	public Definicion getDefinicion(){
		return this.definicion;
	}
	
	public Nodo getSiguiente(){
		return this.siguiente;
	}
	
	public Nodo getAnterior(){
		return this.anterior;
	}
	
	public void setAnterior(Nodo pNodo){
		this.anterior=pNodo;
	}
	
	public void setSiguiente(Nodo pNodo){
		this.siguiente=pNodo;
	}
	
	public boolean comprobarRespuesta(String pRespuesta){
		return this.getDefinicion().comprobarRespuesta(pRespuesta);	
	}
}
