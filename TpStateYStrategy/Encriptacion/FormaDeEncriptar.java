package Encriptacion;

import java.util.List;

public abstract class FormaDeEncriptar {

		abstract String encriptar(String unString);
		abstract String desencriptar(String unString);
			
		public void pasarDeCharAString(char[] listaDeChar, List<String> stringDesarmado){
			
			for(int i=0;i<listaDeChar.length;i++){
				stringDesarmado.add(Character.toString(listaDeChar[i]));
			}	
		}
		
		//Implemente este metodo porque no me toma el toString().
		public String obtenerEnFormatoStringLaLista(List<String> stringEncriptado){
			
			String textoEncriptado = "";
			for(int j=0;j<stringEncriptado.size();j++){
				
				textoEncriptado += stringEncriptado.get(j);
			}
			
			return textoEncriptado.replaceAll(",$", "");
		}
}
