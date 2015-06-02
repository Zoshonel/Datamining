package model;

public class Profile {
	private String montantDuCredit;
	private String dureeDuCredit;
	private String statutDuCompte;
	private String nombreCredit;
	private String historiqueDuCredit;
	private String job;
	private String garanti;
	
	public Profile(String montantDuCredit, String dureeDuCredit, String statutDuCompte, String nombreCredit, String historiqueDuCredit, String job, String garanti) {
		this.montantDuCredit = montantDuCredit;
		this.dureeDuCredit = dureeDuCredit;
		this.statutDuCompte = statutDuCompte;
		this.nombreCredit = nombreCredit;
		this.historiqueDuCredit = historiqueDuCredit;
		this.job = job;
		this.garanti = garanti;
	}

	public String getMontantDuCredit() {
		return montantDuCredit;
	}

	public String getDureeDuCredit() {
		return dureeDuCredit;
	}

	public String getStatutDuCompte() {
		return statutDuCompte;
	}

	public String getNombreCredit() {
		return nombreCredit;
	}

	public String getHistoriqueDuCredit() {
		return historiqueDuCredit;
	}

	public String getJob() {
		return job;
	}

	public String getGaranti() {
		return garanti;
	}
}
