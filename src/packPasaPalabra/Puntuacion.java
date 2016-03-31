package packPasaPalabra;


public class Puntuacion {
	String nombre;
	int puntos;
	
	public Puntuacion(String pNombre, int pPuntos){
		this.nombre=pNombre; //El nombre no se puede coger desde Jugador que es MAE?
		this.puntos=pPuntos;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntos(){
		return this.puntos;
	}
	
	public void setPuntos(int pPuntos){
		this.puntos=pPuntos; //Se supone que hay que hacer la suma de puntos desde otro lugar para actualizarla.
	}
	
	public int compararPuntuacion(String pNombre, int pPuntos){
		//0 si no es de jugador, 1 si la nueva es mas baja, 2 si la nueva es mas alta
		int rdo = 0;
		if(this.getNombre().equals(pNombre)){
				if(this.getPuntos()<pPuntos){
					rdo = 2;
				}else{
					rdo = 1;
				}
		}
		return rdo;
	}
	
	public void imprimir(){
		System.out.println("El jugador "+this.nombre +" ha obtenido una puntuacion de: "+this.puntos+" puntos.");
	}
}