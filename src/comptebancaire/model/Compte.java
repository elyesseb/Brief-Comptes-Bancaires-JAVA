package comptebancaire.model;

import java.util.ArrayList;
import java.util.List;

public class Compte {
	private Long numeroCompte;
	private TypeCompte typeCompte;
	private Titulaire titulaire;
	private double soldeCompte;
	private List<Operation> listeDesOperations = new ArrayList<>();
	
	public Compte() {
		this(0L, 0F);
	}
	

	public Compte(Long numeroCompte, Float soldeCompte) {
		super();
		this.numeroCompte = numeroCompte;
		this.typeCompte = new TypeCompte();
		this.titulaire = new Titulaire();
		this.soldeCompte = soldeCompte;
	}
	
	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}


	public Titulaire getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(Titulaire titulaire) {
		this.titulaire = titulaire;
	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double d) {
		this.soldeCompte = d;
	}

	public List<Operation> getListeDesOperations() {
		return listeDesOperations;
	}

	public void setListeDesOperations(List<Operation> listeDesOperations) {
		this.listeDesOperations = listeDesOperations;
	}
	
	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", typeCompte=" + typeCompte + ", titulaire=" + titulaire
				+ ", soldeCompte=" + soldeCompte + "]";
	}
	
	
}
