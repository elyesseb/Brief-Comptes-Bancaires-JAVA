package comptebancaire.model;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    private int numCompte;
    private float soldeCompte;
    private TypeCompte typeCompte;
    private Titulaire titulaire;
    private List<Operation> listeDesOperations = new ArrayList<>();
    
	public Compte(int numCompte, float soldeCompte, TypeCompte typeCompte, Titulaire titulaire) {
		super();
		this.numCompte = numCompte;
		this.soldeCompte = soldeCompte;
		this.typeCompte = typeCompte;
		this.titulaire = titulaire;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
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

	public List<Operation> getListeDesOperations() {
		return listeDesOperations;
	}

	public void setListeDesOperations(List<Operation> listeDesOperations) {
		this.listeDesOperations = listeDesOperations;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", soldeCompte=" + soldeCompte + ", typeCompte=" + typeCompte
				+ ", titulaire=" + titulaire + "]";
	}
	
	

    

}