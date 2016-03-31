package packPasaPalabra;

public class DoubleLinkedList{

	private static DoubleLinkedList mDoubleLinkedList = new DoubleLinkedList();
	private Nodo primero;
	private int tamano;
	private Nodo actual;

	// Constructor
	private DoubleLinkedList() {
		primero = null;
		actual = null;
		tamano = 0;
	}
	
	public static DoubleLinkedList getDoubleLinkedList(){
		return mDoubleLinkedList;
	}

	private Nodo getPrimero(){
		return this.primero;
	}
	
	private void setPrimero(Nodo pNodo){
		this.primero=pNodo;
	}
	
	private Nodo getActual(){
		return this.actual;
	}
	
	private void setActual(Nodo pActual){
		this.actual=pActual;
	}
	
	public int getTamano(){
		return this.tamano;
	}
	
	private void setTamano(int pTamano){
		this.tamano=pTamano;
	}
	
	private void anadirNodo(Nodo pNodo){
		if(this.getTamano()==0){
			this.setPrimero(pNodo);
			this.setActual(pNodo);
			pNodo.setAnterior(pNodo);
			pNodo.setSiguiente(pNodo);
		}else{
			this.getActual().setSiguiente(pNodo);
			pNodo.setAnterior(this.getActual());
			pNodo.setSiguiente(this.getPrimero());
			this.getPrimero().setAnterior(pNodo);
			this.setActual(pNodo);
		}
		this.setTamano(this.getTamano()+1);
	}
	
	private void eliminarNodoActual() {
		if(this.getTamano()==1){
			this.setPrimero(null);
			this.setActual(null);
		}else{
			this.getActual().getAnterior().setSiguiente(this.getActual().getSiguiente());
			this.getActual().getSiguiente().setAnterior(this.getActual().getAnterior());
		}
		this.setTamano(this.getTamano()-1);
	}
	
	public void prepararPreguntas(){
		//La vacio porque si se juegan dos partidas seguidas las preguntas de la partida anterior seguirían en la lista
		this.setPrimero(null);
		this.setActual(null);
		this.setTamano(0);
		char[] abecedario = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i=0; i<abecedario.length;i++){
			Definicion def = Diccionario.getDiccionario().obtenerDefinicionAleatoria(abecedario[i]);
			Nodo nuevo = new Nodo(def);
			this.anadirNodo(nuevo);
		}
		//Como tambien voy a usar actual para ir cogiendo las preguntas le pongo que apunte al anterior al primero y desde rosco cargo siguiente pregunta
		this.setActual(this.getPrimero().getAnterior());
	}
	
	public boolean quedanPreguntas(){
		return this.tamano!=0;
	}
	
	public Definicion cargarSiguientePregunta(){
		Nodo siguiente = this.getActual().getSiguiente();
		if(this.getActual().getDefinicion().estaContestada()){
			this.eliminarNodoActual();
		}
		if(this.tamano!=0){
			this.setActual(this.getActual().getSiguiente());
			this.setActual(siguiente);	
			return this.getActual().getDefinicion();
		}else{
			return null;
		}
	}
}
