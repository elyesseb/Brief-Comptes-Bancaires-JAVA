package comptebancaire.model;

public class TypeCompte {
	private String codeTypeCompte;
	private String intituleCompte;
	
	public TypeCompte() {
//		this(null, null);
	}
	
	public TypeCompte(String codeTypeCompte, String intituleCompte) {
		super();
		this.codeTypeCompte = codeTypeCompte;
		this.intituleCompte = intituleCompte;
	}
	public String getCodeTypeCompte() {
		return codeTypeCompte;
	}
	public void setCodeTypeCompte(String c) {
		this.codeTypeCompte = c;
	}
	public String getIntituleCompte() {
		return intituleCompte;
	}
	public void setIntituleCompte(String intituleCompte) {
		this.intituleCompte = intituleCompte;
	}
	@Override
	public String toString() {
		return "TypeCompte [codeTypeCompte=" + codeTypeCompte + ", intituleCompte=" + intituleCompte + "]";
	}
	
	
	
	
}
