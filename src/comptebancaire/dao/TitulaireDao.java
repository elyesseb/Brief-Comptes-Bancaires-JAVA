package comptebancaire.dao;

import java.sql.SQLException;

import comptebancaire.model.Titulaire;

public interface TitulaireDao {
	public void ajouterTitulaire(Titulaire titulaire) throws SQLException;
	
	public void supprimerTitulaire(Titulaire titulaire) throws SQLException;
}
