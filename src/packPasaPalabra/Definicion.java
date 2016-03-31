package packPasaPalabra;


public abstract class Definicion {
	private String definicion;
	private enum Estado {ACERTADO, FALLADO, NOCONTESTADO};
	private char letra;
	private Estado estado;
	
	public Definicion(String pDef, char pLetra) {
		this.definicion=pDef;
		this.letra = pLetra;
		this.estado = Estado.NOCONTESTADO;
	}
		
	public String getDefinicion(){
		return this.definicion;
	}
	
	public char getLetra(){
		return this.letra;
	}
	
	private Estado getEstado(){
		return this.estado;
	}
	
	protected void setEstado(boolean pAcertado){
		if(pAcertado==true){
			this.estado=Estado.ACERTADO;
		}else{
			this.estado=Estado.FALLADO;
		}
	}
	
	public boolean estaContestada(){
		if(this.getEstado().equals(Estado.NOCONTESTADO)){
			return false;
		}else{
			return true;
		}
	}
	
	public abstract boolean comprobarRespuesta(String pRespuesta);
}
