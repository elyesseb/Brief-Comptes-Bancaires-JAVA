package comptebancaire.model;

import java.util.Date;

public class Operation {
	private int numOperation;
	private int numCompte;
	private Date dateOperation;
	private String libOperation;
	private float montant;
	private String typeOperation;
	
	public Operation(int numOperation, int numCompte, Date dateOperation, String libOperation, float montant,
			String typeOperation) {
		super();
		this.numOperation = numOperation;
		this.numCompte = numCompte;
		this.dateOperation = dateOperation;
		this.libOperation = libOperation;
		this.montant = montant;
		this.typeOperation = typeOperation;
	}

	public int getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibOperation() {
		return libOperation;
	}

	public void setLibOperation(String libOperation) {
		this.libOperation = libOperation;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	@Override
	public String toString() {
		return "Operation [numOperation=" + numOperation + ", numCompte=" + numCompte + ", dateOperation="
				+ dateOperation + ", libOperation=" + libOperation + ", montant=" + montant + ", typeOperation="
				+ typeOperation + "]";
	}
	
	
}
