package packInterfaz;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ListaBolas {
	
	private HashMap<Character, JLabel> lista;
	
	public ListaBolas(String color, boolean visible){
		this.lista = new HashMap<Character,JLabel>();
		this.rellenarLista(color, visible);
	}
	
	private void rellenarLista(String color, boolean visible){
		char letra = 'A';
		JLabel aux;
		while (letra!='['){
			aux = new JLabel();
			aux.setIcon(new ImageIcon(InterfazRosco2.class.getResource("/packIconos/boton_"+color+"_mini_"+letra+".png")));
			aux.setBounds(240, 0, 32, 32);
			aux.setVisible(visible);
			this.lista.put(letra, aux);
			if(letra=='N'){
				aux=new JLabel();
				aux.setIcon(new ImageIcon(InterfazRosco2.class.getResource("/packIconos/boton_"+color+"_mini_Ñ.png")));
				aux.setBounds(240, 0, 32, 32);
				aux.setVisible(visible);
				this.lista.put('Ñ', aux);
			}
			letra++;
		}
	}
	
	public JLabel getLabel(char letra){
		return this.lista.get(letra);
	}
	
	public void add(JLabel lbl, char pLetra){
		this.lista.put(pLetra, lbl);
	}
}
