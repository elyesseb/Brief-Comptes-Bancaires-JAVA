package comptebancaire.main;

import java.sql.SQLException;

import comptebancaire.dao.TitulaireDao;
import comptebancaire.dao.TitulaireDaoImpl;
import comptebancaire.model.Titulaire;
import comptebancaire.transaction.Requetes;

public class Application {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Requetes.requetesBasiquesSansObjet();
		TitulaireDao titulaireDao = new TitulaireDaoImpl();
		Titulaire titulaire = new Titulaire();
		titulaire.setCodeTitulaire(16);
		titulaire.setPrenomTitulaire("charles");
		titulaire.setNomTitulaire("chrismann");
		titulaire.setAdresseTitulaire("46 grande rue");
		titulaire.setCodePostalTitulaire("78350");
		titulaireDao.ajouterTitulaire(titulaire);
		
		titulaire.setCodeTitulaire(17);
		titulaire.setPrenomTitulaire("charles");
		titulaire.setNomTitulaire("chrismann");
		titulaire.setAdresseTitulaire("46 grande rue");
		titulaire.setCodePostalTitulaire("78350");
		titulaireDao.ajouterTitulaire(titulaire);
		//Requetes.lireDetailsTitulaire("Beecroft");
	}
	
}
