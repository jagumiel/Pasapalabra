package packInterfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import packPasaPalabra.Definicion;
import packPasaPalabra.Jugador;
import packPasaPalabra.Reloj;
import packPasaPalabra.Rosco;

public class InterfazRosco2 extends javax.swing.JDialog implements Observer{
	private static final long serialVersionUID = 1L;


	public InterfazRosco2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        setSize(xSize,ySize);
	}

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(0, 0, 0, 0);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(0, 0, 0, 0);
        jPanel3 = new javax.swing.JPanel();
        
        JLabel aux = new JLabel();
        labelsazules=new ListaBolas("azul", true);
        labelsrojos=new ListaBolas("rojo", false);
        labelsverdes=new ListaBolas("verde", false);
        labelsamarillos=new ListaBolas("amarillo", false);
        aux = labelsazules.getLabel('A');
        aux.setVisible(false);
        labelsazules.add(aux, 'A');
        aux = labelsamarillos.getLabel('A');
        aux.setVisible(true);
        labelsamarillos.add(aux, 'A');
        anadirLabelsAlPanel();
        ordenar();
        
        lblAciertos = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoRespuesta = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        areaPregunta = new javax.swing.JTextArea();
        lblNombre = new JLabel();
        letra = 'A';
        Rosco.getRosco().addObserver(this);
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel2.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packIconos/boton_verde_big.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setRequestFocusEnabled(false);
        jLabel4.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel4);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packIconos/boton_azul_mini.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);

        areaPregunta.setEditable(false);  
	    areaPregunta.setCursor(null);  
	    areaPregunta.setOpaque(false);  
	    areaPregunta.setFocusable(false);
	    areaPregunta.setLineWrap(true);
	    areaPregunta.setWrapStyleWord(true);
	    areaPregunta.setBounds(10, 138, 243, 81);
	    areaPregunta.setText(Rosco.getRosco().getDefinicionActual().getDefinicion());
	    lblNombre.setText("<html><h2>"+Jugador.getJugador().getNombre()+"</h2></html>");
	    lblNombre.setSize(100, 600);
	    lblTiempo.setText("<html><h1>"+String.valueOf(Reloj.getReloj().getTiemporestantesegs())+"</html></h1>");
	    lblTiempo.setBounds(600,600,200,150);
	    Reloj.getReloj().reanudarTiempo();
	    lblAciertos.setText("<html><h3>"+String.valueOf(Rosco.getRosco().getAciertos())+"</h3></html>");
	    campoRespuesta.setText("Introduzca aqui la respuesta");
	    campoRespuesta.requestFocus();

        jScrollPane1.setViewportView(campoRespuesta);

        campoRespuesta.addKeyListener(new KeyListener() {            
			public void keyPressed(KeyEvent evento) {            
				if(evento.getKeyCode()==KeyEvent.VK_ENTER){
					btnOk.doClick();
				}            
			} 
			public void keyReleased(KeyEvent arg0) {  } 
			
			public void keyTyped(KeyEvent arg0) {  }        
		
		});
        
        btnPasar = new JButton("Pasar");
		btnPasar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reloj.getReloj().pararTiempo();
				if(Reloj.getReloj().quedaTiempo()){
					Rosco.getRosco().pasar();
					Reloj.getReloj().reanudarTiempo();
				}else{
					terminar();
				}
			}
		});
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((campoRespuesta.getText()==null)||(campoRespuesta.getText().length()==0)){
					btnPasar.doClick();
				}else{
					Reloj.getReloj().pararTiempo();
					if(Reloj.getReloj().quedaTiempo()){
						Rosco.getRosco().comprobarRespuesta(campoRespuesta.getText());
						Reloj.getReloj().reanudarTiempo();
					}else{
						terminar();
					}
				}
			}
		});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPasar)
                .addGap(17, 17, 17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(areaPregunta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(areaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnPasar))
                .addContainerGap())
        );

        jButton3.setText("Salir");
        jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
        });

        campoRespuesta.setText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAciertos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblNombre)
                .addComponent(lblAciertos)
                .addGap(93, 93, 93)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        
        jPanel2.add(lblTiempo);
        lblTiempo.setBounds(250, 150, 200, 200);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(72, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazRosco2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazRosco2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazRosco2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazRosco2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazRosco2 dialog = new InterfazRosco2(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton jButton3;
    private JLabel lblAciertos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private JLabel lblNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea areaPregunta;
    private javax.swing.JTextField campoRespuesta;
	private JLabel lblTiempo;
	private ListaBolas labelsazules;
	private ListaBolas labelsverdes;
	private ListaBolas labelsrojos;
	private ListaBolas labelsamarillos;
	private Rosco valorobservado = Rosco.getRosco();
	private char letra;
	
	public void ordenar(){
		float theta=0;
		int x;
		int y;
		Dimension dimPanel=new Dimension(200,200); //Circulo mas grande o mas peque√±o, bolas mas juntas o mas espaciadas.
		char letra='I';
		while (theta<2*Math.PI){
			for(int i=0; i<26; i++){
				theta=(float)(theta+((2*Math.PI)/27));
				x=(int) (Math.cos(theta)*dimPanel.width);
				y=(int) (Math.sin(theta)*dimPanel.height);
				x+=256;
				y+=240;
				labelsazules.getLabel(letra).setBounds(x, y, 32, 32);
		        labelsrojos.getLabel(letra).setBounds(x, y, 32, 32);
		        labelsverdes.getLabel(letra).setBounds(x, y, 32, 32);
		        labelsamarillos.getLabel(letra).setBounds(x, y, 32, 32);
		        if(letra=='N'){
		        	theta=(float)(theta+((2*Math.PI)/27));
					x=(int) (Math.cos(theta)*dimPanel.width);
					y=(int) (Math.sin(theta)*dimPanel.height);
					x+=256;
					y+=240;
					labelsazules.getLabel('—').setBounds(x, y, 32, 32);
			        labelsrojos.getLabel('—').setBounds(x, y, 32, 32);
			        labelsverdes.getLabel('—').setBounds(x, y, 32, 32);
			        labelsamarillos.getLabel('—').setBounds(x, y, 32, 32);
		        }
		        letra++;
		        if(letra=='['){
		        	letra='A';
		        }
			}
			break;
		}
	}

	public void update(Observable arg0, Object arg1) {
		if(valorobservado==arg0){
			Definicion nueva = valorobservado.getDefinicionActual();
			if(valorobservado.getUltimaAcertada()==0){
				labelsrojos.getLabel(letra).setVisible(true);
			}else if (valorobservado.getUltimaAcertada()==1){
				labelsverdes.getLabel(letra).setVisible(true);
			}else{
				labelsazules.getLabel(letra).setVisible(true);
			}
			if(nueva==null){
				this.terminar();
			}else{
				letra = valorobservado.getDefinicionActual().getLetra();
				labelsazules.getLabel(letra).setVisible(false);
				labelsamarillos.getLabel(letra).setVisible(true);
				areaPregunta.setText(nueva.getDefinicion());
				lblAciertos.setText("<html><h3>"+String.valueOf(valorobservado.getAciertos())+"</html></h3>");
				lblTiempo.setText("<html><h1>"+String.valueOf(Reloj.getReloj().getTiemporestantesegs())+"</html></h1>");
				campoRespuesta.setText("");
				campoRespuesta.requestFocus();
			}
		}		
	}
	
	private void anadirLabelsAlPanel(){
    	char letra = 'A';
    	while(letra!='['){
    		jPanel2.add(labelsazules.getLabel(letra));
    		jPanel2.add(labelsrojos.getLabel(letra));
    		jPanel2.add(labelsverdes.getLabel(letra));
    		jPanel2.add(labelsamarillos.getLabel(letra));
    		if(letra=='N'){
    			jPanel2.add(labelsazules.getLabel('—'));
        		jPanel2.add(labelsrojos.getLabel('—'));
        		jPanel2.add(labelsverdes.getLabel('—'));
        		jPanel2.add(labelsamarillos.getLabel('—'));
    		}
    		letra++;
    	}
    }
	
	private void terminar(){
		Rosco.getRosco().finalizar();
		dispose();
		InterfazPuntuaciones.main(null);
	}
}