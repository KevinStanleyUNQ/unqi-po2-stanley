package Encriptacion;

import java.util.ArrayList;
import java.util.List;

public class EncriptadorPorVocal extends FormaDeEncriptar {

	@Override
	public String encriptar(String unString) {
		
		char [] listaDeChar = unString.toCharArray();
		List<String> stringDesarmado = new ArrayList<String>();
		List<String> stringEncriptado = new ArrayList<String>();	
		
		pasarDeCharAString(listaDeChar,stringDesarmado);
		encriptarCambiandoVocales(stringDesarmado, stringEncriptado);
		
		return obtenerEnFormatoStringLaLista(stringEncriptado);
	}
	
	private void encriptarCambiandoVocales(List<String> stringDesarmado, 
			List<String> stringEncriptado){

			for(int k=0;k<stringDesarmado.size();k++){
				
				stringEncriptado.add(vocalSiguienteSinoElMismo(stringDesarmado.get(k)));
			}
	}

	private String vocalSiguienteSinoElMismo(String unString){
		
		switch (unString){
		case "a":
		return "e";
		
		case "e":
		return "i";
		
		case "i":
		return "o";
		
		case "o":
		return "u";
		
		case "u":
		return "a";
		
		default:
		return unString;
		}
		
	}

	@Override
	public String desencriptar(String unTexto) {
		
		char [] listaDeChar = unTexto.toCharArray();
		List<String> stringArmado = new ArrayList<String>();
		List<String> stringDesencriptado = new ArrayList<String>();	
		
		pasarDeCharAString(listaDeChar,stringArmado);
		desenctriptarCambiandoVocales(stringArmado, stringDesencriptado);
		
		return obtenerEnFormatoStringLaLista(stringDesencriptado);
	}
	
	private void desenctriptarCambiandoVocales(List<String> stringArmado,
											   List<String> stringDesencriptado){

		for(int d=0;d<stringArmado.size();d++){
			stringDesencriptado.add(vocalAnteriorSinoElMismo(stringArmado.get(d)));
		}
		
	}

	private String vocalAnteriorSinoElMismo(String unaLetra){
		
		switch (unaLetra){
		case "a":
		return "u";
		
		case "e":
		return "a";
		
		case "i":
		return "e";
		
		case "o":
		return "i";
		
		case "u":
		return "o";
		
		default:
		return unaLetra;
		}
	}
}
