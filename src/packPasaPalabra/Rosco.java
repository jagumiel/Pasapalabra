package packPasaPalabra;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Observable;

import sun.audio.*;

public class Rosco extends Observable{
	private static Rosco mRosco=new Rosco();
	private int aciertos;
	private int fallos;
	//0 si fallo la última, 1 si acertó, 2 si pasó
	private int ultimaacertada;
	private boolean sonido;
	private static long TIEMPOPARTIDA = 250000;
	private Definicion definicionActual;

	private Rosco(){ 
		this.aciertos=0;
	}
	
	public static Rosco getRosco(){
		return mRosco;
	}
	
	private void setAciertos(int pAciertos){
		this.aciertos=pAciertos;
	}
	
	public int getAciertos(){
		return this.aciertos;
	}
	
	private void setFallos(int pFallos){
		this.fallos=pFallos;
	}
	
	public int getFallos(){
		return this.fallos;
	}
	
	private void setultimaAcertada(int pAcertada){
		this.ultimaacertada = pAcertada;
	}
	
	public int getUltimaAcertada(){
		return this.ultimaacertada;
	}
	
	private void setDefinicionActual(Definicion pDefinicion){
		this.definicionActual=pDefinicion;
	}
	
	public Definicion getDefinicionActual(){
		return this.definicionActual;
	}
	
	private boolean getSonido(){
		return this.sonido;
	}
	
	private void setSonido(Boolean pSonido){
		this.sonido=pSonido;
	}
	
	public void prepararRosco(Boolean sonido){
		this.setSonido(sonido);
		Jugador.getJugador().prepararJugador();
		DoubleLinkedList.getDoubleLinkedList().prepararPreguntas();
		this.cargarSiguienteDefinicion();
		Reloj.getReloj().prepararReloj(TIEMPOPARTIDA);
		this.setAciertos(0);
		this.setFallos(0);
	}
	
	public void comprobarRespuesta(String pRespuesta){
		boolean acertado;
		acertado = getDefinicionActual().comprobarRespuesta(pRespuesta);
		if(this.getSonido()){
			this.reproducirSonido(acertado);
		}
		if(acertado){
			this.setultimaAcertada(1);
			this.sumarAcierto();
			this.cargarSiguienteDefinicion();
		}else{
			this.setultimaAcertada(0);
			this.cargarSiguienteDefinicion();
			this.sumarFallo();
		}
		setChanged();
		notifyObservers();
	}
	
	public void pasar(){
		this.cargarSiguienteDefinicion();
		this.setultimaAcertada(2);
		setChanged();
		notifyObservers();
	}
	
	private int CalcularPuntosPorTiempo(){
		int tiemporestante = (int) Reloj.getReloj().getTiemporestantesegs();
		if(this.getAciertos()==27){
			return tiemporestante*10;
		}else{
			return 0;
		}
	}
	
	private void sumarAcierto(){
		this.setAciertos(this.getAciertos()+1);
	}
	
	private void sumarFallo(){
		this.setFallos(this.getFallos()+1);
	}
	
	private void cargarSiguienteDefinicion(){
		this.setDefinicionActual(DoubleLinkedList.getDoubleLinkedList().cargarSiguientePregunta());
	}
	
	public void finalizar(){
		int puntos = 25*this.getAciertos();
		puntos = puntos - (10*this.getFallos());
		puntos+=this.CalcularPuntosPorTiempo();
		if(puntos<0){
			puntos=0;
		}
		ListaPuntuaciones.getListaPuntuaciones().anadirPuntuacion(puntos);
		ListaPuntuaciones.getListaPuntuaciones().guardarPuntuaciones();
	}	
	
	//TODO
	@SuppressWarnings("restriction")
	private void reproducirSonido(boolean pAcertado){
		try {
			String fila;
			if(pAcertado){
				 fila = "sounds/correct.wav";
			}else{
				fila = "sounds/wrong.wav";
			}
		    InputStream in = new FileInputStream(fila);
		    AudioStream audioStream = new AudioStream(in);
		    AudioPlayer.player.start(audioStream);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
