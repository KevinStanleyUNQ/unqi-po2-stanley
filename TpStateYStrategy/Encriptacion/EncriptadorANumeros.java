package Encriptacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncriptadorANumeros extends FormaDeEncriptar {
	
	//verificar por retorna todo 26 y no la posicion que cumple con la condicion.
	
	@Override
	public String encriptar(String unString){
		
		List<String> caracteres = Arrays.asList(" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
				   								"q","r","s","t","u","v","w","x","y","z");
		
		char [] listaDeChar = unString.toCharArray();
		List<String> stringDesarmado = new ArrayList<String>();
		List<String> stringEncriptado = new ArrayList<String>();	
		
		pasarDeCharAString(listaDeChar,stringDesarmado);
		encriptarANumeros(stringDesarmado,stringEncriptado,caracteres);

		return obtenerEnFormatoStringLaLista(stringEncriptado);
	}

	private void encriptarANumeros(List<String> stringDesarmado, List<String> stringEncriptado,
								   List<String> caracteres){

		for(int h=0;h<stringDesarmado.size();h++){
			
			stringEncriptado.add(reemplazarLetrasPorNumeros(caracteres,stringDesarmado.get(h)));
		}
	}

	private String reemplazarLetrasPorNumeros(List<String> caracteres, String unCaracter){
		
		String posicion = "Caracter Invalido";
		int t=0;
		while(t<caracteres.size()){	
			if(unCaracter.equals(caracteres.get(t))){
				posicion = ""+t+ ",";
				break;
			}
			else {
				t+=1;
			}	
		}
		return (posicion);
	}

	@Override
	public String desencriptar(String unString){
		
		List<String> caracteres = Arrays.asList(" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
												"q","r","s","t","u","v","w","x","y","z");
		
		String [] arrayDelString = dividirCadena(unString,",");
		List<String> stringEncriptado = new ArrayList<String>();	
		
		desencriptarALetras(arrayDelString,stringEncriptado,caracteres);
		
		return obtenerEnFormatoStringLaLista(stringEncriptado);
	}


	private String[] dividirCadena(String unString, String separador){
		
		String[] cadena = unString.split(separador);	
		return cadena;	
	}

	private void desencriptarALetras(String[] arrayDelString, List<String> stringEncriptado,
									 List<String> caracteres){
		
		for(int h=0;h<arrayDelString.length;h++){
			
			stringEncriptado.add(reemplazarNumerosPorLetras(caracteres,arrayDelString[h]));
		}
		
		
	}

	private String reemplazarNumerosPorLetras(List<String> caracteres, String unNumeroEnString){
		
		//System.out.println(unChar);
		String letra = "Letra Invalida";
		int caracterNumericoEncriptado = Integer.parseInt(unNumeroEnString);
		int z=0;
		while(z<caracteres.size()){	
			if(caracterNumericoEncriptado==z){	
				letra = ""+caracteres.get(z);
				break;
			}
			else {
				z+=1;
			}	
		}
		return letra;
	}

}
