package packPasaPalabra;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class LectorXMLDiccionario{
	   
	private static char letra;
	private static Definicion midefinicion;
	private static String termino;
	private static String definicion;
 
    public static void main(String argv[]) {
 
	    try {
	    	
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
	 
		DefaultHandler handler = new DefaultHandler() {
	 
		boolean bletra = false;
		boolean btermino = false;
		boolean bdefinicion = false;
		boolean bpalabra = false;
		ArrayList<String> terms = new ArrayList<String>();
	 
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			if (qName.equalsIgnoreCase("Letra")) {
				bletra = true;
			}
			
			if(qName.equalsIgnoreCase("Palabra")){
				bpalabra=true;
			}
	 
			if (qName.equalsIgnoreCase("Termino")) {
				btermino = true;
			}
	 
			if (qName.equalsIgnoreCase("Definicion")) {
				bdefinicion = true;
			}
	 
		}
	 
		public void endElement(String uri, String localName, String qName) throws SAXException {	
			if (qName.equalsIgnoreCase("Palabra")) {
				if(terms.size()==1){
					midefinicion=new DefinicionUnTermino(terms.get(0),definicion,letra);
				}else{
					midefinicion=new DefinicionVariosTerminos(definicion,letra,terms);
				}
				Diccionario.getDiccionario().anadirDefinicion(letra, midefinicion);
				terms = new ArrayList<String>();
			}
		}
	 
		public void characters(char ch[], int start, int length) throws SAXException {
	 
			if (bletra) {
				String aux = new String(ch, start, length);
				letra = aux.charAt(0);
				bletra = false;
			}
			
			if(bpalabra){
				if (btermino) {
					termino=new String(ch, start, length);
					terms.add(termino);
					btermino=false;
				}
		 
				if (bdefinicion) {
					definicion=new String(ch, start, length);
					bdefinicion=false;
					bpalabra=false;
				}
		    } 
		 }
	 
	     };
	 
	     saxParser.parse("res\\DICCIONARIO.xml", handler);
	 
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
 
   }
 
}