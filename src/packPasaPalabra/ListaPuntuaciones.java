package packPasaPalabra;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class ListaPuntuaciones {
	
	private static ListaPuntuaciones mListaPuntuaciones=new ListaPuntuaciones();
	private Puntuacion[] listaPuntuaciones;
	private final int TAMANOMAXIMO = 10;
	private int tamano;
	
	private ListaPuntuaciones(){
		this.listaPuntuaciones=new Puntuacion[TAMANOMAXIMO];
		this.tamano=0;
	}
	
	public static ListaPuntuaciones getListaPuntuaciones(){
		return mListaPuntuaciones;
	}
	
	private int getTamano(){
		return this.tamano;
	}
	
	private void setTamano(int pTamano){
		this.tamano = pTamano;
	}
	
	public void cargarPuntuaciones(){
		LectorXMLPuntuaciones.main(null);
	}
	
	private void insertarPuntuacionOrdenada(Puntuacion pPuntuacion){
		int indice;
		if(this.getTamano()==0){
			indice=0;
		}else{
			indice = this.buscarIndiceInsercion(pPuntuacion.getPuntos());
		}
		Puntuacion aux;
		Puntuacion insertarsiguiente = pPuntuacion;
		for(int i = indice; i<=this.getTamano();i++){
			aux = this.listaPuntuaciones[i];
			this.listaPuntuaciones[i]=insertarsiguiente;
			insertarsiguiente=aux;
		}
		this.setTamano(this.getTamano()+1);
	}
	
	private int buscarIndiceInsercion(int pPuntos){
		int i = 0;
		for (i=0;i<this.getTamano();i++){
			if(pPuntos>this.listaPuntuaciones[i].getPuntos()){
				break;
			}
		}
		return i;
	}
	
	public void anadirPuntuacion(int pPuntos){
		this.anadirPuntuacion(Jugador.getJugador().getNombre(),pPuntos);
	}
	
	public void anadirPuntuacion(String pNombre, int pPuntos){
		int aux = this.jugadorTieneOtraPuntuacion(pNombre, pPuntos);
		if(aux==2){
			this.eliminarPuntuacionJugador(pNombre);
			this.insertarPuntuacionOrdenada(new Puntuacion(pNombre, pPuntos));
		}else{
			if(aux==1){
				if(pNombre.equals(Jugador.getJugador().getNombre())){
					JOptionPane.showMessageDialog(null, "Lo sentimos, ya tienes una puntuación en el Top mas alta que esta");
				}
			}else{
				if(this.getTamano()==TAMANOMAXIMO){
					if(pPuntos<=this.listaPuntuaciones[this.getTamano()-1].getPuntos()){
						JOptionPane.showMessageDialog(null, "Lo sentimos, tu puntuacion es demasiado baja como para entrar en el Top");
					}else{
						this.insertarPuntuacionOrdenada(new Puntuacion(pNombre, pPuntos));
					}
				}else{
					this.insertarPuntuacionOrdenada(new Puntuacion(pNombre, pPuntos));
				}
			}
		}
	}
	
	private void eliminarPuntuacionJugador(String pNombre){
		int indice = this.buscarIndicePuntuacion(pNombre);
		for(int i = indice; i<this.getTamano();i++){
			this.listaPuntuaciones[i] = this.listaPuntuaciones[i+1];
		}
		this.setTamano(this.getTamano()-1);
	}
	
	private int buscarIndicePuntuacion(String pNombre){
		int indice=0;
		for (int i=0;i<this.getTamano();i++){
			if(pNombre.equals(listaPuntuaciones[i].getNombre())){
				indice=i;
				break;
			}
		}
		return indice;
	}
	
	public int jugadorTieneOtraPuntuacion(String pNombre, int pPuntos){
		//0 si no tiene, 1 si tiene una mas alta, 2 si tiene una mas baja
		int rdo;
		rdo = 0;
		for(int i=0; i<this.getTamano(); i++){
			rdo = this.listaPuntuaciones[i].compararPuntuacion(pNombre, pPuntos);
			if (rdo!=0){
				break;
			}
		}
		return rdo;
	}
	
	
	public void guardarPuntuaciones(){
		try{ 
			FileWriter archivo = new FileWriter("res\\puntuaciones.xml"); 

			PrintWriter escritura = new PrintWriter(archivo);
			
			//escribimos un archivo de texto con la estructura de xml

			escritura.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			escritura.print("\t<listapuntuaciones>\n");
			for(int i=0; i<this.getTamano(); i++){
				escritura.print("\t\t<puntuacion>\n");
				escritura.print("\t\t\t<nombre>");
				escritura.print(this.listaPuntuaciones[i].getNombre());
				escritura.print("</nombre>\n");
				escritura.print("\t\t\t<puntos>");
				escritura.print(this.listaPuntuaciones[i].getPuntos());
				escritura.print("</puntos>\n");
				escritura.print("\t\t</puntuacion>\n");
			}
			escritura.print("\t</listapuntuaciones>\n");

			archivo.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Puntuacion getPuntuacion(int pIndice){
		if(pIndice<this.getTamano()){
			return this.listaPuntuaciones[pIndice];
		}else{
			return null;
		}
	}
	
}