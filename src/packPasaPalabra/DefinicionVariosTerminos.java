package packPasaPalabra;

import java.util.ArrayList;
import java.util.Iterator;

public class DefinicionVariosTerminos extends Definicion{
	
	private ArrayList<String> terminos;
	
	public DefinicionVariosTerminos(String pDef, char pLetra, ArrayList<String> terms) {
		super(pDef, pLetra);
		terminos = terms;
	}
	
	private Iterator<String> getIterador(){
		return terminos.iterator();
	}
	
	public boolean comprobarRespuesta(String pRespuesta){
		boolean acertado = false;
		super.setEstado(false);
		String term;
		
		Iterator<String> it = this.getIterador();
		while(it.hasNext()){
			term=it.next();
			if(term.equalsIgnoreCase(pRespuesta)){
				acertado=true;
				super.setEstado(true);
			}
		}
		
		return acertado;
	}

}
