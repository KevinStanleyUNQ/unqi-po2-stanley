package CartasDePoker;


public class Carta {
	
	String valor;
	String palo;

	public Carta(String unValor, String unPalo){

		this.palo = unPalo;
		this.valor = unValor;
	}

	public String getValor(){
		
		return this.valor;
	}

	public String getPalo(){
		
		return this.palo;
	}

	public Boolean esMasGrande(Carta unaCarta){
		
		
		int valorDeLaCartaActual = pasarAValorInt(this.valor);
		int valorDeLaOtraCarta = pasarAValorInt(unaCarta.getValor());
		
		return (valorDeLaCartaActual >= valorDeLaOtraCarta);
	}

	private int pasarAValorInt(String unValorEnString){
		
		switch(unValorEnString){
		case "J":
		return 11;
		
		case "Q":
		return 12;
		
		case "K":
		return 13;
		
		case "A":
		return 14;
		
		default:
		return Integer.parseInt(unValorEnString);
		}	
	}

	public Boolean esElMismoPalo(Carta unaCarta){
		
		
		return (this.palo.equals(unaCarta.getPalo()));
	}
	
	public int getValorEnInt(){
		
		return pasarAValorInt(this.valor);
	}

}
