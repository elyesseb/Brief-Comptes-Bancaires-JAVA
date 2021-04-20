package comptebancaire.model;

import java.sql.Date;
import java.time.LocalDate;


public class Operation {
	private Long numOperation;
	private Compte compte;
	private java.sql.Date dateOperation;
	private String libOperation;
	private double montant;
	private String typeOperation;
	
	public Operation() {
		this(0L,null,null, null,0,null);
	}
	
	public Operation(Long numOperation, Compte compte, java.sql.Date dateOperation, String libOperation, double montant,
			String typeOperation) {
		super();
		this.numOperation = numOperation;
		this.compte = new Compte();
		this.dateOperation = new Date(System.currentTimeMillis());
		this.libOperation = libOperation;
		this.montant = montant;
		this.typeOperation = typeOperation;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public java.sql.Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(java.sql.Date date) {
		this.dateOperation = date;
	}
	public String getLibOperation() {
		return libOperation;
	}
	public void setLibOperation(String libOperation) {
		this.libOperation = libOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
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
		return "Operation [numOperation=" + numOperation + ", \ncompte=" + compte + ", dateOperation=" + dateOperation
				+ ", \nlibOperation=" + libOperation + ", montant=" + montant + ", \ntypeOperation=" + typeOperation + "]";
	}

	
	
}
