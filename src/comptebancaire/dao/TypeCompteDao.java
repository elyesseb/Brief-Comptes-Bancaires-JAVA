package comptebancaire.dao;


import java.util.ArrayList;
import comptebancaire.model.TypeCompte;

public interface TypeCompteDao {
	
	int update(TypeCompte typeCompte);
	int delete(TypeCompte typeCompte);
	int create(TypeCompte typeCompte);
	ArrayList<TypeCompte> select();
	TypeCompte getByCode(String code);
}
