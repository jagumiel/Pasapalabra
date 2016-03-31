package packInterfaz;

import javax.swing.JButton; 
import javax.swing.JCheckBox;
import javax.swing.JFrame; 
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout; 
import javax.swing.GroupLayout.ParallelGroup; 
import javax.swing.GroupLayout.SequentialGroup;

import packPasaPalabra.Diccionario;
import packPasaPalabra.Jugador;
import packPasaPalabra.ListaPuntuaciones;
import packPasaPalabra.Rosco;

public class Principal extends JFrame { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnJugar, btnPuntuaciones, btnReglas;
	GroupLayout layout; 
	int xSize;
	int ySize;
	static boolean cargadosPuntuacionesYDiccionario = false;
	JCheckBox chckbxReproducirSonido;
	JLabel lblSonido;
	

	public static void main(String[] args) { 
		Principal dialog = new Principal(); 
		dialog.alinearComoColumna(); 
		dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* este metodo indica que la aplicacion termina al cerrarse la ventana */ 
		dialog.setVisible(true);
		if(!cargadosPuntuacionesYDiccionario){
			ListaPuntuaciones.getListaPuntuaciones().cargarPuntuaciones();
			Diccionario.getDiccionario().prepararDiccionario();
			cargadosPuntuacionesYDiccionario = true;
		}
	}
	
	public Principal(){ 
		inicializarComponentes(); 
		setVisible(true); 
		Toolkit tk = Toolkit.getDefaultToolkit();  
		xSize = ((int) tk.getScreenSize().getWidth());  
		ySize = ((int) tk.getScreenSize().getHeight());  
		setSize(xSize,ySize);
	} 
	
	private void inicializarComponentes() { 
		chckbxReproducirSonido = new JCheckBox("", true);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Rosco.getRosco().prepararRosco(chckbxReproducirSonido.isSelected());
				dispose();
				if(Jugador.getJugador().getNombre()==null){
					Principal.main(null);
				}else{
					InterfazRosco2.main(null);
				}
			}
		});
		
		btnPuntuaciones= new JButton("Puntuaciones"); 
		btnPuntuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				InterfazPuntuaciones.main(null);
			}
		});
		
		btnReglas = new JButton("Reglas");
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				dispose();
				Reglas.main(null);
			}
		});
		
		lblSonido = new JLabel();
		lblSonido.setText("<html><h1><b>Reproducir sonido</b></h1></html>");
		
		layout = new GroupLayout(getContentPane()); /* obtenemos el contenedor del JFrame con el metodo getContentPane() */ 
		
		getContentPane().setLayout(layout); 
	} 
		
	public void alinearComoColumna(){ 
		ParallelGroup parallelGroupA= layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER); 
		
		ParallelGroup parallelGroupAuxiliar= layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);  
		
		parallelGroupAuxiliar.addComponent(btnJugar, 10, 400, 400); 
		parallelGroupAuxiliar.addComponent(btnPuntuaciones, 100, 100, 400); 
		parallelGroupAuxiliar.addComponent(btnReglas, 10, 400, 400); 
		parallelGroupAuxiliar.addComponent(lblSonido, 100, 100, 400); 
		parallelGroupAuxiliar.addComponent(chckbxReproducirSonido);
		
		SequentialGroup sequentialGroupHorizontal= layout.createSequentialGroup(); 
		sequentialGroupHorizontal.addGap(((xSize/2)-200));  
		sequentialGroupHorizontal.addGroup(parallelGroupAuxiliar);
		
		parallelGroupA.addGroup(sequentialGroupHorizontal); 
		layout.setHorizontalGroup(parallelGroupA); 
		
		ParallelGroup parallelGroupB= layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER); 
		
		SequentialGroup sequentialGroupVertical= layout.createSequentialGroup(); 
		sequentialGroupVertical.addGap(((ySize/2)-230)); 
		sequentialGroupVertical.addComponent(btnJugar,100,100,100); 
		sequentialGroupVertical.addGap(20);
		sequentialGroupVertical.addComponent(btnPuntuaciones,100,100,100);
		sequentialGroupVertical.addGap(20);
		sequentialGroupVertical.addComponent(btnReglas,100,100,100);
		sequentialGroupVertical.addGap(20);
		sequentialGroupVertical.addComponent(lblSonido);
		sequentialGroupVertical.addComponent(chckbxReproducirSonido);
		
		parallelGroupB.addGroup(sequentialGroupVertical); 
		layout.setVerticalGroup(parallelGroupB); 
	}  
} 