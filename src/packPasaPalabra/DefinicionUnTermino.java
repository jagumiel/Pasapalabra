package packPasaPalabra;

public class DefinicionUnTermino extends Definicion{
	
	private String termino;
	
	public DefinicionUnTermino(String pTerm, String pDef, char pLetra) {
		super(pDef, pLetra);
		this.termino = pTerm;
	}
	
	private String getTermino(){
		return this.termino;
	}
	
	public boolean comprobarRespuesta(String pRespuesta){
		if (this.getTermino().equalsIgnoreCase(pRespuesta)){
			super.setEstado(true);
			return(true);
		}else{
			super.setEstado(false);
			return(false);
		}
	}
}
