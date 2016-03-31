package packInterfaz;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reglas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnSalir, btnVolver;
	JLabel lblCabecera, lblReglas;
	int xSize, ySize;

	public static void main(String[] args) {
		try {
			Reglas dialog = new Reglas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reglas() {
		Toolkit tk = Toolkit.getDefaultToolkit();  
		xSize = ((int) tk.getScreenSize().getWidth());  
		ySize = ((int) tk.getScreenSize().getHeight());  
		setSize(xSize,ySize);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{xSize/4, xSize/4, xSize/4, xSize/4};
		gridBagLayout.rowHeights = new int[]{(ySize)/7, (ySize*4)/7, (ySize)/7, (ySize)/7};
		getContentPane().setLayout(gridBagLayout);
		
		lblCabecera = new JLabel("New label");
		lblCabecera.setText("<html><h1><b><center>Reglas del juego:</center></b></h1></html>");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblCabecera, gbc_lblNewLabel);
		
		lblReglas = new JLabel("New label");
		lblReglas.setText("<html><h1><ol><li>El objetivo del juego es responder a todas las preguntas del rosco en el menor tiempo posible.</li>"
				+ "<li>Cada respuesta empieza por la letra indicada en amarillo en el rosco, salvo en los casos partículares de la k, ñ, w, x e y donde las respuestas podrán empezar o contener dicha letra.</li>"
				+ "<li>En el centro del rosco se muestra el tiempo restante, pero solo se actualiza después de responder o de pasar una pregunta</li>"
				+ "<li>En la parte superior izquierda de la pantalla se muestran el nombre del jugador y el número de aciertos</li>"
				+ "<li>Al final de la partida se calculan los puntos y si es lo suficientemente alta como para entrar al Top 10 de jugadores, se añade</li>"
				+ "<li>Por cada acierto se añaden 25 puntos a la puntuación del jugador y por cada fallo se restan 10 puntos</li>"
				+ "<li>Si una vez terminada la partida, queda tiempo restante y el jugador ha acertado todas las preguntas, se añaden 5 puntos a la puntuación por cada segundo sobrante.</li>"
				+ "<li>El juego reproduce sonido cada vez que el jugador acierta o falla la pregunta. Esta opción se puede desactivar en el menú principal</li></ol></h1></html>");
		lblReglas.setVerticalAlignment(JLabel.TOP);
		lblReglas.setVerticalTextPosition(JLabel.TOP);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		getContentPane().add(lblReglas, gbc_lblNewLabel_1);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		
		btnVolver = new JButton("New button");
		btnVolver.setText("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Principal.main(null);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnVolver, gbc_btnNewButton);
		
		btnSalir = new JButton("Salir");
		btnSalir.setText("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		getContentPane().add(btnSalir, gbc_btnNewButton_1);
	}

}