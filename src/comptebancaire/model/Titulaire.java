package comptebancaire.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comptebancaire.connection.AccesBD;



public class Titulaire {
	
	private Long codeTitulaire;
	private String prenomTitulaire;
	private String nomTitulaire;
	private String adresseTitulaire;
	private String codePostalTitulaire;
	private List<Compte> listeDesComptes = new ArrayList<>();
	
	
	public Titulaire() {
//		this(0, null, null, null, null);
	}
	
	public Titulaire(Long codeTitulaire, String prenomTitulaire, String nomTitulaire, String adresseTitulaire,
			String codePostalTitulaire) {
		super();
		this.codeTitulaire = codeTitulaire;
		this.prenomTitulaire = prenomTitulaire;
		this.nomTitulaire = nomTitulaire;
		this.adresseTitulaire = adresseTitulaire;
		this.codePostalTitulaire = codePostalTitulaire;
	}


	public Long getCodeTitulaire() {
		return codeTitulaire;
	}


	public void setCodeTitulaire(Long codeTitulaire) {
		this.codeTitulaire = codeTitulaire;
	}


	public String getPrenomTitulaire() {
		return prenomTitulaire;
	}


	public void setPrenomTitulaire(String prenomTitulaire) {
		this.prenomTitulaire = prenomTitulaire;
	}


	public String getNomTitulaire() {
		return nomTitulaire;
	}


	public void setNomTitulaire(String nomTitulaire) {
		this.nomTitulaire = nomTitulaire;
	}


	public String getAdresseTitulaire() {
		return adresseTitulaire;
	}


	public void setAdresseTitulaire(String adresseTitulaire) {
		this.adresseTitulaire = adresseTitulaire;
	}


	public String getCodePostalTitulaire() {
		return codePostalTitulaire;
	}


	public void setCodePostalTitulaire(String codePostalTitulaire) {
		this.codePostalTitulaire = codePostalTitulaire;
	}


	public List<Compte> getListeDesComptes() {
		return listeDesComptes;
	}


	public void setListeDesComptes(List<Compte> listeDesComptes) {
		this.listeDesComptes = listeDesComptes;
	}


	@Override
	public String toString() {
		return "Titulaire [codeTitulaire=" + codeTitulaire + ", prenomTitulaire=" + prenomTitulaire + ", nomTitulaire="
				+ nomTitulaire + ", adresseTitulaire=" + adresseTitulaire + ", codePostalTitulaire="
				+ codePostalTitulaire + "]";
	}
	
	
	
}
