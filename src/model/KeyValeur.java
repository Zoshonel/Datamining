package model;

public class KeyValeur {
	
	private String key;
	private String valeur;
	
	public KeyValeur(String _key, String _valeur) {
		this.key=_key;
		this.valeur=_valeur;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	@Override
	public String toString(){
		return key+" - "+valeur;
	}
	
	
	
}
