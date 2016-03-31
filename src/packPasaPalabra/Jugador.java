package packPasaPalabra;

import javax.swing.JOptionPane;

public class Jugador {
	//Atributos
	private static Jugador mJugador=new Jugador();
	private String nombre;
	
	//Constructora
	private Jugador(){ 	}
	
	public static Jugador getJugador(){
		return mJugador;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	private void setNombre(String pNombre){
		this.nombre=pNombre;
	}
	
	public void prepararJugador(){
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		this.setNombre(nombre);
	}

}