//TODO PRUEBAS

package packPasaPalabra;
  
public class Reloj {
      
    private static Reloj mReloj = new Reloj();
    private int tiemporestantesegs; //De cara a la galería
    private long tiemporestantemilis;
    private long iniciocrono;
    private long fincrono;
      
    private Reloj(){
        this.tiemporestantemilis = 0;
        this.tiemporestantesegs = 0;
        this.iniciocrono = 0;
        this.fincrono = 0;
    }
      
    public static Reloj getReloj(){
        return mReloj;
    }
      
    private long getTiemporestantemilis(){
        return this.tiemporestantemilis;
    }
      
    private void setTiemporestantemilis(long pTiemporestantemilis){
        this.tiemporestantemilis = pTiemporestantemilis;
    }
      
    public int getTiemporestantesegs() {
        return tiemporestantesegs;
    }
  
    public void setTiemporestantesegs(int pTiemporestantesegs) {
        this.tiemporestantesegs = pTiemporestantesegs;
    }
  
    private long getIniciocrono() {
        return iniciocrono;
    }
  
    private void setIniciocrono(long pIniciocrono) {
        this.iniciocrono = pIniciocrono;
    }
  
    private long getFincrono() {
        return fincrono;
    }
  
    private void setFincrono(long pFincrono) {
        this.fincrono = pFincrono;
    }
  
    public void prepararReloj(long pTiempopartida){
        this.tiemporestantemilis = pTiempopartida;
        this.tiemporestantesegs = (int) (pTiempopartida/1000);
    }
      
    public void reanudarTiempo(){
        this.setIniciocrono(System.currentTimeMillis());
    }
      
    public void pararTiempo(){
        this.setFincrono(System.currentTimeMillis());
        long tiempotranscurrido = this.getFincrono()-this.getIniciocrono();
        long nuevotiemporestante = this.getTiemporestantemilis()-tiempotranscurrido;
        if(nuevotiemporestante<0){
        	nuevotiemporestante=0;
        }
        this.setTiemporestantemilis(nuevotiemporestante);
        int nuevotiemporestanteint = (int) (nuevotiemporestante/1000);
        this.setTiemporestantesegs(nuevotiemporestanteint);
    }
    
    public boolean quedaTiempo(){
    	return this.getTiemporestantesegs()>0;
    }
}
